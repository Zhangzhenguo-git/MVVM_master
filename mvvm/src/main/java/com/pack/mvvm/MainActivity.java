package com.pack.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pack.mvvm.databinding.ActivityMainBinding;
import com.pack.mvvm.lifecycle.MyLocationListener;
import com.pack.mvvm.lifecycle.MyService;
import com.pack.mvvm.lifecycle.OnLocationChanagedListener;

public class MainActivity extends AppCompatActivity {

    private final String TAG=this.getClass().getName();
    ActivityMainBinding binding;
    private MyLocationListener myLocationListener;
    private MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        myClick();
    }
    private void myClick(){
        binding.Lifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLocationListener=new MyLocationListener(MainActivity.this, new OnLocationChanagedListener() {
                    @Override
                    public void onChanged(double latitude, double longitude) {
                        Log.d(TAG,"------"+latitude+"------"+longitude);
                    }
                });
                //        将观察者与被观察者关联绑定起来
                getLifecycle().addObserver(myLocationListener);
            }
        });
        myService=new MyService(MainActivity.this, new OnLocationChanagedListener() {
            @Override
            public void onChanged(double latitude, double longitude) {
                Log.d(TAG,"======="+latitude+"======="+longitude);
            }
        });
        binding.LifecycleStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, myService.getClass());
                startService(intent);
            }
        });
        binding.LifecycleStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,myService.getClass());
                stopService(intent);
            }
        });

    }
}
