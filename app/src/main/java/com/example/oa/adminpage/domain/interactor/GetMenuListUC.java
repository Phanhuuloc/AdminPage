package com.example.oa.adminpage.domain.interactor;


import com.example.oa.adminpage.data.cache.ListMenuCache;
import com.example.oa.adminpage.data.remote.RestApi;
import com.example.oa.adminpage.domain.executor.PostExecutionThread;
import com.example.oa.adminpage.domain.executor.ThreadExecutor;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/28/17.
 */

public class GetMenuListUC extends UseCase<ListMenuCache, GetMenuListUC.Param> {
    private final RestApi restApi;

    GetMenuListUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListMenuCache> buildUseCaseObservable(Param param) {
        Preconditions.checkNotNull(param);
        return restApi.getListMenu(param.name);
    }

    public static class Param {
        public final String name;

        public Param(String name) {
            this.name = name;
        }
    }
}
