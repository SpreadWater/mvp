package com.example.mvpdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.User;
import com.example.mvpdemo.presenter.ILoginPresenter;
import com.example.mvpdemo.presenter.LoginPresenter;
import com.example.mvpdemo.utils.T;
import com.example.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private EditText et_name;
    private EditText et_pw;
    private Button btn_login;
    private TextView tv_hint;

    private ProgressDialog dialog;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initListener();
    }

    private void findView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pw = (EditText) findViewById(R.id.et_pw);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_hint = (TextView) findViewById(R.id.tv_hint);
    }

    private void initListener() {
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (loginPresenter == null) {
            loginPresenter = new LoginPresenter(this,this);
        }
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }

        if (TextUtils.isEmpty(et_name.getText().toString())) {
            T.show(this, getResources().getString(R.string.username_isempty));
            return;
        }

        if (TextUtils.isEmpty(et_pw.getText().toString())) {
            T.show(this, getResources().getString(R.string.userpw_isempty));
            return;
        }

        loginPresenter.onLogin();
    }

    @Override
    public void onShowProgress() {
        dialog.show();
    }

    @Override
    public void onHideProgress() {
        dialog.dismiss();
    }

    @Override
    public User getUserMsg() {

        User user = new User();
        user.setUserName(et_name.getText().toString());
        user.setPassword(et_pw.getText().toString());
        return user;
    }

    @Override
    public void clearEdit() {
        et_name.setText("");
        et_pw.setText("");
    }

    @Override
    public void setLoginResult(String result) {
        tv_hint.setText(result);
    }
}
