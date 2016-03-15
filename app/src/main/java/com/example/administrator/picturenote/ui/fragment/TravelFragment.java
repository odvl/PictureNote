package com.example.administrator.picturenote.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseFragment;
import com.example.administrator.picturenote.presenter.activity.TravelPresenter;
import com.example.administrator.picturenote.view.activity.ITravelView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/21.
 */
public class TravelFragment extends BaseFragment implements ITravelView, View.OnClickListener {

    public static final int MODEL_1 = 0;
    public static final int MODEL_2 = 1;


    TravelPresenter travelPresenter;
    private ArrayList<BaseFragment> travelFragmentList = new ArrayList<>();
    private TextView textTitle1;
    private TextView textTitle2;
    private ViewPager viewPagerTravel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_travel, container, false);
        return v;
    }

    @Override
    protected void loadDatas() {
        travelPresenter = new TravelPresenter(getActivity(), this);
        travelFragmentList.clear();
        travelFragmentList.add(new TravelMapViewFragment());
        travelFragmentList.add(new TravelModel2Fragment());

        viewPagerTravel.setAdapter(new TravelAdapter(getChildFragmentManager()));

    }

    @Override
    protected void initListener() {
        textTitle1.setOnClickListener(this);
        textTitle2.setOnClickListener(this);

        viewPagerTravel.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                travelPresenter.checkModel(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void initView(View view) {
        textTitle1 = (TextView) view.findViewById(R.id.textTitle1);
        textTitle2 = (TextView) view.findViewById(R.id.textTitle2);
        textTitle1.setSelected(true);

        viewPagerTravel = (ViewPager) view.findViewById(R.id.viewpagerTravel);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void changeModel(int position) {
        switch (position) {
            case MODEL_1:
                textTitle1.setSelected(true);
                textTitle2.setSelected(false);
                viewPagerTravel.setCurrentItem(position);
                break;

            case MODEL_2:
                textTitle1.setSelected(false);
                textTitle2.setSelected(true);
                viewPagerTravel.setCurrentItem(position);
                break;
        }

    }

    @Override
    public void init() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == textTitle1.getId()) {
            travelPresenter.checkModel(MODEL_1);
        } else if (id == textTitle2.getId()) {
            travelPresenter.checkModel(MODEL_2);
        }
    }

    class TravelAdapter extends FragmentPagerAdapter {

        public TravelAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return travelFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return travelFragmentList.size();
        }
    }
}
