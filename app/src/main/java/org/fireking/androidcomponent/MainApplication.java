package org.fireking.androidcomponent;

import org.fireking.commons.BaseApplication;
import org.fireking.modulea.ModelAAppDelegate;
import org.fireking.moduleb.ModelBApplicationDelegate;

public class MainApplication extends BaseApplication {

    @Override
    public void registerApplicationDelegate() {
        registerApplicationInit(ModelAAppDelegate.class);
        registerApplicationInit(ModelBApplicationDelegate.class);
    }
}
