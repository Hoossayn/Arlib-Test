package com.example.drugdetails.navigation

import android.net.Uri
import androidx.annotation.VisibleForTesting
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.core.network.model.response.Drug
import com.example.drugdetails.screen.DrugDetailsScreen
import com.google.gson.Gson

@VisibleForTesting
@Suppress("TopLevelPropertyNaming", "ktlint:standard:property-naming")
internal const val drugDetails = "drugDetails"

fun NavController.navigateToDrugDetails(
    drug: Drug,
    navOptions: NavOptions? = null,
) {
    currentBackStackEntry?.savedStateHandle?.set(
        key = "drugDetails",
        value = drug
    )
    val drugJson = Uri.encode(Gson().toJson(drug))
    this.navigate("drugDetails/${drugJson}", navOptions = navOptions)

}

fun NavGraphBuilder.drugDetailsScreen() {
    composable(
        route = "drugDetails/{drugDetails}",
        arguments = listOf(
            navArgument(drugDetails) {
                type = DrugNavType
            },
        ),
    ) {backStackEntry ->
        val drug = backStackEntry.arguments?.getParcelable<Drug>(drugDetails)
        if (drug != null) {
            DrugDetailsScreen(
                drug = drug,
            )
        }
    }
}