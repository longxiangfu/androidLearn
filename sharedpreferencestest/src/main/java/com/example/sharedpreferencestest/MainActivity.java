package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        保存数据
         */
        findViewById(R.id.btn_sharepre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取SharedPreference.Editor
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 32);
                editor.putBoolean("married", false);
                //提交
                editor.apply();
            }
        });

        /*
        读取数据
         */
        findViewById(R.id.btn_sharepre_restored).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取SharedPreference.Editor
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                //读取数据
                String name = pref.getString("name", null);
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married", false);
                Log.i("读取数据", name + "-" + age + "-" + married);
            }
        });
    }
}