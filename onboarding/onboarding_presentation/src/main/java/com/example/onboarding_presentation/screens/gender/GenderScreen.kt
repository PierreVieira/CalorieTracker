package com.example.onboarding_presentation.screens.gender

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.R
import com.example.core.domain.model.Gender
import com.example.core.util.NavigationEvent
import com.example.core_ui.presentation.components.spacers.HorizontalSpacer
import com.example.core_ui.presentation.components.spacers.VerticalSpacer
import com.example.core_ui.presentation.theme.LocalSpacing
import com.example.onboarding_presentation.components.buttons.ActionButton
import com.example.onboarding_presentation.screens.gender.components.GenderButton
import kotlinx.coroutines.flow.collect

@Composable
fun GenderScreen(
    onNavigate: (NavigationEvent.Navigate) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            if (uiEvent is NavigationEvent.Navigate) {
                onNavigate(uiEvent)
            }
        }
    }

    GenderScreen(
        selectedGender = uiState.selectedGender,
        onGenderClick = { viewModel.onGenderClick(it.gender) },
        onNextClick = viewModel::onNextClick
    )
}

@Composable
private fun GenderScreen(
    selectedGender: Gender,
    onGenderClick: (GenderUiEvent.SelectGender) -> Unit,
    onNextClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.large)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_gender),
                style = MaterialTheme.typography.h3
            )
            VerticalSpacer()
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
        ActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            text = stringResource(id = R.string.next),
            onClick = onNextClick
        )
    }
}