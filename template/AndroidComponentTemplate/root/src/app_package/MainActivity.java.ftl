package ${ativityPackageName};

import android.os.Bundle;
import org.fireking.androidcomponent.R;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.fireking.commons.mvp.BaseActivity;
import org.fireking.commons.mvp.InjectPresenter;
import io.reactivex.annotations.Nullable;
import ${contractPackageName}.${pageName}Contact;
import ${presenterPackageName}.${pageName}Presenter;

public class ${pageName}Activity extends BaseActivity implements ${pageName}Contact.View {

    @InjectPresenter
    ${pageName}Presenter presenter;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.${activityLayoutName});
    }

    @Override
    protected void initViews() {
        
    }

    @Override
    protected void initData() {
        
    }
}
