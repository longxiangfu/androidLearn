package com.example.uilistvieiwtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    List<HotNews> hotNewsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //找到listview
        ListView listView = findViewById(R.id.listview);
        //初始化数据list
        initHotNewsList();
        //初始化Adapter
        ListAdapter listAdapter = new ListAdapter(this, R.layout.hotnew_item, hotNewsList);
        //ListView设置Adapter
        listView.setAdapter(listAdapter);
        //设置ListView单击监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position表示被click的是哪一个
                HotNews hotNews = hotNewsList.get(position);
                Toast.makeText(ListActivity.this, hotNews.getNews_id(), Toast.LENGTH_LONG).show();
            }
        });
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