package com.example.core_ui.presentation.components.spacers

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.example.core_ui.domain.SpacerType

@Composable
fun VerticalSpacer(size: Dp? = null) {
    BaseSpacer(spacerType = SpacerType.HORIZONTAL, size = size)
}