package com.example.drugdetails.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.network.model.response.Drug
import com.example.core.ui.component.Background
import com.example.drugdetails.viewmodel.DrugDetailsViewModel

@Composable
fun DrugDetailsScreen(
    viewModel: DrugDetailsViewModel = hiltViewModel(),
) {
    val drug by viewModel.drug.collectAsStateWithLifecycle()

    drug?.let {
        DrugDetailsScreen(
        drug = it,
    )
    }
}


@Composable
fun DrugDetailsScreen(
    drug: Drug
) {

    Background {
        Box(modifier = Modifier.fillMaxSize().padding(vertical = 60.dp)) {
            Spacer(modifier = Modifier.padding(vertical = 60.dp))
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),

                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = drug.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Dose: ${drug.dose}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Strength: ${drug.strength}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        }
    }

}