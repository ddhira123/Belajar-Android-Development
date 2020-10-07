package com.example.githubuserwithfavoritesconsumer.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.example.githubuserwithfavoritesconsumer.AlarmReceiver;
import com.example.githubuserwithfavoritesconsumer.R;

public class SettingPreferenceFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    private String ALARM_KEY;

    private SwitchPreference alarmPreference;
    private AlarmReceiver alarmReceiver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alarmReceiver = new AlarmReceiver();
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);
        init();
        setSummaries();
    }

    private void init() {
        ALARM_KEY = getResources().getString(R.string.key_alarm_preference);
        alarmPreference = findPreference(ALARM_KEY);
    }

    private void setSummaries() {
        SharedPreferences sh = getPreferenceManager().getSharedPreferences();
        alarmPreference.setChecked(sh.getBoolean(ALARM_KEY, false));
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(ALARM_KEY)) {
            alarmPreference.setDefaultValue(sharedPreferences.getBoolean(ALARM_KEY, false));
            setAlarmIcon(sharedPreferences.getBoolean(ALARM_KEY, false));
        }
    }

    private void setAlarmIcon(boolean isOn) {
        if (isOn) {
            alarmPreference.setIcon(R.drawable.ic_alarm_on);
            alarmReceiver.setRepeatingAlarm(getContext());
        } else {
            alarmPreference.setIcon(R.drawable.ic_alarm_off);
            alarmReceiver.turnOffRepeatingAlarm(getContext());
        }
    }
}
