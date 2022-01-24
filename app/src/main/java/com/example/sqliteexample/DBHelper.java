package com.example.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "hongdroid.db";
    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS TodoList (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, content TEXT NOT NULL, writeDate TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onCreate(db);
    }

    public void InsertTodo(String _title, String _content, String _writeDate) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO TodoList (title, content, writeDate) VALUES('" + _title + "','" + _content + "', '" + _writeDate + "');");
    }

    public void UpdateTodo(String _title, String _content, String _writeDate, String _beforeDate) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE TodoList SET title='" + _title +"', content ='" + _content +"', writeDate='" + _writeDate +"' WHERE writeDate='" + _beforeDate +"'");
    }

    // DELETE 문 (할일 목록을 제거 한다.)
}
