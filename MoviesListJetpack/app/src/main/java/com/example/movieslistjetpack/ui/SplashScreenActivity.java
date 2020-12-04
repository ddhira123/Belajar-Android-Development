package com.example.movieslistjetpack.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movieslistjetpack.R;
import com.example.movieslistjetpack.ui.home.HomeActivity;
import com.example.movieslistjetpack.utils.EspressoIdlingResource;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int splashInterval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        EspressoIdlingResource.increment();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                startActivity(intent);
                this.finish();
                EspressoIdlingResource.decrement();
            }

            private void finish() {
            }
        }, splashInterval);

    }

}