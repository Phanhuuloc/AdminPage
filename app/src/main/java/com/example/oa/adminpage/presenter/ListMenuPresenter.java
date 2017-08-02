package com.example.oa.adminpage.presenter;


import com.example.oa.adminpage.data.cache.ListMenuCache;
import com.example.oa.adminpage.data.local.Menu;
import com.example.oa.adminpage.domain.interactor.DefaultObserver;
import com.example.oa.adminpage.domain.interactor.GetMenuListUC;
import com.example.oa.adminpage.presenter.view.ListMenuView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/28/17.
 */

public class ListMenuPresenter implements Presenter {
    private final GetMenuListUC getMenuListUC;
    private ListMenuView view;

    @Inject
    public ListMenuPresenter(GetMenuListUC getMenuListUC) {
        this.getMenuListUC = getMenuListUC;
    }

    public void setView(ListMenuView view) {
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

    public void getListMenu(String name) {
        getMenuListUC.execute(new ListMenuObserver(),new GetMenuListUC.Param(name));
    }

    private class ListMenuObserver extends DefaultObserver<ListMenuCache> {
        @Override
        public void onNext(ListMenuCache listMenuCache) {
            ListMenuPresenter.this.showMenuList(listMenuCache.getItems());
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

    private void showMenuList(RealmList<Menu> items) {
        view.renderNetData(items);
    }
}
