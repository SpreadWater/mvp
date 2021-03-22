package com.example.mvpdemo.model;

import android.text.TextUtils;

import com.example.mvpdemo.presenter.OnResultListener;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:18
 * @description TODO(网络请求具体实现类)
 */

public class UserModelImpl implements IUserModel{

    /**
     * @Description TODO(实现具体的登录逻辑)
     * @author SpreadWater
     * @Date 2018/10/25 17:09
     */
    @Override
    public void onHttpRequest(final String url, final OnResultListener listener) {

        if (listener == null) throw new NullPointerException("OnResultListener is null,this is illegal");
        if (TextUtils.isEmpty(url)) throw new NullPointerException("url is null,this is illegal");

        //这里模拟网络耗时操作,实际开发中绝对不要这样直接new Thread
        new Thread(new Runnable() {
            @Override
            public void run() {

                String result = "";

                //接下来就是网络操作 进行登录 获取登录结果
                try {
                    Thread.sleep(2000);
                    result = "success";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (TextUtils.isEmpty(result)) {
                    listener.onError();
                } else {
                    listener.onSuccess();
                }

            }
        }).start();

    }

}

