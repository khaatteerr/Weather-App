package com.khater.weather.ui.screens.homeScreen.uiStates

data class TodayWeatherUiState(
    val hourlyItems: List<HourlyWeatherUiState> = emptyList()
)