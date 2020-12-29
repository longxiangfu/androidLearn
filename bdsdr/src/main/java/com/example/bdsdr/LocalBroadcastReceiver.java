package com.example.bdsdr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 接收本地广播
 */
public class LocalBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到本地广播", Toast.LENGTH_SHORT).show();
    }

}
