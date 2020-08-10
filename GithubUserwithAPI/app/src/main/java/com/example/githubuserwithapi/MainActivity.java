package com.example.githubuserwithapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private UserAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        SearchView searchView = findViewById(R.id.search_box);
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);

        RecyclerView recyclerView = findViewById(R.id.search_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickCallback(new UserAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(User data) {
                showSelectedUser(data);
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        showLoading(true);
        final ArrayList<User> listUsers = new ArrayList<>();
        String url = "https://api.github.com/search/users?q=" + query;

        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization", "token 7ca8cdacf2042ca26f9ffe28aff1cf333f07e830");
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
                        listUsers.add(user);
                    }
                    //set data ke adapter
                    adapter.setData(listUsers);
                    showLoading(false);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showLoading(false);
                Log.d("onFailure", error.getMessage());
            }
        });
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void showSelectedUser(User user) {
//        Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, UserDetails.class);
        intent.putExtra(UserDetails.EXTRA_USERNAME, user.getUserName());
        startActivity(intent);
    }
}