package org.fireking.moduleb;

import android.app.Application;
import android.util.Log;

import org.fireking.commons.IApplicationDelegate;
import org.fireking.commons.mvp.DefaultRetrofitProxyImpl;
import org.fireking.moduleb.data.ZhiuService;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.logging.HttpLoggingInterceptor;

public class ModelBApplicationDelegate implements IApplicationDelegate {

    @Override
    public void onCreate(Application application) {

        RetrofitUrlManager.getInstance().putDomain(ZhiuService.ZHIHU_DOMAIN, ZhiuService.BASE_URL);

        //增加http监听
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        DefaultRetrofitProxyImpl.getInstance().addInterceptor(loggingInterceptor);
        Log.d("info", "初始化ModelA");
    }
}
