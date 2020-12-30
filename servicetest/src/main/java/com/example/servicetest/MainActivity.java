package com.example.servicetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {
    private int num = 10;
    TextView tv_num;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 启动服务
         */
        findViewById(R.id.btn_start_sv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示启动服务
                Intent intent = new Intent(MainActivity.this, MyService.class);
                //Activity传递数据到Service
                intent.putExtra("data", "I am MainActivity");
                //启动
                startService(intent);
            }
        });

        /**
         * 停止服务
         */
        findViewById(R.id.btn_stop_sv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //停止服务
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });


        /**
         * 启动后台线程执行耗时任务
         */
        findViewById(R.id.btn_start_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 10;
                doBack();
            }
        });
        tv_num = findViewById(R.id.tv_num);


        /**
         * Looper 循环 去MessageQueue中取消息，分发消息->相应的Handler。主线程默认维护一个Looper，不用用户自己创建
         * Message 消息
         * MessageQueue  消息队列。不用用户自己创建
         * Handler 处理器  发送消息->MessageQueue,处理消息（由Looper分发而来）。在代码中我们主要关注这个
         */
        mHandler = new Handler(){//类似接口的匿名内部类
            @Override
            public void handleMessage(@NonNull Message msg) {
                //处理消息
                super.handleMessage(msg);
                switch (msg.what){
                    case 0x123:
                        //取出数据
                        int data = msg.getData().getInt("data");
                        Log.e("MainActivity", "Ui thread:" + data);
                        //主线程设置Ui
                        tv_num.setText("doBack num:" + data);
                        break;
                }
            }
        };
    }


    /**
     * 子线程执行一些耗时的任务
     */
    public void doBack(){
        new Thread(() ->{
            while (num-- > 0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("MainActivity", "doBack num:" + num);
                //子线程操作UI。会报错Only the original thread that created a view hierarchy can touch its views.
                //只能主线程操作UI
//                tv_num.setText("doBack num:" + num);

                //利用runOnUiThread，在主线程上操作UI，底层也是利用EventLoop机制
                //ui上num值有些滞后
//                runOnUiThread(() -> tv_num.setText("doBack num:" + num));

                //利用Handler，发送消息到主线程，然后主线程操作ui
                Message msg = new Message();
                msg.what = 0x123;//设定消息类型
                //设置数据
                Bundle bundle = new Bundle();
                bundle.putInt("data", num);
                msg.setData(bundle);
                //子线程发送消息->MessageQueue
                mHandler.sendMessage(msg);
            }
        }).start();

    }
}