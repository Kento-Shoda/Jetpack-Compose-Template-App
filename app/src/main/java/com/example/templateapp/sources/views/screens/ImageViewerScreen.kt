package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.templateapp.R

@Composable
fun ImageViewer(
	imageResourceId: Int
)
{
	Image(
		painter = painterResource(imageResourceId),
		contentDescription = "Image",
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.Black)
			.clickable {

			},
	)
}

@Preview(showBackground = true)
@Composable
fun ImageViewerPreview()
{
	ImageViewer(R.drawable.image_home)
}