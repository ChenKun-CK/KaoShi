package com.example.kaoshi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by WangZhiQiang on 2018/4/16.
 */
public class Dao {

    private SQLiteHelper helper;

    public Dao(Context context) {
        helper = new SQLiteHelper(context);
    }
    //插入
    public void insert(String lu){
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("lu",lu);
        database.insert("texts",null,values);
    }
    //查询数据库
    public List<String> select(){
        SQLiteDatabase database = helper.getReadableDatabase();
        List<String> list=new ArrayList<>();
        Cursor texts = database.query("texts", null, null, null, null, null, null);
        while (texts.moveToNext()){
            String lu = texts.getString(texts.getColumnIndex("lu"));
            list.add(lu);
        }
        return list;
    }
    //清空
    public void delete(){
        SQLiteDatabase database = helper.getWritableDatabase();
        database.delete("texts",null,null);
    }
}
