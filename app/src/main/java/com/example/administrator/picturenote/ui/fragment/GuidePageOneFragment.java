package com.example.administrator.picturenote.ui.fragment;

import android.animation.AnimatorSet;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.picturenote.R;
import com.example.administrator.picturenote.base.BaseFragment;

/**
 * Created by Administrator on 2016/1/18.
 */
public class GuidePageOneFragment extends BaseFragment {

    private ImageView imgFlag1;
    private ImageView imgFlag2;
    private ImageView imgFlag3;
    private ImageView imgIsland1;
    private ImageView imgIsland2;
    private ImageView imgEarth;
    private TextView textTitle;

    AnimatorSet set;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide_one, container, false);
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void loadDatas() {


    }

    @Override
    protected void initListener() {


    }

    @Override
    protected void initView(View view) {
        imgEarth = (ImageView) view.findViewById(R.id.imgEarth);
        imgFlag1 = (ImageView) view.findViewById(R.id.imgFlag1);
        imgFlag2 = (ImageView) view.findViewById(R.id.imgFlag2);
        imgFlag3 = (ImageView) view.findViewById(R.id.imgFlag3);
        imgIsland1 = (ImageView) view.findViewById(R.id.imgIsland1);
        imgIsland2 = (ImageView) view.findViewById(R.id.imgIsland2);
        textTitle = (TextView) view.findViewById(R.id.textTitle);

        setAnimation();
    }

    private void setAnimation() {
        Point point = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(point);

        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, -point.y / 2, 0);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(900);
        imgFlag2.setAnimation(translateAnimation);


        RotateAnimation rotateAnimation = new RotateAnimation(-11.5f, 23f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(Integer.MAX_VALUE);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        imgIsland1.setAnimation(rotateAnimation);

    }
}
