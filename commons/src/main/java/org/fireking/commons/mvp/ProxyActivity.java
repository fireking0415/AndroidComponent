package org.fireking.commons.mvp;

class ProxyActivity<V extends IBaseView> extends ProxyImpl {

    ProxyActivity(V view) {
        super(view);
    }
}
