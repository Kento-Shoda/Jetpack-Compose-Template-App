package com.example.templateapp.sources.view_models.screens

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

abstract class IDetailViewModel: ViewModel()
{
}

class MockDetailViewModel: IDetailViewModel()
{
}

@HiltViewModel(assistedFactory = DetailViewModel.Factory::class)
class DetailViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController
): IDetailViewModel()
{
	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController
		): DetailViewModel
	}
}