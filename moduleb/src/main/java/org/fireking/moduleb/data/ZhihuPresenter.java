package org.fireking.moduleb.data;

import com.trello.rxlifecycle2.android.ActivityEvent;

import org.fireking.commons.mvp.BasePresenter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ZhihuPresenter extends BasePresenter<ZhihuContact.View, ZhihuModel> implements ZhihuContact.Presenter {

    @Override
    public void loadZhihu() {
        getModel().loadZhihu().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(getView().bindActivityEvent(ActivityEvent.DESTROY))
                .subscribe(new ErrorHandleSubscriber<CommonResponse<List<ZhihuEntity>>>() {
                    @Override
                    public void onNext(CommonResponse<List<ZhihuEntity>> listCommonResponse) {
                        getView().setResult(listCommonResponse.stories);
                    }
                });
    }
}
