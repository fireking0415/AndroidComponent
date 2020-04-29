package org.fireking.login.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.fireking.login.R;

@Route(path = "/login/main")
public class MainActivity extends AppCompatActivity {

    private EditText input_username_edit;
    private EditText input_password_edit;
    private Button btn_login;
    private Button btn_back;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        input_username_edit = findViewById(R.id.input_username_edit);
        input_password_edit = findViewById(R.id.input_password_edit);

        btn_login = findViewById(R.id.btn_login);
        btn_back = findViewById(R.id.btn_back);

        progressDialog = new ProgressDialog(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,
                                input_username_edit.getText().toString() + "-" + input_password_edit.getText().toString(), Toast.LENGTH_SHORT).show();
                        setResult(Activity.RESULT_OK);
                        onBackPressed();
                    }
                }, 3000);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
