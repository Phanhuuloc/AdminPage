package com.example.oa.adminpage.presenter.view;



import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Menu;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/27/17.
 */

public interface ListBillView {
    void renderNetData(RealmList<Bill> items);
}
