package com.example.oa.adminpage.presenter.fragment;

import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.presenter.adapter.CustomAdapter;

import java.util.ArrayList;

/**
 * Created by Phoenix on 7/11/17.
 */

public class ListCategoryFragment extends RecyclerViewBaseFragment<Category> {

    public ListCategoryFragment() {
        mCurrentLayoutManagerType = TYPE_HORIZONTAL_LIST;
    }

    @Override
    protected void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_CATEGORY);
        initDummyData();
    }

    private void initDummyData() {
        mDataset = new ArrayList<Category>();
        for (int i = 0; i < 50; i++) {
            mDataset.add(new Category("#"+i));
        }

        mAdapter.setItems(mDataset);
    }
}
