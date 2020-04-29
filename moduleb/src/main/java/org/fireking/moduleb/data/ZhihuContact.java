package org.fireking.moduleb.data;

import org.fireking.commons.mvp.IBaseModel;
import org.fireking.commons.mvp.IBasePresenter;
import org.fireking.commons.mvp.IBaseView;

import java.util.List;

import io.reactivex.Observable;

public interface ZhihuContact {

    interface View extends IBaseView {

        void setResult(List<ZhihuEntity> result);
    }

    interface Presenter extends IBasePresenter {

        void loadZhihu();
    }

    interface Model extends IBaseModel {
        Observable<CommonResponse<List<ZhihuEntity>>> loadZhihu();
    }
}
