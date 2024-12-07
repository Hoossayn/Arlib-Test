package com.example.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.common.injection.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel() {}

sealed interface LoginUiState {

    data object Loading : LoginUiState

    data class Success(val message: String) : LoginUiState

    data class LoadFailed(val message: String) : LoginUiState
}
