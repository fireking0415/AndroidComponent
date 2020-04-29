package org.fireking.moduleb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.barlibrary.ImmersionBar;

import org.fireking.commons.mvp.BaseActivity;
import org.fireking.commons.mvp.InjectPresenter;
import org.fireking.moduleb.R;
import org.fireking.moduleb.data.ZhihuContact;
import org.fireking.moduleb.data.ZhihuEntity;
import org.fireking.moduleb.data.ZhihuPresenter;

import java.util.List;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

@Route(path = "/b/main")
public class MainActivity extends BaseActivity implements ZhihuContact.View {

    private MainAdapter mMainAdapter;

    private ImmersionBar mImmersionBar;

    @InjectPresenter
    ZhihuPresenter zhihuPresenter;

    private BlurView blurView;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.b_activity_main);
    }

    @Override
    protected void initViews() {

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.transparentBar();
        mImmersionBar.init();

        RecyclerView rv_zhihu_list = findViewById(R.id.rv_zhihu_list);
        mMainAdapter = new MainAdapter();
        rv_zhihu_list.setLayoutManager(new LinearLayoutManager(this));
        rv_zhihu_list.setAdapter(mMainAdapter);

        blurView = findViewById(R.id.blurView);

        View decorView = getWindow().getDecorView();
        ViewGroup rootView = decorView.findViewById(android.R.id.content);
        blurView.setupWith(rootView)
                .setFrameClearDrawable(decorView.getBackground())
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(20f)//0<r<25  数值越大越模糊
                .setHasFixedTransformationMatrix(true);
    }

    @Override
    protected void initData() {
        zhihuPresenter.loadZhihu();
    }

    @Override
    public void setResult(List<ZhihuEntity> result) {
        mMainAdapter.submitList(result);
    }
}
