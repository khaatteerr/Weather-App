package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khater.weather.ui.theme.WeatherTheme

@Composable
fun SectionLabel(modifier: Modifier = Modifier,text: String) {
    Text(
        text = text,
        style = WeatherTheme.typography.body,
        color = WeatherTheme.colors.onBackground,
        modifier = modifier
    )
}