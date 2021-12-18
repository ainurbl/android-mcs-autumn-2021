package com.ainuribatov.learnandroid.repository

import com.ainuribatov.learnandroid.data.network.Api
import com.ainuribatov.learnandroid.entity.Item
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val api: Api
) {
    suspend fun getUsers(): NetworkResponse<List<Item>, Unit> {
        return api.getUsers()
    }
}