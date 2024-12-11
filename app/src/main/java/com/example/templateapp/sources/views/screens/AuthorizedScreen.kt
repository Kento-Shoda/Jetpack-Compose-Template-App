package com.example.templateapp.sources.views.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.templateapp.sources.utilities.RouteManager
import com.example.templateapp.sources.view_models.screens.DetailViewModel
import com.example.templateapp.sources.view_models.screens.HomeViewModel
import com.example.templateapp.sources.view_models.screens.ListViewModel
import com.example.templateapp.sources.view_models.screens.MockDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizedScreen(mainScreenNavController: NavHostController)
{
	val navController = rememberNavController()

	val currentBackStack by navController.currentBackStackEntryAsState()
	var isHome: Boolean = currentBackStack?.destination?.route.equals(RouteManager.Route.HOME.name)

	var isAsyncProcessing: Boolean by remember { mutableStateOf(false) }

	var isExpanded: Boolean by remember { mutableStateOf(false) }

	var routeName: String? =
		if (currentBackStack?.destination?.route == null) "" else currentBackStack?.destination?.route

	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					routeName?.let {
						val routeNameRoot = it.split("/").first()
						Text(
							text = when (routeNameRoot)
							{
								RouteManager.Route.HOME.name -> "Home"
								RouteManager.Route.LIST.name -> "List"
								RouteManager.Route.DETAIL.name -> "Detail"
								else -> "Navigation Error"
							},
							fontWeight = FontWeight.Bold,
						)
					}
				},
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary,
				),
				navigationIcon = {
					if (!isHome)
					{
						IconButton(
							onClick = {
								navController.popBackStack()
							},
						) {
							Icon(
								imageVector = Icons.Default.ArrowBackIosNew,
								contentDescription = "Back",
							)
						}
					}
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
							if (!isHome)
							{
								DropdownMenuItem(
									text = { Text("home") },
									onClick = {
										isExpanded = false
										navController.popBackStack(
											route = RouteManager.Route.HOME.name,
											inclusive = false,
										)
									}
								)
							}

							DropdownMenuItem(
								text = { Text("Settings") },
								onClick = {
									isExpanded = false
								}
							)

							DropdownMenuItem(
								text = { Text("logout") },
								onClick = {
									isExpanded = false
									mainScreenNavController.navigateUp()
								}
							)
						}
					}
				}
			)
		},
	) { innerPadding ->
		NavHost(
			navController = navController,
			startDestination = RouteManager.Route.HOME.name,
			modifier = Modifier.padding(innerPadding),
		) {
			composable(route = RouteManager.Route.HOME.name)
			{
				val viewModel: HomeViewModel = hiltViewModel(
					creationCallback = { factory: HomeViewModel.Factory ->
						factory.create(
							navController = navController
						)
					}
				)
				Home(viewModel)
			}

			composable(route = RouteManager.Route.LIST.name)
			{
				val viewModel: ListViewModel = hiltViewModel(
					creationCallback = { factory: ListViewModel.Factory ->
						factory.create(
							navController = navController
						)
					}
				)
				ListScreen(viewModel)
			}

			composable(
				route = "${RouteManager.Route.DETAIL.name}/{orderId}",
				arguments = listOf(navArgument("orderId") { type = NavType.IntType })
			)
			{
				val viewModel: DetailViewModel = hiltViewModel(
					creationCallback = { factory: DetailViewModel.Factory ->
						factory.create(
							navController = navController
						)
					}
				)
				DetailScreen(viewModel)
			}
		}
	}
}