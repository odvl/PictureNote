package com.example.administrator.picturenote.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseFragment;
import com.example.administrator.picturenote.common.Constant;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/1/18.
 */
public class GuidePageFourFragment extends BaseFragment {

    private AppCompatButton btnBegin;
    private Subscriber subscriber;


    public GuidePageFourFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide_four, container, false);
        return v;
    }

    @Override
    protected void loadDatas() {

    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    protected void initListener() {
        btnBegin.setOnClickListener(onClickListener);
    }

    @Override
    protected void initView(View view) {
        btnBegin = (AppCompatButton) view.findViewById(R.id.btnBegin);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == btnBegin.getId()) {
                Observable.create(new Observable.OnSubscribe<Void>() {
                    @Override
                    public void call(Subscriber<? super Void> subscriber) {
                        sharedPreferencesUtil.setBoolean(Constant.SharedPreferencesField.IS_FIRST_BOOT, false);
                        subscriber.onNext(null);
                        subscriber.onError(null);
                        subscriber.onCompleted();

                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber);
            }

        }
    };
}
