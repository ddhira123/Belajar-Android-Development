package com.example.githubuserwithapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private UserAdapter adapter;
    private ProgressBar progressBar;
    private MainViewModel mainViewModel;
    private TextView tv_notFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        tv_notFound = findViewById(R.id.tv_notFound);
        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);
        SearchView searchView = findViewById(R.id.search_box);
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        RecyclerView recyclerView = findViewById(R.id.search_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        mainViewModel.getListUsers().observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                if (users != null) {
                    adapter.setData(users);
                    if (users.isEmpty()) {
                        tv_notFound.setVisibility(View.VISIBLE);
                    }
                    showLoading(false);
                }
            }
        });

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
        tv_notFound.setVisibility(View.GONE);
        mainViewModel.setListUsers(query);
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