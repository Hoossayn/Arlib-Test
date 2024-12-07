package com.example.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.common.ExcludeFromGeneratedCoverageReport
import com.example.designSystem.core.annotation.ThemePreviews
import com.example.ds.core.theme.AppBaseTheme
import com.example.ds.core.theme.DrugApp


@ThemePreviews
@Composable
@ExcludeFromGeneratedCoverageReport
private fun BackgroundPreview() {
    AppBaseTheme {
        Background {
            Text(text = "Background")
        }
    }
}

@Composable
fun Background(content: @Composable () -> Unit) {
    @Suppress("MagicNumber")
    val colorStops = listOf(
        DrugApp.color.primary,
        Color(0x00000000),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DrugApp.color.surface),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(colorStops)),
        )
        content()
    }
}
