package com.example.oa.adminpage.presenter.di.components;

import android.app.Activity;


import com.example.oa.adminpage.presenter.di.PerActivity;
import com.example.oa.adminpage.presenter.di.modules.ActivityModule;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
  //Exposed to sub-graphs.
  Activity activity();
}
