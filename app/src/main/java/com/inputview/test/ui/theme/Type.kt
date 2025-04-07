package com.inputview.test.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.inputview.test.R

val mainFontFamily = FontFamily(
    Font(R.font.inter)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = mainFontFamily, // or your custom font family
        fontSize = 16.sp,
        fontWeight = FontWeight(500),
        lineHeight = 22.sp,
        letterSpacing = 0.16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.01.sp
    ),
    labelSmall = TextStyle(
        fontFamily = mainFontFamily, // or your custom font family
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        lineHeight = 22.sp,
        letterSpacing = 0.01.sp,
    )
)