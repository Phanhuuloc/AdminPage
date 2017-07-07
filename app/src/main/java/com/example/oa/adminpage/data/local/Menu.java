package com.example.oa.adminpage.data.local;



import com.example.oa.adminpage.data.ODObject;

import org.parceler.Parcel;

import java.util.UUID;


import io.realm.MenuRealmProxy;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by Phoenix on 6/14/17.
 */
@Parcel(implementations = {MenuRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Menu.class})
public class Menu extends RealmObject implements ODObject {
    @Ignore
    private String uuid;
    private String name;
    private String price;
    private String description;
    private String note;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
