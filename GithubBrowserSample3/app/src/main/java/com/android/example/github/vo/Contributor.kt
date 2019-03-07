package com.android.example.github.vo

import com.google.gson.annotations.SerializedName

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/5 7:49 PM
 **/
data class Contributor(
        @field:SerializedName("login")
        val login: String,
        @field: SerializedName("contributions")
        var contributors: Int,
        @field:SerializedName("avatar_url")
        val avatarUrl: String?
) {
    lateinit var repoNam: String

    lateinit var repoOwner: String
}