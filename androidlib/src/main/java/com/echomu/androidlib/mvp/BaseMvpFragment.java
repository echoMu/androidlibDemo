package com.echomu.androidlib.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.echomu.androidlib.mvp.base.BaseFragment;
import com.echomu.androidlib.mvp.base.IBasePresenter;

/**
 * 基类的mvpFragment
 *
 * @author cicinnus
 * @date 2018/4/16.
 */

public abstract class BaseMvpFragment<T extends IBasePresenter> extends BaseFragment {
    /**
     * Context对象
     */
    protected Activity mContext;
    /**
     * 持有的Presenter
     */
    protected T mPresenter;
    /**
     * 根View
     */
    private View mRootView;

    @Override
    public void onAttach(Context context) {
        mContext = (Activity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        mPresenter = getPresenter();
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.onViewStop();
        }

    }

    @Override
    public void onDestroy() {
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


}

