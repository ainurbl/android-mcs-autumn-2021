package com.ainuribatov.learnandroid.interactor

import com.ainuribatov.learnandroid.entity.Item
import com.ainuribatov.learnandroid.entity.UserData
import com.ainuribatov.learnandroid.repository.UserListRepository
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class UserListInteractor @Inject constructor(
    private val userListRepository: UserListRepository
) {
    suspend fun loadUsers(): NetworkResponse<List<UserData>, Unit> =
        userListRepository.getUsers()
}