package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.templateapp.sources.view_models.screens.ISplashViewModel
import com.example.templateapp.sources.view_models.screens.MockSplashViewModel

@Composable
fun SplashScreen(viewModel: ISplashViewModel)
{
	LaunchedEffect(Unit) {
		viewModel.toLoginScreen()
	}

	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = "Application Name",
		)
	}
}

@Preview
@Composable
fun SplashScreenPreview()
{
	SplashScreen(MockSplashViewModel())
}