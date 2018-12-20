package com.umeng.soexample.fenlei.callback;

public interface MyCallBack<T> {
    void setSuccess(T successData);
    void setError(T errorData);
}
