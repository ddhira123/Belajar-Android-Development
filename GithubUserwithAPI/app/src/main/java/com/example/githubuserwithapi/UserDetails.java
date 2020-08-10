package com.example.githubuserwithapi;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.githubuserwithapi.ui.main.SectionsPagerAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetails extends AppCompatActivity {
    private ProgressBar progressBar;
    CircleImageView imgPhoto;
    TextView tv_uname, tv_name, tv_company, tv_location;
    public static final String EXTRA_USERNAME = "extra_username";
    public String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        tv_name = findViewById(R.id.tv_name);
        tv_uname = findViewById(R.id.tv_userName);
        tv_company = findViewById(R.id.tv_company);
        tv_location = findViewById(R.id.tv_location);
        imgPhoto = findViewById(R.id.imgPhoto);
        progressBar = findViewById(R.id.progressBar);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), username);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        try {
            username = getIntent().getStringExtra(EXTRA_USERNAME);
            Log.d("Success: ", username);
            showUserDetails(username);
        } catch (Exception e){
            Log.d("error", e.toString());
        }

    }


    private void showUserDetails(final String username) {
        showLoading(true);
        String url = "https://api.github.com/users/" + username;

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

                    String name = responseObject.getString("name");
                    String location = responseObject.getString("location");
                    String company = responseObject.getString("company");
                    String imgUrl = responseObject.getString("avatar_url");

                    tv_name.setText(name);
                    tv_uname.setText(username);
                    tv_company.setText(company);
                    tv_location.setText(location);
                    Glide.with(UserDetails.this).load(imgUrl).into(imgPhoto);

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
    }
    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}