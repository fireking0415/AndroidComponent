package org.fireking.moduleb;

import org.fireking.commons.BaseApplication;

public class ModelBApplication extends BaseApplication {

    @Override
    public void registerApplicationDelegate() {
        registerApplicationInit(ModelBApplicationDelegate.class);
    }
}
