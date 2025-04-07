package com.inputview.test.ui.events

sealed interface MainScreenEvents {
    data class OnUserNameChanged(val userName: String) : MainScreenEvents
    data class OnPasswordChanged(val password: String) : MainScreenEvents
}