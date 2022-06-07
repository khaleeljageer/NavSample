package com.jskhaleel.navsample.ui.view.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jskhaleel.navsample.data.source.local.NavDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Khaleel Jageer on 06/06/22.
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val navDataStore: NavDataStore) : ViewModel() {
    private val _isReady = mutableStateOf(false)
    val isReady: Boolean by _isReady

    private val _userLogged = mutableStateOf(false)
    val userLogged: Boolean by _userLogged

    init {
        delaySplashScreen()
    }

    private fun delaySplashScreen() {
        viewModelScope.launch {
            _userLogged.value = navDataStore.isUserLogged()
            delay(timeMillis = 1000)
            _isReady.value = true
        }
    }

    fun setUserLogged() {
        viewModelScope.launch {
            navDataStore.login()
        }
    }
}