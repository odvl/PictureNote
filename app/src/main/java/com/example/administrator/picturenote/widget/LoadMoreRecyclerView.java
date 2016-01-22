package com.example.administrator.picturenote.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2016/1/22.
 */
public class LoadMoreRecyclerView extends RecyclerView {

    private boolean isScroll2Bottom = false;
    private FloatingActionButton floatingActionButton;
    private LoadMoreListener loadMoreListener;



    public LoadMoreRecyclerView(Context context) {
        super(context);
    }

    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);

    }

    public interface LoadMoreListener{
        void loadmore();
    }
}
