package com.example.niu.myapplication.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/5/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    //***数据库名称
    private static  final String DATABASE_NAME = "z_qmai.db";
    //数据库版本号
    private static final int DATABASE_VERSION=5;
    //创建表,用户信息表
    public static final  String TABLE_USERINFO="user_info";
    //创建用户信息表，建表语句
    public static final String TABLE_CITYINFO="city_info";
    public static final String TABLE_PROVINCEINFO="province_info";

    private static final String CREATE_USERINFO_SQL="CREATE TABLE "
            + TABLE_USERINFO
            + " (_id Integer primary key autoincrement,"
            + " uid integer,"
            + " nickname text,"
            + " avatar_url text,"
            + " username text,"
            + " account text,"
            + " password text);";

    private static final String TABEL_WEATHERINFO = "weather_info";

    private static final String CREATE_WEATHER_SQL="CREATE TABLE "
            + TABEL_WEATHERINFO
            + " (_id Integer primary key autoincrement,"
            + " cityid integer,"
            + " weather text,"
            + " degree text);";

    //城市信息表
    private static final String CREATE_CITY_SQL="CREATE TABLE "
            + TABLE_CITYINFO
            + " (_id Integer primary key autoincrement,"
            + " province_id text,"
            + " city_num text,"
            + " name text);";
    //省份信息表
    private static final String CREATE_PROVINCE_SQL="CREATE TABLE "
            + TABLE_PROVINCEINFO
            + " (_id Integer primary key autoincrement,"
            + " name text,"
            + " province_id text);";

    public DBHelper (Context context)
    {
        this(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERINFO_SQL);
        db.execSQL(CREATE_WEATHER_SQL);
        db.execSQL(CREATE_PROVINCE_SQL);
        db.execSQL(CREATE_CITY_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_USERINFO);
            db.execSQL("DROP TABLE IF EXISTS "+ TABEL_WEATHERINFO);
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_CITYINFO);
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_PROVINCEINFO);
            onCreate(db);

        }
    }
}