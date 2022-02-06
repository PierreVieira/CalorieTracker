package com.example.onboarding_presentation.screens.onboarding.input_text.implementation.weight

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextScreen
import com.example.util.presentation.ui.event.NavigationUiEvent
import com.example.util.R

@ExperimentalComposeUiApi
@Composable
fun WeightScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit,
    viewModel: WeightViewModel = hiltViewModel(),
) = OnboardingInputTextScreen(
    viewModel = viewModel,
    scaffoldState = scaffoldState,
    appBarTitleResourceId = R.string.weight,
    questionResourceId = R.string.whats_your_weight,
    unitTextResourceId = R.string.kg,
    onNavigate = onNavigate,
    onBackClick = onBackClick
)