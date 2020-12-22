package com.example.uirecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置布局的方向为水平方向，默认是垂直方向
//        //设置瀑布流布局管理器
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(
//                3,//一行3列
//                StaggeredGridLayoutManager.VERTICAL//方向垂直
//        );
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
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