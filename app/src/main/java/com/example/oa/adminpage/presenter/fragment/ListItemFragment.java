package com.example.oa.adminpage.presenter.fragment;

import android.os.Bundle;

import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Menu;
import com.example.oa.adminpage.presenter.ListMenuPresenter;
import com.example.oa.adminpage.presenter.activity.ProviderActivity;
import com.example.oa.adminpage.presenter.adapter.CustomAdapter;
import com.example.oa.adminpage.presenter.di.components.UserComponent;
import com.example.oa.adminpage.presenter.view.ListMenuView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/11/17.
 */

public class ListItemFragment extends RecyclerViewBaseFragment<Bill> implements ListMenuView{
    @Inject
    ListMenuPresenter presenter;
    private String providerId;

    public ListItemFragment() {
        mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        providerId = getArguments().getString(ProviderActivity.ID);
        this.getComponent(UserComponent.class).inject(this);
        presenter.setView(this);
    }

    @Override
    protected void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_BILL);
        presenter.getListMenu(providerId);
    }

    @Override
    public void renderNetData(RealmList<Menu> items) {
        mAdapter.setItems(items);
    }
}
