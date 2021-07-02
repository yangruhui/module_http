package com.fuxun.http;

import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestRetrofit {

    /**
     * 服务器超时时间 16 秒
     */
    public final static int TIME_OUT = 16;

    /**
     * 创建okhttp相关对象
     */
    private static OkHttpClient okHttpClient;

    /**
     * 创建Retrofit相关对象
     */
    private static Retrofit retrofit;

    private static void initOkHttpClient(Interceptor requestInterceptor, Interceptor responseInterceptor) {
        if (okHttpClient == null) {
            synchronized (RequestRetrofit.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                            @Override
                            public void log(String message) {
                                Log.d("RequestRetrofit", message);
                            }
                        })
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .addNetworkInterceptor(new StethoInterceptor())
                        .addInterceptor(requestInterceptor)
                        .addInterceptor(responseInterceptor)
                        .build();
                }
            }
        }
    }

    public static void initRetrofit(final String baseUrl,
        Interceptor requestInterceptor, Interceptor responseInterceptor) {
        initOkHttpClient(requestInterceptor, responseInterceptor);
        if (retrofit == null) {
            synchronized (RequestRetrofit.class) {
                if(retrofit == null) {
                    retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                }
            }
        }
    }

    public static <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
