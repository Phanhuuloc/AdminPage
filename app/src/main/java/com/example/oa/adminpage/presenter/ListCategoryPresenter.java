package com.example.oa.adminpage.presenter;

import com.example.oa.adminpage.data.cache.ListCategoryCache;
import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.domain.interactor.DefaultObserver;
import com.example.oa.adminpage.domain.interactor.GetListCategoryUC;
import com.example.oa.adminpage.presenter.view.ListCategoryView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public class ListCategoryPresenter implements Presenter{
    private final GetListCategoryUC getListCategoryUC;
    private ListCategoryView view;

    @Inject
    public ListCategoryPresenter(GetListCategoryUC getListCategoryUC) {
        this.getListCategoryUC = getListCategoryUC;
    }

    public void setView(ListCategoryView view) {
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

    public void getListCategory(String uid) {
        getListCategoryUC.execute(new ListCategoryObserver(),new GetListCategoryUC.Param(uid));
    }

    private class ListCategoryObserver extends DefaultObserver<ListCategoryCache> {
        @Override
        public void onNext(ListCategoryCache listCategoryCache) {
            ListCategoryPresenter.this.showListCategory(listCategoryCache.getItems());
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

    private void showListCategory(RealmList<Category> items) {
        view.showListCategory(items);
    }
}
