package org.fireking.modulea;

import android.app.Application;
import android.util.Log;

import org.fireking.commons.IApplicationDelegate;
import org.fireking.commons.mvp.DefaultRetrofitProxyImpl;
import org.fireking.modulea.data.GankIOService;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.logging.HttpLoggingInterceptor;

public class ModelAAppDelegate implements IApplicationDelegate {

    @Override
    public void onCreate(Application application) {

        //增加请求domain
        RetrofitUrlManager.getInstance().putDomain(GankIOService.GANK_DOMAIN, GankIOService.BASE_URL);

        //增加http监听
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        DefaultRetrofitProxyImpl.getInstance().addInterceptor(loggingInterceptor);
        Log.d("info", "初始化ModelA");
    }
}
