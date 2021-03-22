package com.example.mvpdemo.view;

import com.example.mvpdemo.model.User;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:16
 * @description TODO(由View层实现，主要是响应presenter层的操作)
 */

public interface ILoginView  extends OnProgressListener {

    /**
     * @Description TODO(将View中数据反馈给presenter)
     * @author SpreadWater
     */
    User getUserMsg();

    /**
     * @Description TODO(清除edittext数据)
     * @author SpreadWater
     */
    void clearEdit();

    /**
     * @Description TODO(将登录数据返回给View)
     * @author SpreadWater
     * @parame result 登录返回数据
     */
    void setLoginResult(String result);

}

