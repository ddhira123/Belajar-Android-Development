package com.example.githubuserwithfavoritesconsumer;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubuserwithfavoritesconsumer.model.User;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;


public class MainViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<User>> listUsers = new MutableLiveData<>();

    public MutableLiveData<ArrayList<User>> getListUsers() {
        return listUsers;
    }

    void setListUsers(final String query) {
        final ArrayList<User> listItems = new ArrayList<>();
        String url = "https://api.github.com/search/users?q=" + query;

        AsyncHttpClient client = new AsyncHttpClient();
//        client.addHeader("Authorization", new StringBuilder().append("token ").append(GITHUB_TOKEN).toString());
        client.addHeader("User-Agent", "request");
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    //parsing json
                    String result = new String(responseBody);
                    Log.d("Hasil JSON", result);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("items");
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
}

