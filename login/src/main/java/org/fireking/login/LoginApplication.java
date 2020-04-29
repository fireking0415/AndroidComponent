package org.fireking.login;

import org.fireking.commons.BaseApplication;

public class LoginApplication extends BaseApplication {

    @Override
    public void registerApplicationDelegate() {
        registerApplicationInit(LoginAppDelegate.class);
    }
}
