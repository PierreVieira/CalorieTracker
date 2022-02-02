package com.example.util.presentation.ui.state.base

import com.example.util.presentation.ui.data.UiData

interface UiState<DATA: UiData> {
    val data: DATA?
}