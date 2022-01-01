package com.ainuribatov.learnandroid.ui.userlist

import androidx.lifecycle.viewModelScope
import com.ainuribatov.learnandroid.entity.Item
import com.ainuribatov.learnandroid.entity.SeparatorData
import com.ainuribatov.learnandroid.entity.UserData
import com.ainuribatov.learnandroid.interactor.UserListInteractor
import com.ainuribatov.learnandroid.ui.base.BaseViewModel
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userListInteractor: UserListInteractor
) : BaseViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        data class Data(val userList: List<UserData>) : ViewState()
        object Empty : ViewState()
        object Error : ViewState()
    }

    private val _uiState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState: Flow<ViewState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.emit(ViewState.Loading)
            when (val response = userListInteractor.loadUsers()) {
                is NetworkResponse.Success -> {
                    if (response.body.isEmpty()) {
                        _uiState.emit(ViewState.Empty)
                    } else {
                        _uiState.emit(ViewState.Data(response.body))
                    }
                }
                else -> {
                    _uiState.emit(ViewState.Error)
                }
            }

        }

    }

}