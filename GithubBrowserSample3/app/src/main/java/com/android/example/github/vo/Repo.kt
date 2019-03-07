package com.android.example.github.vo

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/5 7:37 PM
 **/

data class Repo(
        val id: Int,
        @field:SerializedName("name")
        val name: String,
        @field: SerializedName("full_name")
        val fullName: String,
        @field:SerializedName("description")
        val description: String?,
        @field:SerializedName("owner")
        @field:Embedded(prefix = "owner_")
        val owner: Owner,
        @field:SerializedName("stargazers_count")
        val stars: Int
) {
    data class Owner(
            @field: SerializedName("login")
            val login: String,
            @field:SerializedName("url")
            val url: String?
    )

    companion object {
        const val UNKNOWN_ID = -1
    }

}