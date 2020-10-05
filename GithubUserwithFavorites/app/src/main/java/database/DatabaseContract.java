package database;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_NAME = "user";

    public static final class UserColumns implements BaseColumns {
        public static String USERNAME = "username";
        public static String PHOTO_URL = "photo";
    }
}
