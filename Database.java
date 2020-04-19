package com.example.login;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final  String db_name="pass.db";
    public static final  String table_name="c_table";
    public static final  String mirror_name="name";
    public static final  String mirror_code="code";

    SQLiteDatabase db;
    public DatabaseHelper (@Nullable Context context)
    {
        super(context,db_name,null,1);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=" create table "+table_name+"(code INTEGER )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q= "DROP TABLE IF EXISTS "+table_name;
        db.execSQL(q);
        onCreate(db);

    }

    public String check(int code) {
        int b = -1;
        //StringBuffer mirror=new StringBuffer();
        int t=0;


        Cursor c = db.rawQuery("SELECT * FROM " + table_name, null);
        while (c.moveToNext()) {
            //String n=null;
            b = (c.getInt(0));


        }

        if (b== code)
            return ("Success");
        else {
            return ("Incorrect Code");
        }

    }


    public void insert( int c)
        {
            String query = "INSERT INTO c_table VALUES ("+c+ ");";
            db.execSQL(query);
        }


    }
