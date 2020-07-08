package com.example.githubusers;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetails extends AppCompatActivity {

    public static final String EXTRA_IMG = "0";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_USERNAME = "extra_uname";
    public static final String EXTRA_COMPANY = "extra_company";
    public static final String EXTRA_LOCATION = "extra_location";
    public static final String EXTRA_REPO = "extra_repository";
    public static final String EXTRA_FOLLOWING = "extra_following";
    public static final String EXTRA_FOLLOWERS = "extra_followers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
    }
}