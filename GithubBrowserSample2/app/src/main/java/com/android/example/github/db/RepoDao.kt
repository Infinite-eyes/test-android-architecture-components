package com.android.example.github.db

import com.android.example.github.vo.Repo

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/19 上午9:59
 **/
abstract class RepoDao{

    abstract fun insert(vararg repos: Repo)

//    abstract fun insertContributors(contributors: List<Con>)


}