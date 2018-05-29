package com.echomu.androidlib.mvp.base;

/**
 * 基类View
 *
 * @author: cicinnus
 * @date: 2018/4/5.
 */
public interface IBaseView {

    /**
     * 显示加载布局
     */
    void showLoading();

    /**
     * 显示内容布局
     */
    void showContent();

    /**
     * 显示错误布局
     */
    void showError(String errorMsg);


}
