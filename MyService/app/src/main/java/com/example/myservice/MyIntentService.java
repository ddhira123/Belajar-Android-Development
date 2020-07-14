package com.example.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String TAG = MyIntentService.class.getSimpleName();


    // TODO: Rename parameters
    public static String EXTRA_DURATION = "extra_duration";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: Mulai.....");
        if (intent != null) {
            long duration = intent.getLongExtra(EXTRA_DURATION, 0);
            try {
                Thread.sleep(duration);
                Log.d(TAG, "onHandleIntent: Selesai..... Waktu = " + duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
