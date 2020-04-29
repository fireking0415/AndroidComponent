package org.fireking.modulea.data;

import com.trello.rxlifecycle2.android.ActivityEvent;

import org.fireking.commons.mvp.BasePresenter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContact.View, MainModel> implements MainContact.Presenter {

    @Override
    public void loadGirls() {
        getView().showLoading();
        getModel().loadGirls()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(getView().bindActivityEvent(ActivityEvent.DESTROY))
                .subscribe(new ErrorHandleSubscriber<GankIoCommonResponse<List<GankIOEntity>>>() {
                    @Override
                    public void onNext(GankIoCommonResponse<List<GankIOEntity>> response) {
                        getView().hideLoading();
                        if (response.status != 100) {
                            getView().setError(1, "接口请求报错");
                        } else {
                            getView().setResult(response.data);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                        super.onError(t);
                        getView().hideLoading();
                        getView().setError(1, t.getMessage());
                    }
                });
    }
}
