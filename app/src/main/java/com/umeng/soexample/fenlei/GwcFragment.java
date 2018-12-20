package com.umeng.soexample.fenlei;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.umeng.soexample.fenlei.adapter.LeftAdapter;
import com.umeng.soexample.fenlei.adapter.RightAdapter;
import com.umeng.soexample.fenlei.bean.Food;
import com.umeng.soexample.fenlei.presenter.MyPresenter;
import com.umeng.soexample.fenlei.view.IView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GwcFragment<T> extends Fragment implements IView<T>{


    private String url = "http://www.wanandroid.com/tools/mockapi/6523/restaurant-list";
    private RecyclerView recyLeft;
    private RecyclerView recyRight;
    private List<Food.DataBean> list = new ArrayList<>();
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    private MyPresenter myPresenter;
    private TextView shangjia;
    private TextView jiesuan;
    List<Food.DataBean.SpusBean> spus=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gwc, container, false);
        initView(view);
        leftAdapter = new LeftAdapter(list, getActivity());
        rightAdapter = new RightAdapter(spus, getActivity());
        recyLeft.setAdapter(leftAdapter);
        recyRight.setAdapter(rightAdapter);

        myPresenter = new MyPresenter(this);
        myPresenter.startRequest(url, 3);
        leftAdapter.setOnClick(new LeftAdapter.Callback() {
            @Override
            public void setOnItemClick(View view, int position) {
                //刚进去数量全部为0
                spus.addAll(list.get(position).getSpus());
                for (int i = 0; i <spus.size() ; i++) {
                    spus.get(i).setPraise_num(0);
                }
                rightAdapter.notifyDataSetChanged();
                shangjia.setText(list.get(position).getName());

            }
        });
        rightAdapter.setCallBack(new RightAdapter.AdapterCallBack() {
            @Override
            public void shuaxin() {
                jiesuan.setText(rightAdapter.getGoodsPrice()+"");
            }
        });


        return view;
    }

    private void initView(View view) {
        recyLeft = view.findViewById(R.id.recyLeft);
        LinearLayoutManager leftManager = new LinearLayoutManager(getActivity());
        recyLeft.setLayoutManager(leftManager);

        recyRight = view.findViewById(R.id.recyRight);
        LinearLayoutManager rightManager = new LinearLayoutManager(getActivity());
        recyRight.setLayoutManager(rightManager);
        shangjia = view.findViewById(R.id.shangjia);
        jiesuan = view.findViewById(R.id.jiesuan);

    }



    //Iview

    @Override
    public void success(T success) {
        final Food food = (Food) success;
        list.addAll(food.getData());

        leftAdapter.notifyDataSetChanged();

        //调用接口回调方法给右边适配器赋值


    }




    @Override
    public void error(T error) {

    }

}
