package com.example.githubusers;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetails extends AppCompatActivity {

    public static final String EXTRA_IMG = "0";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_COMPANY = "extra_company";
    public static final String EXTRA_LOCATION = "extra_location";
    public static final String EXTRA_REPO = "extra_repository";
    public static final String EXTRA_FOLLOWING = "extra_following";
    public static final String EXTRA_FOLLOWERS = "extra_followers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        CircleImageView imgPhoto = findViewById(R.id.img_photo);
        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_userName = findViewById(R.id.tv_userName);
        TextView tv_company = findViewById(R.id.tv_company);
        TextView tv_location = findViewById(R.id.tv_location);
        TextView tv_repo = findViewById(R.id.tv_repo);
        TextView tv_following = findViewById(R.id.tv_following);
        TextView tv_followers = findViewById(R.id.tv_followers);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String userName = getIntent().getStringExtra(EXTRA_USERNAME);
        String company = getIntent().getStringExtra(EXTRA_COMPANY);
        String location = getIntent().getStringExtra(EXTRA_LOCATION);
        String repo = getIntent().getStringExtra(EXTRA_REPO);
        String following = getIntent().getStringExtra(EXTRA_FOLLOWING);
        String followers = getIntent().getStringExtra(EXTRA_FOLLOWERS);
        int img = getIntent().getIntExtra(EXTRA_IMG, 0);

        tv_name.setText(name);
        tv_userName.setText(userName);
        tv_company.setText(company);
        tv_location.setText(location);
        tv_repo.setText(repo);
        tv_followers.setText(followers);
        tv_following.setText(following);
        imgPhoto.setImageResource(img);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
        getSupportActionBar().setTitle("Detail User");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}