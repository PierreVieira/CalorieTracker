package com.example.onboarding_presentation.screens.onboarding.input_text.base.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ui.presentation.components.spacers.HorizontalSpacer
import com.example.ui.presentation.theme.CalorieTrackerTheme
import com.example.ui.presentation.theme.LocalSpacing
import com.example.util.R

@Composable
fun InvalidValuesDialog(
    @StringRes title: Int,
    @StringRes message: Int,
    @StringRes buttonText: Int,
    checkBoxIsChecked: Boolean,
    onCheckChange: () -> Unit,
    onDismissRequest: () -> Unit,
    buttonClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = stringResource(id = title),
                fontSize = 16.sp
            )
        },
        text = {
            Column {
                Text(
                    text = stringResource(id = message),
                    fontSize = 14.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = checkBoxIsChecked, onCheckedChange = { onCheckChange() })
                    HorizontalSpacer(LocalSpacing.current.extraSmall)
                    Text(
                        text = stringResource(id = R.string.keep_value_informed),
                        fontSize = 12.sp
                    )
                }
            }
        },
        buttons = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = buttonClick
            ) {
                Text(text = stringResource(id = buttonText))
            }
        }
    )
}

@Composable
@Preview
fun InvalidValuesDialogCheckedPreview() {
    CalorieTrackerTheme {
        InvalidValuesDialog(
            title = R.string.high_height,
            message = R.string.high_height_message,
            buttonText = R.string.next,
            checkBoxIsChecked = true,
            onCheckChange = {},
            onDismissRequest = {},
            buttonClick = {}
        )
    }
}