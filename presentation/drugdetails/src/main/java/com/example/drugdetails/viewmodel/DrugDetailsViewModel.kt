package com.example.drugdetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.core.network.model.response.Drug
import com.example.drugdetails.navigation.drugDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DrugDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _drug = MutableStateFlow<Drug?>(null)
    val drug: StateFlow<Drug?> = _drug.asStateFlow()

    init {
        val drug = savedStateHandle.get<Drug>(drugDetails)
        _drug.value = drug
    }
}