package com.example.mvvm_master.view.login;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.mvvm_master.R;
import com.example.mvvm_master.base.BaseActivity;
import com.example.mvvm_master.bean.User;
import com.example.mvvm_master.databinding.ActivityLoginBinding;
import com.example.mvvm_master.view.login.callback.LoginView;
import com.example.mvvm_master.view.main.MainActivity;
import com.example.mvvm_master.viewmodel.login.LoginViewModel;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding mainBinding;
    @Override
    protected int getCententView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        loginViewModel=new LoginViewModel(this,this);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        mainBinding.setViewModel(loginViewModel);
        mainBinding.btLoginCommit.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void myClick() {

    }

    @Override
    public void onSuccess(User objMsg) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onError(Object objMsg) {

    }

    @Override
    public void showDialog(String msg) {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLoginCommit:
                loginViewModel.reqLogin(mainBinding.etLoginName.getText().toString().trim(),mainBinding.etLoginPwd.getText().toString().trim());
                break;
        }
    }
}
