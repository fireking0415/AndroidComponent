package org.fireking.modulea.data;

import org.fireking.commons.mvp.BaseModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class MainModel extends BaseModel implements MainContact.Model {

    public MainModel() {
        super(null);
    }

    @Override
    public Observable<GankIoCommonResponse<List<GankIOEntity>>> loadGirls() {
        return Observable.just(iRepositoryManager.obtainRetrofitService(GankIOService.class).loadGirls())
                .flatMap((Function<Observable<GankIoCommonResponse<List<GankIOEntity>>>,
                        ObservableSource<GankIoCommonResponse<List<GankIOEntity>>>>) gankIoCommonResponseObservable -> gankIoCommonResponseObservable);
    }
}
