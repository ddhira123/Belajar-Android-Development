package com.example.githubuserwithfavorites;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubuserwithfavorites.adapter.UserAdapter;
import com.example.githubuserwithfavorites.database.DatabaseContract;
import com.example.githubuserwithfavorites.helper.MappingHelper;
import com.example.githubuserwithfavorites.model.User;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

interface LoadUsersCallback {
    void preExecute();

    void postExecute(ArrayList<User> users);
}

public class FavoritesActivity extends AppCompatActivity implements LoadUsersCallback {
    private UserAdapter adapter;
    private ProgressBar progressBar;
    private TextView tv_noDataFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Favorites");

        progressBar = findViewById(R.id.progressBar);
        tv_noDataFav = findViewById(R.id.tv_no_data_fav);
        RecyclerView rvUsers = findViewById(R.id.fav_list);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        rvUsers.setAdapter(adapter);

        HandlerThread handlerThread = new HandlerThread("DataObserver");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        DataObserver myObserver = new DataObserver(handler, this);
        getContentResolver().registerContentObserver(DatabaseContract.UserColumns.CONTENT_URI, true, myObserver);
        new LoadUsersAsync(this, this).execute();

        adapter.notifyDataSetChanged();
        adapter.setOnItemClickCallback(new UserAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(User data) {
                showSelectedUser(data);
            }
        });

        try {
            assert getSupportActionBar() != null;   //null check
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
            getSupportActionBar().setTitle("Favorit");
        } catch (Exception e) {
            Log.d("Error back:", e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
            tv_noDataFav.setVisibility(View.GONE);
        } else {
            adapter.setData(new ArrayList<User>());
            tv_noDataFav.setVisibility(View.VISIBLE);
        }
    }

    private void showSelectedUser(User user) {
        Intent intent = new Intent(FavoritesActivity.this, UserDetails.class);
        intent.putExtra(UserDetails.EXTRA_USERNAME, user.getUserName());
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class LoadUsersAsync extends AsyncTask<Void, Void, ArrayList<User>> {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadUsersCallback> weakCallback;

        private LoadUsersAsync(Context context, LoadUsersCallback callback) {
            weakContext = new WeakReference<Context>(context);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            weakCallback.get().preExecute();
        }

        @Override
        protected ArrayList<User> doInBackground(Void... voids) {
            Context context = weakContext.get();
            Cursor dataCursor = context.getContentResolver().query(DatabaseContract.UserColumns.CONTENT_URI,
                    null, null, null, null);
            return MappingHelper.mapCursorToArrayList(dataCursor);
        }

        @Override
        protected void onPostExecute(ArrayList<User> users) {
            super.onPostExecute(users);
            weakCallback.get().postExecute(users);
        }
    }

    public static class DataObserver extends ContentObserver {
        final Context context;

        public DataObserver(Handler handler, Context context) {
            super(handler);
            this.context = context;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            new LoadUsersAsync(context, (LoadUsersCallback) context).execute();
        }
    }

}