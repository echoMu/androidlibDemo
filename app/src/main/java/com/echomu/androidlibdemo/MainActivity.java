package com.echomu.androidlibdemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.echomu.androidlibdemo.douban.DoubanActivity;

public class MainActivity extends AppBaseActivity {

    private ListView lvDemo;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(View view) {
        lvDemo = (ListView) findViewById(R.id.lvDemo);
    }

    @Override
    protected void doBusiness(Context mContext, Bundle savedInstanceState) {
        // ArrayAdapter的参数1是一个context，代表要生成ListView的上下文
        // 参数2要传入的是一个布局文件id值，这里使用google预置的布局文件
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvDemo.setAdapter(adapter);

        // 添加数据
        for (int i = 0; i < 20; i++) {
            adapter.add("item " + getItemText(i));
        }

        lvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(MainActivity.this,WebViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, DoubanActivity.class));
                        break;
                }
            }
        });
    }

    private String getItemText(int i) {
        String itemText = "";
        switch (i) {
            case 0:
                itemText = "选图&拍照";
                break;
            case 1:
                break;
        }
        return itemText;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    /**
     * 由于三星机型拍照返回时，会旋转屏幕，导致不可用，所以必须重写此方法
     * 并且在AndroidManifest.xml中设置对应activity的属性
     * android:configChanges="keyboardHidden|orientation|screenSize"
     * android:screenOrientation="portrait"
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initViewAndData(Bundle savedInstanceState) {

    }
}
