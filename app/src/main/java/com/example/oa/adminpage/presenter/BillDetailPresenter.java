package com.example.oa.adminpage.presenter;

import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.domain.interactor.BillDetailUC;
import com.example.oa.adminpage.domain.interactor.DefaultObserver;
import com.example.oa.adminpage.presenter.view.BillDetailView;

import javax.inject.Inject;

/**
 * Created by Phoenix on 10/25/17.
 */

public class BillDetailPresenter implements Presenter{
    private final BillDetailUC billDetailUC;
    private BillDetailView view;

    @Inject
    public BillDetailPresenter(BillDetailUC billDetailUC) {
        this.billDetailUC = billDetailUC;
    }

    public void setView(BillDetailView view) {
        this.view = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void getBillDetail(String bid) {
        billDetailUC.execute(new BillDetailObserver(),new BillDetailUC.Params(bid));
    }

    private class BillDetailObserver extends DefaultObserver<Bill>{
        @Override
        public void onNext(Bill bill) {
            view.renderNetData(bill);
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }
}
