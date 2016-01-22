package com.example.administrator.picturenote.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.administrator.picturenote.utils.LogUtil;
import com.example.administrator.picturenote.utils.SharedPreferencesUtil;

/**
 * Created by Administrator on 2016/1/18.
 */
public abstract class BaseFragment extends Fragment {

    public SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.i("fragment onViewCreated");
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

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.i("fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.i("fragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.i("fragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.i("fragment onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.i("fragment onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.i("fragment onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.i("fragment onDestroy");
    }

}
