package com.example.onboarding_presentation.screens.onboarding.selectable.implementation.gender.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.util.R
import com.example.util.domain.model.Gender
import com.example.onboarding_presentation.screens.welcome.components.SelectableButton
import com.example.onboarding_presentation.screens.onboarding.selectable.implementation.gender.ui.GenderUiEvent
import com.example.ui.presentation.theme.CalorieTrackerTheme

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

@Composable
@Preview
private fun GenderButtonPreview() {
    CalorieTrackerTheme {
        GenderButton(
            gender = Gender.MALE,
            selectedGender = Gender.MALE,
            onGenderClick = {}
        )
    }
}