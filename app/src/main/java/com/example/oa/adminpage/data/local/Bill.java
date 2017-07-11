package com.example.oa.adminpage.data.local;

import com.example.oa.adminpage.data.ODObject;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;

import java.util.List;
import java.util.UUID;

import io.realm.BillRealmProxy;
import io.realm.MenuRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by Phoenix on 7/7/17.
 */
@Parcel(implementations = {BillRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Bill.class})
public class Bill extends RealmObject implements ODObject {
    private String uuid;
    private String code;
    private RealmList<Menu> items;

    public Bill() {
    }

    public Bill(String code) {
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RealmList<Menu> getItems() {
        return items;
    }

    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public void setItems(RealmList<Menu> items) {
        this.items = items;
    }
}
