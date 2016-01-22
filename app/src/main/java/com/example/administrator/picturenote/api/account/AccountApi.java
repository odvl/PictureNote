package com.example.administrator.picturenote.api.account;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/1/22.
 */
public class AccountApi {


    public static void login(String username , String password, Subscriber subscriber) {
        Retrofit  retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
    }
}
