package com.example.githubuserwithfavorites.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.githubuserwithfavorites.database.DatabaseContract.TABLE_NAME;
import static com.example.githubuserwithfavorites.database.DatabaseContract.UserColumns.PHOTO_URL;
import static com.example.githubuserwithfavorites.database.DatabaseContract.UserColumns.USERNAME;
import static com.example.githubuserwithfavorites.database.DatabaseContract.UserColumns._ID;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbgithubuserapp";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_NOTE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s )",
            TABLE_NAME,
            _ID,
            USERNAME,
            PHOTO_URL
    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(db);
    }
}
