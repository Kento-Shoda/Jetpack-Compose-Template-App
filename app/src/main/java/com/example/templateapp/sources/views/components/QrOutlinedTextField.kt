package com.example.templateapp.sources.views.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun QrOutlinedTextField(
	text: String,
	placeholder: String = "",
	modifier: Modifier = Modifier,
	onValueChange: (String) -> Unit,
)
{
	OutlinedTextField(
		value = text,
		onValueChange = { onValueChange(it) },
		placeholder = { Text(text = placeholder) },
		singleLine = true,
		leadingIcon = {
			IconButton(
				onClick = {},
			) {
				Icon(
					imageVector = Icons.Default.QrCode,
					contentDescription = "QrCode",
				)
			}
		},
		trailingIcon = {
			IconButton(
				onClick = {},
			) {
				Icon(
					imageVector = Icons.Default.Clear,
					contentDescription = "Clear",
				)
			}
		},
		modifier = modifier,
	)
}

@Preview
@Composable
fun QrOutlinedTextFieldPreview()
{
	QrOutlinedTextField(
		text = "",
		placeholder = "Placeholder",
		onValueChange = {},
	)
}