package com.example.oa.adminpage.data.remote;



import com.example.oa.adminpage.data.cache.ListMenuCache;
import com.example.oa.adminpage.data.cache.ListProviderCache;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/14/17.
 */

public interface RestApi {

    Observable<ListProviderCache> getListProvider();

    Observable<ListMenuCache> getListMenu(String name);
}
