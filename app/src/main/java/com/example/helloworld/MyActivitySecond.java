package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MyActivitySecond extends AppCompatActivity {

    private static final String TAG = "MyActivitySecond";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_second);

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("key1");
        int value2 = intent.getIntExtra("key2", 0);
//        Log.i(TAG, value1);
//        Log.i(TAG, String.valueOf(value2));


        View data_return_btn = findViewById(R.id.btn_data_return);
        data_return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("A2_data", "A2 return data xxx");
                setResult(RESULT_OK, intent1);//返回数据
                finish();//结束A2,返回A1
            }
        });
    }
}