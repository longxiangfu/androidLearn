package com.example.uirecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    List<HotNews> hotNewsList = new ArrayList<>();

    public RecyclerAdapter(List<HotNews> hotNewsList){
        this.hotNewsList = hotNewsList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate出子项布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotnew_item, parent, false);
        //构造RecyclerViewHolder
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        //click右侧大图
        recyclerViewHolder.iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当前click的单项位置
                int position = recyclerViewHolder.getAdapterPosition();
                HotNews hotNews = hotNewsList.get(position);
                Toast.makeText(v.getContext(), hotNews.getNews_id(), Toast.LENGTH_SHORT).show();
            }
        });

        //click热度图片
        recyclerViewHolder.iv_hot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = recyclerViewHolder.getAdapterPosition();
                HotNews hotNews = hotNewsList.get(position);
                hotNews.setHot(hotNews.getHot() + 1);//点击一次，数值+1
                notifyDataSetChanged();//发出通知，让UI更新
            }
        });

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        HotNews hotNews = hotNewsList.get(position);
        //标题
        holder.tv_news.setText(hotNews.getNews_id());
        //热度图片
        holder.iv_hot.setImageResource(hotNews.getHot_img_id());
        //分享图片
        holder.iv_share.setImageResource(hotNews.getShare_img_id());
        //右侧的大图片
        holder.iv_img.setImageResource(hotNews.getImg_id());
        //热度文本
        holder.tv_hot.setText(String.valueOf(hotNews.getHot()));
        //分享文本
        holder.tv_share.setText(String.valueOf(hotNews.getShare()));
    }

    @Override
    public int getItemCount() {
        return hotNewsList.size();
    }
}
