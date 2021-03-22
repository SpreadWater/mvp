package com.example.mvpdemo.view;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:14
 * @description TODO(显示进度条 隐藏进度的接口，统一定义，避免每个需要进度显示的接口重复定义这些方法)
 * 这就是把UI逻辑抽象成了接口，由Activity去实现
 */

public interface OnProgressListener {

    void onShowProgress();
    void onHideProgress();
}
