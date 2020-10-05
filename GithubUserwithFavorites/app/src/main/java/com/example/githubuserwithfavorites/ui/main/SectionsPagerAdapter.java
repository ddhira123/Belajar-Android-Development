package com.example.githubuserwithfavorites.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.githubuserwithfavorites.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public static final int[] TAB_TITLES = new int[]{
            R.string.following,
            R.string.followers
    };
    public final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @Override
    public PlaceholderFragment getItem(int position) {
        return new PlaceholderFragment(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        ArrayList<Integer> count = PageViewModel.getCount();
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}