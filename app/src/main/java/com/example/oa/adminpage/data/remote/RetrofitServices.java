package com.example.oa.adminpage.data.remote;



import com.example.oa.adminpage.data.cache.ListMenuCache;
import com.example.oa.adminpage.data.cache.ListProviderCache;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Phoenix on 6/14/17.
 */

public interface RetrofitServices {
    @GET("provider/list")
    Observable<ListProviderCache> getListProvider();

    @GET("menu/provider/{name}")
    Observable<ListMenuCache> getListMenu(@Path("name") String name);
}
