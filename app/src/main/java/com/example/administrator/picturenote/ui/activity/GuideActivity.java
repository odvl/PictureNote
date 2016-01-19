package com.example.administrator.picturenote.ui.activity;

import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseActivity;
import com.example.administrator.picturenote.base.BaseFragment;
import com.example.administrator.picturenote.ui.fragment.GuidePageFourFragment;
import com.example.administrator.picturenote.ui.fragment.GuidePageOneFragment;
import com.example.administrator.picturenote.ui.fragment.GuidePageThreeFragment;
import com.example.administrator.picturenote.ui.fragment.GuidePageTwoFragment;
import com.example.administrator.picturenote.utils.LogUtil;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * 引导页
 */
public class GuideActivity extends BaseActivity {

    private ViewPager viewPagerGuide;
    private CirclePageIndicator indicatorGuide;

    List<BaseFragment> fragments = new ArrayList<>();


    @Override
    protected void loadDatas() {
        fragments.add(new GuidePageOneFragment());
        fragments.add(new GuidePageTwoFragment());
        fragments.add(new GuidePageThreeFragment());
        GuidePageFourFragment fourFragment = new GuidePageFourFragment();

        fragments.add(fourFragment);
        fourFragment.setSubscriber(new Subscriber() {
            @Override
            public void onCompleted() {
                jumpActivityAndFinish(MainActivity.class);
            }

            @Override
            public void onError(Throwable e) {
                jumpActivityAndFinish(MainActivity.class);
            }

            @Override
            public void onNext(Object o) {

            }
        });
        viewPagerGuide.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        viewPagerGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Point point = new Point();
                getWindowManager().getDefaultDisplay().getSize(point);


                LogUtil.d("offset " + positionOffsetPixels + " " + positionOffset);

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        indicatorGuide.setViewPager(viewPagerGuide);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_guide);

        viewPagerGuide = (ViewPager) findViewById(R.id.viewPagerGuide);

        indicatorGuide = (CirclePageIndicator) findViewById(R.id.indicatorGuide);


    }


}
