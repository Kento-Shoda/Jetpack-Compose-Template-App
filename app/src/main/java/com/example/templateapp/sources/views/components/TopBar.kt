package com.example.templateapp.sources.views.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
	title: String,
	toHomeScreen: () -> Unit = {},
	toSettingsScreen: () -> Unit = {},
	toLoginScreen: () -> Unit = {}
)
{
	TopAppBar(
		navigationIcon = {
			IconButton(
				onClick = {},
			) {
				Icon(
					imageVector = Icons.Default.ArrowBackIosNew,
					contentDescription = "More",
				)
			}
		},
		title = {
			Text(
				text = title,
				fontWeight = FontWeight.Bold,
			)
		},
		actions = { TopBarDropdownMenu() },
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primary,
		),
	)
}

@Composable
fun TopBarDropdownMenu(
	toHomeScreen: () -> Unit = {},
	toSettingsScreen: () -> Unit = {},
	toLoginScreen: () -> Unit = {}
)
{
	var isExpanded: Boolean by remember { mutableStateOf(false) }

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
				text = { Text("Home") },
				onClick = {
					isExpanded = false
					toHomeScreen()
				}
			)
			DropdownMenuItem(
				text = { Text("Settings") },
				onClick = {
					isExpanded = false
					toSettingsScreen()
				}
			)
			DropdownMenuItem(
				text = { Text("Logout") },
				onClick = {
					isExpanded = false
					toLoginScreen()
				}
			)
		}
	}
}

@Preview
@Composable
private fun TopBarPreview()
{
	TopBar(
		title = "Title",
	)
}