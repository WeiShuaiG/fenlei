package com.umeng.soexample.fenlei.presenter;


import com.umeng.soexample.fenlei.callback.MyCallBack;
import com.umeng.soexample.fenlei.model.MyModel;
import com.umeng.soexample.fenlei.view.IView;

public class MyPresenter implements IPresenter{

    private MyModel myModel;
    private IView iView;

    public MyPresenter(IView iView) {
        this.iView = iView;
        myModel = new MyModel();
    }

    @Override
    public void startRequest(String url, final int type) {
        myModel.getData(url, type, new MyCallBack() {
            @Override
            public void setSuccess(Object successData) {
                switch (type){
                    case 1:
                        iView.success(successData);
                        break;
                    case 3:
                        iView.success(successData);
                        break;
                }
            }

            @Override
            public void setError(Object errorData) {
                switch (type){
                    case 1:
                        iView.error(errorData);
                        break;
                    case 3:
                        iView.error(errorData);
                        break;
                }
            }
        });
    }
}
