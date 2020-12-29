package com.example.bdrev;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 广播接收:在开机状态下发生的广播，使用动态注册
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到网络变化", Toast.LENGTH_SHORT).show();
    }

}
