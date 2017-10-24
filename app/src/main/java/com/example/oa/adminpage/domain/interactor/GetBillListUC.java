package com.example.oa.adminpage.domain.interactor;


import com.example.oa.adminpage.data.cache.ListBillCache;
import com.example.oa.adminpage.data.remote.RestApi;
import com.example.oa.adminpage.domain.executor.PostExecutionThread;
import com.example.oa.adminpage.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/28/17.
 */

public class GetBillListUC extends UseCase<ListBillCache, Void> {
    private final RestApi restApi;

    @Inject
    GetBillListUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListBillCache> buildUseCaseObservable(Void avoid) {
        return restApi.getListBill();
    }
}
