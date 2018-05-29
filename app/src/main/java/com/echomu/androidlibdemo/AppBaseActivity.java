package com.echomu.androidlibdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.echomu.androidlib.mvp.base.BaseActivity;

/**
 * 主项目中的AppBaseActivity 基类封装的是业务相关的公用逻辑
 *
 * @author echoMu
 */
public abstract class AppBaseActivity extends BaseActivity {

    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置渲染视图View
        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mContextView);

        // 初始化控件
        initView(mContextView);

        // 业务操作
        doBusiness(this, savedInstanceState);
    }

    /**
     * 绑定渲染视图的布局文件
     *
     * @return 布局文件资源id
     */
    protected abstract int bindLayout();

    /**
     * 初始化控件
     */
    protected abstract void initView(View view);

    /**
     * 业务处理操作（onCreate方法中调用）
     *
     * @param mContext 当前Activity对象
     */
    protected abstract void doBusiness(Context mContext, Bundle savedInstanceState);

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
