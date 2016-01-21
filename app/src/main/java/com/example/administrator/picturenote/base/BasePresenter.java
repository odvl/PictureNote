package com.example.administrator.picturenote.base;

/**
 * Created by Administrator on 2016/1/20.
 */
public interface BasePresenter<T> {

    void bind(T view);
    void unBind();
}
