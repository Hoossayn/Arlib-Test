package com.example.home.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.DrugRepository
import com.example.core.network.model.response.Drug
import com.example.home.navigation.HomeArg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val drugRepository: DrugRepository,
) : ViewModel() {

    val userName = HomeArg(savedStateHandle).name

    val hourOfDay = flow {
        emit(getHourOfDay())
    }


    val homeUiState: StateFlow<HomeUiState> = flow {
        emit(HomeUiState.Loading)
        try {
            drugRepository.cachingDrugs()
            emit(HomeUiState.Success(drugRepository.getDrugsFromDb()))
        } catch (e: Exception) {
            emit(HomeUiState.LoadFailed(e.message ?: "An unknown error occurred"))
        }

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HomeUiState.Loading,
    )

    fun getHourOfDay(): String {
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 6..11 -> "Good morning"
            in 12..16 -> "Good afternoon"
            in 17..19 -> "Good evening"
            else -> "Good night"
        }
    }

}

sealed interface HomeUiState {

    data object Loading : HomeUiState

    data class Success(val drugs: List<Drug>) : HomeUiState

    data class LoadFailed(val message: String) : HomeUiState
}