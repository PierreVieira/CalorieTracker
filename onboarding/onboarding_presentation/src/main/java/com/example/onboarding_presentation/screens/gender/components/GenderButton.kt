package com.example.onboarding_presentation.screens.gender.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.core.R
import com.example.core.domain.model.Gender
import com.example.onboarding_presentation.components.buttons.SelectableButton
import com.example.onboarding_presentation.screens.gender.GenderUiEvent

@Composable
internal fun GenderButton(
    gender: Gender,
    selectedGender: Gender,
    onGenderClick: (GenderUiEvent.SelectGender) -> Unit
) {
    val event = GenderUiEvent.SelectGender(gender)
    SelectableButton(
        text = stringResource(id = if (gender == Gender.MALE) R.string.male else R.string.female),
        isSelected = selectedGender == gender,
        color = MaterialTheme.colors.primaryVariant,
        selectedTextColor = Color.White,
        onClick = { onGenderClick(event) },
        textStyle = MaterialTheme.typography.button.copy(
            fontWeight = FontWeight.Normal
        )
    )
}