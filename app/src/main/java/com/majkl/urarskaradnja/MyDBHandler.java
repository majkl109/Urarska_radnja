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
    public static final String COLUMN_NAME = "NazivSata";



    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
    String CREATE_SATOVI_TABLE = "CREATE TABLE SATOVI" + TABLE_NAME +"(" + COLUMN_ID +
    " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT " + ")";
    db.execSQL(CREATE_SATOVI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public String loadHandler(){
        String result = "";
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result = result_0 + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public  void addHandler(Satovi satovi){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, satovi.getSatID());
        values.put(COLUMN_NAME, satovi.getNazivSata());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Satovi findHandler(String nazivSata){
        String query = "Select * FROM " + TABLE_NAME + "WHERE" +
                COLUMN_NAME + " = '" + "'" + nazivSata;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery(query, null);
        Satovi satovi = new Satovi();
        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            satovi.setSatID(Integer.parseInt(cursor.getString(0)));
            satovi.setNazivSata(cursor.getString(1));
            cursor.close();
            }else {
            satovi = null;
            }
        db.close();
        return satovi;
        }

    public boolean deleteHandler(int ID){
        boolean result = false;
        String query = "Select * FROM" + TABLE_NAME + "WHERE" + COLUMN_ID + "= '" + ID + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Satovi satovi = new Satovi();
        if(cursor.moveToFirst()) {
            satovi.setSatID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN_ID + "=?",
                    new String[]{
                String.valueOf(satovi.getSatID())
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
    public boolean updateHandler(int ID, String naziv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, naziv);
        return  db.update(TABLE_NAME, args, COLUMN_ID + "="
                + ID, null) > 0;
    }

    }

