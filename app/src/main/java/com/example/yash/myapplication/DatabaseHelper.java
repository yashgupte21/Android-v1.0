package com.example.yash.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME='user_details.db';
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "uid";
    public static final String COL_2 = "Fullname";
    public static final String COL_3 = "Username";
    public static final String COL_4 = "Password";
    public static final String COL_5 = "Contactno";


    @Override
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //To see if db is created we use following line
        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table" + TABLE_NAME +" ( uid INTEGER PRIMARY KEY AUTOINCREMENT, Fullname TEXT, Username TEXT, Password VARCHAR , Contactno INTEGER) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS"+TABLE_NAME );
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String Fullname , String Username , String Password , String Contactno){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,Fullname);
        contentValues.put(COL_3,Username);
        contentValues.put(COL_4,Password);
        contentValues.put(COL_5,Contactno);

        long result=  sqLiteDatabase.insert(TABLE_NAME , null , contentValues);

        if(result == -1)
            return false;
        else
            return true;


    }

}
