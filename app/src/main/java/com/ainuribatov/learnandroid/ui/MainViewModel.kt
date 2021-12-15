package com.ainuribatov.learnandroid.ui

import com.ainuribatov.learnandroid.interactor.AuthInteractor
import com.ainuribatov.learnandroid.repository.AuthRepository
import com.ainuribatov.learnandroid.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): BaseViewModel() {
    suspend fun isAuthorizedFlow(): Flow<Boolean> =
        authInteractor.isAuthorized()
}