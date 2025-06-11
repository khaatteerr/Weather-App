package com.khater.weather.ui.screens.homeScreen.uiStates

data class WeeklyWeatherUiState(
    val dailyForecast: List<DailyForecast> = emptyList()
)