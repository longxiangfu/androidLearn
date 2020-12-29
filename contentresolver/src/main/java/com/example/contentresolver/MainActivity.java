package com.example.contentresolver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.net.URI;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 按钮触发读取通讯录
         */
        findViewById(R.id.btn_read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCheckPermission();
            }
        });

    }

    /**
     * 授权读取通讯录
     */
    private void myCheckPermission() {
        //检查权限是否已经授权
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            //没有授权，请求用户授权。这里会跳出一个对话框
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    111);
        }else {
            //已经授权，读取通讯录
            readContact();
        }
    }


    /**
     * 读取通讯录
     */
    private void readContact() {
        //uri代替数据库的表
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,
                null,//相当于数据库column
                null,//条件
                null,//条件的附加参数
                null);//排序
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do{
                    //联系人名字
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    //电话
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Log.i("MainActivity", name + " " + number);
                }while (cursor.moveToNext());
            }
        }
    }


    /**
     * 请求授权的回调
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 111) {
            //是自己的请求
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //用户同意授权，读取通讯录
                readContact();
            }else {
                //用户没有授权
                Toast.makeText(this, "你没有授权我去读取通讯录", Toast.LENGTH_SHORT).show();
            }
        }

    }
}