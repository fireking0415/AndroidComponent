package org.fireking.commons;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

public class BaseApplication extends Application {

    private List<IApplicationDelegate> appInitList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        // 打印日志
        ARouter.openLog();
        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.openDebug();
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);

        ManifestParser manifestParser = new ManifestParser(this);
        List<IApplicationDelegate> delegateList = manifestParser.parse();
        for (IApplicationDelegate delegate : delegateList) {
            appInitList.add(delegate);
            delegate.onCreate(this);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate classInit : appInitList) {
            classInit.onTerminate();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        for (IApplicationDelegate classInit : appInitList) {
            classInit.onTrimMemory(level);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (IApplicationDelegate classInit : appInitList) {
            classInit.onLowMemory();
        }
    }
}
