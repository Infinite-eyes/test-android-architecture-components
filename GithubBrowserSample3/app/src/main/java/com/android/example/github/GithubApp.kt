package com.android.example.github

import android.app.Activity
import android.app.Application
import com.android.example.github.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/4 2:16 PM
 **/
class GithubApp : Application(), HasActivityInjector {

    lateinit var dispatchingAnnotation: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        AppInjector.init(this)
    }


    override fun activityInjector() = dispatchingAnnotation


}