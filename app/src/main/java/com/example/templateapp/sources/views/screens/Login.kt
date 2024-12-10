package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.templateapp.sources.view_models.screens.ILoginViewModel
import com.example.templateapp.sources.view_models.screens.MockLoginViewModel
import com.example.templateapp.sources.views.components.CredentialOutlinedTextField


@Composable
fun Login(viewModel: ILoginViewModel)
{
	val userId: String by viewModel.textUserId.collectAsState()
	val password: String by viewModel.textPassword.collectAsState()

	Column(
		modifier = Modifier
			.padding(24.dp)
			.fillMaxSize(),
		horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
		verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
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
}

@Preview
@Composable
fun LoginPreview()
{
	Login(MockLoginViewModel())
}