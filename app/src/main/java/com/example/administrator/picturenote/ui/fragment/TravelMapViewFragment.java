package com.example.administrator.picturenote.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseFragment;
import com.example.administrator.picturenote.view.fragment.ITravelMapView;

/**
 * Created by Administrator on 2016/1/22.
 */
public class TravelMapViewFragment extends BaseFragment  implements ITravelMapView{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_travel_map_view, container, false);
        return v;
    }

    @Override
    protected void loadDatas() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void init() {

    }
}
