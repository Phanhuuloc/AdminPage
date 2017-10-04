package com.example.oa.adminpage.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.oa.adminpage.OAApplication;
import com.example.oa.adminpage.presenter.di.components.UserComponent;


/**
 * Created by Phoenix on 5/25/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    UserComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponent();
    }

    protected void initializeComponent(){
        this.component = OAApplication.component;
    }
}
