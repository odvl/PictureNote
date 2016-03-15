package com.example.administrator.picturenote.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseActivity;
import com.example.administrator.picturenote.base.BaseFragment;
import com.example.administrator.picturenote.presenter.activity.MainPresenter;
import com.example.administrator.picturenote.ui.fragment.MeFragment;
import com.example.administrator.picturenote.ui.fragment.NoteFragment;
import com.example.administrator.picturenote.ui.fragment.PictureFragment;
import com.example.administrator.picturenote.ui.fragment.TravelFragment;
import com.example.administrator.picturenote.view.activity.IMainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IMainView {


    private ViewPager viewPagerMain;
    private TabLayout tabLayoutMain;

    MainPresenter mainPresenter;

    private List<BaseFragment> fragmentList = new ArrayList<>();

    @Override
    protected void loadDatas() {

        mainPresenter = new MainPresenter(this, this);
        fragmentList.add(new TravelFragment());
        fragmentList.add(new PictureFragment());
        fragmentList.add(new NoteFragment());
        fragmentList.add(new MeFragment());
        viewPagerMain.setAdapter(new MainAdapter(getSupportFragmentManager()));

    }

    @Override
    protected void initListener() {

        tabLayoutMain.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerMain));

        tabLayoutMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mainPresenter.switchFragment(position);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPagerMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMain));

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);

        viewPagerMain = (ViewPager) findViewById(R.id.viewPagerMain);
        tabLayoutMain = (TabLayout) findViewById(R.id.tabLayoutMain);

        LayoutInflater inflater = LayoutInflater.from(this);

        tabLayoutMain.addTab(tabLayoutMain.newTab().setCustomView(inflater.inflate(R.layout.item_bottom_travle, null)));
        tabLayoutMain.addTab(tabLayoutMain.newTab().setCustomView(inflater.inflate(R.layout.item_bottom_picture, null)));
        tabLayoutMain.addTab(tabLayoutMain.newTab().setCustomView(inflater.inflate(R.layout.item_bottom_note, null)));
        tabLayoutMain.addTab(tabLayoutMain.newTab().setCustomView(inflater.inflate(R.layout.item_bottom_me, null)));


    }

    @Override
    public void init() {

    }

    @Override
    public BaseActivity getActivity() {
        return this;
    }

    @Override
    public void setCurrentFragment(int position) {
        viewPagerMain.setCurrentItem(position, true);
    }

    class MainAdapter extends FragmentPagerAdapter {

        public MainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
