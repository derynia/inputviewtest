package com.inputview.test.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = blue500,
    secondary = yellow700,
    secondaryContainer = yellow100,
    tertiary = gray950,
    surface = gray00,
    surfaceContainerLow = gray00,
    surfaceContainer = gray950,
    surfaceContainerHigh = gray500,
    error = red600,
    errorContainer = red100,
)

@Composable
fun InputViewTestApplicationTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}