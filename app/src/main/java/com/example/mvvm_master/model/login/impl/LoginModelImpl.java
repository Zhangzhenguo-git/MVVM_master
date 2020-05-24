package com.example.mvvm_master.model.login.impl;

import android.os.Handler;
import android.util.Log;

import com.example.mvvm_master.bean.User;
import com.example.mvvm_master.http.HttpUtils;
import com.example.mvvm_master.model.login.LoginModel;
import com.example.mvvm_master.viewmodel.login.LoginViewModelCallback;
import com.google.gson.Gson;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LoginModelImpl implements LoginModel {

    private LoginViewModelCallback callback;
    public LoginModelImpl(LoginViewModelCallback callback){
        this.callback=callback;
    }

    @Override
    public void reqLogin(String userName, String userPwd) {
        HttpUtils.login(userName,userPwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<User>() {
                    @Override
                    public void onNext(User s) {
                        if (s != null) {
                            if (s.getCode().equals("0")){
                                Gson gson=new Gson();
                                String json=gson.toJson(s);
                                Log.i(TAG, "thumbnail:---->"+json);
                                callback.onSuccess(s);
                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError:---->" + e.getMessage());
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete:---->");
                    }
                });
    }
}
