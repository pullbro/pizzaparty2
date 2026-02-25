package com.example.pizzaparty3.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

private val BaseTypography = Typography()

private fun TextStyle.serif() = copy(fontFamily = FontFamily.Serif)
private fun TextStyle.cursive() = copy(fontFamily = FontFamily.Cursive)

val Typography = Typography(
    displayLarge = BaseTypography.displayLarge.serif(),
    displayMedium = BaseTypography.displayMedium.serif(),
    displaySmall = BaseTypography.displaySmall.serif(),
    headlineLarge = BaseTypography.headlineLarge.serif(),
    headlineMedium = BaseTypography.headlineMedium.serif(),
    headlineSmall = BaseTypography.headlineSmall.serif(),
    titleLarge = BaseTypography.titleLarge.cursive(),
    titleMedium = BaseTypography.titleMedium.serif(),
    titleSmall = BaseTypography.titleSmall.serif(),
    bodyLarge = BaseTypography.bodyLarge.serif(),
    bodyMedium = BaseTypography.bodyMedium.serif(),
    bodySmall = BaseTypography.bodySmall.serif(),
    labelLarge = BaseTypography.labelLarge.cursive(),
    labelMedium = BaseTypography.labelMedium.serif(),
    labelSmall = BaseTypography.labelSmall.serif()
)
