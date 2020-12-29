package com.example.bdsdr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //本地广播管理器
    LocalBroadcastManager localBroadcastManager;
    //本地广播接收者
    LocalBroadcastReceiver localBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 发送标准广播
         */
        findViewById(R.id.btn_send_ord_bd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //构造一个Intent，指定发送广播的action
                Intent intent = new Intent("com.example.bdsdr.MY_BROADCAST");
                //发送
                sendBroadcast(intent);
            }
        });


        /**
         * 发送有序广播
         */
        findViewById(R.id.btn_send_order_bd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //构造一个Intent，指定发送广播的action
                Intent intent = new Intent("com.example.bdsdr.MY_BROADCAST");
                //发送
                sendOrderedBroadcast(intent, null);
            }
        });



        //获取本地广播管理器
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        //注册广播接收
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.bdsdr.LOCAL_BROADCAST");
        localBroadcastReceiver = new LocalBroadcastReceiver();
        localBroadcastManager.registerReceiver(localBroadcastReceiver, filter);
        /**
         * 发送本地广播
         */
        findViewById(R.id.btn_send_local_bd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //构造一个Intent，指定发送广播的action
                Intent intent = new Intent("com.example.bdsdr.LOCAL_BROADCAST");
                //通过本地广播管理器发送
                localBroadcastManager.sendBroadcast(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localBroadcastReceiver);
    }
}