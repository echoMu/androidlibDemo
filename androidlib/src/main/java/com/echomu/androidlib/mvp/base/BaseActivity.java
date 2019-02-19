package com.echomu.androidlib.mvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * AndroidLib 下的基类 BaseActivity 封装的是业务无关的公用逻辑
 *
 * @author echoMu
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Context对象,使用Activity
     */
    protected AppCompatActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mContext = this;
        initViewAndData(savedInstanceState);
    }

    /**
     * 布局Id
     *
     * @return
     */
    protected abstract int getLayoutId();

    protected abstract void initViewAndData(Bundle savedInstanceState);

}