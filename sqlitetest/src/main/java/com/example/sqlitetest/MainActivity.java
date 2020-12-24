package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDbHelper = new MyDbHelper(this,//context
                "BookStore.db",//数据库文件名字
                null,
                1);//版本号

        /**
         * 新建数据库
         */
        findViewById(R.id.btn_createdb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //任意操作一下，就操作数据库。该方法会回调onCreate
                myDbHelper.getWritableDatabase();
            }
        });

        /**
         * 添加数据
         */
        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The first line code");
                values.put("autor", "longxiangfu");
                values.put("price", 20.1);
                values.put("pages", 300);
                db.insert("Book", null, values);
                values.clear();
                values.put("name", "The second line code");
                values.put("autor", "chenting");
                values.put("price", 30.1);
                values.put("pages", 400);
                db.insert("Book", null, values);
                Log.i("MainActivity", "添加数据成功");
            }
        });


        /**
         * 修改数据
         */
        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                //组装数据
                ContentValues values = new ContentValues();
                values.put("price", 15.23);
                db.update("Book",//表名
                        values,//values
                        "name = ?",//条件
                        new String[]{"The first line code"});
                Log.i("MainActivity", "修改数据成功");
            }
        });


        /**
         * 删除数据
         */
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[]{"350"});
                Log.i("MainActivity", "删除数据成功");
            }
        });


        /**
         * 查询数据
         */
        findViewById(R.id.btn_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                //查询，返回游标。可以添加查询条件
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {//游标移动到第一行，并且判断是否有数据
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String autor = cursor.getString(cursor.getColumnIndex("autor"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        Log.i("MainActivity", "name:" + name + "autor:" + autor + "price:" + price + "pages:" + pages);

                    }while (cursor.moveToNext());//游标移动到下一行，如果有数据则继续取出
                }
                //关闭游标
                cursor.close();
            }
        });


    }
}