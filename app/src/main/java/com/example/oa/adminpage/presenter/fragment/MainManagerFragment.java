package com.example.oa.adminpage.presenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.presenter.adapter.CustomPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Phoenix on 7/16/17.
 */

public class MainManagerFragment extends BaseFragment {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    Unbinder unbinder;
    private CustomPagerAdapter pagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {
        initGUI();
    }

    private void initGUI() {
        pagerAdapter = new CustomPagerAdapter(this, getChildFragmentManager());
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
        b2.putInt(CheckListFragment.TYPE, 1);
        Fragment f2 = Fragment.instantiate(getContext(), CheckListFragment.class.getName(), b2);

        List<Fragment> fragments = new ArrayList<>(Arrays.asList(f1, f2));
        List<String> titles = new ArrayList<>(Arrays.asList("Xem theo ban", " Xem theo don hang"));
        pagerAdapter.setFragments(fragments);
        pagerAdapter.setTitles(titles);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}