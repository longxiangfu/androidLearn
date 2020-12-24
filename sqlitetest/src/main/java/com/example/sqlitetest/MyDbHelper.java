package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {

    private Context context;
    final static String CREATE_BOOK = "create table Book (id integer primary key autoincrement," +
            "autor text," +
            "price real," +
            "pages integer," +
            "name text)";

    public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    /**
     * 在其中创建数据库和表
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(context, "创建数据库成功", Toast.LENGTH_LONG).show();
    }

    /**
     * 在其中更新数据库
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
