package com.echomu.androidlibdemo.douban;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.echomu.androidlib.mvp.BaseMvpActivity;
import com.echomu.androidlibdemo.R;

public class DoubanActivity extends BaseMvpActivity<DoubanPresenter> implements DoubanContract.IDoubanView{

    @Override
    protected DoubanPresenter getPresenter() {
        return new DoubanPresenter(mContext,this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_douban;
    }

    @Override
    protected void initViewAndData(Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void success(DoubanTop250Response doubanTop250Response) {
        ((TextView)findViewById(R.id.tv_douban)).setText(doubanTop250Response.toString());
    }

    public void onClick(View view) {
        mPresenter.getTop250();
    }
}
