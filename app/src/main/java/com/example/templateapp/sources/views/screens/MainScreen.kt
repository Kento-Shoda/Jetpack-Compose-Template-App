package com.example.templateapp.sources.views.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.templateapp.sources.utilities.RouteManager
import com.example.templateapp.sources.view_models.screens.HomeViewModel
import com.example.templateapp.sources.view_models.screens.ListViewModel
import com.example.templateapp.sources.view_models.screens.LoginViewModel
import com.example.templateapp.sources.view_models.screens.MockDetailViewModel
import com.example.templateapp.sources.view_models.screens.SplashViewModel


@Composable
fun MainScreen()
{
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = RouteManager.Route.SPLASH.name
	) {
		composable(route = RouteManager.Route.SPLASH.name)
		{
			val viewModel: SplashViewModel = hiltViewModel(
				creationCallback = { factory: SplashViewModel.Factory ->
					factory.create(navController)
				}
			)
			SplashScreen(viewModel)
		}

		composable(route = RouteManager.Route.LOGIN.name)
		{
			val viewModel: LoginViewModel = hiltViewModel(
				creationCallback = { factory: LoginViewModel.Factory ->
					factory.create(
						navController = navController,
					)
				}
			)
			Login(viewModel)
		}

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

		composable(route = RouteManager.Route.DETAIL.name)
		{
			val viewModel: ListViewModel = hiltViewModel(
				creationCallback = { factory: ListViewModel.Factory ->
					factory.create(
						navController = navController
					)
				}
			)
			DetailScreen(MockDetailViewModel())
		}
	}
}