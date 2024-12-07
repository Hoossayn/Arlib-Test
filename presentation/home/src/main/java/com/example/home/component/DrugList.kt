package com.example.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.network.model.response.Drug

@Composable
fun DrugList(
    drugs: List<Drug>,
    //navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        drugs.forEach { drug ->

        }
    }
}

