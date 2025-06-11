package com.khater.weather.ui.screens.homeScreen.uiStates

data class DailyForecast(
    val dayName: String,
    val weatherIcon: Int,
    val highTemp: String,
    val lowTemp: String
)