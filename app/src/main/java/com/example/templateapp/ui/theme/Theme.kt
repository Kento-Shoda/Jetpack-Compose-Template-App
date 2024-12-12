package com.example.templateapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
	primary = Purple80,
	secondary = PurpleGrey80,
	tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
	primary = BsOrange,
	onPrimary = BsLight,
	primaryContainer = BsOrange200,
	onPrimaryContainer = BsLight,
	inversePrimary = BsBlue,
	secondary = BsBlue,
	onSecondary = BsLight,
	secondaryContainer = BsBlue200,
	onSecondaryContainer = BsLight,
	tertiary = BsTeal,
	onTertiary = BsDark,
	tertiaryContainer = BsTeal200,
	onTertiaryContainer = BsDark,
	background = BsLight,
	onBackground = BsDark,
	surface = BsLight,
	onSurface = BsDark,
	surfaceVariant = BsLight,
	onSurfaceVariant = BsDark,
	surfaceTint = BsLight,
	inverseSurface = BsGray900,
	inverseOnSurface = BsLight,
	error = BsDanger,
	onError = BsLight,
	errorContainer = BsDanger,
	onErrorContainer = BsLight,
	outline = BsOrange400,
	outlineVariant = BsOrange400,
	scrim = BsOrange400,
	surfaceBright = White,
	surfaceDim = BsGray500,
	surfaceContainer = BsGray,
	surfaceContainerHigh = BsGray200,
	surfaceContainerHighest = BsGray100,
	surfaceContainerLow = BsGray800,
	surfaceContainerLowest = BsGray900,

	/* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TemplateAppTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	// Dynamic color is available on Android 12+
	dynamicColor: Boolean = false,	// Changed from true
	content: @Composable () -> Unit
)
{
	val colorScheme = when
	{
		dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
		{
			val context = LocalContext.current
			if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
		}

		darkTheme -> DarkColorScheme
		else -> LightColorScheme
	}

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}