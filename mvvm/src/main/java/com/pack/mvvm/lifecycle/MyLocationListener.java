package com.pack.mvvm.lifecycle;

import android.app.Activity;
import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author Zhangzhenguo
 * @create 2020/10/9
 * @Email 18311371235@163.com
 * @Describe
 */
//观察者
public class MyLocationListener implements LifecycleObserver {
    private final  String TAG=this.getClass().getName();
    private  OnLocationChanagedListener onLocationChanagedListener;

    public MyLocationListener(Activity context,OnLocationChanagedListener onListener){
        onLocationChanagedListener=onListener;
//        初始化操作
        initLocationManager();
    }

    /**
     * 初始化
     */
    private void initLocationManager() {
    }

    /**
     * 使用注解注册一个onResume生命周期观察者，
     * 当activity执行onResume方法时，该方法会自动调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startGetLocation(){
        Log.d(TAG,"startGetLocation");
        onLocationChanagedListener.onChanged(111,111);
    }

    /**
     * 和onResume一样，当activiyt执行onStop方法时，该方法自动被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void stopGetLocation(){
        Log.d(TAG,"stopGetLocation");
    }

}
