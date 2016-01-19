package com.example.administrator.picturenote.ui.activity;

import android.os.Handler;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseActivity;
import com.example.administrator.picturenote.common.Constant;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class WelcomeActivity extends BaseActivity {


    @Override
    protected void loadDatas() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_welcome);
        Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                boolean isFirstBoot = sharedPreferencesUtil.getBoolean(Constant.SharedPreferencesField.IS_FIRST_BOOT, true);
                subscriber.onCompleted();
                subscriber.onError(null);
                subscriber.onNext(isFirstBoot);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            startGuideActivity();
                        } else {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    jumpActivityAndFinish(MainActivity.class);

                                }
                            }, 1000);
                        }
                    }
                });

    }

    private void startGuideActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpActivityAndFinish(GuideActivity.class);
            }
        }, 1000);
    }
}
