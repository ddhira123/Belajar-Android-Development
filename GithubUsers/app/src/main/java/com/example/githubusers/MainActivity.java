package com.example.githubusers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private String[] dataName, dataUserName, dataLocation, dataFollowing, dataFollowers, dataCompany, dataRepo;
    private TypedArray dataPhoto;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(MainActivity.this, UserDetails.class);
                mIntent.putExtra(UserDetails.EXTRA_USER, users.get(i));
                startActivity(mIntent);
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataUserName = getResources().getStringArray(R.array.username);
        dataCompany = getResources().getStringArray(R.array.company);
        dataLocation = getResources().getStringArray(R.array.location);
        dataRepo = getResources().getStringArray(R.array.repository);
        dataFollowing = getResources().getStringArray(R.array.following);
        dataFollowers = getResources().getStringArray(R.array.followers);
        dataPhoto = getResources().obtainTypedArray(R.array.avatar);
    }

    private void addItem() {
        users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            User user = new User();
            user.setPhoto(dataPhoto.getResourceId(i, -1));
            user.setName(dataName[i]);
            user.setUserName(dataUserName[i]);
            user.setCompany(dataCompany[i]);
            user.setLocation(dataLocation[i]);
            user.setRepository(dataRepo[i]);
            user.setFollowing(dataFollowing[i]);
            user.setFollowers(dataFollowers[i]);
            users.add(user);
        }

        adapter.setUsers(users);
    }
}