package com.example.mvvm_master.viewmodel.login;

import com.example.mvvm_master.bean.User;
import com.example.mvvm_master.view.login.callback.LoginView;

public interface LoginViewModelCallback {
    void onSuccess(User user);
    void onError(String msg);
}
