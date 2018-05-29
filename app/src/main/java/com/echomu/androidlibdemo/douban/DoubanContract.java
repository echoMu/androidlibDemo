package com.echomu.androidlibdemo.douban;

import com.echomu.androidlib.mvp.base.IBasePresenter;
import com.echomu.androidlib.mvp.base.IBaseView;

/**
 * <pre>
 *     author : echoMu
 *     e-mail :
 *     time   : 2018/05/29
 *     desc   :
 *     version:
 * </pre>
 */
public class DoubanContract {
    interface IDoubanView extends IBaseView {
        void success(DoubanTop250Response doubanTop250Response);
    }

    interface IDoubanPresenter extends IBasePresenter {
        void getTop250();
    }
}
