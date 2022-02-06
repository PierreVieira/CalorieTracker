package com.example.onboarding_presentation.screens.onboarding.input_text.implementation.age

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextScreen
import com.example.util.R
import com.example.util.presentation.ui.event.NavigationUiEvent

@ExperimentalComposeUiApi
@Composable
fun AgeScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit,
    viewModel: AgeViewModel = hiltViewModel()
) = OnboardingInputTextScreen(
    viewModel = viewModel,
    scaffoldState = scaffoldState,
    appBarTitleResourceId = R.string.age,
    questionResourceId = R.string.whats_your_age,
    unitTextResourceId = R.string.years,
    onNavigate = onNavigate,
    onBackClick = onBackClick
)