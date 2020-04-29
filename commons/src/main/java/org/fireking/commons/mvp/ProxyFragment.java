package org.fireking.commons.mvp;

class ProxyFragment<V extends IBaseView> extends ProxyImpl {

    ProxyFragment(V view) {
        super(view);
    }
}
