package com.inputview.test.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.inputview.test.ui.events.MainScreenEvents
import com.inputview.test.ui.state.MainScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel: ViewModel() {
    private val _mainScreenState = MutableStateFlow<MainScreenState>(MainScreenState())
    val mainScreenState: StateFlow<MainScreenState> = _mainScreenState

    private val regex = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[?=#/%]).{8,}$")

    fun onEvent(event: MainScreenEvents) {
        when (event) {
            is MainScreenEvents.OnPasswordChanged -> _mainScreenState.update {
                it.copy(
                    password = event.password,
                    isPasswordError = event.password.isNotEmpty() && !regex.matches(event.password)
                )
            }
            is MainScreenEvents.OnUserNameChanged -> _mainScreenState.update {
                it.copy(
                    userName = event.userName,
                    isUserError = false
                )
            }
        }
    }
}