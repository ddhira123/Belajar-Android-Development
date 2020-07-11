package com.example.githubusers;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetails extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

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

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        assert user != null;
        tv_name.setText(user.getName());
        tv_userName.setText(user.getUserName());
        tv_company.setText(user.getCompany());
        tv_location.setText(user.getLocation());
        tv_repo.setText(user.getRepository());
        tv_followers.setText(user.getFollowers());
        tv_following.setText(user.getFollowing());
        imgPhoto.setImageResource(user.getPhoto());

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