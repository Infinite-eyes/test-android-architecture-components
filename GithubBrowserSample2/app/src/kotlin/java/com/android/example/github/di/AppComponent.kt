package com.android.example.github.di

import android.app.Application
import com.android.example.github.GithubApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/18 下午4:34
 **/

@Singleton
@Component(
    modules = [
    AndroidInjectionModule::class
    ]
)
interface AppComponent{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(githubApp: GithubApp)

}