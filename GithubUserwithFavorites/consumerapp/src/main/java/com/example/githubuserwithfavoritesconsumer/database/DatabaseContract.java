package com.example.githubuserwithfavoritesconsumer.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    public static final String AUTHORITY = "com.example.githubuserwithfavorites";
    private static final String SCHEME = "content";

    public static final String TABLE_NAME = "user";

    public static final class UserColumns implements BaseColumns {
        // Creating URI content://com.example.githubuserwithfavorites/user
        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build();
        public static final String USERNAME = "username";
        public static final String PHOTO_URL = "photo";
    }
}
