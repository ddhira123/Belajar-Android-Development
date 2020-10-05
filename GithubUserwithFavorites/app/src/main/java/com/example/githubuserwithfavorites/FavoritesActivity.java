package com.example.githubuserwithfavorites;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import adapter.UserAdapter;
import database.UserHelper;
import helper.MappingHelper;
import model.User;

interface LoadUsersCallback {
    void preExecute();

    void postExecute(ArrayList<User> users);
}

public class FavoritesActivity extends AppCompatActivity implements LoadUsersCallback {
    private UserAdapter adapter;
    private ProgressBar progressBar;
    private TextView tv_empty;
    private UserHelper userHelper;
    private RecyclerView rvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Favorites");

        rvUsers = findViewById(R.id.fav_list);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        rvUsers.setAdapter(adapter);
        userHelper = UserHelper.getInstance(getApplicationContext());
        userHelper.open();
        adapter.notifyDataSetChanged();
        new LoadUsersAsync(userHelper, this).execute();
        adapter.setOnItemClickCallback(new UserAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(User data) {
                showSelectedUser(data);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userHelper.close();
    }

    @Override
    public void preExecute() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void postExecute(ArrayList<User> users) {
        progressBar.setVisibility(View.INVISIBLE);
        if (users.size() > 0) {
            adapter.setData(users);
        } else {
            adapter.setData(new ArrayList<User>());
            showSnackbarMessage("Anda belum memiliki pengguna kesukaan Anda.");
        }
    }

    private void showSnackbarMessage(String message) {
        Snackbar.make(rvUsers, message, Snackbar.LENGTH_SHORT).show();
    }

    private void showSelectedUser(User user) {
        Intent intent = new Intent(FavoritesActivity.this, UserDetails.class);
        intent.putExtra(UserDetails.EXTRA_USERNAME, user.getUserName());
        startActivity(intent);
    }

    private static class LoadUsersAsync extends AsyncTask<Void, Void, ArrayList<User>> {
        private final WeakReference<UserHelper> weakUserHelper;
        private final WeakReference<LoadUsersCallback> weakCallback;

        private LoadUsersAsync(UserHelper userHelper, LoadUsersCallback callback) {
            weakUserHelper = new WeakReference<>(userHelper);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            weakCallback.get().preExecute();
        }

        @Override
        protected ArrayList<User> doInBackground(Void... voids) {
            Cursor dataCursor = weakUserHelper.get().queryAll();
            return MappingHelper.mapCursorToArrayList(dataCursor);
        }

        @Override
        protected void onPostExecute(ArrayList<User> users) {
            super.onPostExecute(users);
            weakCallback.get().postExecute(users);
        }
    }
}