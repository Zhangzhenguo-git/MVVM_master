package com.example.mvvm_master.http.retrofitinterface;

import com.example.mvvm_master.bean.NewsBean;
import com.example.mvvm_master.bean.User;
import com.example.mvvm_master.http.constant.URLConstant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

/**
 * 作者： 周旭 on 2017年10月17日 0017.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public interface RetrofitInterface {

    //登录
    @GET(URLConstant.URL_LOGIN)
    Observable<User> login(@Query("userName") String userName, @Query("userPwd") String userPwd);

    //获取“分类中搜索商品”的数据
    @GET(URLConstant.URL_PATH)
    Observable<NewsBean> getNewsData();
}
