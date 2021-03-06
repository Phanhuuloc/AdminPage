package com.example.oa.adminpage.data.remote;


import com.example.oa.adminpage.data.cache.ListMenuCache;
import com.example.oa.adminpage.data.cache.ListProviderCache;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/14/17.
 */
@Singleton
public class RestApiImpl implements RestApi {
    private final RetrofitServices r;
    private final EntityJsonMapper jsonMapper;
//    private final ApiConnection apiConnection;

    @Inject
    public RestApiImpl(RetrofitServices retrofitServices, EntityJsonMapper jsonMapper/*, ApiConnection apiConnection*/) {
        this.r = retrofitServices;
        this.jsonMapper = jsonMapper;
//        this.apiConnection = apiConnection;
    }

    @Override
    public Observable<ListProviderCache> getListProvider() {
        return this.r.getListProvider();
    }

    @Override
    public Observable<ListMenuCache> getListMenu(String name) {
        return this.r.getListMenu(name);
    }
}
