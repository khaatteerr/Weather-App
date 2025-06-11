package com.khater.weather.domain.entities.weatherEntity

data class HourlyWeather(
    val time: List<String>,
    val temperature: List<Double>,
    val weatherCode: List<Int>,
    val isDay: List<Int>,
)