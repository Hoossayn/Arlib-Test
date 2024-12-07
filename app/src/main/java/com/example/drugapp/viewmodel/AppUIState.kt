package com.example.drugapp.viewmodel

import com.example.core.model.UserEditableSettings


sealed interface AppUIState {
    data object Loading : AppUIState

    data class Success(val settings: UserEditableSettings) : AppUIState
}
