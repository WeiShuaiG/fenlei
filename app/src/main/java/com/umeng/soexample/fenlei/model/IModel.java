package com.umeng.soexample.fenlei.model;


import com.umeng.soexample.fenlei.callback.MyCallBack;

public interface IModel {
    void getData(String url, int type, MyCallBack myCallBack);
}
