package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.templateapp.R
import com.example.templateapp.sources.view_models.screens.IHomeViewModel
import com.example.templateapp.sources.view_models.screens.MockHomeViewModel
import com.example.templateapp.sources.views.components.LeftBorderCard
import com.example.templateapp.sources.views.components.LeftBorderHeadlineText
import com.example.templateapp.sources.views.components.LeftHeaderTable
import com.example.templateapp.sources.views.components.LinearProgressBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun Home(viewModel: IHomeViewModel)
{
	val contentSpaceDp = 12.dp
	val cardContentPaddingDp = 12.dp

	var isAsyncTask by remember { mutableStateOf(false) }

	Scaffold(
		topBar = { HomeTopBar(isAsyncTask, { viewModel.toLoginScreen() }) },
		floatingActionButton = { SettingFloatingActionButton() },
	) { innerPadding ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(innerPadding)
				.verticalScroll(rememberScrollState()),
			verticalArrangement = Arrangement.spacedBy(contentSpaceDp),
		) {
			HomeImage()
			Column(
				modifier = Modifier
					.fillMaxSize()
					.padding(6.dp),
				verticalArrangement = Arrangement.spacedBy(contentSpaceDp),
			) {
				Button(
					onClick = {
						GlobalScope.launch {
							withContext(Dispatchers.IO) {
								isAsyncTask = true
								Thread.sleep(3000)
								isAsyncTask = false
							}
						}
					},
					modifier = Modifier.fillMaxWidth(),
				) {
					Text(
						text = "Toggle Async Task",
					)
				}

				Button(
					onClick = { viewModel.toListScreen() },
					modifier = Modifier.fillMaxWidth(),
				) {
					Text(
						text = "To List Screen",
					)
				}

				LeftBorderCard(
					borderColor = Color.Red,
					backgroundColor = Color.White,
					contentPaddingValues = PaddingValues(cardContentPaddingDp),
				) {
					val data: MutableMap<String, String> = mutableMapOf()
					for (i in 0..5)
					{
						data += Pair("Header $i", "Data $i")
					}
					LeftHeaderTable(data)
					LinearProgressBar("Linear Progress Bar", 25, 100)
				}

				LeftBorderHeadlineText(
					text = "入荷",
					borderColor = Color.Red,
					textColor = Color.Black,
				)
				FunctionButtons()
				LeftBorderHeadlineText(
					text = "出荷",
					borderColor = Color.Red,
					textColor = Color.Black,
				)
				FunctionButtons()
				FunctionButtons()
				FunctionButtons()
				LeftBorderHeadlineText(
					text = "在庫管理",
					borderColor = Color.Red,
					textColor = Color.Black,
				)
				FunctionButtons()
				FunctionButtons()

				Spacer(modifier = Modifier.padding(48.dp))
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(isAsyncTask: Boolean, toLoginScreen: () -> Unit)
{
	var isExpanded by remember { mutableStateOf(false) }
	Column {
		TopAppBar(
			colors = TopAppBarDefaults.topAppBarColors(
				containerColor = MaterialTheme.colorScheme.primaryContainer,
				titleContentColor = MaterialTheme.colorScheme.primary,
			),
			title = {
				Text(
					text = "Home",
					fontStyle = FontStyle.Italic,
					fontWeight = FontWeight.Bold,
				)
			},
			actions = {
				IconButton(onClick = { isExpanded = !isExpanded }) {
					Icon(
						imageVector = Icons.Default.MoreVert,
						contentDescription = "More",
					)
					DropdownMenu(
						expanded = isExpanded,
						onDismissRequest = { isExpanded = false }
					) {
						DropdownMenuItem(
							text = { Text("home") },
							onClick = {
								isExpanded = false
							}
						)
						DropdownMenuItem(
							text = { Text("Settings") },
							onClick = {
								isExpanded = false
							}
						)
						DropdownMenuItem(
							text = { Text("logout") },
							onClick = {
								toLoginScreen()
								isExpanded = false
							}
						)
					}
				}
			}
		)
		if (isAsyncTask)
		{
			LinearProgressIndicator(
				modifier = Modifier.fillMaxWidth(),
				color = MaterialTheme.colorScheme.primary,
			)
		}
	}
}

@Preview
@Composable
fun HomeImage()
{
	Box(
		modifier = Modifier
			.height(150.dp)
			.fillMaxWidth(),
		contentAlignment = Alignment.Center
	) {
		Image(
			painter = painterResource(id = R.drawable.image_home),
			contentDescription = "Home Image",
			contentScale = ContentScale.Crop,
		)
		Text(
			text = "Application Name",
			fontWeight = FontWeight.Bold,
			fontStyle = FontStyle.Italic,
			color = Color(0xAAAAAAAA),
			fontSize = 24.sp,
		)
	}
}

@Preview
@Composable
fun FunctionButton()
{
	Button(
		onClick = { },
		modifier = Modifier
			.width(100.dp)
			.height(100.dp),
		shape = RoundedCornerShape(4.dp),
		elevation = ButtonDefaults.buttonElevation(12.dp),
	) {
		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.spacedBy(12.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Icon(
				imageVector = Icons.Filled.Settings,
				contentDescription = "Settings",
				modifier = Modifier.size(48.dp),
			)
			Text(text = "Button")
		}
	}
}

@Preview
@Composable
fun FunctionButtons()
{
	Row(
		modifier = Modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceEvenly,
	) {
		FunctionButton()
		FunctionButton()
		FunctionButton()
	}
}

@Preview
@Composable
fun SettingFloatingActionButton()
{
	FloatingActionButton(
		onClick = { },
		shape = CircleShape,
	) {
		Icon(Icons.Filled.Settings, contentDescription = "Settings")
	}
}

@Preview
@Composable
fun HomePreview()
{
	Home(MockHomeViewModel())
}