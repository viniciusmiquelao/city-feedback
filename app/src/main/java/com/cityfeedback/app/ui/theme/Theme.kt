package com.cityfeedback.app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF585858),
    secondary = Primary,
    tertiary = Primary,
    background = Color.White,
    surface = Color(0xFF585858),
    onPrimary = Color.White,
    onSecondary = Color(0xFF585858),
    onTertiary = Color.White,
    onBackground = Color.White,
    primaryContainer = Primary,
    secondaryContainer = Color.Transparent,
    onSurface = Primary,
    onSurfaceVariant = Color.DarkGray

)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    secondary = Color.White,
    tertiary = Primary,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Primary,
    onTertiary = Color.White,
    onBackground = Color.White,
    primaryContainer = Primary,
    secondaryContainer = Color.Transparent,
    onSurface = Primary,
    onSurfaceVariant = Color.LightGray

)


@Composable
fun CityfeedbackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) DarkColorScheme else LightColorScheme
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}