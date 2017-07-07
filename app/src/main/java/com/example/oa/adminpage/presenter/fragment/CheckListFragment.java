package com.example.oa.adminpage.presenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.presenter.adapter.CustomListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Phoenix on 7/5/17.
 */

public class CheckListFragment extends BaseFragment {

    public static final int TYPE_LIST_INVOICE = 0;
    public static final int TYPE_GRID_INVOICE = 1;
    public static final int TYPE_LIST_FOOD = 3;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private int type = TYPE_LIST_INVOICE;
    CustomListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        initialize();
        return view;
    }

    private void initialize() {
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = null;
        if (TYPE_LIST_INVOICE == type) {
            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(getContext());
        } else if (TYPE_GRID_INVOICE == type) {
            // use a grid layout manager
            mLayoutManager = new GridLayoutManager(getContext(), 3);
        } else if (TYPE_LIST_FOOD == type) {
            // use a grid layout manager
            mLayoutManager = new LinearLayoutManager(getContext());
        }
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new CustomListAdapter(getActivity(), type);
        recyclerView.setAdapter(adapter);

        initFakeData();
    }

    private void initFakeData() {

    }

    private void initData() {
        Bundle b = getArguments();
        if (b != null) {
            type = b.getInt(TYPE, 0);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
