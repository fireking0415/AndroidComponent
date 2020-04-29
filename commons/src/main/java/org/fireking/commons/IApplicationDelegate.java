package org.fireking.commons;

import android.app.Application;

public interface IApplicationDelegate {

    void onCreate(Application application);

    default void onTerminate() {
    }

    default void onTrimMemory(int level) {
    }

    default void onLowMemory() {
    }
}
