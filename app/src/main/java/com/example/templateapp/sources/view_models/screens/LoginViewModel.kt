package com.example.templateapp.sources.view_models.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.templateapp.sources.utilities.RouteManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class ILoginViewModel : ViewModel()
{
	protected var _textUserId: MutableStateFlow<String> = MutableStateFlow<String>("")
	var textUserId: StateFlow<String> = _textUserId.asStateFlow()

	protected var _textPassword: MutableStateFlow<String> = MutableStateFlow<String>("")
	var textPassword: StateFlow<String> = _textPassword.asStateFlow()

	abstract fun onUserIdChange(changedUserId: String)
	abstract fun onPasswordChange(changedPassword: String)
	abstract fun onUserIdClearClick()
	abstract fun onPasswordClearClick()
	abstract fun onLoginClick()
}

class MockLoginViewModel : ILoginViewModel()
{
	override fun onUserIdChange(changedUserId: String)
	{
		TODO("Not yet implemented")
	}

	override fun onPasswordChange(changedPassword: String)
	{
		TODO("Not yet implemented")
	}

	override fun onUserIdClearClick()
	{
		TODO("Not yet implemented")
	}

	override fun onPasswordClearClick()
	{
		TODO("Not yet implemented")
	}

	override fun onLoginClick()
	{
		TODO("Not yet implemented")
	}
}

@HiltViewModel(assistedFactory = LoginViewModel.Factory::class)
class LoginViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController,
) : ILoginViewModel()
{
	override fun onUserIdChange(changedUserId: String)
	{
		_textUserId.value = changedUserId
	}

	override fun onPasswordChange(changedPassword: String)
	{
		_textPassword.value = changedPassword
	}

	override fun onUserIdClearClick()
	{
		_textUserId.value = ""
	}

	override fun onPasswordClearClick()
	{
		_textPassword.value = ""
	}

	override fun onLoginClick()
	{
		viewModelScope.launch {
			Thread.sleep(3000)
			println(_textUserId.value)
			println(_textPassword.value)
		}
		toHomeScreen()
	}

	private fun toHomeScreen()
	{
		navController.navigate(RouteManager.Route.HOME.name)
	}

	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController,
		): LoginViewModel
	}
}