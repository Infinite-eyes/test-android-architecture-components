package com.android.example.github;

import android.app.Activity;
import android.app.Application;

import java.util.Timer;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;


/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/10/26 7:21 PM
 **/
public class GithubApp extends Application implements HasActivityInjector {

    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;


    public final DispatchingAndroidInjector<Activity> getDispatchingAndroidInjector() {
        return dispatchingAndroidInjector;
    }
    public final void setDispatchingAndroidInjector(DispatchingAndroidInjector<Activity> dispatchingAndroidInjector) {
        this.dispatchingAndroidInjector = dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
