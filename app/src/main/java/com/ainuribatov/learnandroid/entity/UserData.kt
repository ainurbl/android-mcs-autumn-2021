package com.ainuribatov.learnandroid.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserData(
    @Json(name = "id") val id: Long,
    @Json(name = "user_name") val userName: String,
    @Json(name = "picture") var avatarUrl: String?,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "group_name") val groupName: String?
) : Item
