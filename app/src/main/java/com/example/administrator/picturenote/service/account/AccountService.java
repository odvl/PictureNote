package com.example.administrator.picturenote.service.account;

import com.example.administrator.picturenote.model.responseModel.LoginResponseModel;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/1/22.
 */
public interface AccountService {



    @POST("")
    Observable<LoginResponseModel> login(String username, String password);
}
