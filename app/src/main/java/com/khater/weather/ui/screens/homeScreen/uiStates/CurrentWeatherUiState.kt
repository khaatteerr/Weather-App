package com.khater.weather.ui.screens.homeScreen.uiStates

import com.khater.weather.R

data class CurrentWeatherUiState(
    val temperature: String = "20°C",
    val temperatureUnit: String = "°C",
    val weatherDescription: String = "Partly cloudy",
    val weatherCode: Int = 0,
    val minTemperature: String = "10°C",
    val maxTemperature: String = "20°C",
    val image: Int = R.drawable.night_clear_sky,
    val location: String = "Cairo",
    val windSpeed: String = "21",
    val humidity: String = "24",
    val rain: String = "2",
    val uvIndex: String = "2",
    val pressure: String = "1012",
    val feelsLike: String = "22",
)