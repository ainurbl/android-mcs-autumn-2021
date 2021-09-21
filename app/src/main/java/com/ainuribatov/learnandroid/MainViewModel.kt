package com.ainuribatov.learnandroid

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        data class Data(val userList: List<Item>) : ViewState()
    }

    private val _uiState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState: Flow<ViewState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = ViewState.Loading
            val users = loadUsers(true)
            _uiState.value = ViewState.Data(users)
        }
    }

    private fun decorateUsers(users: List<Item>): List<Item> {
        val decorated: MutableList<Item> = mutableListOf()
        for (i in users) {
            decorated.add(i)
            decorated.add(SeparatorData())
        }
        return decorated
    }

    private suspend fun loadUsers(decorated: Boolean): List<Item> {
        val users = withContext(Dispatchers.IO) {
            Thread.sleep(3000)
            provideApi().getUsers().data
        }
        if (decorated) {
            return decorateUsers(users)
        }
        return users
    }

    private fun provideApi(): Api {
        return Retrofit.Builder()
            .client(provideOkHttpClient())
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
            .build()
            .create(Api::class.java)
    }

    private fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}