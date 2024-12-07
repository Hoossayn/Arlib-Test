package com.example.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.ui.navigation.enterTransition
import com.example.core.ui.navigation.exitTransition
import com.example.core.ui.navigation.popEnterTransition
import com.example.core.ui.navigation.popExitTransition
import com.example.login.screen.LoginScreen


@Suppress("TopLevelPropertyNaming", "ktlint:standard:property-naming")
const val loginRoutePattern = "/login"

fun NavGraphBuilder.loginScreen(onLoginClick: (String) -> Unit) {
    composable(
        route = loginRoutePattern,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
    ) {
        LoginScreen(onLoginClicked = onLoginClick)
    }
}
