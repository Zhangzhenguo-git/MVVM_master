package com.example.mvvm_master.view.welcomepage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.mvvm_master.R;
import com.example.mvvm_master.base.BaseActivity;
import com.example.mvvm_master.databinding.ActivityWelcomePageBinding;

public class WelcomePageActivity extends AppCompatActivity {

    private ActivityWelcomePageBinding dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_welcome_page);

    }

}
