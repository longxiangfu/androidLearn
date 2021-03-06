package com.example.bdrev;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 广播接收:接收自定义标准广播和有序广播
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "接收者APP 收到自定义广播", Toast.LENGTH_SHORT).show();
    }

}
