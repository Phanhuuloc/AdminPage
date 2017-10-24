package com.example.oa.adminpage.data.cache;




import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Menu;
import com.example.oa.adminpage.data.local.RealmListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;


import butterknife.BindView;
import io.realm.ListBillCacheRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 6/14/17.
 */

@Parcel(implementations = {ListBillCacheRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {ListBillCache.class})
public class ListBillCache extends RealmObject{
    private RealmList<Bill> items;
    private int count;

    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public RealmList<Bill> getItems() {
        return items;
    }

    public void setItems(RealmList<Bill> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


