package com.echomu.androidlibdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.echomu.androidlib.utils.immersion.StatusBarUtil;
import com.echomu.androidlibdemo.AppBaseActivity;
import com.echomu.androidlibdemo.R;

public class ImmersionActivity extends AppBaseActivity {

    @Override
    protected void initView(View view) {
//        StatusBarUtil.setImmersiveStatusBar(this,true);
        StatusBarUtil.fullScreen(this);
    }

    @Override
    protected void doBusiness(Context mContext, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_immersion;
    }

    @Override
    protected void initViewAndData(Bundle savedInstanceState) {

    }
}
