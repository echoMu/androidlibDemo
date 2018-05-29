package com.echomu.androidlibdemo.douban;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * <pre>
 *     author : echoMu
 *     e-mail :
 *     time   : 2018/05/29
 *     desc   :
 *     version:
 * </pre>
 */
public interface Api {
    @GET("v2/movie/top250")
    Observable<DoubanTop250Response> getTop250(@Query("start") int start, @Query("count") int count);
}
