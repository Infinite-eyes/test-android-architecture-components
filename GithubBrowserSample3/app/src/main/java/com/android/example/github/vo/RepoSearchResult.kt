package com.android.example.github.vo

import android.app.DownloadManager
import androidx.room.Entity

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/5 7:34 PM
 **/
@Entity(primaryKeys = ["query"])
data class RepoSearchResult(
        val query: String,
        val repoIds: List<Int>,
        val totalCount: Int,
        val next: Int?
)