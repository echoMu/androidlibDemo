package com.echomu.androidlibdemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.echomu.androidlib.utils.FragmentFactory;
import com.echomu.androidlib.utils.FragmentUtil;
import com.echomu.androidlib.widget.HomeTabLayout;
import com.echomu.androidlibdemo.douban.DoubanActivity;

import java.util.Arrays;

public class MainActivity extends AppBaseActivity {

    private HomeTabLayout mBottomBar;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(View view) {
        mBottomBar= (HomeTabLayout) findViewById(R.id.tb_bottom_bar);
    }

    @Override
    protected void doBusiness(Context mContext, Bundle savedInstanceState) {
        initTab();
        initFragment(savedInstanceState);
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

    /**
     * 初始化底部tab
     */
    private void initTab() {
        mBottomBar.setBottomLabel(Arrays.asList(getResources().getStringArray(R.array.bottom_bar)));

        int[] drawables = new int[]{R.drawable.ic_home, R.drawable.ic_mail, R.drawable.ic_task_manager, R.drawable.ic_person};
        mBottomBar.setBottomLabelImg(drawables);
        mBottomBar.setOnTabClickListener(new HomeTabLayout.OnTabClickListener() {
            @Override
            public void onClick(int position) {
                FragmentUtil.showFragment(getSupportFragmentManager(), position);
            }
        });
    }

    /**
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        //工厂创建Fragment
        Fragment homeFragment = FragmentFactory.createFragment(HomeFragment.class,null);
        Fragment messageFragment = FragmentFactory.createFragment(HomeFragment.class,null);

        Fragment performanceFragment = FragmentFactory.createFragment(HomeFragment.class,null);
        Fragment userFragment = FragmentFactory.createFragment(HomeFragment.class,null);

        FragmentUtil.addFragmentToContainer(savedInstanceState,
                getSupportFragmentManager(),
                R.id.fl_fragment_container,
                homeFragment, messageFragment, performanceFragment, userFragment);
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
