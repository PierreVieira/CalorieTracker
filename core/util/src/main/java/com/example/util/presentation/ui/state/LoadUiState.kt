package com.example.util.presentation.ui.state

import com.example.util.presentation.ui.state.base.UiState

abstract class LoadUiState(
    open val isLoading: Boolean,
    open val isError: Boolean
): UiState