package org.fireking.moduleb.data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

public interface ZhiuService {

    String ZHIHU_DOMAIN = "zhihu";
    String BASE_URL = "http://news-at.zhihu.com/api/";

    @Headers(DOMAIN_NAME_HEADER + ZHIHU_DOMAIN)
    @GET("4/news/latest")
    Observable<CommonResponse<List<ZhihuEntity>>> getZhihu();
}
