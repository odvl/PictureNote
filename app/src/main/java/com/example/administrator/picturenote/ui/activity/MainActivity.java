package com.example.administrator.picturenote.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseActivity;

public class MainActivity extends BaseActivity {


    private ViewPager viewPagerMain;
    private TabLayout tabLayoutMain;

    @Override
    protected void loadDatas() {

    }

    @Override
    protected void initListener() {

        tabLayoutMain.setupWithViewPager(viewPagerMain);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);

        viewPagerMain = (ViewPager) findViewById(R.id.viewPagerMain);
        tabLayoutMain = (TabLayout) findViewById(R.id.tabLayoutMain);

    }
}
