package com.example.oa.adminpage.domain.interactor;


import com.example.oa.adminpage.data.cache.ListCategoryCache;
import com.example.oa.adminpage.data.remote.RestApi;
import com.example.oa.adminpage.domain.executor.PostExecutionThread;
import com.example.oa.adminpage.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by Phoenix on 7/10/17.
 */

public class GetListCategoryUC extends UseCase<ListCategoryCache, GetListCategoryUC.Param> {
    private  final RestApi restApi;

    @Inject
    GetListCategoryUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListCategoryCache> buildUseCaseObservable(Param param) {
        Preconditions.checkNotNull(param);
        return restApi.getListCategory(param.uid);

    }

    public static class Param {
        private final String uid;

        public Param(String uid) {
            this.uid = uid;
        }
    }
}
