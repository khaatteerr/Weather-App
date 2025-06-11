package com.khater.weather.ui.screens.homeScreen.uiStates

data class HomeUiState(
    val isLoading: Boolean = false,
    val isDay: Boolean = false,
    val error: String? = null,
    val currentWeatherUiState: CurrentWeatherUiState = CurrentWeatherUiState(),
    val todayWeatherUiState: TodayWeatherUiState = TodayWeatherUiState(),
    val weekWeatherUiState: WeeklyWeatherUiState = WeeklyWeatherUiState(),
 )
