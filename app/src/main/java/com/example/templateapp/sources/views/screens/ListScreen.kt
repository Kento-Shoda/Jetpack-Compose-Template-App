package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.templateapp.sources.models.Order
import com.example.templateapp.sources.view_models.screens.IListViewModel
import com.example.templateapp.sources.view_models.screens.MockListViewModel
import com.example.templateapp.sources.views.components.ExpandCard
import com.example.templateapp.sources.views.components.LeftBorderCard
import com.example.templateapp.sources.views.components.LeftHeaderTable

@Composable
fun ListScreen(viewModel: IListViewModel)
{
	Column(
		modifier = Modifier
	) {
		// Filtering
		ExpandCard(
			headlineText = "検索",
			headlineIcon = Icons.Default.Search,
			modifier = Modifier
				.fillMaxWidth()
				.padding(6.dp),
		) {
			Filtering({})
		}

		// List Information
		ListInformation(100, "2024/01/01 12:34:56")

		HorizontalDivider(
			modifier = Modifier.padding(1.dp),
		)

		// List
		LazyColumn(
			modifier = Modifier
				.padding(horizontal = 6.dp)
				.fillMaxWidth(),
			verticalArrangement = Arrangement.spacedBy(6.dp),
		) {
			item{
				Spacer(modifier = Modifier.padding(3.dp))
			}
			itemsIndexed(viewModel.orders) { _, order ->
				LeftBorderCard(
					borderColor = Color.Red,
					backgroundColor = Color.White,
					onClick = {viewModel.toDetailScreen(order.id)},
				) {
					LeftHeaderTable(data = order.toMap())
				}
			}
			item{
				Spacer(modifier = Modifier.padding(3.dp))
			}
		}
	}
}

@Composable
fun Filtering(toDetailScreen: () -> Unit)
{
	Column(
		modifier = Modifier
			.padding(6.dp)
			.fillMaxWidth(),
		verticalArrangement = Arrangement.spacedBy(6.dp),
	) {
		// Date Filter
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(6.dp),
			modifier = Modifier.fillMaxWidth(),
		) {
			Text(
				text = "日付",
				fontWeight = FontWeight.Bold,
			)
			Row(
				modifier = Modifier
					.padding(3.dp)
					.weight(1f)
					.border(1.dp, Color.Gray, RoundedCornerShape(4.dp)),
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					imageVector = Icons.Default.CalendarMonth,
					contentDescription = "Start Date",
					tint = Color.DarkGray,
				)
				Text(
					text = "2024/01/01",
					color = Color.DarkGray,
					fontWeight = FontWeight.Bold,
					modifier = Modifier.padding(6.dp),
				)
			}
			Text("~")
			Row(
				modifier = Modifier
					.padding(3.dp)
					.weight(1f)
					.border(1.dp, Color.Gray, RoundedCornerShape(4.dp)),
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					imageVector = Icons.Default.CalendarMonth,
					contentDescription = "End Date",
					tint = Color.DarkGray,
				)
				Text(
					text = "2024/01/01",
					color = Color.DarkGray,
					fontWeight = FontWeight.Bold,
					modifier = Modifier.padding(6.dp),
				)
			}
		}

		// Text Filter
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(6.dp),
			modifier = Modifier.fillMaxWidth(),
		) {
			Text(
				text = "Order Number",
				fontWeight = FontWeight.Bold,
			)
			OutlinedTextField(
				value = "",
				onValueChange = {},
				modifier = Modifier.fillMaxWidth(),
				leadingIcon = {
					IconButton(
						onClick = {},
					) {
						Icon(
							imageVector = Icons.Default.QrCodeScanner,
							contentDescription = "QR Code Scanner",
							tint = Color.DarkGray,
						)
					}
				},
				trailingIcon = {
					IconButton(
						onClick = {},
					) {
						Icon(
							imageVector = Icons.Default.Clear,
							contentDescription = "Clear",
							tint = Color.DarkGray,
						)
					}
				},
			)
		}

		// Submit And Reset Buttons
		Row(
			horizontalArrangement = Arrangement.spacedBy(6.dp),
			modifier = Modifier.fillMaxWidth(),
		) {
			// Submit Button
			Button(
				onClick = {},
				modifier = Modifier.weight(1f),
				shape = RoundedCornerShape(4.dp),
				colors = ButtonDefaults.buttonColors(
					containerColor = Color.Blue,
					contentColor = Color.White,
				),
			) {
				Text(
					text = "Submit",
					fontWeight = FontWeight.Bold,
				)
			}
			// Reset Button
			Button(
				onClick = { toDetailScreen() },
				modifier = Modifier.weight(1f),
				shape = RoundedCornerShape(4.dp),
				colors = ButtonDefaults.buttonColors(
					containerColor = Color.Red,
					contentColor = Color.White,
				),
			) {
				Text(
					text = "Reset",
					fontWeight = FontWeight.Bold,
				)
			}
		}
	}
}

@Composable
fun ListInformation(count: Int, dateTime: String)
{
	Row(
		modifier = Modifier
			.padding(6.dp)
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
	) {
		Text(
			text = "取得件数: $count 件",
		)
		Text(
			text = "取得日時: $dateTime",
		)
	}
}

@Preview(showBackground = true)
@Composable
fun DatePicker()
{
	Box(
		modifier = Modifier
			.border(1.dp, Color.Gray, RoundedCornerShape(4.dp)),
	) {
		Text(
			text = "2024/01/01",
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(6.dp),
		)
	}
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview()
{
	ListScreen(MockListViewModel())
}