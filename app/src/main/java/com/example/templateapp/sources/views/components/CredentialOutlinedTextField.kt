package com.example.templateapp.sources.views.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CredentialOutlinedTextField(
	text: String,
	placeholder: String = "",
	isPassword: Boolean = false,
	onValueChange: (String) -> Unit,
	onClearClick: () -> Unit,
)
{
	OutlinedTextField(
		value = text,
		onValueChange = onValueChange,
		placeholder = { Text(text = placeholder) },
		singleLine = true,
		visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
		keyboardOptions = KeyboardOptions(
			keyboardType = KeyboardType.Password,
			imeAction = ImeAction.Done,
		),
		trailingIcon = {
			IconButton(
				onClick = onClearClick,
			) {
				Icon(
					imageVector = Icons.Default.Clear,
					contentDescription = "Clear",
				)
			}
		},
		modifier = Modifier.fillMaxWidth(),
	)
}

@Preview
@Composable
fun CredentialOutlinedTextFieldPreview()
{
	CredentialOutlinedTextField(
		text = "",
		placeholder = "Placeholder",
		isPassword = false,
		onValueChange = {},
		onClearClick = {},
	)
}