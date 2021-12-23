package com.ainuribatov.learnandroid.data.network

import com.ainuribatov.learnandroid.data.network.request.CreateProfileRequest
import com.ainuribatov.learnandroid.data.network.request.RefreshAuthTokensRequest
import com.ainuribatov.learnandroid.data.network.request.SignInWithEmailRequest
import com.ainuribatov.learnandroid.data.network.response.VerificationTokenResponse
import com.ainuribatov.learnandroid.data.network.response.error.*
import com.ainuribatov.learnandroid.entity.AuthTokens
import com.ainuribatov.learnandroid.entity.Post
import com.ainuribatov.learnandroid.entity.UserData
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.*

interface Api {

    @GET("users?per_page=10")
    suspend fun getUsers(): NetworkResponse<List<UserData>, Unit>


    @POST("auth/sign-in-email")
    suspend fun signInWithEmail(
            @Body request: SignInWithEmailRequest
    ): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse>

    @POST("auth/refresh-tokens")
    suspend fun refreshAuthTokens(
            @Body request: RefreshAuthTokensRequest
    ): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse>

    @POST("registration/verification-code/send")
    suspend fun sendRegistrationVerificationCode(
            @Query("email") email: String,
    ): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse>

    @POST("registration/verification-code/verify")
    suspend fun verifyRegistrationCode(
            @Query("code") code: String,
            @Query("email") email: String?,
            @Query("phone_number") phoneNumber: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse>

    @PUT("registration/create-profile")
    suspend fun createProfile(
            @Body request: CreateProfileRequest
    ): NetworkResponse<AuthTokens, CreateProfileErrorResponse>

    @POST("posts")
    suspend fun getPosts(): NetworkResponse<List<Post>, Unit>
}