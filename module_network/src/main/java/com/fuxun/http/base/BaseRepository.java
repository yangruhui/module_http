package com.fuxun.http.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Repository基类
 *
 * @author twilight
 * @since 2021/7/1
 */
public class BaseRepository {

    /**
     * 请求网络
     *
     * @param flowable 被观察者
     * @param <T> 泛型类
     * @return LiveData
     */
    public <T> MutableLiveData<BaseDto<T>> request(Flowable<BaseDto<T>> flowable) {
        BaseSubscriber<T> baseSubscriber = new BaseSubscriber<>();
        flowable.subscribeOn(Schedulers.io()) //解决背压
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseSubscriber);
        return baseSubscriber.getData();
    }
}
