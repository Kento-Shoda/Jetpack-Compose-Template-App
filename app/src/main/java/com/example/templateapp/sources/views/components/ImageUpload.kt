package com.example.templateapp.sources.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.templateapp.R

@Composable
fun ImageUpload(
	painter: Painter? = null,
)
{
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.wrapContentHeight(),
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.height(300.dp)
				.padding(6.dp),
		) {
			// Image Title And Icon Buttons
			Row(
				horizontalArrangement = Arrangement.spacedBy(3.dp),
				verticalAlignment = Alignment.CenterVertically,
			) {
				Text(
					text = "Image Name",
					fontSize = 16.sp,
					fontWeight = FontWeight.Bold,
					modifier = Modifier.weight(1f),
				)
				IconButton(
					onClick = {},
				) {
					Icon(
						imageVector = Icons.Default.PhotoCamera,
						contentDescription = "PhotoCamera",
						modifier = Modifier.size(24.dp)
					)
				}
				IconButton(
					onClick = {},
				) {
					Icon(
						imageVector = Icons.Default.Folder,
						contentDescription = "Folder",
						modifier = Modifier.size(24.dp)
					)
				}
				IconButton(
					onClick = {},
				) {
					Icon(
						imageVector = Icons.Default.Delete,
						contentDescription = "Delete",
						modifier = Modifier.size(24.dp)
					)
				}
			}

			HorizontalDivider(modifier = Modifier.padding(bottom = 3.dp))

			// Image Preview
			Image(
				painter = painter ?: painterResource(id = R.drawable.no_image),
				contentDescription = "image preview",
				contentScale = ContentScale.Fit,
				modifier = Modifier
					.weight(1f)
					.fillMaxWidth()
					.clickable(
						enabled = true,
						onClick = {

						},
					),
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun ImageUploadPreview()
{
	ImageUpload()
}