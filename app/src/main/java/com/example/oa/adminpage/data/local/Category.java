package com.example.oa.adminpage.data.local;


import com.example.oa.adminpage.data.ODObject;

import org.parceler.Parcel;

import io.realm.CategoryRealmProxy;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 7/10/17.
 */
@Parcel(implementations = {CategoryRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Category.class})
public class Category extends RealmObject implements ODObject {
    private String uuid;
    private String name;
    private String defaultImage;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }
}
