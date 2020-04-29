package org.fireking.commons.mvp;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class BaseModel implements IBaseModel {

    protected IRepositoryManager iRepositoryManager;

    public BaseModel(IRetrofitProxy proxy) {
        if (proxy == null) {
            proxy = DefaultRetrofitProxyImpl.getInstance();
        }
        this.iRepositoryManager = new RepositoryManager(proxy);
    }

    @Override
    public void onDestroy() {
        iRepositoryManager = null;
    }

    /**
     * 构造post请求实体
     */
    public RequestBody createRequestBody(HashMap<String, Object> params) {
        return RequestBody.create(MediaType.parse("application/json;charset=utf-8"), GSON.toJsonString(params));
    }

}
