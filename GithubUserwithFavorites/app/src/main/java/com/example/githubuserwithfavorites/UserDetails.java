package com.example.githubuserwithfavorites;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.githubuserwithfavorites.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import de.hdodenhof.circleimageview.CircleImageView;
import model.User;

import static com.example.githubuserwithfavorites.BuildConfig.GITHUB_TOKEN;
import static database.DatabaseContract.UserColumns.CONTENT_URI;
import static database.DatabaseContract.UserColumns.PHOTO_URL;
import static database.DatabaseContract.UserColumns.USERNAME;

public class UserDetails extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_USERNAME = "extra_username";
    public String username;
    public User user;
    CircleImageView imgPhoto;
    TextView tv_uname, tv_name, tv_company, tv_location;
    FloatingActionButton fab_favorite;
    private ProgressBar progressBar;
    private boolean statusFavorite;
    private Uri uriWithUname;

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
        fab_favorite = findViewById(R.id.fab_favorite);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        try {
            username = getIntent().getStringExtra(EXTRA_USERNAME);
            uriWithUname = Uri.parse(CONTENT_URI + "/#" + username);
            statusFavorite = getStatusFavorite();
            setStatusFavorite();
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

        fab_favorite.setOnClickListener(this);
    }


    private void showUserDetails(final String username) {
        showLoading(true);
        String url = "https://api.github.com/users/" + username;

        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization", new StringBuilder().append("token ").append(GITHUB_TOKEN).toString());
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

                    user = new User();
                    user.setUserName(username);
                    user.setPhoto(imgUrl);

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

    public boolean getStatusFavorite() {
        if (uriWithUname != null) {
            Log.d("URI: ", uriWithUname.toString());
            Cursor check = getContentResolver().query(uriWithUname,
                    null, null, null, null);
            return check.getCount() > 0;
        }
        return false;
    }

    public void setStatusFavorite() {
        if (statusFavorite) {
            fab_favorite.setImageResource(R.drawable.ic_favorite_fill);
        } else {
            fab_favorite.setImageResource(R.drawable.ic_favorite_empty);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab_favorite) {
            if (!statusFavorite) {
                try {
                    ContentValues initialValues = new ContentValues();
                    initialValues.put(USERNAME, user.getUserName());
                    initialValues.put(PHOTO_URL, user.getPhoto());

                    Uri result = getContentResolver().insert(CONTENT_URI, initialValues);
                    Log.d("Last Path Segment := ", result != null ? result.getLastPathSegment() : "null");
                    if (result.getLastPathSegment() != "0") {
                        statusFavorite = !statusFavorite;
                        setStatusFavorite();
                    } else {
                        Toast.makeText(UserDetails.this, "Gagal menambah data", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.d("Error:", String.valueOf(e.getMessage()));
                }
            } else {
                try {
                    int result = getContentResolver().delete(uriWithUname, null, null);
                    Log.d("Result code of del:", String.valueOf(result));

                    if (result > 0) {
                        statusFavorite = !statusFavorite;
                        setStatusFavorite();
                    } else {
                        Toast.makeText(UserDetails.this, "Gagal menghapus data", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Log.d("Error:", String.valueOf(e.getCause()));
                }
            }
        }
    }
}