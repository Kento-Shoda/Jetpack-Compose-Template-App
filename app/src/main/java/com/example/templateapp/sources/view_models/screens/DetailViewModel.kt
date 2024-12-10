package com.example.templateapp.sources.view_models.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

abstract class IDetailViewModel constructor(savedStateHandle: SavedStateHandle): ViewModel()
{
	abstract val orderId: Int
}

class MockDetailViewModel constructor(
	savedStateHandle: SavedStateHandle
): IDetailViewModel(savedStateHandle)
{
	override val orderId: Int = 0
}

@HiltViewModel(assistedFactory = DetailViewModel.Factory::class)
class DetailViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController,
	@set: Inject var savedStateHandle: SavedStateHandle,
): IDetailViewModel(savedStateHandle)
{
	override val orderId = checkNotNull<Int>(savedStateHandle["orderId"])

	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController
		): DetailViewModel
	}
}