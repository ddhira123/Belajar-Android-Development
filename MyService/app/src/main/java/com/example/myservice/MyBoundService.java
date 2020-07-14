package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

/**
 * Steps:
 * 1. Create the Service
 * 2. Set the variables {@link #TAG}, {@link #mBinder}, {@link #startTime}
 * 3. Create the inner class {@link MyBinder}
 * 4. Set up the timer (Create the timer variable) {@link #mTimer}
 * 5. Set up the service methods and use the timer variable mTimer declared at step 4:
 * {@link #onCreate()},
 * {@link #onDestroy()},
 * {@link #onBind},
 * {@link #onRebind},
 * {@link #onUnbind}
 * <p>
 * 6. Set up the ServiceConnection at main (parent) class/activity/fragment.
 * In this context, it's the mServiceConnection in class {@link MainActivity}
 * 7. Assign the things will be done when clicking button referring to this service in parent class
 * 8. Set up the method onDestroy() in {@link MainActivity}
 */

public class MyBoundService extends Service {
    private final String TAG = MyBoundService.class.getSimpleName();
    private final MyBinder mBinder = new MyBinder();
    private final long startTime = System.currentTimeMillis();
    CountDownTimer mTimer = new CountDownTimer(100000, 1000) {
        @Override
        public void onTick(long l) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            Log.d(TAG, "onTick: " + elapsedTime);
        }

        @Override
        public void onFinish() {
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        mTimer.start();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        mTimer.cancel();
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind: ");
    }

    class MyBinder extends Binder {
        MyBoundService getService() {
            return MyBoundService.this;
        }
    }
}
