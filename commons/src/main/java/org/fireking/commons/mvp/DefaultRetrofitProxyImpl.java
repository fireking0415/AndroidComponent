package org.fireking.commons.mvp;

import android.annotation.SuppressLint;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import io.reactivex.schedulers.Schedulers;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class DefaultRetrofitProxyImpl implements IRetrofitProxy {

    private static final int DEFAULT_MILLISECONDS = 10 * 1000;
    private Retrofit mRetrofit;
    /**
     * 该url只是占位使用，具体使用url，使用retrofitUrlManager的逻辑处理
     */
    private static final String BASE_URL = "http://www.baidu.com/";

    /**
     * 自定义拦截器列表
     */
    private static List<Interceptor> interceptorList = new ArrayList<>();

    private static final class SingletonHolder {
        private static final DefaultRetrofitProxyImpl sInstance = new DefaultRetrofitProxyImpl();
    }

    private DefaultRetrofitProxyImpl() {
    }


    public static DefaultRetrofitProxyImpl getInstance() {
        return SingletonHolder.sInstance;
    }

    @Override
    public <T> T create(Class<T> serviceClass) {
        if (mRetrofit == null) {
            createRetrofit();
        }
        return mRetrofit.create(serviceClass);
    }

    private void createRetrofit() {
        OkHttpClient.Builder mBuilder = RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder());
        mBuilder.connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        mBuilder.readTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        mBuilder.writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        mBuilder.retryOnConnectionFailure(true);
        mBuilder.followRedirects(true); // 请求支持重定向

        // 信任所有证书
        try {
            TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
                @SuppressLint("TrustAllX509TrustManager")
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @SuppressLint("TrustAllX509TrustManager")
                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            }};

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new SecureRandom());
            mBuilder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //应用自定义拦截器
        for (Interceptor interceptor : interceptorList) {
            mBuilder.addInterceptor(interceptor);
        }

        // 不验证域名
        mBuilder.hostnameVerifier((hostname, session) -> true);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(GSON.getGson))
                .client(mBuilder.build())
                .build();
    }

    /**
     * 添加自定义拦截器
     *
     * @param interceptor {@link Interceptor}
     */
    public void addInterceptor(Interceptor interceptor) {
        if (!interceptorList.contains(interceptor)) {
            interceptorList.add(interceptor);
        }
    }
}
