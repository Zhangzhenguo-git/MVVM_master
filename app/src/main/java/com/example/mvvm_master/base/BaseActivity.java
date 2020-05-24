package com.example.mvvm_master.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getCententView());
        initView();
        initData();
        myClick();

    }
    protected abstract int getCententView();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void myClick();
    protected ProgressDialog progressDialog;

    /**
     * 显示loding框
     * @param title
     * @param msg
     */
    protected void showProgressDialog(String title,String msg){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage(msg);
        }
    }
}
