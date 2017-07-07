package com.example.oa.adminpage.presenter.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.example.oa.adminpage.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 5/28/17.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    private Context context;

    public CustomPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    public void addFragment(Fragment f) {
        fragments.add(f);
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
//        switch (position){
//            case 0: return  context.getString(R.string.menu_all);
//            case 1: return  context.getString(R.string.menu_near_me);
//            case 2: return  context.getString(R.string.menu_favorite);
//            default: return "";
//        }
    }
}
