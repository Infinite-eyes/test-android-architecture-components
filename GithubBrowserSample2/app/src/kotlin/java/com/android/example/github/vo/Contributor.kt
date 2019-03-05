package com.android.example.github.vo

import androidx.room.Entity
import androidx.room.ForeignKey
import com.google.gson.annotations.SerializedName
import java.security.acl.Owner

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/19 上午10:06
 **/

@Entity(
    primaryKeys = ["repoName","repoOwner","login"],
        foreignKeys = [ForeignKey(
                entity = Repo::class,
                parentColumns = ["name","owner_login"],
                childColumns = ["repoName","repoOwner"],
                onUpdate = ForeignKey.CASCADE,
                deferred = true
        )]
)
data class Contributor(
        @field: SerializedName("login")
        val login: String,
        @field: SerializedName("contributions")
        val contributions: Int,
        @field: SerializedName("avatar_url")
        val avatarUrl: String?

){

    lateinit var repoName: String

    lateinit var repoOwner: String
}



