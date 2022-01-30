package com.example.onboarding_presentation.screens.onboarding.gender

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.util.domain.model.Gender
import com.example.util.presentation.ui.event.NavigationUiEvent
import com.example.ui.presentation.components.spacers.HorizontalSpacer
import com.example.onboarding_presentation.screens.onboarding.BaseOnboardScreen
import com.example.onboarding_presentation.screens.onboarding.gender.components.GenderButton
import com.example.onboarding_presentation.screens.onboarding.gender.ui.GenderUiEvent
import kotlinx.coroutines.flow.collect
import com.example.util.R

@Composable
fun GenderScreen(
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val gender by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when(uiEvent) {
                is NavigationUiEvent.Navigate -> onNavigate(uiEvent)
                is NavigationUiEvent.NavigateUp -> onBackClick(uiEvent)
                else -> {}
            }
        }
    }
    GenderScreen(
        selectedGender = gender,
        onGenderClick = { viewModel.onGenderClick(it.gender) },
        onNextClick = viewModel::onNextClick,
        onBackClick = viewModel::onBackClick
    )
}

@Composable
private fun GenderScreen(
    selectedGender: Gender,
    onGenderClick: (GenderUiEvent.SelectGender) -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    BaseOnboardScreen(
        appBarTitleResource = R.string.gender,
        questionResource = R.string.whats_your_gender,
        onNextClick = onNextClick,
        onBackClick = onBackClick
    ) {
        Row {
            GenderButton(
                gender = Gender.MALE,
                selectedGender = selectedGender,
                onGenderClick = onGenderClick
            )
            HorizontalSpacer()
            GenderButton(
                gender = Gender.FEMALE,
                selectedGender = selectedGender,
                onGenderClick = onGenderClick
            )
        }
    }
}