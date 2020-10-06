package com.example.githubuserwithfavorites.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;
import model.User;

import static com.example.githubuserwithfavorites.BuildConfig.GITHUB_TOKEN;

public class PageViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<User>> listUsers = new MutableLiveData<>();

    public MutableLiveData<ArrayList<User>> getListFolUsers() {
        return listUsers;
    }

    void setListFolUsers(final String username, final String section) {
        final ArrayList<User> listItems = new ArrayList<>();
        String url = urlSelector(username, section);
        Log.d("URL: ", url);
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization", new StringBuilder().append("token ").append(GITHUB_TOKEN).toString());
        client.addHeader("User-Agent", "request");
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    //parsing json
                    String result = new String(responseBody);
                    Log.d("Hasil JSON", result);
                    JSONArray list = new JSONArray(result);
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject userItems = list.getJSONObject(i);
                        User user = new User();
                        user.setUserName(userItems.getString("login"));
                        user.setPhoto(userItems.getString("avatar_url"));
                        listItems.add(user);
                    }
                    //set data ke adapter
                    listUsers.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Status Code: ", String.valueOf(statusCode));
                Log.d("Response Body: ", Arrays.toString(responseBody));
                Log.d("onFailure", error.toString());
            }
        });
    }

    private String urlSelector(final String username, final String section) {
        if (section.equals("Follower(s)")) {
            return ("https://api.github.com/users/" + username + "/followers");
        } else {
            return ("https://api.github.com/users/" + username + "/following");
        }
    }

}