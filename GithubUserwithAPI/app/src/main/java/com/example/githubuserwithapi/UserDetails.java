package com.example.githubuserwithapi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.githubuserwithapi.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

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

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        try {
            username = getIntent().getStringExtra(EXTRA_USERNAME);
            Log.d("Success: ", username);
            showUserDetails(username);
        } catch (Exception e) {
            Log.d("error", e.toString());
        }

        try {
            assert getSupportActionBar() != null;   //null check
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
            getSupportActionBar().setTitle("Detail User");
        } catch (Exception e) {
            Log.d("Error back:", e.getMessage());
        }
    }


    private void showUserDetails(final String username) {
        showLoading(true);
        String url = "https://api.github.com/users/" + username;

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

                    String name = replaceIfNull(responseObject.getString("name"));
                    String location = replaceIfNull(responseObject.getString("location"));
                    String company = replaceIfNull(responseObject.getString("company"));
                    String imgUrl = replaceIfNull(responseObject.getString("avatar_url"));

                    tv_name.setText(name);
                    String uname = "@" + username;
                    tv_uname.setText(uname);
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

    private String replaceIfNull(String txt) {
        if (txt.equals("null")) {
            return "(Info Tidak Terseida)";
        } else {
            return txt;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}