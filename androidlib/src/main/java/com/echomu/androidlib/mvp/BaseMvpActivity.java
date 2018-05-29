package com.echomu.androidlib.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.echomu.androidlib.mvp.base.BaseActivity;
import com.echomu.androidlib.mvp.base.IBasePresenter;

/**
 * MVP的基类Activity
 *
 * @author: cicinnus
 * @date: 2018/4/5.
 */
public abstract class BaseMvpActivity<T extends IBasePresenter> extends BaseActivity {

    /**
     * Presenter变量
     */
    protected T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.onViewStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onViewDestroy();
        }
    }

    /**
     * 获取Presenter
     *
     * @return
     */
    protected abstract T getPresenter();

    /**
     * 获取布局id
     *
     * @return
     */
    @Override
    protected abstract int getLayoutId();
}
