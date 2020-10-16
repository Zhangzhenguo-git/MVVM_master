package com.pack.mvvm.lifecycle;

/**
 * @author Zhangzhenguo
 * @create 2020/10/15
 * @Email 18311371235@163.com
 * @Describe
 */
/**
 *当地理位置发生变化时，通过此接口通知调用者
 */
public interface OnLocationChanagedListener {
    void onChanged(double latitude,double longitude);
}
