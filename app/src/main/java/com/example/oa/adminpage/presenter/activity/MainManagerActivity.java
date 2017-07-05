package com.example.oa.adminpage.presenter.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.presenter.adapter.CustomPagerAdapter;
import com.example.oa.adminpage.presenter.fragment.CategoryFragment;
import com.example.oa.adminpage.presenter.fragment.CheckListFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainManagerActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    CustomPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manager);
        ButterKnife.bind(this);
        initialize();
    }

    private void initialize() {
        initToolBar();
        initGUI();
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(R.string.app_menu_title);
    }

    private void initGUI() {
        pagerAdapter = new CustomPagerAdapter(this, getSupportFragmentManager());
        tabs.setupWithViewPager(viewPager);
        if (viewPager != null) {
            setupViewPager();
        }
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(pagerAdapter);
    }

    private void setupViewPager() {
        Fragment f1 = new CheckListFragment();

        Bundle b2 = new Bundle();
        b2.putInt(CheckListFragment.TYPE,1);
        Fragment f2 = Fragment.instantiate(this,CheckListFragment.class.getName(),b2);

        List<Fragment> fragments = new ArrayList(Arrays.asList(f1,f2));
        pagerAdapter.setFragments(fragments);

    }
}
