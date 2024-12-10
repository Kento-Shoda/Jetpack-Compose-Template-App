package com.example.templateapp.sources.view_models.screens

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.templateapp.sources.utilities.RouteManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


abstract class ISplashViewModel : ViewModel()
{
	abstract var application: Application
	abstract val versionName: String

	protected val _isVersionChecking: MutableStateFlow<Boolean> = MutableStateFlow(false)
	val isVersionChecking: StateFlow<Boolean> = _isVersionChecking.asStateFlow()

	abstract fun toLoginScreen()
}

class MockSplashViewModel : ISplashViewModel()
{
	override var application: Application = Application()
	override val versionName: String = "1.0.0"

	override fun toLoginScreen()
	{
	}
}

@HiltViewModel(assistedFactory = SplashViewModel.Factory::class)
class SplashViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController,
) : ISplashViewModel()
{
	override var application: Application = navController.context.applicationContext as Application
	override val versionName: String =
		application.packageManager.getPackageInfo(application.packageName, 0).versionName.toString()

	override fun toLoginScreen()
	{
		GlobalScope.launch {
			withContext(Dispatchers.Default) {
				_isVersionChecking.value = true
				// TODO: Check version
				Thread.sleep(3000)
				_isVersionChecking.value = false
			}
			withContext(Dispatchers.Main) {
				navController.navigate(RouteManager.Route.LOGIN.name)
			}
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