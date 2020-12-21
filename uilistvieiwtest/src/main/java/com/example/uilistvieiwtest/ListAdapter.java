package com.example.uilistvieiwtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<HotNews> {

    int mResource;

    /**
     * @param context
     * @param resource 对应单项布局hotnew_item
     * @param objects 数据列表
     */
    public ListAdapter(@NonNull Context context, int resource, @NonNull List<HotNews> objects) {
        super(context, resource, objects);
        this.mResource = resource;
    }


    /**
     * 每次显示某一单项的时候，被调用
     * @param position 当前单项的位置
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //根据当前位置，获取单项数据
        HotNews hotNews = this.getItem(position);
        //把单项布局inflate出来
        View view;
        ListViewHolder holder;
        if (convertView == null) {//实际上每次显示某一个单项时候，convertView都是null
            view = LayoutInflater.from(getContext()).inflate(this.mResource, parent, false);
            holder = new ListViewHolder();
            //标题
            holder.tv_news = view.findViewById(R.id.tv_news);
            //热度图片
            holder.iv_hot= view.findViewById(R.id.iv_hot);
            //分享图片
            holder.iv_share = view.findViewById(R.id.iv_share);
            //右侧的大图片
            holder.iv_img = view.findViewById(R.id.iv_img);
            //热度文本
            holder.tv_hot = view.findViewById(R.id.tv_hot);
            //分享文本
            holder.tv_share = view.findViewById(R.id.tv_share);

            view.setTag(holder);

        } else {
            view = convertView;
            holder = (ListViewHolder)view.getTag();
        }

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

        return view;
    }
}
