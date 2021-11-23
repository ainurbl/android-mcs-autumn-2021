package com.ainuribatov.learnandroid

import com.ainuribatov.learnandroid.data.network.response.GetUsersResponse
import retrofit2.http.GET

interface Api {
    @GET("users")
    suspend fun getUsers(): GetUsersResponse
}

