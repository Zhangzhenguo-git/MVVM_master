package com.example.mvvm_master.viewmodel.login;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mvvm_master.bean.User;
import com.example.mvvm_master.model.login.LoginModel;
import com.example.mvvm_master.model.login.impl.LoginModelImpl;
import com.example.mvvm_master.view.login.callback.LoginView;

public class LoginViewModel implements LoginViewModelCallback{

    private Activity activity;
    private LoginModelImpl loginModel;
    private LoginView loginView;
    public LoginViewModel(Activity activity,LoginView loginView){
        this.activity=activity;
        this.loginView=loginView;
        loginModel=new LoginModelImpl(this);
    }

    public void reqLogin(String userName, String userPwd) {
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(activity, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPwd)) {
            Toast.makeText(activity, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        loginView.showDialog("正在登陆中");
        loginModel.reqLogin(userName,userPwd);
    }

    @Override
    public void onSuccess(User user) {
        loginView.onSuccess(user);
        Toast.makeText(activity, "登录成功", Toast.LENGTH_SHORT).show();
        loginView.hideDialog();
    }

    @Override
    public void onError( String msg) {
        loginView.onError(msg);
        Toast.makeText(activity, "登录失败", Toast.LENGTH_SHORT).show();
        loginView.hideDialog();
    }
}
