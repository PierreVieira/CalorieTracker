package com.example.util.presentation.ui.state

import com.example.util.presentation.ui.data.UiData
import com.example.util.presentation.ui.state.base.UiState

abstract class LoadUiState<DATA: UiData>(
    val isLoading: Boolean,
    val isError: Boolean
): UiState<DATA>