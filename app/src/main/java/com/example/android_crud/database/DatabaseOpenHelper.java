package com.example.android_crud.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public DatabaseOpenHelper(Context context) {
        super(context, "android-crud-db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            String student_table = "CREATE TABLE students (" +
                    " id INTEGER primary key AUTOINCREMENT NOT NULL, " +
                    " name TEXT, " +
                    " rollno INTEGER " +
                    ");";
            sqLiteDatabase.execSQL(student_table);
            System.out.println("db created=========================================");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
