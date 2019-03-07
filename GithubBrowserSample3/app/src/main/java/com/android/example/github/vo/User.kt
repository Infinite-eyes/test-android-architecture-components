package com.android.example.github.vo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/5 7:19 PM
 **/
@Entity(primaryKeys = ["login"])
data class User(
        @field:SerializedName("login")
        val login: String,
        @field:SerializedName("avatar_url")
        val avatarUrl: String?,
        @field:SerializedName("name")
        val name: String?,
        @field:SerializedName("company")
        val company: String?,
        @field: SerializedName("repos_url")
        val reposUrl: String?,
        @field: SerializedName("blog")
        val blog: String?
)