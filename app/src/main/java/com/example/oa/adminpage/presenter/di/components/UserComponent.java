package com.example.oa.adminpage.presenter.di.components;


import com.example.oa.adminpage.presenter.activity.AddNewProductActivity;
import com.example.oa.adminpage.presenter.activity.CreateCategoryActivity;
import com.example.oa.adminpage.presenter.activity.CreateProviderActivity;
import com.example.oa.adminpage.presenter.activity.ProviderActivity;
import com.example.oa.adminpage.presenter.di.modules.AppModule;
import com.example.oa.adminpage.presenter.di.modules.DataModule;
import com.example.oa.adminpage.presenter.di.modules.NetModule;
import com.example.oa.adminpage.presenter.fragment.ListCategoryFragment;
import com.example.oa.adminpage.presenter.fragment.ListItemFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {AppModule.class, NetModule.class, DataModule.class})
public interface UserComponent {
    void inject(ProviderActivity providerActivity);

    void inject(ListItemFragment listItemFragment);

    void inject(ListCategoryFragment listCategoryFragment);

    void inject(CreateProviderActivity createProviderActivity);

    void inject(CreateCategoryActivity createCategoryActivity);

    void inject(AddNewProductActivity addNewProductActivity);

}
