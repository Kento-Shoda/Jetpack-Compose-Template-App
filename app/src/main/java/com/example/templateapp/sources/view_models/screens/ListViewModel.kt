package com.example.templateapp.sources.view_models.screens

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel


abstract class IListViewModel : ViewModel()
{
	abstract fun toDetailScreen()
}

class MockListViewModel : IListViewModel()
{
	override fun toDetailScreen()
	{
		TODO("Not yet implemented")
	}
}

@HiltViewModel(assistedFactory = ListViewModel.Factory::class)
class ListViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController
) : IListViewModel()
{
	override fun toDetailScreen()
	{
		navController.navigate("Detail")
	}

	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController
		): ListViewModel
	}
}