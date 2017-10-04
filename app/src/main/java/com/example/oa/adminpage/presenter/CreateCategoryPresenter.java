package com.example.oa.adminpage.presenter;


import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.domain.interactor.CreateCategoryUC;
import com.example.oa.adminpage.domain.interactor.CreateProviderUC;
import com.example.oa.adminpage.domain.interactor.DefaultObserver;
import com.example.oa.adminpage.presenter.view.CreateProviderView;

import javax.inject.Inject;

/**
 * Created by Phoenix on 6/27/17.
 */

public class CreateCategoryPresenter implements Presenter{
    private final CreateCategoryUC createProviderUC;
    private CreateProviderView view;

    @Inject
    public CreateCategoryPresenter(CreateCategoryUC getProviderListUC) {
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

    public void createCategory(Category p) {
        createProviderUC.execute(new CreateCategoryObserver(), new CreateCategoryUC.Param(p));
    }

    class CreateCategoryObserver extends DefaultObserver{
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
