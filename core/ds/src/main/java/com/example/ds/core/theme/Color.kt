@file:Suppress("MagicNumber")

package com.example.ds.core.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF7C16F2)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFECDCFF)
val md_theme_light_onPrimaryContainer = Color(0xFF270057)
val md_theme_light_secondary = Color(0xFFBA0061)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFD9E2)
val md_theme_light_onSecondaryContainer = Color(0xFF3E001C)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF1D1B1E)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF1D1B1E)

val md_theme_dark_primary = Color(0xFFD6BAFF)
val md_theme_dark_onPrimary = Color(0xFF42008A)
val md_theme_dark_primaryContainer = Color(0xFF5F00C0)
val md_theme_dark_onPrimaryContainer = Color(0xFFECDCFF)
val md_theme_dark_secondary = Color(0xFFFFB1C7)
val md_theme_dark_onSecondary = Color(0xFF650032)
val md_theme_dark_secondaryContainer = Color(0xFF8E0049)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFD9E2)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1D1B1E)
val md_theme_dark_onBackground = Color(0xFFE6E1E6)
val md_theme_dark_surface = Color(0xFF1D1B1E)
val md_theme_dark_onSurface = Color(0xFFE6E1E6)
val md_theme_dark_surfaceVariant = Color(0xFF49454E)
val md_theme_dark_onSurfaceVariant = Color(0xFFCBC4CF)
val md_theme_dark_outline = Color(0xFF958E99)


@Stable
class AppColorScheme(extraColor: Color) {
    var extraColor by mutableStateOf(extraColor, structuralEqualityPolicy())
        internal set
}

fun appLightColorScheme(): AppColorScheme {
    return AppColorScheme(extraColor = md_theme_dark_outline)
}

fun appDarkColorScheme(): AppColorScheme {
    return AppColorScheme(extraColor = md_theme_dark_outline)
}

val LocalAppColorScheme = staticCompositionLocalOf { appLightColorScheme() }
