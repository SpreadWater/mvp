package com.example.mvpdemo.model;

import com.example.mvpdemo.presenter.OnResultListener;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:17
 * @description TODO(由相应的model实现，关于用户数据操作接口)
 */

public interface IUserModel {

    /**
     * @Description TODO(提供网络请求操作)
     * @author SpreadWater
     * @parame url 网络请求链接
     * @parame resultListener 请求回调接口
     */
    void onHttpRequest(String url, OnResultListener resultListener);
}
