package com.example.administrator.picturenote.presenter.activity;

import android.content.Context;

import com.example.administrator.picturenote.base.BasePresenter;
import com.example.administrator.picturenote.view.activity.ITravelView;

/**
 * Created by Administrator on 2016/1/21.
 */
public class TravelPresenter extends BasePresenter<ITravelView> {


    public TravelPresenter(Context context, ITravelView iView) {
        super(context, iView);
    }

    @Override
    public void bind(ITravelView view) {

    }

    public void checkModel(int position) {
        this.iView.changeModel(position);
    }

    @Override
    public void unBind() {

    }
}
