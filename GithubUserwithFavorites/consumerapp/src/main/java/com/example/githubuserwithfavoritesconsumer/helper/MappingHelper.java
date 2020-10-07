package com.example.githubuserwithfavoritesconsumer.helper;

import android.database.Cursor;

import com.example.githubuserwithfavoritesconsumer.database.DatabaseContract;
import com.example.githubuserwithfavoritesconsumer.model.User;

import java.util.ArrayList;

public class MappingHelper {

    public static ArrayList<User> mapCursorToArrayList(Cursor usersCursor) {
        ArrayList<User> usersList = new ArrayList<>();
        while (usersCursor.moveToNext()) {
            int id = usersCursor.getInt(usersCursor.getColumnIndexOrThrow(DatabaseContract.UserColumns._ID));
            String username = usersCursor.getString(usersCursor.getColumnIndexOrThrow(DatabaseContract.UserColumns.USERNAME));
            String photoURL = usersCursor.getString(usersCursor.getColumnIndexOrThrow(DatabaseContract.UserColumns.PHOTO_URL));
            usersList.add(new User(id, username, photoURL));
        }
        return usersList;
    }

    public static User mapCursorToObject(Cursor usersCursor) {
        usersCursor.moveToFirst();
        int id = usersCursor.getInt(usersCursor.getColumnIndexOrThrow(DatabaseContract.UserColumns._ID));
        String username = usersCursor.getString(usersCursor.getColumnIndexOrThrow(DatabaseContract.UserColumns.USERNAME));
        String photoURL = usersCursor.getString(usersCursor.getColumnIndexOrThrow(DatabaseContract.UserColumns.PHOTO_URL));
        return new User(id, username, photoURL);
    }
}
