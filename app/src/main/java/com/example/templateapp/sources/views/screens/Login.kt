package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.templateapp.sources.view_models.screens.ILoginViewModel
import com.example.templateapp.sources.view_models.screens.MockLoginViewModel
import com.example.templateapp.sources.views.components.CredentialOutlinedTextField
import com.example.templateapp.ui.theme.TemplateAppTheme


@Composable
fun Login(viewModel: ILoginViewModel)
{
	val userId: String by viewModel.textUserId.collectAsState()
	val password: String by viewModel.textPassword.collectAsState()
	val isAuthenticating: Boolean by viewModel.isAuthenticating.collectAsState()

	Column(
		modifier = Modifier
			.padding(24.dp)
			.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
	) {
		Box(
			modifier = Modifier.weight(1f),
			contentAlignment = Alignment.BottomCenter,
		) {
			Text(
				text = "Application Name",
				fontWeight = FontWeight.Bold,
				fontSize = 24.sp,
			)
		}

		Column(
			modifier = Modifier.weight(1f),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
		) {
			CredentialOutlinedTextField(
				text = userId,
				placeholder = "User ID",
				isPassword = false,
				onValueChange = { viewModel.onUserIdChange(it) },
				onClearClick = { viewModel.onUserIdClearClick() },
			)
			Spacer(modifier = Modifier.padding(12.dp))
			CredentialOutlinedTextField(
				text = password,
				placeholder = "Password",
				isPassword = true,
				onValueChange = { viewModel.onPasswordChange(it) },
				onClearClick = { viewModel.onPasswordClearClick() },
			)
			Spacer(modifier = Modifier.padding(24.dp))
			Button(
				onClick = { viewModel.onLoginClick() },
				modifier = Modifier.fillMaxWidth(),
			) {
				Text(
					text = "Login",
				)
			}
		}

		Box(
			modifier = Modifier.weight(1f),
			contentAlignment = Alignment.Center,
		) {
			if (isAuthenticating)
			{
				CircularProgressIndicator()
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun LoginPreview()
{
	TemplateAppTheme {
		Login(MockLoginViewModel())
	}
}