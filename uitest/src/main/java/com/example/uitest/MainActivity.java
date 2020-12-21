package com.example.uitest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 动态设置ImageView的图片资源
         */
        ImageView iv_test = findViewById(R.id.iv_test);
        findViewById(R.id.btn_iv_test).setOnClickListener(v -> {
            iv_test.setImageResource(R.drawable.chong);
        });


        /**
         * 自定义Toast
         */
        Button btn_self_toast = findViewById(R.id.btn_self_toast);
        btn_self_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast self_toast = Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_LONG);
                self_toast.setView(new MyView(MainActivity.this, null));//设置View,覆盖掉默认的文本View
                self_toast.show();
            }
        });

    }


    /**
     * 自定义View。需继承自ViewGroup
     * 定义成内部类时，用该构造函数即可。
     * 但是定义成外部类时，用该构造函数就会报错，可以换成别的构造
     */
//    class MyView extends LinearLayout{
//        public MyView(Context context) {
//            super(context);
//            LayoutInflater.from(context).inflate(R.layout.line_nest, this);//myView就相当于R.layout.line_nest对应的布局
//        }
//    }



}