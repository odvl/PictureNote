package com.example.administrator.picturenote.view;

import com.example.administrator.picturenote.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/21.
 */
public interface IMainView extends IBaseView{

    BaseActivity getActivity();
    void setCurrentFragment(int position);
}
