package org.fireking.modulea.data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

public interface GankIOService {

    String GANK_DOMAIN = "gankio";
    String BASE_URL = "https://gank.io/api/";

    @Headers(DOMAIN_NAME_HEADER + GANK_DOMAIN)
    @GET("v2/data/category/Girl/type/Girl/page/1/count/10")
    Observable<GankIoCommonResponse<List<GankIOEntity>>> loadGirls();
}
