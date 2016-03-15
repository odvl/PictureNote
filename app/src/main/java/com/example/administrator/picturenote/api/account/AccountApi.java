package com.example.administrator.picturenote.api.account;

import com.example.administrator.picturenote.model.responseModel.LoginResponseModel;
import com.example.administrator.picturenote.service.account.AccountService;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/1/22.
 */
public class AccountApi {


    public static void login(String username, String password, Subscriber subscriber) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Observable<LoginResponseModel> observable = retrofit.create(AccountService.class).login(username, password);
        observable.doOnNext(new Action1<LoginResponseModel>() {
            @Override
            public void call(LoginResponseModel loginResponseModel) {

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
