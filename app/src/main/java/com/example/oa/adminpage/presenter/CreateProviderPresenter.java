package com.example.oa.adminpage.presenter;


import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.domain.interactor.CreateProviderUC;
import com.example.oa.adminpage.domain.interactor.DefaultObserver;
import com.example.oa.adminpage.presenter.view.CreateProviderView;

import javax.inject.Inject;

/**
 * Created by Phoenix on 6/27/17.
 */

public class CreateProviderPresenter implements Presenter{
    private final CreateProviderUC createProviderUC;
    private CreateProviderView view;

    @Inject
    public CreateProviderPresenter(CreateProviderUC getProviderListUC) {
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

    public void createProvider(String name, String address, String image, String des, String url, String openHour, String start) {
        createProviderUC.execute(new DefaultObserver<>(), new CreateProviderUC.Param(name,address,image,des,url,openHour,start));
    }

    class CreateProvideObserver extends DefaultObserver{
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
