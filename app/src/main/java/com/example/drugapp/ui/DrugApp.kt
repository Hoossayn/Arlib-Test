package com.example.drugapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.drugapp.navigation.BaseNavHost


const val MAIN_CONTENT_TEST_TAG = "mainContent"

@Composable
fun DrugApp(
    navController: NavHostController = rememberNavController(),
) {

    Scaffold(
        modifier = Modifier.testTag(MAIN_CONTENT_TEST_TAG),
    ) { innerPadding ->

        Box(
            modifier = Modifier.padding(
                bottom = max(
                    a = 0.dp,
                    b = innerPadding.calculateBottomPadding() - 40.dp,
                ),
            ),
            content = {
                BaseNavHost(
                    navController = navController,
                )
            },
        )
    }

}
