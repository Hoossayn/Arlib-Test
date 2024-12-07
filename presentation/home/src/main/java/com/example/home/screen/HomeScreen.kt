package com.example.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.network.model.response.Drug
import com.example.core.ui.component.Background
import com.example.core.ui.component.ErrorText
import com.example.core.ui.component.Loading
import com.example.home.component.DrugItem
import com.example.home.viewmodel.HomeUiState
import com.example.home.viewmodel.HomeViewModel


const val DRUG_LIST_TEST_TAG = "drug_listItems"

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onDrugItemClicked: (drug: Drug) -> Unit,
) {
    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()

    val userName by viewModel.userName.collectAsStateWithLifecycle()

    val hourOfDay by viewModel.hourOfDay.collectAsState("Good day")

    HomeScreen(
        username = userName,
        hourOfDay = hourOfDay,
        homeUiState = homeUiState,
        onItemClick = onDrugItemClicked
    )
}


@Composable
fun HomeScreen(
    username: String ?= "",
    hourOfDay: String ?= "",
    homeUiState: HomeUiState,
    onItemClick: (drug: Drug) -> Unit = {}
) {

    Background {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = " ${hourOfDay}, $username !",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.background,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )

            when (homeUiState) {

                is HomeUiState.Loading  -> {
                    Loading()
                }
                is HomeUiState.LoadFailed  -> {
                    ErrorText(message = "Error: ${homeUiState.message}")

                }
                is HomeUiState.Success  -> {
                    val drugs = homeUiState.drugs
                    if (drugs.isEmpty()) {
                        Text(text = "No drugs found")
                    } else {
                        LazyColumn(
                            modifier = Modifier.padding(horizontal = 8.dp)
                                .testTag(DRUG_LIST_TEST_TAG),
                            content = {
                                items(
                                    count = drugs.size
                                ){index ->
                                    DrugItem(
                                        drug = drugs[index],
                                        onItemClick = { onItemClick(drugs[index]) }
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
