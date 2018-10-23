package com.android.example.github

import android.app.Application
import timber.log.Timber

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/18 下午4:17
 **/
class GithubApp : Application(){

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

}