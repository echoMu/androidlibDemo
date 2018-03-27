package com.echomu.androidlib.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * AndroidLib 下的基类 BaseActivity 封装的是业务无关的公用逻辑
 *
 * @author echoMu
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
