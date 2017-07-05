package com.example.oa.adminpage.presenter.view;



import com.example.oa.adminpage.data.local.Menu;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/27/17.
 */

public interface ListMenuView {
    void renderNetData(RealmList<Menu> items);
}
