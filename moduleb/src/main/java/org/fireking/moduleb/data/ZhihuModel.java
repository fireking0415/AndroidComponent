package org.fireking.moduleb.data;

import org.fireking.commons.mvp.BaseModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class ZhihuModel extends BaseModel implements ZhihuContact.Model {

    public ZhihuModel() {
        super(null);
    }

    @Override
    public Observable<CommonResponse<List<ZhihuEntity>>> loadZhihu() {
        return Observable.just(iRepositoryManager.obtainRetrofitService(ZhiuService.class).getZhihu())
                .flatMap((Function<Observable<CommonResponse<List<ZhihuEntity>>>,
                        ObservableSource<CommonResponse<List<ZhihuEntity>>>>) commonResponseObservable -> commonResponseObservable);
    }
}
