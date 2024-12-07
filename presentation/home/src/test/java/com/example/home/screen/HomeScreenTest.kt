package com.example.home.screen

import android.os.Build
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasProgressBarRangeInfo
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.home.component.DRUG_ITEM_TEST_TAG
import com.example.home.viewmodel.HomeUiState
import com.example.test.util.DrugsTestData.result
import com.google.common.truth.Truth
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(
    sdk = [Build.VERSION_CODES.O],
    instrumentedPackages = ["androidx.loader.content"],
    qualifiers = "xlarge",
)
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private var drugItemClickCounter = 0


    @Test
    fun homeScreen_drugsLoading_progressBarIsShown() {
        with(composeTestRule) {
            setContent {
                HomeScreen(
                    homeUiState = HomeUiState.Loading
                )
            }

            onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate))
                .assertExists()
                .assertIsDisplayed()
        }
    }

    @Test
    fun homeScreen_drugsLoaded_showDrugList() {
        with(composeTestRule) {
            setContent {
                HomeScreen(
                    homeUiState = HomeUiState.Success( result() )
                )
            }

            composeTestRule.onNodeWithTag(DRUG_LIST_TEST_TAG)
                .assertExists()
                .assert(hasScrollAction())
                .assertIsDisplayed()

        }
    }

    @Test
    fun homeScreen_drugItemClicked_drugSummaryIsShown() {
        with(composeTestRule) {
            setContent {
                HomeScreen(
                    homeUiState = HomeUiState.Success( result() ),
                    onItemClick = { drugItemClickCounter++ }
                )
            }

            composeTestRule.onNodeWithTag(DRUG_LIST_TEST_TAG)
                .assertExists()
                .assert(hasScrollAction())
                .assertIsDisplayed()
                .onChildren()
                .assertCountEquals(4)

            composeTestRule.onAllNodesWithTag(DRUG_ITEM_TEST_TAG, useUnmergedTree = true)
                .assertCountEquals(4)
                .onFirst()
                .assertHasClickAction()
                .performClick()

            Truth.assertThat(drugItemClickCounter).isEqualTo(1)

        }
    }

}