package com.android.example.github.di

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.android.example.github.api.GithubService
import com.android.example.github.db.GithubDb
import com.android.example.github.db.RepoDao
import com.android.example.github.db.UserDao
import com.android.example.github.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/18 下午5:23
 **/
class AppModule{
    @Singleton
    @Provides
    fun provideGithubService() : GithubService{
        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(GiethubService::class.java)
    }
//
    fun provideDb(app: Application): GithubDb{
        return Room
                .databaseBuilder(app,GithubDb::class.java, "github.db")
                .fallbackToDestructiveMigration()
                .build()
    }


    fun provideUserDao(db: GithubDb): UserDao {
        return db.userDao();
    }


    fun provideRepoDao(db: GithubDb): RepoDao{
        return db.repoDao()
    }



}