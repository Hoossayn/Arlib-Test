package com.example.drugapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.ThemeConfig
import com.example.core.model.UserEditableSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<AppUIState>(AppUIState.Loading)
    val uiState: StateFlow<AppUIState> = _uiState.asStateFlow()

    init {
        loadUserData()
    }

    private fun loadUserData() {
        viewModelScope.launch {
            _uiState.value = AppUIState.Success(
                UserEditableSettings(
                    themeConfig = ThemeConfig.FOLLOW_SYSTEM,
                    isDynamicColor = true,
                )
            )
        }
    }
}

