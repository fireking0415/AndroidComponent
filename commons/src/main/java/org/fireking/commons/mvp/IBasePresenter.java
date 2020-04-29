package org.fireking.commons.mvp;

public interface IBasePresenter {

    void attach(IBaseView view);

    void detach();
}
