package com.example.administrator.picturenote.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.picturenote.R;

/**
 * Created by Administrator on 2016/1/18.
 */
public class CircleIndicator extends LinearLayout {

    private static final float DEFAULT_INDICATOR_WIDTH = 5;

    private int mCircleIndicatorBackgroundId = R.drawable.white_circle;
    private int mCircleIndicatorUnSelectedBackgroundId = R.drawable.white_circle;
    private int mIndicatorWidth;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorAnimatorOut;
    private int mIndicatorAnimatorIn;


    private Animator animatorIn;
    private Animator animatorOut;


    public CircleIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        handlerTypedArray(attrs);
        checkAttrs(context);
    }

    private void checkAttrs(Context context) {
        mIndicatorWidth = mIndicatorWidth == -1 ? dip2px(DEFAULT_INDICATOR_WIDTH) : mIndicatorWidth;
        mIndicatorHeight = mIndicatorHeight == -1 ? dip2px(DEFAULT_INDICATOR_WIDTH) : mIndicatorHeight;
        mIndicatorMargin = mIndicatorMargin == -1 ? dip2px(DEFAULT_INDICATOR_WIDTH) : mIndicatorMargin;

        animatorIn = AnimatorInflater.loadAnimator(getContext(), mIndicatorAnimatorIn);
        animatorOut = AnimatorInflater.loadAnimator(getContext(), mIndicatorAnimatorOut);
    }

    private void handlerTypedArray(AttributeSet attrs) {
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.CircleIndicator);
        mIndicatorWidth = t.getDimensionPixelSize(R.styleable.CircleIndicator_indicatorWidth, -1);
        mIndicatorHeight = t.getDimensionPixelSize(R.styleable.CircleIndicator_indicatorHeight, -1);
        mIndicatorMargin = t.getDimensionPixelSize(R.styleable.CircleIndicator_indicatorMargin, -1);
        mCircleIndicatorBackgroundId = t.getResourceId(R.styleable.CircleIndicator_indicatorBackground, R.drawable.white_circle);
        mIndicatorAnimatorOut = t.getResourceId(R.styleable.CircleIndicator_indicatorAnimatorOut, R.animator.scale_with_alpha);
        mIndicatorAnimatorIn = t.getResourceId(R.styleable.CircleIndicator_indicatorAnimatorIn, R.animator.scale_with_alpha);

        t.recycle();
    }

    private void init() {
        setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        setOrientation(LinearLayout.HORIZONTAL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setCircleIndicator(int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            createCircleIndicator();
        }
    }

    private void createCircleIndicator() {
        View circleIndicator = new View(getContext());
        circleIndicator.setBackgroundResource(mCircleIndicatorBackgroundId);
        addView(circleIndicator, mIndicatorWidth, mIndicatorHeight);

        LinearLayout.LayoutParams params = (LayoutParams) circleIndicator.getLayoutParams();
        params.setMargins(mIndicatorMargin, mIndicatorMargin, mIndicatorMargin, mIndicatorMargin);
        circleIndicator.setLayoutParams(params);

    }

    private int dip2px(float value) {
        if (value < 0) {
            value = 5;
        }
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

}
