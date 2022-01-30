package com.example.onboarding_presentation.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.presentation.theme.CalorieTrackerTheme
import com.example.ui.presentation.theme.LocalSpacing

@Composable
fun SelectableButton(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primaryVariant,
    selectedTextColor: Color = Color.White,
    textStyle: TextStyle = MaterialTheme.typography.button,
    onClick: () -> Unit
) {
    val shapeSize = 100.dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(shapeSize))
            .border(
                width = 2.dp,
                color = color,
                shape = RoundedCornerShape(shapeSize)
            )
            .background(
                color = if (isSelected) color else Color.Transparent,
                shape = RoundedCornerShape(shapeSize)
            )
            .clickable {
                onClick()
            }
            .padding(LocalSpacing.current.medium)
    ) {
        Text(
            text = text,
            style = textStyle,
            color = if (isSelected) selectedTextColor else color
        )
    }
}

@Composable
@Preview
private fun SelectableButtonUnselectedPreview() {
    CalorieTrackerTheme {
        SelectableButton(
            text = "Male",
            isSelected = false,
            onClick = {}
        )
    }
}

@Composable
@Preview
private fun SelectableButtonSelectedPreview() {
    CalorieTrackerTheme {
        SelectableButton(
            text = "Male",
            isSelected = true,
            onClick = {}
        )
    }
}