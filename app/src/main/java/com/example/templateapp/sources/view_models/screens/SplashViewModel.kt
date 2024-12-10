package com.example.templateapp.sources.view_models.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.templateapp.sources.utilities.RouteManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch


abstract class ISplashViewModel : ViewModel()
{
	abstract fun toLoginScreen()
}

class MockSplashViewModel : ISplashViewModel()
{
	override fun toLoginScreen()
	{
	}
}

@HiltViewModel(assistedFactory = SplashViewModel.Factory::class)
class SplashViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController
) : ISplashViewModel()
{
	override fun toLoginScreen()
	{
		viewModelScope.launch {
			Thread.sleep(3000)
			navController.navigate(RouteManager.Route.LOGIN.name)
		}
	}

	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController
		): SplashViewModel
	}
}