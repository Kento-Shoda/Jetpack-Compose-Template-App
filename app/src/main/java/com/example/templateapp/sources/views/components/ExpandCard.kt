package com.example.templateapp.sources.views.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ExpandCard(
	headlineText: String,
	headlineIcon: ImageVector,
	modifier: Modifier,
	backgroundColor: Color = Color.White,
	content: @Composable () -> Unit = {}
)
{
	var isExpanded: Boolean by remember { mutableStateOf(true) }

	Card(
		onClick = { isExpanded = !isExpanded },
		modifier = modifier,
		colors = CardDefaults.cardColors(backgroundColor),
		elevation = CardDefaults.cardElevation(12.dp),
		shape = RoundedCornerShape(4.dp),
	) {
		Column(
			modifier = Modifier
				.padding(12.dp)
				.animateContentSize(
					animationSpec = spring(
						dampingRatio = Spring.DampingRatioLowBouncy,
						stiffness = Spring.StiffnessLow
					)
				),
		) {
			// Headline
			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					imageVector = headlineIcon,
					contentDescription = "Expand Card",
				)
				Text(
					text = headlineText,
					fontWeight = FontWeight.Bold,
					modifier = Modifier.weight(1f),
				)
				Icon(
					imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
					contentDescription = "Expand Card",
				)
			}

			// Expanded Content
			if (isExpanded)
			{
				content()
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun ExpandCardPreview()
{
	ExpandCard(
		headlineText = "Headline",
		headlineIcon = Icons.Default.Search,
		modifier = Modifier
			.fillMaxWidth()
			.padding(6.dp),
		content = {
			Text(
				text = "Expanded Content",
			)
		}
	)
}