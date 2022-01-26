package com.example.onboarding_presentation.screens.base

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.core.R
import com.example.core_ui.presentation.components.app_bar.ScaffoldAppBar
import com.example.core_ui.presentation.components.spacers.VerticalSpacer
import com.example.core_ui.presentation.theme.LocalSpacing
import com.example.onboarding_presentation.components.buttons.ActionButton

@Composable
fun BaseOnboardScreen(
    @StringRes appBarTitleResource: Int,
    @StringRes questionResource: Int,
    onNextClick: () -> Unit,
    onBackClick: (() -> Unit)? = null,
    buttonsScope: @Composable () -> Unit,
) {
    val spacing = LocalSpacing.current
    Scaffold(
        topBar = {
            ScaffoldAppBar(
                titleId = appBarTitleResource,
                onBackClick = onBackClick
            )
        }
    ) {
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
                    text = stringResource(id = questionResource),
                    style = MaterialTheme.typography.h3
                )
                VerticalSpacer()
                buttonsScope()
            }
            ActionButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                text = stringResource(id = R.string.next),
                onClick = onNextClick
            )
        }
    }
}