package com.example.templateapp.sources.view_models.screens

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

abstract class ILoginViewModel : ViewModel()
{
	protected val _textUserId: MutableStateFlow<String> = MutableStateFlow<String>("")
	val textUserId: StateFlow<String> = _textUserId.asStateFlow()

	protected val _textPassword: MutableStateFlow<String> = MutableStateFlow<String>("")
	val textPassword: StateFlow<String> = _textPassword.asStateFlow()

	protected var _isAuthenticating: MutableStateFlow<Boolean> = MutableStateFlow(false)
	val isAuthenticating: StateFlow<Boolean> = _isAuthenticating.asStateFlow()

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
		if(_isAuthenticating.value){
			return
		}

		GlobalScope.launch {
			withContext(Dispatchers.Default) {
				_isAuthenticating.value = true
				Thread.sleep(3000)
				_isAuthenticating.value = false
			}
			withContext(Dispatchers.Main) {
				toHomeScreen()
			}
		}
	}

	private fun toHomeScreen()
	{
		navController.navigate(RouteManager.Route.AUTHORIZED.name)
	}

	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController,
		): LoginViewModel
	}
}