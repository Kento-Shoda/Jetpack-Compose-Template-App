package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import com.example.templateapp.R
import com.example.templateapp.sources.view_models.screens.IDetailViewModel
import com.example.templateapp.sources.view_models.screens.MockDetailViewModel
import com.example.templateapp.sources.views.components.ImageUpload
import com.example.templateapp.sources.views.components.LeftBorderCard
import com.example.templateapp.sources.views.components.LinearProgressBar
import com.example.templateapp.sources.views.components.QrOutlinedTextField
import com.example.templateapp.ui.theme.TemplateAppTheme

@Composable
fun DetailScreen(viewModel: IDetailViewModel)
{
	Column(
		modifier = Modifier.fillMaxSize(),
	) {
		Column(
			modifier = Modifier
				.padding(6.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(12.dp),
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

			QrOutlinedTextField(
				text = "",
				placeholder = "IDを入力してください",
				modifier = Modifier.fillMaxWidth(),
				onValueChange = {
					//viewModel.onValueChange(it)
				},
			)

			Card(
				elevation = CardDefaults.elevatedCardElevation(12.dp),
			) {
				ImageUpload(painter = painterResource(R.drawable.image_home))
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview()
{
	TemplateAppTheme {
		DetailScreen(MockDetailViewModel(SavedStateHandle()))
	}
}