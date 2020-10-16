package com.pack.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pack.mvvm.databinding.ActivityMainBinding;
import com.pack.mvvm.lifecycle.MyLocationListener;
import com.pack.mvvm.lifecycle.MyService;
import com.pack.mvvm.lifecycle.OnLocationChanagedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG=this.getClass().getName();
    ActivityMainBinding binding;
    private MyLocationListener myLocationListener;
    private MyService myService;
    private MyAdapter adapter;
    private List<String> listss;
    String imgUrll="https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        myClick();
        listss=new ArrayList<>();
        for (int i=0;i<20;i++){
            listss.add(imgUrll);
        }
        adapter=new MyAdapter(MainActivity.this,listss);
        binding.recyListview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyListview.setAdapter(adapter);
        adapter.setOnClcik(new MyAdapter.MyonListener() {
            @Override
            public void onChanged(int position) {
                adapter.notifyItemChanged(position);
            }
        });
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
