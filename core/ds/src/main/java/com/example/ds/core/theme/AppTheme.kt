package com.example.ds.core.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.example.common.ExcludeFromGeneratedCoverageReport

@VisibleForTesting
val LightColors =
    lightColorScheme(
        primary = md_theme_light_primary,
        onPrimary = md_theme_light_onPrimary,
        primaryContainer = md_theme_light_primaryContainer,
        onPrimaryContainer = md_theme_light_onPrimaryContainer,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        secondaryContainer = md_theme_light_secondaryContainer,
        onSecondaryContainer = md_theme_light_onSecondaryContainer,
        error = md_theme_light_error,
        errorContainer = md_theme_light_errorContainer,
        onError = md_theme_light_onError,
        onErrorContainer = md_theme_light_onErrorContainer,
        background = md_theme_light_background,
        onBackground = md_theme_light_onBackground,
        surface = md_theme_light_surface,
        onSurface = md_theme_light_onSurface,

    )

@VisibleForTesting
val DarkColors =
    darkColorScheme(
        primary = md_theme_dark_primary,
        onPrimary = md_theme_dark_onPrimary,
        primaryContainer = md_theme_dark_primaryContainer,
        onPrimaryContainer = md_theme_dark_onPrimaryContainer,
        secondary = md_theme_dark_secondary,
        onSecondary = md_theme_dark_onSecondary,
        secondaryContainer = md_theme_dark_secondaryContainer,
        onSecondaryContainer = md_theme_dark_onSecondaryContainer,
        error = md_theme_dark_error,
        errorContainer = md_theme_dark_errorContainer,
        onError = md_theme_dark_onError,
        onErrorContainer = md_theme_dark_onErrorContainer,
        background = md_theme_dark_background,
        onBackground = md_theme_dark_onBackground,
        surface = md_theme_dark_surface,
        onSurface = md_theme_dark_onSurface,
        surfaceVariant = md_theme_dark_surfaceVariant,
        onSurfaceVariant = md_theme_dark_onSurfaceVariant,

    )

object DrugApp {
    val spacing: AppBaseSpacing
        @Composable
        get() = LocalAppBaseSpacing.current

    val typography: AppBaseTypography
        @Composable
        get() = LocalAppBaseTypography.current

    val shape: AppBaseShape
        @Composable
        get() = LocalAppShape.current

    val color: ColorScheme
        @Composable
        get() = MaterialTheme.colorScheme

    val extraColor: AppColorScheme
        @Composable
        get() = LocalAppColorScheme.current

}

@Composable
@ExcludeFromGeneratedCoverageReport
fun AppBaseTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isDynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    /**
     * Dynamic Colors are supported on API level 31 and above
     * */
    val dynamicColor = isDynamicColor && supportsDynamicTheming()
    val colorScheme =
        when {
            dynamicColor && isDarkTheme -> {
                Pair(dynamicDarkColorScheme(LocalContext.current), appDarkColorScheme())
            }

            dynamicColor && !isDarkTheme -> {
                Pair(dynamicLightColorScheme(LocalContext.current), appLightColorScheme())
            }

            isDarkTheme -> Pair(DarkColors, appDarkColorScheme())
            else -> Pair(LightColors, appLightColorScheme())
        }
    val appBaseShape = AppBaseShape()

    CompositionLocalProvider(
        LocalAppBaseSpacing provides AppBaseSpacing(),
        LocalAppBaseTypography provides AppBaseTypography(),
        LocalAppColorScheme provides colorScheme.second,
        LocalAppShape provides appBaseShape,
    ) {
        MaterialTheme(
            colorScheme = colorScheme.first,
            typography = DrugApp.typography.toMaterialTypography(),
            shapes = appBaseShape.toMaterialShapes(),
            content = content,
        )
    }
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
