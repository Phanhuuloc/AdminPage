package com.example.oa.adminpage.data.remote;



import com.example.oa.adminpage.data.cache.ListCategoryCache;
import com.example.oa.adminpage.data.cache.ListMenuCache;
import com.example.oa.adminpage.data.cache.ListProviderCache;
import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.data.local.Result;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/14/17.
 */

public interface RestApi {

    Observable<ListProviderCache> getListProvider();

    Observable<ListMenuCache> getListMenu(String name);

    Observable<Provider> getProvider(String uid);

    Observable<ListCategoryCache> getListCategory(String uid);

    Observable<Result> createProvider(Provider provider);
}
