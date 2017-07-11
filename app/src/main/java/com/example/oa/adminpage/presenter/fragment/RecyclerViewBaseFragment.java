/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.oa.adminpage.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.presenter.adapter.CustomAdapter;

import java.util.List;

import io.realm.RealmObject;

/**
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} and a
 * {@link GridLayoutManager}.
 */
public abstract class RecyclerViewBaseFragment<T extends RealmObject> extends BaseFragment {

    private static final String TAG = "RecyclerViewBaseFragment";
    public static final String KEY_LAYOUT_MANAGER = "layoutManager";
    public static final int TYPE_VERTICAL_LIST = 0;
    public static final int TYPE_HORIZONTAL_LIST = 1;
    public static final int TYPE_GRID = 2;
    public static final int TYPE_STAGGERD_GRID = 3;
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    protected Integer mCurrentLayoutManagerType;

    protected RadioButton mLinearLayoutRadioButton;
    protected RadioButton mGridLayoutRadioButton;

    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<T> mDataset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        Bundle b = getArguments();
        if (b != null)
            mCurrentLayoutManagerType = getArguments().getInt(KEY_LAYOUT_MANAGER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mAdapter = new CustomAdapter<T>();
        initData();

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (Integer) savedInstanceState
                    .getInt(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    protected abstract void initData();

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(int layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case TYPE_GRID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mAdapter.setType(TYPE_GRID);
                mCurrentLayoutManagerType = TYPE_GRID;
                break;
            case TYPE_STAGGERD_GRID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mAdapter.setType(TYPE_STAGGERD_GRID);
                mCurrentLayoutManagerType = TYPE_STAGGERD_GRID;
                break;
            case TYPE_VERTICAL_LIST:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mAdapter.setType(TYPE_VERTICAL_LIST);
                mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
                break;
            case TYPE_HORIZONTAL_LIST:
                mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mCurrentLayoutManagerType = TYPE_HORIZONTAL_LIST;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

}