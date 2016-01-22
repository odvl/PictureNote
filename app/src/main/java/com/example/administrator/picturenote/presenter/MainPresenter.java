package com.example.administrator.picturenote.presenter;

import android.content.Context;

import com.example.administrator.picturenote.base.BasePresenter;
import com.example.administrator.picturenote.view.IMainView;

/**
 * Created by Administrator on 2016/1/21.
 */
public class MainPresenter extends BasePresenter<IMainView> {


    public MainPresenter(Context context, IMainView iView) {
        super(context, iView);
    }


    /**
     *检测网络状态
     */
    public void checkNetWork() {

    }


    /**
     * 选择fragment
     * @param position
     */
    public void switchFragment(int position){
        this.iView.setCurrentFragment(position);
    }

    @Override
    public void bind(IMainView view) {

    }

    @Override
    public void unBind() {
        this.subscription.unsubscribe();

    }
}
