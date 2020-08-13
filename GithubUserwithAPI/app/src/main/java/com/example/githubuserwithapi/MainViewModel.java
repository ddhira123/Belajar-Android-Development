package com.example.githubuserwithapi;

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


public class MainViewModel extends ViewModel {
    private MutableLiveData<ArrayList<User>> listUsers = new MutableLiveData<>();

    public MutableLiveData<ArrayList<User>> getListUsers() {
        return listUsers;
    }

    void setListUsers(final String query) {
        final ArrayList<User> listItems = new ArrayList<>();
        String url = "https://api.github.com/search/users?q=" + query;

        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization", "token ae3a34eb90b34f7ccb5695bbfd267a21d18959df");
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

