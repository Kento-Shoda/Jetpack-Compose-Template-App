package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.templateapp.R
import com.example.templateapp.sources.view_models.screens.ISplashViewModel
import com.example.templateapp.sources.view_models.screens.MockSplashViewModel
import com.example.templateapp.ui.theme.TemplateAppTheme


@Composable
fun SplashScreen(viewModel: ISplashViewModel)
{
	val isVersionChecking by viewModel.isVersionChecking.collectAsState()

	val backgroundColor = MaterialTheme.colorScheme.primary
	val textColor = MaterialTheme.colorScheme.onPrimary

	LaunchedEffect(Unit) {
		viewModel.toLoginScreen()
	}

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(backgroundColor),
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
				color = textColor,
				fontSize = 32.sp,
				fontWeight = FontWeight.Bold,
				style = TextStyle(
					brush = ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.image_home))),
				)
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
			) {
				if (isVersionChecking)
				{
					CircularProgressIndicator(
						color = MaterialTheme.colorScheme.primaryContainer,
						trackColor = MaterialTheme.colorScheme.onPrimaryContainer,
					)
				}
			}
			Box(
				modifier = Modifier.weight(1f),
				contentAlignment = Alignment.Center,
			) {
				Text(
					text = "version ${viewModel.versionName}",
					color = textColor,
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview()
{
	TemplateAppTheme {
		SplashScreen(MockSplashViewModel())
	}
}