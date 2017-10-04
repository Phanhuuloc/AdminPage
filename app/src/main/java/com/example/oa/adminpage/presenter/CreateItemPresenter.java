package com.example.oa.adminpage.presenter;


import com.example.oa.adminpage.domain.interactor.CreateMenuUC;
import com.example.oa.adminpage.domain.interactor.DefaultObserver;
import com.example.oa.adminpage.presenter.view.CreateProviderView;

import javax.inject.Inject;

/**
 * Created by Phoenix on 6/27/17.
 */

public class CreateItemPresenter implements Presenter {
    private final CreateMenuUC createProviderUC;
    private CreateProviderView view;

    @Inject
    public CreateItemPresenter(CreateMenuUC getProviderListUC) {
        this.createProviderUC = getProviderListUC;
    }

    public void setView(CreateProviderView view) {
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

    public void createMenuItem(String providerUid, String categoryUid, String name, String price, String des, String note) {
        createProviderUC.execute(new CreateCategoryObserver(), new CreateMenuUC.Param(providerUid, categoryUid, name, price, des, note));
    }

    private class CreateCategoryObserver extends DefaultObserver {
        @Override
        public void onNext(Object o) {
            super.onNext(o);
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
