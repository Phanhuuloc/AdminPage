package com.example.oa.adminpage.presenter.di.modules;

import android.content.Context;

import com.example.oa.adminpage.OAApplication;
import com.example.oa.adminpage.UIThread;
import com.example.oa.adminpage.data.executor.JobExecutor;
import com.example.oa.adminpage.domain.executor.PostExecutionThread;
import com.example.oa.adminpage.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Phoenix on 6/14/17.
 */
@Module
public class AppModule {

    private final OAApplication application;

    public AppModule(OAApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    OAApplication provideAndroidApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
