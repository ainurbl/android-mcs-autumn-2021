package com.ainuribatov.learnandroid.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    val id: Long,
    val linkUrl: String?,
    val imageUrl: String?,
    val title: String?,
    val text: String,
    val createdAt: String,
    val updatedAt: String,
)