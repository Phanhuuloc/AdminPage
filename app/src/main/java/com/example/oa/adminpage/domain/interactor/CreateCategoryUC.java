package com.example.oa.adminpage.domain.interactor;


import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.data.local.Result;
import com.example.oa.adminpage.data.remote.RestApi;
import com.example.oa.adminpage.domain.executor.PostExecutionThread;
import com.example.oa.adminpage.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/28/17.
 */

public class CreateCategoryUC extends UseCase<Result, CreateCategoryUC.Param>{

    private final RestApi restApi;

    @Inject
    CreateCategoryUC(ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread,
                     RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<Result> buildUseCaseObservable(Param param) {
        return restApi.createCategory(param.provider);
    }

    public static class Param {
        private final Category provider;

        public Param(Category provider) {
            this.provider = provider;
        }
    }
}
