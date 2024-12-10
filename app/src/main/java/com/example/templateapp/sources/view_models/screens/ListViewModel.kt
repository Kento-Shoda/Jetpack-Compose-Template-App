package com.example.templateapp.sources.view_models.screens

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.example.templateapp.sources.models.Order
import com.example.templateapp.sources.utilities.RouteManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel


abstract class IListViewModel : ViewModel()
{
	abstract var orders: List<Order>
	abstract fun toDetailScreen(orderId: Int)
}

class MockListViewModel : IListViewModel()
{
	override var orders: List<Order> = listOf(
		Order(0, "Order1", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(1, "Order2", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(2, "Order3", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(3, "Order4", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(4, "Order5", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(5, "Order6", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(6, "Order7", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(7, "Order8", "2024/01/01 12:34:56", "10", "Status", "備考"),
	)

	override fun toDetailScreen(orderId: Int)
	{
		TODO("Not yet implemented")
	}
}

@HiltViewModel(assistedFactory = ListViewModel.Factory::class)
class ListViewModel @AssistedInject constructor(
	@Assisted private val navController: NavController
) : IListViewModel()
{
	override var orders: List<Order> = listOf(
		Order(0, "Order1", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(1, "Order2", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(2, "Order3", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(3, "Order4", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(4, "Order5", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(5, "Order6", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(6, "Order7", "2024/01/01 12:34:56", "10", "Status", "備考"),
		Order(7, "Order8", "2024/01/01 12:34:56", "10", "Status", "備考"),
	)

	override fun toDetailScreen(orderId: Int)
	{
		navController.navigate(
			route = "${RouteManager.Route.DETAIL.name}/${orderId}",
		)
	}

	@AssistedFactory
	interface Factory
	{
		fun create(
			@Assisted navController: NavController
		): ListViewModel
	}
}