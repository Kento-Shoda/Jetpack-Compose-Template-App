package com.example.templateapp.sources.views.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun LeftHeaderTable(data: Map<String, String>)
{
	val headers = data.keys.toList()
	val values = data.values.toList()

	Row(
		modifier = Modifier.fillMaxWidth()
	) {
		TableHeaderColumn(headers)
		TableDividerColumn(headers.size)
		TableDataColumn(values)
	}
}

@Composable
fun TableHeader(columnName: String)
{
	Text(
		text = columnName,
		fontWeight = FontWeight.Bold,
	)
}

@Composable
fun TableData(columnData: String)
{
	Text(
		text = columnData,
	)
}

@Composable
fun TableHeaderColumn(rowData: List<String>)
{
	Column(
	) {
		for (item in rowData)
		{
			TableHeader(item)
		}
	}
}

@Composable
fun TableDividerColumn(count: Int)
{
	Column(
	) {
		for (i in 0 until count)
		{
			Text(" : ")
		}
	}
}

@Composable
fun TableDataColumn(rowData: List<String>)
{
	Column(
	) {
		for (item in rowData)
		{
			TableData(item)
		}
	}
}

@Preview
@Composable
fun LeftHeaderTablePreview()
{
	val data: MutableMap<String, String> = mutableMapOf()
	for (i in 0..15)
	{
		data += Pair("Header $i", "Data $i")
	}
	LeftHeaderTable(data)
}