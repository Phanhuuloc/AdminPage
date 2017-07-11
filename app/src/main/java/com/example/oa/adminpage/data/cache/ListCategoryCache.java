package com.example.oa.adminpage.data.cache;


import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.data.local.RealmListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;

import io.realm.ListCategoryCacheRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 6/14/17.
 */

@Parcel(implementations = {ListCategoryCacheRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {ListCategoryCache.class})
public class ListCategoryCache extends RealmObject{
    RealmList<Category> items;
    int count;

    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public RealmList<Category> getItems() {
        return items;
    }

    public void setItems(RealmList<Category> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

