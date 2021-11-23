package com.ainuribatov.learnandroid.data.network.response

import com.ainuribatov.learnandroid.entity.UserData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetUsersResponse(
    @Json(name = "data")
    val data: List<UserData>
)
