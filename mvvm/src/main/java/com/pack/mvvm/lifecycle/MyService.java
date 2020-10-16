package com.pack.mvvm.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleService;

/**
 * @author Zhangzhenguo
 * @create 2020/10/15
 * @Email 18311371235@163.com
 * @Describe
 */
public class MyService extends LifecycleService {
    private MyServiceObServer myServiceObServer;
    private OnLocationChanagedListener listener;
    public MyService(Context context, final OnLocationChanagedListener listener){
        this.listener=listener;
//        实例化service的观察者
        myServiceObServer=new MyServiceObServer(context, new OnLocationChanagedListener() {
            @Override
            public void onChanged(double latitude, double longitude) {
                listener.onChanged(latitude,longitude);
            }
        });
//        将观察者与被观察者进行绑定
        getLifecycle().addObserver(myServiceObServer);

    }


    @Nullable
    @Override
    public IBinder onBind(@NonNull Intent intent) {
        return super.onBind(intent);

    }


}
