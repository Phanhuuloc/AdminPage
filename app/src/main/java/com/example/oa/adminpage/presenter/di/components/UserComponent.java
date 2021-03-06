package com.example.oa.adminpage.presenter.di.components;



import com.example.oa.adminpage.presenter.activity.ProviderActivity;
import com.example.oa.adminpage.presenter.di.PerActivity;
import com.example.oa.adminpage.presenter.di.modules.ActivityModule;
import com.example.oa.adminpage.presenter.di.modules.AppModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, AppModule.class})
public interface UserComponent extends ActivityComponent {
    void inject(ProviderActivity providerActivity);
//  void inject(UserListFragment userListFragment);
//  void inject(UserDetailsFragment userDetailsFragment);
}
