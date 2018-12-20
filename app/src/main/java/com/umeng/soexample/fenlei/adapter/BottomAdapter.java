package com.umeng.soexample.fenlei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.umeng.soexample.fenlei.R;
import com.umeng.soexample.fenlei.bean.BottomBean;

import java.util.List;


public class BottomAdapter extends RecyclerView.Adapter<BottomAdapter.ViewHolder> {

    private List<BottomBean.DataBean> list;
    private Context context;

    public BottomAdapter(List<BottomBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.bottomitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        BottomBean.DataBean dataBean = list.get(i);
        Glide.with(context).load(dataBean.getThumbnail_pic_s()).into(viewHolder.bottomimg);
        viewHolder.bottomtv.setText(dataBean.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView bottomimg;
        private TextView bottomtv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bottomimg = itemView.findViewById(R.id.bottomimg);
            bottomtv = itemView.findViewById(R.id.bottomtv);
        }
    }
}
