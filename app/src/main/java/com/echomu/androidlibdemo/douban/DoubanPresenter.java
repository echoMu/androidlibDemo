package com.echomu.androidlibdemo.douban;

import android.content.Context;
import android.util.Log;

import com.echomu.androidlib.mvp.base.BaseMvpPresenter;
import com.echomu.androidlibdemo.RetrofitProvider;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : echoMu
 *     e-mail :
 *     time   : 2018/05/29
 *     desc   :
 *     version:
 * </pre>
 */
public class DoubanPresenter extends BaseMvpPresenter<DoubanContract.IDoubanView> implements DoubanContract.IDoubanPresenter {

    public DoubanPresenter(Context context, DoubanContract.IDoubanView view) {
        super(context, view);
    }

    @Override
    public void onViewStop() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void getTop250() {
        Api api = RetrofitProvider.get().create(Api.class);
        api.getTop250(0, 50)
                .subscribeOn(Schedulers.io())               //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
                .subscribe(new Observer<DoubanTop250Response>() {
                    protected Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable=d;
                    }

                    @Override
                    public void onNext(DoubanTop250Response doubanTop250Response) {
                        Log.d("echoMu",doubanTop250Response.toString());
                        mView.success(doubanTop250Response);

                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("echoMu",e.getMessage());

                        if (disposable != null && !disposable.isDisposed()) {
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
