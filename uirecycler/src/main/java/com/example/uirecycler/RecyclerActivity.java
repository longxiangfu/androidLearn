package com.example.uirecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    List<HotNews> hotNewsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //找到RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        initHotNewsList();//初始化数据
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(hotNewsList);
        recyclerView.setAdapter(recyclerAdapter);


    }


    public void initHotNewsList(){
        for (int i = 0; i < 10; i++) {
            HotNews hotNews = new HotNews();
            hotNews.setNews_id(getResources().getIdentifier("news_" + (i+1), "string", getPackageName()));
            hotNews.setImg_id(getResources().getIdentifier("img" + (i+1), "drawable", getPackageName()));
            hotNews.setHot_img_id(R.drawable.hot);
            hotNews.setShare_img_id(R.drawable.share);
            hotNews.setHot(i*3+1);
            hotNews.setShare(i*8+1);
            hotNewsList.add(hotNews);
        }
    }
}