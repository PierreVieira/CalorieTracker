package com.example.onboarding_presentation.screens.onboarding.input_text.implementation.height

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.onboarding_presentation.screens.onboarding.input_text.base.OnboardingInputTextScreen
import com.example.util.R
import com.example.util.presentation.ui.event.NavigationUiEvent

@ExperimentalComposeUiApi
@Composable
fun HeightScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    onBackClick: (NavigationUiEvent.NavigateUp) -> Unit,
    viewModel: HeightViewModel = hiltViewModel()
) = OnboardingInputTextScreen(
    viewModel = viewModel,
    scaffoldState = scaffoldState,
    appBarTitleResourceId = R.string.height,
    questionResourceId = R.string.whats_your_height,
    unitTextResourceId = R.string.cm,
    onNavigate = onNavigate,
    onBackClick = onBackClick
)