package com.example.oa.adminpage.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.oa.adminpage.OAApplication;
import com.example.oa.adminpage.presenter.di.components.ApplicationComponent;
import com.example.oa.adminpage.presenter.di.components.DaggerUserComponent;
import com.example.oa.adminpage.presenter.di.components.UserComponent;
import com.example.oa.adminpage.presenter.di.modules.ActivityModule;
import com.example.oa.adminpage.presenter.di.modules.AppModule;


/**
 * Created by Phoenix on 5/25/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    UserComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent(){
        return ((OAApplication)getApplication()).getApplicationComponent();
    }

    protected void initializeComponent(){
        this.component = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .appModule(new AppModule())
                .build();
    }
}
