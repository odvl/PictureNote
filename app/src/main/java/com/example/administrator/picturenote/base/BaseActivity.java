package com.example.administrator.picturenote.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.picturenote.utils.SharedPreferencesUtil;

/**
 * Created by Administrator on 2016/1/18.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(this);
        initView();
        initListener();
        loadDatas();

    }

    protected abstract void loadDatas();

    protected abstract void initListener();

    protected abstract void initView();


    public void jumpActivity(Class clzz) {
        Intent intent = new Intent(this, clzz);
        startActivity(intent);
    }

    public void jumpActivityAndFinish(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    public void jumpActivityForResult(Class clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }
}
