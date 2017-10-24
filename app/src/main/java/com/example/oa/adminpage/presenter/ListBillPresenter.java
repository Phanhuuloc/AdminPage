package com.example.oa.adminpage.presenter;


import com.example.oa.adminpage.data.cache.ListBillCache;
import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Menu;
import com.example.oa.adminpage.domain.interactor.DefaultObserver;
import com.example.oa.adminpage.domain.interactor.GetBillListUC;
import com.example.oa.adminpage.presenter.view.ListBillView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/28/17.
 */

public class ListBillPresenter implements Presenter {
    private final GetBillListUC getBillListUC;
    private ListBillView view;

    @Inject
    public ListBillPresenter(GetBillListUC getBillListUC) {
        this.getBillListUC = getBillListUC;
    }

    public void setView(ListBillView view) {
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

    public void getListBill() {
        getBillListUC.execute(new ListMenuObserver(),null);
    }

    private class ListMenuObserver extends DefaultObserver<ListBillCache> {
        @Override
        public void onNext(ListBillCache listBillCache) {
            ListBillPresenter.this.showMenuList(listBillCache.getItems());
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

    private void showMenuList(RealmList<Bill> items) {
        view.renderNetData(items);
    }
}
