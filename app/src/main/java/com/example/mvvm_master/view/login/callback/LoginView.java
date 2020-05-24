package com.example.mvvm_master.view.login.callback;

import com.example.mvvm_master.bean.User;

public interface LoginView {
    void onSuccess(User objMsg);
    void onError(Object objMsg);
    void showDialog(String msg);
    void hideDialog();
}
