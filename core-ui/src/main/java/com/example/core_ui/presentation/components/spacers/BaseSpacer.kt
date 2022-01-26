package com.example.core_ui.presentation.components.spacers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.core_ui.domain.SpacerType
import com.example.core_ui.presentation.LocalSpacing

@Composable
fun BaseSpacer(spacerType: SpacerType, size: Dp?) {
    val spaceSize = size ?: LocalSpacing.current.medium
    if (spacerType == SpacerType.HORIZONTAL) {
        Spacer(modifier = Modifier.width(spaceSize))
    } else {
        Spacer(modifier = Modifier.height(spaceSize))
    }
}