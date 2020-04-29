package org.fireking.commons.mvp;

import android.content.Context;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;

public interface IBaseView {

    Context getContext();

    boolean isActive();

    <T> LifecycleTransformer<T> bindLifecycle();

    <T> LifecycleTransformer<T> bindActivityEvent(@NonNull ActivityEvent event);
}
