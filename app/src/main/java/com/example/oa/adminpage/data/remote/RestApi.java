package com.example.oa.adminpage.data.remote;


import com.example.oa.adminpage.data.cache.ListBillCache;
import com.example.oa.adminpage.data.cache.ListCategoryCache;
import com.example.oa.adminpage.data.cache.ListProviderCache;
import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.data.local.Result;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Phoenix on 6/14/17.
 */
public interface RestApi {

    @GET("provider/list")
    Observable<ListProviderCache> getListProvider();

    @GET("bill/list")
    Observable<ListBillCache> getListBill();

    @GET("provider/{name}")
    Observable<Provider> getProvider(@Path("name") String uid);

    @GET("provider/{id}/category")
    Observable<ListCategoryCache> getListCategory(@Path("id") String uid);

    @POST("provider")
    Observable<Result> createProvider(@Query("name") String name, @Query("address") String address,
                                      @Query("image") String image, @Query("des") String des,
                                      @Query("url") String url, @Query("openHour") String openHour ,
                                      @Query("start") String start);

    @POST("category")
    Observable<Result> createCategory(@Body Category provider);

    @POST("provider/mon")
    Observable<Result> createMenu(@Query("pid") String providerUid, @Query("category") String categoryUid,
                                  @Query("name") String name, @Query("price") String price,
                                  @Query("des") String des, @Query("note") String note);

    @POST("provider/{uuid}/token")
    Observable<Result> setProviderToken(@Path("uuid") String uuid, @Query("token") String token);

    @GET("bill/{uuid}")
    Observable<Bill> getBillDetail(@Path("uuid") String bid);
}
