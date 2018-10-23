package com.android.example.github.vo

import com.google.gson.annotations.SerializedName

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/18 下午7:44
 **/
data class RepoSearchResponse(
        @SerializedName("total_count")
        val total: Int = 0,
        @SerializedName("items")
        val items: List<Repo>
) {
    var nextPage: Int? = null
}