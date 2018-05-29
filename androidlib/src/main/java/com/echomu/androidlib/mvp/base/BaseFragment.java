package com.echomu.androidlib.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基类Fragment
 *
 * @author cicinnus
 * @date 2018/4/11.
 */

public abstract class BaseFragment extends Fragment {
    /**
     * Context
     */
    protected Activity mContext;
    /**
     * 根布局view
     */
    protected View mRootView;

    @Override
    public void onAttach(Context context) {
        mContext = (Activity) context;
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewAndData(savedInstanceState);
    }

    /**
     * 获取layoutId
     *
     * @return 布局  R.layout.xx
     */
    protected abstract @LayoutRes
    int getLayoutId();

    /**
     * 创建时间和数据
     *
     * @param savedInstanceState
     */
    protected abstract void initViewAndData(Bundle savedInstanceState);

}
