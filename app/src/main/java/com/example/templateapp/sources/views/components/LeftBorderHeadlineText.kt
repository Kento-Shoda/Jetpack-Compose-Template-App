package com.example.templateapp.sources.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LeftBorderHeadlineText(
	text: String,
	borderColor: Color,
	textColor: Color = Color.Black,
)
{
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
		Text(
			text = text,
			color = textColor,
			fontSize = 18.sp,
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(start = 12.dp, top = 3.dp, bottom = 3.dp),
		)
	}
}

@Preview(showBackground = true)
@Composable
fun BorderHeadlineTextSamplePreview()
{
	LeftBorderHeadlineText(
		text = "Headline Text",
		borderColor = Color.Red,
		textColor = Color.Black,
	)
}