package org.fireking.moduleb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.fireking.commons.mvp.BaseActivity;
import org.fireking.commons.mvp.InjectPresenter;
import org.fireking.moduleb.R;
import org.fireking.moduleb.data.ZhihuContact;
import org.fireking.moduleb.data.ZhihuEntity;
import org.fireking.moduleb.data.ZhihuPresenter;

import java.util.List;

@Route(path = "/b/main")
public class MainActivity extends BaseActivity implements ZhihuContact.View {

    private MainAdapter mMainAdapter;

    @InjectPresenter
    ZhihuPresenter zhihuPresenter;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.b_activity_main);
    }

    @Override
    protected void initViews() {
        Button btn_zhihu = findViewById(R.id.btn_zhihu);
        btn_zhihu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhihuPresenter.loadZhihu();
            }
        });

        RecyclerView rv_zhihu_list = findViewById(R.id.rv_zhihu_list);
        mMainAdapter = new MainAdapter();
        rv_zhihu_list.setLayoutManager(new LinearLayoutManager(this));
        rv_zhihu_list.setAdapter(mMainAdapter);
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
