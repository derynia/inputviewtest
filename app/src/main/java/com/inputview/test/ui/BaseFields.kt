package com.inputview.test.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.Container
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.inputview.test.R
import com.inputview.test.ui.theme.Typography
import com.inputview.test.ui.theme.dimenBorder
import com.inputview.test.ui.theme.dimenRadius
import com.inputview.test.ui.theme.dimenS
import com.inputview.test.ui.theme.gray300

val EmptyComposable: @Composable () -> Unit = {}

// basic password field
// uses basic text field with added trailing icon which lets to show or hide user password
@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    labelModifier: Modifier = Modifier,
    text: String,
    interactionSource: MutableInteractionSource,
    labelText: String,
    errorText: String? = null,
    placeholderText: String? = null,
    isEnabled: Boolean = true,
    onValueChange: (String) -> Unit,
) {
    var masked by remember { mutableStateOf(true) }
    val visualTransformation by remember(masked) {
        if (masked) mutableStateOf(PasswordVisualTransformation())
        else mutableStateOf(VisualTransformation.None)
    }

    MainTextFieldWithLabel(
        modifier = modifier,
        labelModifier = labelModifier,
        interactionSource = interactionSource,
        visualTransformation = visualTransformation,
        labelText = labelText,
        text = text,
        errorText = errorText,
        onValueChange = onValueChange,
        placeholderText = placeholderText,
        isEnabled = isEnabled,
        trailingIcon = {
            IconButton(
                onClick = { masked = !masked }) {
                Icon(
                    painter = painterResource(if (!masked) R.drawable.pass_eye else R.drawable.pass_eye_cross),
                    tint = Color.Unspecified,
                    contentDescription = null
                )
            }
        }
    )
}

// Basic input text field with abillity to show errors
// parameter isEnabled added for future references
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextFieldWithLabel(
    modifier: Modifier = Modifier,
    labelModifier: Modifier = Modifier,
    text: String,
    interactionSource: MutableInteractionSource,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    labelText: String,
    errorText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholderText: String? = null,
    isEnabled: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = EmptyComposable,
    onValueChange: (String) -> Unit
) {
    if (labelText.isNotEmpty()) {
        LabelText(
            modifier = labelModifier,
            isError = !errorText.isNullOrEmpty(),
            labelText = labelText,
        )
        Spacer(modifier = Modifier.requiredHeight(dimenS))
    }

    BasicTextField(
        modifier = modifier,
        value = text,
        enabled = isEnabled,
        textStyle = Typography.bodyLarge,
        interactionSource = interactionSource,
        visualTransformation = visualTransformation,
        onValueChange = { newText -> onValueChange(newText) },
        keyboardOptions = keyboardOptions,
        maxLines = 1,
        singleLine = true
    ) {
        OutlinedTextFieldDefaults.DecorationBox(
            innerTextField = it,
            singleLine = true,
            enabled = true,
            value = text,
            isError = !errorText.isNullOrEmpty(),
            supportingText = getErrorText(errorText),
            placeholder = placeholderText?.let {
                {
                    Text(
                        text = placeholderText,
                        style = Typography.bodyLarge,
                        color = gray300
                    )
                }
            },
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            trailingIcon = trailingIcon,
            container = {
                Container(
                    enabled = true,
                    isError = !errorText.isNullOrEmpty(),
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surface,
                        errorBorderColor = MaterialTheme.colorScheme.error,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                        focusedBorderColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        unfocusedBorderColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        focusedSupportingTextColor = MaterialTheme.colorScheme.error,
                        unfocusedSupportingTextColor = MaterialTheme.colorScheme.error
                    ),
                    shape = RoundedCornerShape(dimenRadius),
                    focusedBorderThickness = dimenBorder,
                    unfocusedBorderThickness = dimenBorder,
                )
            }
        )
    }
}

// Basic label text for input field
@Composable
fun LabelText(
    modifier: Modifier,
    isError: Boolean,
    labelText: String,
) {
    Text(
        modifier = modifier,
        text = labelText,
        color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.tertiary,
        style = Typography.labelLarge
    )
}

// this function returns error text composable in case error text is not null
fun getErrorText(
    errorText: String?,
): @Composable (() -> Unit)? =
    errorText?.let {
        @Composable
        {
            ErrorText(
                modifier = Modifier.fillMaxWidth(),
                errorText = errorText
            )
        }
    }

// error text composable
@Composable
fun ErrorText(
    modifier: Modifier,
    errorText: String,
) {
    Text(
        modifier = modifier,
        fontFamily = Typography.labelSmall.fontFamily,
        color = MaterialTheme.colorScheme.error,
        text = errorText
    )
}
