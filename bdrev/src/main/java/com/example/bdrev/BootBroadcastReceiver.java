package com.example.bdrev;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 广播接收: 系统刚启动时，使用静态注册
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到系统启动", Toast.LENGTH_LONG).show();
    }

}
