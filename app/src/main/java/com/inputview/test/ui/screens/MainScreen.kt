package com.inputview.test.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.inputview.test.R
import com.inputview.test.ui.MainTextFieldWithLabel
import com.inputview.test.ui.state.MainScreenState
import com.inputview.test.ui.theme.dimenM
import com.inputview.test.ui.viewmodel.MainScreenViewModel
import androidx.compose.runtime.getValue
import com.inputview.test.ui.PasswordInput
import com.inputview.test.ui.events.MainScreenEvents
import com.inputview.test.ui.theme.dimenL
import com.inputview.test.ui.theme.dimenTextField

@Composable
fun MainScreen(viewModel: MainScreenViewModel = viewModel()) {
    val state by viewModel.mainScreenState.collectAsState()
    MainScreenData(
        state = state,
        onUserNameChanged = { userName -> viewModel.onEvent(MainScreenEvents.OnUserNameChanged(userName)) },
        onPasswordChanged = { password -> viewModel.onEvent(MainScreenEvents.OnPasswordChanged(password)) }
    )
}

@Composable
fun MainScreenData(
    state: MainScreenState,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
) {
    val userNameInteraction = remember { MutableInteractionSource() }
    val passwordInteraction = remember { MutableInteractionSource() }
    val passwordErrorMsg = if (state.isPasswordError) stringResource(R.string.password_error) else null
    val userErrorMsg = if (state.isUserError) stringResource(R.string.user_error) else null

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(100.dp))
        MainTextFieldWithLabel(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = dimenTextField)
                .padding(horizontal = dimenM),
            labelModifier = Modifier.fillMaxWidth().padding(horizontal = dimenM),
            interactionSource = userNameInteraction,
            visualTransformation = VisualTransformation.None,
            labelText = stringResource(R.string.user_name),
            text = state.userName,
            errorText = userErrorMsg,
            keyboardOptions = KeyboardOptions.Default,
            onValueChange = { text -> onUserNameChanged(text) },
            placeholderText = stringResource(R.string.user_name),
        )

        Spacer(Modifier.height(dimenL))
        PasswordInput(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = dimenTextField)
                .padding(horizontal = dimenM),
            labelModifier = Modifier.fillMaxWidth().padding(horizontal = dimenM),
            interactionSource = passwordInteraction,
            labelText = stringResource(R.string.password),
            text = state.password,
            errorText = passwordErrorMsg,
            onValueChange = { text -> onPasswordChanged(text) },
            placeholderText = stringResource(R.string.password),
        )
    }
}