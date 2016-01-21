package com.example.administrator.picturenote.base;

import android.content.Context;

import com.example.administrator.picturenote.view.IBaseView;

import rx.Subscription;

/**
 * Created by Administrator on 2016/1/20.
 */
public abstract class BasePresenter<T extends IBaseView> {

    protected Context context;
    protected Subscription subscription;
    protected T iView;

    public BasePresenter(Context context, T iView) {
        this.context = context;
        this.iView = iView;
    }

    public abstract void bind(T view);

    public abstract void unBind();
}
