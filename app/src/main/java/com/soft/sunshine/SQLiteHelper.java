package com.soft.sunshine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String name = "sunshine.db";
    private static final int version = 1;

    public SQLiteHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //table goods (sj, sl, zq)
        db.execSQL("CREATE TABLE [goods] (sj INTEGER PRIMARY KEY,sl INTEGER,zq REAL)");
        //table sale_mx (rq, sj, sl, zq, je)
        db.execSQL("CREATE TABLE [sale_mx] (rq DATETIME PRIMARY KEY,sj INTEGER,sl INTEGER,zq REAL,je INTEGER)");
        //table sale_db (rq, sl, je, ss, zl)
        db.execSQL("CREATE TABLE [sale_db] (rq DATETIME PRIMARY KEY,sl INTEGER,je INTEGER,ss INTEGER,zl INTEGER)");
        //table rk (rq, sj, sl)
        db.execSQL("CREATE TABLE [rk] (rq DATETIME PRIMARY KEY,sj INTEGER,sl INTEGER)");
        //table ck (rq, sj, sl)
        db.execSQL("CREATE TABLE [ck] (rq DATETIME PRIMARY KEY,sj INTEGER,sl INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
