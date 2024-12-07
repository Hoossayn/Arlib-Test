package com.example.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.network.model.response.Drug

const val DRUG_ITEM_TEST_TAG = "drug_item"

@Composable
fun DrugItem(
    drug: Drug,
    onItemClick: (Drug) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(drug)
            }
        .testTag(DRUG_ITEM_TEST_TAG),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, Color.LightGray),

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

@Preview
@Composable
fun previewDrugItem() {
    val drug = Drug("aspirin", "1 tablet", "500 mg")

    //DrugItem(drug = drug)
}