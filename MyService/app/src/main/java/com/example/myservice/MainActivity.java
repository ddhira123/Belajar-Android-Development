package com.example.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStartService;         // for Simple service
    Button btnStartIntentService;   // for Intent Service

    // For BoundService
    Button btnStartBoundService;
    Button btnStopBoundService;
    boolean mServiceBound = false;
    MyBoundService mBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btn_start_service);
        btnStartIntentService = findViewById(R.id.btn_start_intent_service);
        btnStartBoundService = findViewById(R.id.btn_start_bound_service);
        btnStopBoundService = findViewById(R.id.btn_stop_bound_service);

        btnStartService.setOnClickListener(this);
        btnStartIntentService.setOnClickListener(this);
        btnStartBoundService.setOnClickListener(this);
        btnStopBoundService.setOnClickListener(this);
    }

    // This variable will be used as connection of this activity and MyBoundService
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            myBinder.getService();
            mServiceBound = true;
        }
    };

    // When the button stop service pressed, this method will be used to unbind the current
    // working bound service and also PREVENTING THE MEMORY LEAKS from bound service
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mServiceBound) {
            unbindService(mServiceConnection);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                Intent mStartServiceIntent = new Intent(MainActivity.this, MyService.class);
                startService(mStartServiceIntent);
                break;
            case R.id.btn_start_intent_service:
                Intent mStartIntentService = new Intent(MainActivity.this, MyIntentService.class);
                mStartIntentService.putExtra(MyIntentService.EXTRA_DURATION, 5000L);
                startService(mStartIntentService);
                break;
            case R.id.btn_start_bound_service:
                Intent mBoundServiceIntent = new Intent(MainActivity.this, MyBoundService.class);
                bindService(mBoundServiceIntent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.btn_stop_bound_service:
                unbindService(mServiceConnection);
                break;
        }
    }
}