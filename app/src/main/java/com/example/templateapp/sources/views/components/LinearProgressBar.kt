package com.example.templateapp.sources.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LinearProgressBar(title: String = "", progress: Int, max: Int)
{
	Column {
		Row(
			modifier = Modifier
				.padding(6.dp)
				.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
		) {
			Text(
				text = title,
				fontWeight = FontWeight.Bold,
				modifier = Modifier.weight(1f),
			)
			Spacer(modifier = Modifier.padding(3.dp))
			Text(
				text = "$progress / $max",
				fontWeight = FontWeight.Bold,
			)
		}
		LinearProgressIndicator(
			modifier = Modifier.fillMaxWidth(),
			progress = { progress.toFloat() / max.toFloat() },
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun LinearProgressBarPreview()
{
	LinearProgressBar(
		title = "Progress",
		progress = 50,
		max = 100,
	)
}