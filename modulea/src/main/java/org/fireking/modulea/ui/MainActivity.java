package org.fireking.modulea.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.fireking.commons.mvp.BaseActivity;
import org.fireking.commons.mvp.InjectPresenter;
import org.fireking.modulea.R;
import org.fireking.modulea.data.GankIOEntity;
import org.fireking.modulea.data.MainContact;
import org.fireking.modulea.data.MainPresenter;

import java.util.List;

@Route(path = "/a/main")
public class MainActivity extends BaseActivity implements MainContact.View {

    private MainAdapter mMainAdapter;
    private ProgressDialog dialog;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.a_activity_main);
    }

    @Override
    protected void initViews() {
        RecyclerView rv_content_list = findViewById(R.id.rv_content_list);
        rv_content_list.setLayoutManager(new LinearLayoutManager(this));
        rv_content_list.setAdapter(mMainAdapter = new MainAdapter());
    }

    @Override
    protected void initData() {
        dialog = new ProgressDialog(this);
        presenter.loadGirls();
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.cancel();
    }

    @Override
    public void setResult(List<GankIOEntity> girls) {
        mMainAdapter.submitList(girls);
    }

    @Override
    public void setError(int code, String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
