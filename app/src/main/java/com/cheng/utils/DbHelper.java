package com.cheng.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cheng on 2016/8/19 0019.
 */
public class DbHelper extends SQLiteOpenHelper {
    private final static String DABASENAME="tickets";
    private final static int VERSION=1;
    public DbHelper(Context context){//创建数据库
        super(context,DABASENAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//创建数据表
        String sql = "create table contact(contactId integer primary key autoincrement" +
        ",contactName varchar(50) not null" +
                ",contactCardID varchar(50) not null" +
                ",contactPhone varchar(50)" +
                ",contactState integer)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exist contact";
        db.execSQL(sql);
        this.onCreate(db);
    }
}
