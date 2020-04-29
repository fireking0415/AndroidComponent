package org.fireking.modulea;

import org.fireking.commons.BaseApplication;

public class ModelAApplication extends BaseApplication {

    @Override
    public void registerApplicationDelegate() {
        registerApplicationInit(ModelAAppDelegate.class);
    }

}
