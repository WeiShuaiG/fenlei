package com.umeng.soexample.fenlei.view;

public interface IView<T> {
    void success(T success);
    void error(T error);
}
