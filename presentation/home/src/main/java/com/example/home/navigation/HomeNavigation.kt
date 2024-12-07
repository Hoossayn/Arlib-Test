package com.example.home.navigation

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.core.network.model.response.Drug
import com.example.home.screen.HomeScreen
import kotlinx.coroutines.flow.StateFlow

@VisibleForTesting
@Suppress("TopLevelPropertyNaming", "ktlint:standard:property-naming")
internal const val nameArg = "userName"

@Suppress("TopLevelPropertyNaming", "ktlint:standard:property-naming")
const val homeRoutePattern = "home/{$nameArg}"

internal class HomeArg(val name: StateFlow<String>) {

    constructor(savedStateHandle: SavedStateHandle) : this(
        name = checkNotNull(savedStateHandle.getStateFlow(nameArg, "/")),
    )
}

fun NavController.navigateToHome(
    userName: String,
    navOptions: NavOptions? = null,
) {
    this.navigate(route = "home/$userName", navOptions = navOptions)
}

fun NavGraphBuilder.homeScreen(
    onDrugItemClicked: (Drug) -> Unit,
) {
    composable(
        route = homeRoutePattern,
        arguments = listOf(
            navArgument(nameArg) {
                type = NavType.StringType
                defaultValue = "/"
            },
        ),
    ) {
        HomeScreen(
            onDrugItemClicked = onDrugItemClicked
        )
    }
}