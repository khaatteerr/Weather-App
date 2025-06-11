package com.khater.weather.domain.entities.weatherEntity

data class DailyWeather(
    val temperatureMax: List<Double>,
    val temperatureMin: List<Double>,
    val time: List<String>,
    val weatherCode: List<Int>
)
