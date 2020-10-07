package com.example.githubuserwithfavorites.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.BaseColumns._ID;
import static com.example.githubuserwithfavorites.database.DatabaseContract.TABLE_NAME;
import static com.example.githubuserwithfavorites.database.DatabaseContract.UserColumns.USERNAME;

public class UserHelper {
    private static final String DATABASE_TABLE = TABLE_NAME;
    private static DatabaseHelper dataBaseHelper;
    private static UserHelper INSTANCE;
    private static SQLiteDatabase database;

    private UserHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static UserHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = dataBaseHelper.getWritableDatabase();
    }

    public void close() {
        dataBaseHelper.close();
        if (database.isOpen())
            database.close();
    }

    public Cursor queryByUsername(String username) {
        Cursor c = database.query(
                DATABASE_TABLE,
                null,
                USERNAME + " = ?",
                new String[]{username},
                null,
                null,
                null,
                null);
        c.moveToFirst();
        Log.d("The query result: ", c.getString(c.getColumnIndex(USERNAME)));
        return c;
    }

    public Cursor queryAll() {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                _ID + " ASC",
                null);
    }

    public long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    public int deleteByUsername(String username) {
        return database.delete(DATABASE_TABLE, USERNAME + " = ?", new String[]{username});
    }
}
