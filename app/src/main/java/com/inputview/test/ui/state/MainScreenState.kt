package com.inputview.test.ui.state

data class MainScreenState(
    val userName: String = "",
    val password: String = "",
    val isUserError: Boolean = false,
    val isPasswordError: Boolean = false
)
