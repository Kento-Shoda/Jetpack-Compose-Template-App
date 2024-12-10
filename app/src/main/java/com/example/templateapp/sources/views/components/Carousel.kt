package com.example.templateapp.sources.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Carousel(
	contents: List<@Composable () -> Unit>,
	modifier: Modifier = Modifier
)
{
	if (contents.isEmpty())
	{
		Text(
			text = "No content",
			modifier = Modifier.fillMaxWidth(),
			textAlign = TextAlign.Center)
	}
	else
	{
		val state = rememberPagerState { contents.size }
		Column {
			HorizontalPager(
				state = state,
				modifier = modifier,
			) { index: Int ->
				contents[index]()
			}
			Row(
				Modifier
					.wrapContentHeight()
					.fillMaxWidth()
					.padding(bottom = 8.dp),
				horizontalArrangement = Arrangement.Center
			) {
				repeat(state.pageCount) { iteration ->
					val color = if (state.currentPage == iteration) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer
					Box(
						modifier = Modifier
							.padding(2.dp)
							.clip(CircleShape)
							.background(color)
							.size(6.dp)
					)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CarouselPreview()
{
	Column {
		Carousel(
			contents = listOf(
				{
					Text("Page 1")
				},
				{
					Text("Page 2")
				},
				{
					Text("Page 3")
				},
			)
		)
		Carousel(
			contents = emptyList()
		)
	}
}