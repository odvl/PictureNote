package com.example.administrator.picturenote.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.picturenote.utils.SharedPreferencesUtil;

/**
 * Created by Administrator on 2016/1/18.
 */
public abstract class BaseFragment extends Fragment {
    public SharedPreferencesUtil sharedPreferencesUtil;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferencesUtil = SharedPreferencesUtil.getInstance(getActivity());
        initView(view);
        initListener();
        loadDatas();
    }

    protected abstract void loadDatas();

    protected abstract void initListener();

    protected abstract void initView(View view);

    public void jumpActivity(Class clzz) {
        Intent intent = new Intent(getActivity(), clzz);
        startActivity(intent);
    }


    public void jumpActivityAndFinish(Class clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
        getActivity().finish();
    }


    public void jumpActivityForResult(Class clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }
}
