package com.example.templateapp.sources.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LeftBorderCard(
	borderColor: Color,
	backgroundColor: Color,
	cardModifier: Modifier = Modifier,
	contentPaddingValues: PaddingValues = PaddingValues(12.dp),
	onClick: () -> Unit = {},
	content: @Composable () -> Unit
)
{
	Card(
		onClick = onClick,
		colors = CardDefaults.cardColors(backgroundColor),
		elevation = CardDefaults.cardElevation(12.dp),
		shape = RoundedCornerShape(4.dp),
		modifier = cardModifier,
	) {
		Row(
			modifier = Modifier
				.height(IntrinsicSize.Min)
				.fillMaxWidth(),
		) {
			Box(
				modifier = Modifier
					.width(6.dp)
					.fillMaxHeight()
					.background(borderColor),
			)
			Column(
				modifier = Modifier.padding(contentPaddingValues),
			) {
				content()
			}
		}
	}
}

@Preview
@Composable
private fun LeftBorderCardPreview()
{
	LeftBorderCard(
		borderColor = Color.Blue,
		backgroundColor = Color.White,
		contentPaddingValues = PaddingValues(12.dp),
		cardModifier = Modifier.padding(6.dp),
	)
	{
		// content
		Text(
			text = "Hello, World!",
		)
	}
}