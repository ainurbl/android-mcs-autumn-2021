package com.ainuribatov.learnandroid.data.network

import com.ainuribatov.learnandroid.data.network.request.CreateProfileRequest
import com.ainuribatov.learnandroid.data.network.request.RefreshAuthTokensRequest
import com.ainuribatov.learnandroid.data.network.request.SignInWithEmailRequest
import com.ainuribatov.learnandroid.data.network.response.error.*
import com.ainuribatov.learnandroid.entity.AuthTokens
import com.haroldadmin.cnradapter.NetworkResponse
import com.ainuribatov.learnandroid.data.network.response.VerificationTokenResponse
import com.ainuribatov.learnandroid.entity.UserData

class MockApi : Api {
    override suspend fun getUsers(): NetworkResponse<List<UserData>, Unit> {

        return NetworkResponse.Success(
            body = listOf(
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
                UserData(
                    avatarUrl = "https://sun9-75.userapi.com/impg/Pmwi-wYiLsvYmwx-vdqdjAjYa_wpJVaGUUh8vw/0ZGgCahPtt0.jpg?size=798x800&quality=96&sign=186834bb91f11d0dd712ca272d3ca828&type=album",
                    userName = "Лёша",
                    groupName = "Б09.мкн"
                ),
            ),
            code = 200
        )
    }

    override suspend fun signInWithEmail(request: SignInWithEmailRequest): NetworkResponse<AuthTokens, SignInWithEmailErrorResponse> {
        return NetworkResponse.Success(
            AuthTokens(
                accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dnZWRJbkFzIjoiYWRtaW4iLCJpYXQiOjE0MjI3Nzk2MzgsImV4cCI6MTY0MDg3MTc3MX0.gzSraSYS8EXBxLN_oWnFSRgCzcmJmMjLiuyu5CSpyHI",
                accessTokenExpiration = 1640871771000,
                refreshTokenExpiration = 1640871771000,
            ),
            code = 200
        )
    }

    override suspend fun refreshAuthTokens(request: RefreshAuthTokensRequest): NetworkResponse<AuthTokens, RefreshAuthTokensErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun sendRegistrationVerificationCode(email: String): NetworkResponse<Unit, SendRegistrationVerificationCodeErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun verifyRegistrationCode(
        code: String,
        email: String?,
        phoneNumber: String?
    ): NetworkResponse<VerificationTokenResponse, VerifyRegistrationCodeErrorResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun createProfile(request: CreateProfileRequest): NetworkResponse<AuthTokens, CreateProfileErrorResponse> {
        TODO("Not yet implemented")
    }
}