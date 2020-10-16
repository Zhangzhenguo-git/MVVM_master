package com.pack.mvvm.lifecycle;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author Zhangzhenguo
 * @create 2020/10/15
 * @Email 18311371235@163.com
 * @Describe
 */
public class MyServiceObServer implements LifecycleObserver {
    private final String TAG=this.getClass().getName();
    private OnLocationChanagedListener listener;

    public MyServiceObServer(Context context,OnLocationChanagedListener listener){
        this.listener=listener;
    }

    /**
     * 在service中与lifecycle进行解耦获取当activity调用onCreate方法时自动调用此方法
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startGetLocation(){
        Log.d(TAG,"startGetLocation");
        listener.onChanged(111,111);
    }
    /**
     * 在service中与lifecycle进行解耦获取当activity调用onDestroy方法时自动调用此方法
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopGetLocation(){
        Log.d(TAG,"stopGetLocation");
        listener.onChanged(00,00);
    }
}
