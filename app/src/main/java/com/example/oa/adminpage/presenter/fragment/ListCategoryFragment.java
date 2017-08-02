package com.example.oa.adminpage.presenter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.presenter.ListCategoryPresenter;
import com.example.oa.adminpage.presenter.activity.ProviderActivity;
import com.example.oa.adminpage.presenter.adapter.CustomAdapter;
import com.example.oa.adminpage.presenter.di.components.UserComponent;
import com.example.oa.adminpage.presenter.view.ListCategoryView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/11/17.
 */

public class ListCategoryFragment extends RecyclerViewBaseFragment<Category> implements ListCategoryView {

    @Inject
    ListCategoryPresenter presenter;
    private String providerId;

    public ListCategoryFragment() {
        mCurrentLayoutManagerType = TYPE_HORIZONTAL_LIST;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        providerId = getArguments().getString(ProviderActivity.ID);
        this.getComponent(UserComponent.class).inject(this);
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_CATEGORY);
        presenter.getListCategory(providerId);
    }

    @Override
    public void showListCategory(RealmList<Category> items) {
        mAdapter.setItems(items);
    }
}
