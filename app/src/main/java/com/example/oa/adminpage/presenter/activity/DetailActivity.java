package com.example.oa.adminpage.presenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.presenter.fragment.ListItemFragment;
import com.example.oa.adminpage.presenter.fragment.ListCategoryFragment;
import com.example.oa.adminpage.presenter.fragment.RecyclerViewBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {


    @BindView(R.id.sample_content_fragment)
    FrameLayout sampleContentFragment;
    @BindView(R.id.category_content_fragment)
    FrameLayout categoryContentFragment;
    @BindView(R.id.sample_main_layout)
    RelativeLayout sampleMainLayout;

    public static void start(Context context) {
        Intent i = new Intent(context, DetailActivity.class);
        context.startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            RecyclerViewBaseFragment fragment1 = new ListItemFragment();
            transaction.replace(R.id.sample_content_fragment, fragment1);

            RecyclerViewBaseFragment fragment2 = new ListCategoryFragment();
            transaction.replace(R.id.category_content_fragment, fragment2);

            transaction.commit();
        }
        initialize();
    }

    private void initialize() {

    }
}
