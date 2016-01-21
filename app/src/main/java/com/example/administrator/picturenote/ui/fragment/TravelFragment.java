package com.example.administrator.picturenote.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseFragment;
import com.example.administrator.picturenote.presenter.TravelPresenter;
import com.example.administrator.picturenote.view.ITravelView;

/**
 * Created by Administrator on 2016/1/21.
 */
public class TravelFragment extends BaseFragment implements ITravelView {

    TravelPresenter travelPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_travel, container, false);
        return v;
    }

    @Override
    protected void loadDatas() {
        travelPresenter = new TravelPresenter(getActivity(), this);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void changeModel(int position) {

    }

    @Override
    public void init() {

    }
}
