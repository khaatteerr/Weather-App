package com.khater.weather.ui.screens.homeScreen.uiStates

import com.khater.weather.R

data class ExtraWeatherInfoUiState(
    val icon: Int = R.drawable.humidity ,
    val title: String = "2%",
    val description: String="Humidity",
)
