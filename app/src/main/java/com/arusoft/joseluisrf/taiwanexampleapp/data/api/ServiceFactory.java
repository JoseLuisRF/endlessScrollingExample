package com.arusoft.joseluisrf.taiwanexampleapp.data.api;

import android.util.Log;


import com.arusoft.joseluisrf.taiwanexampleapp.data.api.interceptor.ApiInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joseluisrf on 7/12/16.
 */
public class ServiceFactory {

    private static final String TAG = ServiceFactory.class.getSimpleName();
    private static final String BASE_URL = "http://apiofferme.azurewebsites.net/";
    private static final int MAX_READ_TIME_OUT_SECONDS = 60;
    private static final int MAX_CONNECTION_TIME_OUT_SECONDS = 60;

    public static <T> T createRetrofitService(final Class<T> clazz, ApiInterceptor apiInterceptor) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        //FIXME: Use BuildTypes to check whether app is debug or not
        HttpLoggingInterceptor loggerInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i(TAG, "OkHttp" + message);
            }
        });
        loggerInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (apiInterceptor != null) {
            httpClientBuilder.addInterceptor(apiInterceptor);
        }

        //Logger interceptor added
        OkHttpClient client = httpClientBuilder
                .addInterceptor(loggerInterceptor)
                .readTimeout(MAX_READ_TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .connectTimeout(MAX_CONNECTION_TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(clazz);
    }
}
