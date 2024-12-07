@file:Suppress("TooManyFunctions", "MatchingDeclarationName")

package com.example.ds.core.theme

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.common.ExcludeFromGeneratedCoverageReport

data class AppBaseSpacing(
    val none: Dp = 0.dp,
    val quarter: Dp = 2.dp,
    val half: Dp = 4.dp,
    val one: Dp = 8.dp,
    val oneAndHalf: Dp = 12.dp,
    val two: Dp = 16.dp,
    val twoAndaHalf: Dp = 20.dp,
    val three: Dp = 24.dp,
    val four: Dp = 32.dp,
    val five: Dp = 40.dp,
    val fiveAndHalf: Dp = 44.dp,
    val six: Dp = 48.dp,
    val seven: Dp = 56.dp,
    val eight: Dp = 64.dp,
    val nine: Dp = 72.dp,
    val ten: Dp = 80.dp,
    val twelve: Dp = 96.dp,
)

@Composable
@ExcludeFromGeneratedCoverageReport
fun QuarterVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.quarter))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun HalfVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.half))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun OneVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.one))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun OneAndHalfVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.oneAndHalf))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun TwoVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.two))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun TwoAndHalfVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.twoAndaHalf))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun ThreeVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.three))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun FourVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.four))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun FiveVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.five))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun SixVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.six))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun EightVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.eight))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun TenVerticaSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.ten))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun TwelveVerticalSpacer() {
    Spacer(modifier = Modifier.height(DrugApp.spacing.twelve))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun ColumnScope.FillingSpacer() {
    Spacer(modifier = Modifier.weight(1f))
}

// Horizontal Spacers
@Composable
@ExcludeFromGeneratedCoverageReport
fun QuarterHorizontalSpacer() {
    Spacer(modifier = Modifier.width(DrugApp.spacing.quarter))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun HalfHorizontalSpacer() {
    Spacer(modifier = Modifier.width(DrugApp.spacing.half))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun OneHorizontalSpacer() {
    Spacer(modifier = Modifier.width(DrugApp.spacing.one))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun OneAndHalfHorizontalSpacer() {
    Spacer(modifier = Modifier.width(DrugApp.spacing.oneAndHalf))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun TwoHorizontalSpacer() {
    Spacer(modifier = Modifier.width(DrugApp.spacing.two))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun ThreeHorizontalSpacer() {
    Spacer(modifier = Modifier.width(DrugApp.spacing.three))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun TwoAndHalfHorizontalSpacer() {
    Spacer(modifier = Modifier.width(DrugApp.spacing.twoAndaHalf))
}

@Composable
@ExcludeFromGeneratedCoverageReport
fun RowScope.FillingSpacer() {
    Spacer(modifier = Modifier.weight(1f))
}

val LocalAppBaseSpacing = staticCompositionLocalOf { AppBaseSpacing() }
