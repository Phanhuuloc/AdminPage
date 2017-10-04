package com.example.oa.adminpage.domain.interactor;


import com.example.oa.adminpage.data.local.Result;
import com.example.oa.adminpage.data.remote.RestApi;
import com.example.oa.adminpage.domain.executor.PostExecutionThread;
import com.example.oa.adminpage.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/28/17.
 */

public class CreateMenuUC extends UseCase<Result, CreateMenuUC.Param> {

    private final RestApi restApi;

    @Inject
    CreateMenuUC(ThreadExecutor threadExecutor,
                 PostExecutionThread postExecutionThread,
                 RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<Result> buildUseCaseObservable(Param param) {
        return restApi.createMenu(param.providerUid, param.category, param.name, param.price, param.des, param.note);
    }

    public static class Param {
        private final String providerUid;
        private final String category;
        private final String name;
        private final String price;
        private final String des;
        private final String note;

        public Param(String providerUid, String category, String name, String price, String des, String note) {
            this.providerUid = providerUid;
            this.category = category;
            this.name = name;
            this.price = price;
            this.des = des;
            this.note = note;
        }
    }
}
