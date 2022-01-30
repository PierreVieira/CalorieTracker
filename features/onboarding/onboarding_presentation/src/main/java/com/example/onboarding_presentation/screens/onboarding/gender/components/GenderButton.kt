package com.example.onboarding_presentation.screens.onboarding.gender.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.util.R
import com.example.util.domain.model.Gender
import com.example.onboarding_presentation.components.buttons.SelectableButton
import com.example.onboarding_presentation.screens.onboarding.gender.ui.GenderUiEvent

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
        onClick = { onGenderClick(event) },
        textStyle = MaterialTheme.typography.button.copy(
            fontWeight = FontWeight.Normal
        )
    )
}