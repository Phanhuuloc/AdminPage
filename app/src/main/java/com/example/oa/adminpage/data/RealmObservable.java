package com.example.oa.adminpage.data;//package com.example.oa.orderapp.data;
//
//import android.content.Context;
//
//import io.reactivex.Observable;
//import io.realm.Realm;
//import io.realm.RealmList;
//import io.realm.RealmObject;
//import io.realm.RealmResults;
//
///**
// * Created by Ikorn Solutions Ltd,.. on 12/6/2016.
// */
//
//public final class RealmObservable {
//
//    private RealmObservable() {
//    }
//
//    public static <T extends RealmObject> Observable<T> object(Context context, final Func1<Realm, T> function) {
//        return Observable.create(new OnSubscribeRealm<T>(context) {
//            @Override
//            public T get(Realm realm) {
//                return function.call(realm);
//            }
//        });
//    }
//
//    public static <T extends RealmObject> Observable<T> object(Context context, String fileName, final Func1<Realm, T> function) {
//        return Observable.create(new OnSubscribeRealm<T>(context, fileName) {
//            @Override
//            public T get(Realm realm) {
//                return function.call(realm);
//            }
//        });
//    }
//
//    public static <T extends RealmObject> Observable<RealmList<T>> list(Context context, final Func1<Realm, RealmList<T>> function) {
//        return Observable.create(new OnSubscribeRealm<RealmList<T>>(context) {
//            @Override
//            public RealmList<T> get(Realm realm) {
//                return function.call(realm);
//            }
//        });
//    }
//
//    public static <T extends RealmObject> Observable<RealmList<T>> list(Context context, String fileName, final Func1<Realm, RealmList<T>> function) {
//        return Observable.create(new OnSubscribeRealm<RealmList<T>>(context, fileName) {
//            @Override
//            public RealmList<T> get(Realm realm) {
//                return function.call(realm);
//            }
//        });
//    }
//
//    public static <T extends RealmObject> Observable<RealmResults<T>> results(Context context, final Func1<Realm, RealmResults<T>> function) {
//        return Observable.create(new OnSubscribeRealm<RealmResults<T>>(context) {
//            @Override
//            public RealmResults<T> get(Realm realm) {
//                return function.call(realm);
//            }
//        });
//    }
//
//    public static <T extends RealmObject> Observable<RealmResults<T>> results(Context context, String fileName, final Func1<Realm, RealmResults<T>> function) {
//        return Observable.create(new OnSubscribeRealm<RealmResults<T>>(context, fileName) {
//            @Override
//            public RealmResults<T> get(Realm realm) {
//                return function.call(realm);
//            }
//        });
//    }
//}
