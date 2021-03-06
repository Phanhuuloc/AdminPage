package com.example.oa.adminpage.presenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;


import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.presenter.ProviderPresenter;
import com.example.oa.adminpage.presenter.adapter.CustomPagerAdapter;
import com.example.oa.adminpage.presenter.fragment.CategoryFragment;
import com.example.oa.adminpage.presenter.view.ListProviderView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

public class ProviderActivity extends BaseActivity implements ListProviderView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    android.support.design.widget.TabLayout tabs;

    @Inject
    ProviderPresenter presenter;

    private CustomPagerAdapter pagerAdapter;
    private int countTab = 3;

    public static void start(Context context) {
        Intent i = new Intent(context, ProviderActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        initializeComponent();
        initializeInjector();
        initialize();
    }

    private void initializeInjector() {
        component.inject(this);
        presenter.setView(this);
    }

    private void initialize() {
        initToolBar();
        initViewpager();
        initData();
    }

    private void initData() {
        presenter.getListProvider();
    }

    private void initViewpager() {
        pagerAdapter = new CustomPagerAdapter(this, getSupportFragmentManager());
        tabs.setupWithViewPager(viewPager);

        if (viewPager != null) {
            setupViewPager();
        }
        viewPager.setOffscreenPageLimit(countTab);
        tabs.setupWithViewPager(viewPager);
        setupTabTitle();
    }

    private void setupTabTitle() {

    }

    private void setupViewPager() {
        for (int i=0;i<countTab;i++) {

            Bundle bundle = new Bundle();
//            bundle.putString(GalleryFragment.FILE, value);
            Fragment fragment = Fragment.instantiate(this, CategoryFragment.class.getName(), bundle);
            pagerAdapter.addFragment(fragment);
        }
        viewPager.setAdapter(pagerAdapter);
    }

    private void initToolBar() {
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(R.string.app_menu_title);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void renderNetData(RealmList<Provider> items) {

    }
}
