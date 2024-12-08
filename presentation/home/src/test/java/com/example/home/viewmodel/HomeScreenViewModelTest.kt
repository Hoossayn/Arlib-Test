package com.example.home.viewmodel

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.example.core.data.repository.DrugRepository
import com.example.home.navigation.nameArg
import com.example.test.util.DrugsTestData.drugResponse
import com.example.test.util.DrugsTestData.result
import com.example.test.util.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

const val TEST_ID = ""

class HomeScreenViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var homeViewModel: HomeViewModel

    private val drugRepository = mockk<DrugRepository>()

    private val savedStateHandle = SavedStateHandle().apply {
        this[nameArg] = TEST_ID
    }

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(
            drugRepository = drugRepository,
            savedStateHandle = savedStateHandle
        )
    }


    @Test
    fun home_screen_loadDrugsSuccessful() = runTest {
        coEvery { drugRepository.cachingDrugs() } returns Unit
        coEvery { drugRepository.getDrugsFromDb() } returns result()
        coEvery { drugRepository.getDrugsFromRemote() } returns drugResponse()

        homeViewModel.homeUiState.test {
            assertEquals(HomeUiState.Loading, awaitItem())
            assertEquals(HomeUiState.Success(result()), awaitItem())
        }
    }

    @Test
    fun home_screen_ViewModel_empty_drugs_retrieval() = runTest {
        coEvery { drugRepository.cachingDrugs() } returns Unit
        coEvery { drugRepository.getDrugsFromDb() } returns emptyList()

        homeViewModel.homeUiState.test {
            assertEquals(HomeUiState.Loading, awaitItem())
            assertEquals(HomeUiState.Success(emptyList()), awaitItem())
        }
    }

    @Test
    fun home_screen_ViewModel_failed_drugs_retrieval() = runTest {
        coEvery { drugRepository.cachingDrugs() } returns Unit
        coEvery { drugRepository.getDrugsFromDb() } throws Exception("Network error")
        coEvery { drugRepository.getDrugsFromRemote() } throws Exception("Network error")

        homeViewModel.homeUiState.test {
            assertEquals(HomeUiState.Loading, awaitItem())
            assertEquals(HomeUiState.LoadFailed("Network error"), awaitItem())
        }
    }

}