package com.example.ui.presentation.components.spacers

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.example.ui.presentation.components.spacers.base.SpacerType
import com.example.ui.presentation.components.spacers.base.BaseSpacer

@Composable
fun HorizontalSpacer(size: Dp? = null) {
    BaseSpacer(spacerType = SpacerType.HORIZONTAL, size = size)
}