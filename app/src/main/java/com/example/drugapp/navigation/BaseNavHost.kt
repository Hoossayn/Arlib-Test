package com.example.drugapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.example.core.network.model.response.Drug
import com.example.drugdetails.navigation.drugDetailsScreen
import com.example.drugdetails.navigation.navigateToDrugDetails
import com.example.home.navigation.homeScreen
import com.example.home.navigation.navigateToHome
import com.example.login.navigation.loginRoutePattern
import com.example.login.navigation.loginScreen

@Suppress("UnusedPrivateMember")
@Composable
fun BaseNavHost(
    navController: NavHostController,
) {
    val onNavigateUp: () -> Unit = {
        navController.navigateUp()
    }

    val onLoginClick: (String) -> Unit = { userName ->
        navController.navigateToHome(
            userName = userName,
            navOptions = navOptions {},
        )
    }

    val onDrugItemClick: (Drug) -> Unit = { drug ->
        navController.navigateToDrugDetails(
            drug = drug,
            navOptions = navOptions {},
        )
    }

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = loginRoutePattern,
    ) {
        loginScreen( onLoginClick =  onLoginClick)
        homeScreen(onDrugItemClicked = onDrugItemClick)
        drugDetailsScreen()
    }
}
