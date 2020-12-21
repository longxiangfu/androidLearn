package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    Button toast_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        /**
         * 跳转模拟器app赚钱页面
         */
//        View moniApp_btn = findViewById(R.id.btn_moniApp);
//        moniApp_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MyActivity.this, MoniAppActivity.class));
//            }
//        });


        /**
         * 课堂练习
         */
        toast_btn = findViewById(R.id.btn_toast);//父类AppCompatActivity的方法
//        toast_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast toast = Toast.makeText(MyActivity.this, "面包烤焦了", Toast.LENGTH_LONG);
//                toast.show();
//            }
//        });
        toast_btn.setOnClickListener(v -> {
            /*
            弹框消息
             */
//            Toast toast = Toast.makeText(MyActivity.this, "面包烤焦了", Toast.LENGTH_LONG);
//            toast.show();
            /*
            Activity间显示跳转
             */
//            Intent intent = new Intent(MyActivity.this, MyActivitySecond.class);
//            startActivity(intent);
            /*
            Activity间隐式跳转
             */
            //普通隐式跳转
//            Intent intent = new Intent("com.example.helloworld.MyActivitySecond.MY_ACTION");
//            intent.addCategory("com.example.helloworld.MyActivitySecond.MY_CATEGORY");
//            intent.addCategory("com.example.helloworld.MyActivitySecond.MY_CATEGORY1");
//            startActivity(intent);
            //打开网页的隐式跳转
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("http://www.baidu.com"));
//            startActivity(intent);

            /**
             * Activity间传递参数
             */
            //数据正向传递
            Intent intent = new Intent(MyActivity.this, MyActivitySecond.class);
            intent.putExtra("key1", "hello world");
            intent.putExtra("key2", 22222);
            startActivity(intent);
        });


        /**
         * Activity间传递参数
         */
        //请求数据传回
        View data_trans_btn = findViewById(R.id.btn_data_trans);
        data_trans_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, MyActivitySecond.class);
                startActivityForResult(intent, 111);
            }
        });
    }
    /**
     * Activity间传递参数  请求数据返回的监听
     * 重写父类方法。先写@Override会弹出框选择重写方法
     * @param requestCode  请求码
     * @param resultCode 结果码
     * @param data Intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 111:
                if (resultCode == RESULT_OK){
                    String a2_data = data.getStringExtra("A2_data");
                    Log.i(TAG, a2_data);
                }
                break;
            default:
                break;
        }


    }
}