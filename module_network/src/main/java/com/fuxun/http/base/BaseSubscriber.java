package com.fuxun.http.base;

import androidx.lifecycle.MutableLiveData;

import com.fuxun.http.exception.ApiException;
import com.fuxun.http.exception.ExceptionEngine;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * 自定义请服务器被观察者
 *
 * @author twilight
 * @since 2021/7/1
 */
public class BaseSubscriber<T> implements Subscriber<BaseDto<T>> {

    // LiveData
    private MutableLiveData<BaseDto<T>> data = new MutableLiveData<BaseDto<T>>();

    @Override
    public void onSubscribe(Subscription s) {
        // 观察者接收事件 = 1个
        s.request(1);
    }

    @Override
    public void onNext(BaseDto<T> baseDto) {
        setData(baseDto);
    }

    @Override
    public void onError(Throwable t) {
        ApiException ex = ExceptionEngine.handleException(t);
        BaseDto baseDto = new BaseDto();
        baseDto.setCode(ex.getStatusCode());
        baseDto.setMessage(ex.getStatusDesc());
        setData(baseDto);
    }

    @Override
    public void onComplete() {

    }

    public MutableLiveData<BaseDto<T>> getData() {
        return data;
    }

    public void setData(BaseDto<T> t) {
        this.data.setValue(t);
    }
}
