package com.example.templateapp.sources.models

class Order constructor(
	var id: Int,
	var orderNumber: String,
	var orderDate: String,
	var orderStatusId: String,
	var orderStatus: String,
	var remarks: String,
)
{
	fun toMap(): Map<String, String>
	{
		return mapOf(
			"Order Number" to orderNumber,
			"Order Date" to orderDate,
			"Order Status" to orderStatus,
			"Remarks" to remarks,
		)
	}
}