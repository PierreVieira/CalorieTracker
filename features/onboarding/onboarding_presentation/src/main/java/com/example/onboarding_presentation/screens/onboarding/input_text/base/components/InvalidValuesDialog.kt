package com.example.onboarding_presentation.screens.onboarding.input_text.base.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.presentation.theme.CalorieTrackerTheme
import com.example.util.R

@Composable
fun InvalidValuesDialog(
    @StringRes title: Int,
    @StringRes message: Int,
    @StringRes changeMessage: Int,
    checkBoxIsChecked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    okClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(text = stringResource(id = title))
        },
        text = {
            Column {
                Text(text = stringResource(id = message))
                Row {
                    Text(text = stringResource(id = R.string.keep_value_informed))
                    Checkbox(checked = checkBoxIsChecked, onCheckedChange = onCheckChange)
                }
            }
        },
        buttons = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = okClick
            ) {
                Text(text = stringResource(id = if (checkBoxIsChecked) changeMessage else R.string.next))
            }
        }
    )
}

@Composable
@Preview
fun InvalidValuesDialogUnCheckedPreview() {
    CalorieTrackerTheme {
        InvalidValuesDialog(
            title = R.string.high_height,
            message = R.string.high_height_message,
            changeMessage = R.string.change_height,
            checkBoxIsChecked = false,
            onCheckChange = {},
            okClick = {}
        )
    }
}

@Composable
@Preview
fun InvalidValuesDialogCheckedPreview() {
    CalorieTrackerTheme {
        InvalidValuesDialog(
            title = R.string.high_height,
            message = R.string.high_height_message,
            changeMessage = R.string.change_height,
            checkBoxIsChecked = true,
            onCheckChange = {},
            okClick = {}
        )
    }
}