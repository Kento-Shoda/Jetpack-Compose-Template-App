package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import com.example.templateapp.sources.view_models.screens.IDetailViewModel
import com.example.templateapp.sources.view_models.screens.MockDetailViewModel
import com.example.templateapp.sources.views.components.LeftBorderCard
import com.example.templateapp.sources.views.components.LinearProgressBar
import com.example.templateapp.sources.views.components.TopBar

@Composable
fun DetailScreen(viewModel: IDetailViewModel)
{
	Column(
		modifier = Modifier
	) {
		Column(
			modifier = Modifier
				.padding(6.dp),
		) {
			// Detail content
			LeftBorderCard(
				borderColor = Color.Red,
				backgroundColor = Color.White,
			) {
				Text(
					text = "Order Id: ${viewModel.orderId}",
					fontWeight = FontWeight.Bold,
					color = Color.Black,
				)

				Text("依頼番号")
				Text("発注番号")
				Text("品目コード")
				Text("数量")

				LinearProgressBar("入荷数量", 30, 70)
			}


		}
	}
}

@Preview
@Composable
private fun DetailScreenPreview()
{
	DetailScreen(MockDetailViewModel(SavedStateHandle()))
}