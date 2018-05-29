package com.echomu.androidlib.mvp.base;

/**
 * @description: 基础的Presenter接口<br>
 * @author: cicinnus <br>
 * @date: 2018/4/5.
 */
public interface IBasePresenter {
    void onViewStop();

    void onViewDestroy();
}
