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
        //table goods (tm, pm, sj, kc)
        db.execSQL("CREATE TABLE [goods] (tm TEXT PRIMARY KEY,pm TEXT,sj INTEGER,kc INTEGER)");
        //table sale_mx (djh, tm, sj, zq, je)
        db.execSQL("CREATE TABLE [sale_mx] (djh TEXT,tm TEXT,sj INTEGER,zq REAL,je INTEGER)");
        //table sale_db (djh, sl, je, ss, zl, rq)
        db.execSQL("CREATE TABLE [sale_db] (djh TEXT PRIMARY KEY,sl INTEGER,je INTEGER,ss INTEGER,zl INTEGER,rq DATETIME)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
