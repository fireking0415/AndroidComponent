package org.fireking.modulea.data;

import org.fireking.commons.mvp.IBaseModel;
import org.fireking.commons.mvp.IBasePresenter;
import org.fireking.commons.mvp.IBaseView;
import org.fireking.modulea.data.GankIOEntity;
import org.fireking.modulea.data.GankIoCommonResponse;

import java.util.List;

import io.reactivex.Observable;

public interface MainContact {

    interface View extends IBaseView {

        void showLoading();

        void hideLoading();

        void setResult(List<GankIOEntity> girls);

        void setError(int code, String message);
    }

    interface Presenter extends IBasePresenter {
        void loadGirls();
    }

    interface Model extends IBaseModel {
        Observable<GankIoCommonResponse<List<GankIOEntity>>> loadGirls();
    }
}
