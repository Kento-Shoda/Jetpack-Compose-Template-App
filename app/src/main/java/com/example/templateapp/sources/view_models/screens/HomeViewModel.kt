package com.example.templateapp.sources.view_models.screens

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.templateapp.sources.utilities.RouteManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

abstract class IHomeViewModel: ViewModel()
{
	abstract fun toListScreen()
	abstract fun toLoginScreen()
}

class MockHomeViewModel : IHomeViewModel()
{
	override fun toListScreen()
	{
		TODO("Not yet implemented")
	}

	override fun toLoginScreen()
	{
		TODO("Not yet implemented")
	}
}

@HiltViewModel(assistedFactory = HomeViewModel.Factory::class)
class HomeViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController
) : IHomeViewModel()
{
	override fun toListScreen(){
		navController.navigate(RouteManager.Route.LIST.name)
	}

	override fun toLoginScreen()
	{
		navController.navigate(RouteManager.Route.HOME.name)
	}

	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController
		): HomeViewModel
	}
}