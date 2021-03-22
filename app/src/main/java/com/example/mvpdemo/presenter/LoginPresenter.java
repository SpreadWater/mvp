package com.example.mvpdemo.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.IUserModel;
import com.example.mvpdemo.model.User;
import com.example.mvpdemo.model.UserModelImpl;
import com.example.mvpdemo.utils.StringUtils;
import com.example.mvpdemo.view.ILoginView;

import java.lang.ref.WeakReference;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:20
 * @description TODO(登录presenter对应的具体实现类)
 */

public class LoginPresenter implements ILoginPresenter, OnResultListener {

    private final int REQUEST_SUCCESS = 1;
    private final int REQUEST_ERROR = 2;

    private ILoginView loginView;
    private IUserModel userModel;

    private WeakReference<Context> mContext ;

    public LoginPresenter(Context context,ILoginView loginView) {
        this.loginView = loginView;
        userModel = new UserModelImpl();
        mContext = new WeakReference<>(context);
    }

    @Override
    public void onLogin() {
        loginView.onShowProgress();

        User user = loginView.getUserMsg();
        if (StringUtils.isEmpty(user.getUserName(),user.getPassword()) ) {
            handler.sendEmptyMessage(REQUEST_ERROR);
            return;
        }

        String url ;

        //接下来进行登录请求链接的组装
        url = "www.baidu.com";

        userModel.onHttpRequest(url,this);
    }

    @Override
    public void onSuccess() {
        handler.sendEmptyMessage(REQUEST_SUCCESS);
    }

    @Override
    public void onError() {
        handler.sendEmptyMessage(REQUEST_ERROR);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            switch (what) {
                case REQUEST_SUCCESS:
                    loginView.onHideProgress();
                    loginView.setLoginResult(mContext.get().getResources().getString(R.string.login_success));
                    break;
                case REQUEST_ERROR:
                    loginView.onHideProgress();
                    loginView.clearEdit();
                    loginView.setLoginResult(mContext.get().getResources().getString(R.string.login_fail));
                    break;
            }
        }
    };
}

