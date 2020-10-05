package helper;

import android.database.Cursor;

import java.util.ArrayList;

import database.DatabaseContract;
import model.User;

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
}
