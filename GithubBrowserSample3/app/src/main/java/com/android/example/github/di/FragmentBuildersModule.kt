package com.android.example.github.di

import com.android.example.github.ui.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/7 3:53 PM
 **/
@Module
abstract class FragmentBuildersModule {


    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment


}