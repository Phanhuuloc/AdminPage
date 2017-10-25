package com.example.oa.adminpage.domain.interactor;

import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.remote.RestApi;
import com.example.oa.adminpage.domain.executor.PostExecutionThread;
import com.example.oa.adminpage.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 10/25/17.
 */

public class BillDetailUC extends UseCase<Bill, BillDetailUC.Params>{

    private final RestApi api;

    @Inject
    BillDetailUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi api) {
        super(threadExecutor, postExecutionThread);
        this.api = api;
    }

    @Override
    Observable<Bill> buildUseCaseObservable(Params params) {
        return api.getBillDetail(params.bid);
    }

    public static class Params {
        private final String bid;
        public Params(String bid) {
            this.bid = bid;
        }
    }
}
