package com.echomu.androidlib.mvp.base;

import android.content.Context;

/**
 * BaseMvpPresenter，封装调用链
 *
 */

public class BaseMvpPresenter<T> implements IBasePresenter {
    private static final String TAG = "BaseMvpPresenter";
    /**
     * Context
     */
    protected Context mContext;
    /**
     * Presenter持有的View
     */
    protected T mView;


    public BaseMvpPresenter(Context context, T view) {
        this.mContext = context;
        this.mView = view;

    }


    @Override
    public void onViewStop() {

    }

    @Override
    public void onViewDestroy() {

    }
}
