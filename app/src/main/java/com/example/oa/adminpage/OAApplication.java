package com.example.oa.adminpage;

import android.app.Application;

import com.example.oa.adminpage.common.AppConstants;
import com.example.oa.adminpage.data.RealmSharedModule;
import com.example.oa.adminpage.presenter.di.components.DaggerUserComponent;
import com.example.oa.adminpage.presenter.di.components.UserComponent;
import com.example.oa.adminpage.presenter.di.modules.AppModule;
import com.example.oa.adminpage.presenter.di.modules.DataModule;
import com.example.oa.adminpage.presenter.di.modules.NetModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Android Main Application
 */
public class OAApplication extends Application implements AppConstants {

    public static OAApplication instance = null;
    public static String LANGUAGE_DEVICE = "";
    public static UserComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;
        }
        LANGUAGE_DEVICE = Locale.getDefault().getLanguage();
        initializeRealmDb();
        initializeStetho();
        initializeInjector();

    }

    private void initializeStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build());
    }

    private void initializeRealmDb() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .modules(Realm.getDefaultModule(), new RealmSharedModule())
                .schemaVersion(DB_VERSION)
                .deleteRealmIfMigrationNeeded()
//                .migration(new Migration())
//                .rxFactory(new QuarkRxFactory())
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        Realm realm = Realm.getInstance(realmConfiguration);
//        InitRealmDB(realm);
//        initRealmDB.initDB();
//        if (realm != null) {
//            realm.close();
//        }
    }


    private void initializeInjector() {
        this.component = DaggerUserComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://192.168.1.3:8800/"))
                .dataModule(new DataModule())
                .build();

    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
