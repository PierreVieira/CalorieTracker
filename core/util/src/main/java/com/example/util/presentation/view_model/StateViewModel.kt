package com.example.util.presentation.view_model

import com.example.util.presentation.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StateView<Q: UiState>(
    firstState: Q
) {
    private val _uiState =  MutableStateFlow(firstState)
    val uiState: StateFlow<Q> = _uiState

    fun updateUiState(updateBlock: (currentUiState: Q) -> Q) {
        _uiState.value = updateBlock(uiState.value)
    }
}