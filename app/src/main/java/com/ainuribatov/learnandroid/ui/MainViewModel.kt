package com.ainuribatov.learnandroid.ui

import com.ainuribatov.learnandroid.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : BaseViewModel() {

    val isAuthorizedFlow: Flow<Boolean> = MutableStateFlow(true)


}