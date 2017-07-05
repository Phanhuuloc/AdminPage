package com.example.oa.adminpage.presenter.view;



import com.example.oa.adminpage.data.local.Provider;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/27/17.
 */

public interface ListProviderView {
    void renderNetData(RealmList<Provider> items);
}
