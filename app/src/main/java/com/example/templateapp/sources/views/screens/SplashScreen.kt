package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.templateapp.sources.view_models.screens.ISplashViewModel
import com.example.templateapp.sources.view_models.screens.MockSplashViewModel
import com.example.templateapp.ui.theme.BsWarning
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(viewModel: ISplashViewModel)
{
	val isVersionChecking by viewModel.isVersionChecking.collectAsState()

	LaunchedEffect(Unit) {
		viewModel.toLoginScreen()
	}

	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.weight(1f),
			contentAlignment = Alignment.Center,
		) {

		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.weight(1f),
			contentAlignment = Alignment.Center,
		) {
			Text(
				text = "Application Name",
				textAlign = TextAlign.Center,
				color = BsWarning,
			)
		}

		Column(
			modifier = Modifier
				.fillMaxWidth()
				.weight(1f),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
		) {
			Box(
				modifier = Modifier.weight(1f),
				contentAlignment = Alignment.Center,
			){
				if (isVersionChecking) {
					CircularProgressIndicator()
				}
			}
			Box(
				modifier = Modifier.weight(1f),
				contentAlignment = Alignment.Center,
			) {
				Text(
					text = "version ${viewModel.versionName}",
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview()
{
	SplashScreen(MockSplashViewModel())
}