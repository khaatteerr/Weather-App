package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import com.khater.weather.ui.screens.homeScreen.uiStates.HourlyWeatherUiState
import com.khater.weather.ui.theme.WeatherTheme

@Composable
fun TodaySection(modifier: Modifier = Modifier, hourlyWeather:List<HourlyWeatherUiState>,isDay:Boolean = false) {
    val rowScrollState = rememberScrollState()

    SectionLabel(
        text = "Today",
        modifier = Modifier.padding(horizontal = WeatherTheme.size.medium))
    VerticalSpacer(height = WeatherTheme.size.large)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rowScrollState)
            .padding(horizontal = WeatherTheme.size.medium),
        horizontalArrangement = Arrangement.spacedBy(WeatherTheme.size.medium),

        ) {
        hourlyWeather.forEach {
            key(it.time) { // Add key for better recomposition
                TodayWeatherItem(hourlyWeatherUiState = it, isDay = isDay)
            }
        }

    }
}