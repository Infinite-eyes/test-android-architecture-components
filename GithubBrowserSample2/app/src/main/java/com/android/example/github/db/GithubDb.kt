package com.android.example.github.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.example.github.vo.Contributor
import com.android.example.github.vo.Repo
import com.android.example.github.vo.RepoSearchResponse
import com.android.example.github.vo.User

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/19 上午9:50
 **/
@Database(entities = [
    User::class,
    Repo::class,
    Contributor::class,
    RepoSearchResponse::class],
        version = 3,
        exportSchema = false
)

abstract class GithubDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun repoDao(): RepoDao

}