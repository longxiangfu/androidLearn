package com.example.bdrev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    NetBroadcastReceiver netBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //利用IntentFilter，过滤广播
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netBroadcastReceiver = new NetBroadcastReceiver();
        //注册广播接收
        registerReceiver(netBroadcastReceiver, filter);
    }

    /**
     * 动态注册时需要注销
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netBroadcastReceiver);
    }
}