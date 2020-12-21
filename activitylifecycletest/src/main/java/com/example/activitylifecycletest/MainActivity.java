package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");

        /**
         * 测试activity生命周期
         */
        //正常的activity
        findViewById(R.id.start_normal).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Main2Activity.class)));
//        12-14 08:16:07.300 30014-30014/com.example.activitylifecycletest I/MainActivity: onPause
//        12-14 08:16:07.978 30014-30014/com.example.activitylifecycletest I/MainActivity: onStop
//        12-14 08:16:12.317 30014-30014/com.example.activitylifecycletest I/MainActivity: onRestart
//        12-14 08:16:12.318 30014-30014/com.example.activitylifecycletest I/MainActivity: onStart
//        12-14 08:16:12.318 30014-30014/com.example.activitylifecycletest I/MainActivity: onResume
        //对话框类型的activity
        findViewById(R.id.start_dialog).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Main3Activity.class)));
//        12-14 08:16:19.359 30014-30014/com.example.activitylifecycletest I/MainActivity: onPause
//        12-14 08:16:23.766 30014-30014/com.example.activitylifecycletest I/MainActivity: onResume
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");

    }
}