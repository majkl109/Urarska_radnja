package com.majkl.urarskaradnja;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="satoviDB.db";
    public static final String TABLE_NAME = "Satovi";
    public static final String COLUMN_ID = "SatID";
    public static final String TABLE_NAME = "NazivSata";

    public MyDBHandler(Context context, Stringname, SQLiteDatabase.CursorFactory factory, intversion) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){}

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){}
    public String loadHandler{}
    public  void addHandler(Satovi satovi){}
    public Satovi findHandler(String nazivsata){}
    public boolean deleteHandler(int ID){}
    public boolean updateHandler(int ID, String naziv){}

}