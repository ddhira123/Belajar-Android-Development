package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import model.User;

import static android.provider.BaseColumns._ID;
import static database.DatabaseContract.TABLE_NAME;
import static database.DatabaseContract.UserColumns.PHOTO_URL;
import static database.DatabaseContract.UserColumns.USERNAME;

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

    public long insert(User user) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(USERNAME, user.getUserName());
        initialValues.put(PHOTO_URL, user.getPhoto());
        Log.d("Uname:", user.getUserName());
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, _ID + " = ?", new String[]{id});
    }
}
