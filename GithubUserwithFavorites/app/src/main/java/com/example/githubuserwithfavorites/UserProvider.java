package com.example.githubuserwithfavorites;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import database.UserHelper;

import static database.DatabaseContract.AUTHORITY;
import static database.DatabaseContract.TABLE_NAME;
import static database.DatabaseContract.UserColumns.CONTENT_URI;

public class UserProvider extends ContentProvider {

    private static final int USER = 1;
    private static final int USER_UNAME = 2;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        // content://com.example.githubuserwithfavorite/user
        sUriMatcher.addURI(AUTHORITY, TABLE_NAME, USER);
        // content://com.example.githubuserwithfavorite/user/username
        sUriMatcher.addURI(AUTHORITY,
                TABLE_NAME + "/#",
                USER_UNAME);
    }

    private UserHelper userHelper;

    public UserProvider() {
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        userHelper = UserHelper.getInstance(getContext());
        userHelper.open();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        Cursor cursor;
        switch (sUriMatcher.match(uri)) {
            case USER:
                cursor = userHelper.queryAll();
                break;
            case USER_UNAME:
                Log.d("Ret username: ", uri.getLastPathSegment());
                cursor = userHelper.queryByUsername(uri.getLastPathSegment());
                break;
            default:
                cursor = null;
                break;
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        long added;
        switch (sUriMatcher.match(uri)) {
            case USER:
                added = userHelper.insert(values);
                break;
            default:
                added = 0;
                break;
        }
        getContext().getContentResolver().notifyChange(CONTENT_URI, null);
        return Uri.parse(CONTENT_URI + "/" + added);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        int deleted;
        switch (sUriMatcher.match(uri)) {
            case USER_UNAME:
                deleted = userHelper.deleteByUsername(uri.getLastPathSegment());
                break;
            default:
                deleted = 0;
                break;
        }
        getContext().getContentResolver().notifyChange(CONTENT_URI, null);
        return deleted;
    }
}