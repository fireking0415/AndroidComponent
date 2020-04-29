package org.fireking.commons.mvp;

public interface IRetrofitProxy {

    <T> T create(Class<T> serviceClass);
}
