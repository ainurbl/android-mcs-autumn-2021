package com.ainuribatov.learnandroid.ui.signin

import androidx.lifecycle.viewModelScope
import com.ainuribatov.learnandroid.repository.AuthRepository
import com.ainuribatov.learnandroid.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SignInViewModel : BaseViewModel() {
    fun signIn() {
        viewModelScope.launch {
            AuthRepository.signIn()
        }
    }
}