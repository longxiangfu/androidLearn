package com.example.uirecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_news;
    public TextView tv_hot;
    public TextView tv_share;
    public ImageView iv_img;
    public ImageView iv_hot;
    public ImageView iv_share;

    public RecyclerViewHolder(@NonNull View view) {
        super(view);
        //标题
        this.tv_news = view.findViewById(R.id.tv_news);
        //热度图片
        this.iv_hot= view.findViewById(R.id.iv_hot);
        //分享图片
        this.iv_share = view.findViewById(R.id.iv_share);
        //右侧的大图片
        this.iv_img = view.findViewById(R.id.iv_img);
        //热度文本
        this.tv_hot = view.findViewById(R.id.tv_hot);
        //分享文本
        this.tv_share = view.findViewById(R.id.tv_share);
    }
}
