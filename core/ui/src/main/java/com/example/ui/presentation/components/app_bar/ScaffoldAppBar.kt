package com.example.ui.presentation.components.app_bar

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun ScaffoldAppBar(
    @StringRes titleId: Int,
    onBackClick: (() -> Unit)? = null
) {
    TopAppBar {
        onBackClick?.also {
            IconButton(onClick = it) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back to previous screen"
                )
            }
        }
        Text(
            text = stringResource(id = titleId),
            style = MaterialTheme.typography.h2
        )
    }
}