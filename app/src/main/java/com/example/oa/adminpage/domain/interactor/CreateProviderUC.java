package com.example.oa.adminpage.domain.interactor;


import com.example.oa.adminpage.data.cache.ListProviderCache;
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

public class CreateProviderUC extends UseCase<Result, CreateProviderUC.Param>{

    private final RestApi restApi;

    @Inject
    CreateProviderUC(ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread,
                     RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<Result> buildUseCaseObservable(Param param) {
        return restApi.createProvider(param.name,param.address,param.image,param.des,param.url,param.openHour, param.start);
    }

    public static class Param {
       private final String name;
        private final String address;
        private final String image;
        private  final String des;
        private final String url;
        private final String openHour;
        private final String start;

        public Param(String name, String address, String image, String des, String url, String openHour, String start) {
            this.name = name;
            this.address = address;
            this.image = image;
            this.des = des;
            this.url = url;
            this.openHour = openHour;
            this.start = start;
        }
    }
}
