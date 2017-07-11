package com.example.oa.adminpage.presenter.fragment;

import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.presenter.adapter.CustomAdapter;

import java.util.ArrayList;

/**
 * Created by Phoenix on 7/11/17.
 */

public class ListBillFragment extends RecyclerViewBaseFragment<Bill> {
    public ListBillFragment() {
        mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
    }

    @Override
    protected void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_BILL);

        initDummyData();
    }

    private void initDummyData() {
        mDataset = new ArrayList<Bill>();
        for (int i = 0; i < 50; i++) {
            mDataset.add(new Bill("Hoa don so "+i));
        }

        mAdapter.setItems(mDataset);
    }
}
