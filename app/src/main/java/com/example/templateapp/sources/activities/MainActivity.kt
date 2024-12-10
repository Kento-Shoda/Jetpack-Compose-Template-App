package com.example.templateapp.sources.activities

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.templateapp.sources.views.screens.MainScreen
import com.example.templateapp.ui.theme.TemplateAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoreApplication : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			TemplateAppTheme {
				MainScreen()
			}
		}
	}
}