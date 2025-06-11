package com.khater.weather.domain.entities.weatherEntity

data class CurrentWeather(
    val time: String,
    val interval: Int,
    val temperature: Double,
    val relativeHumidity: Int,
    val apparentTemperature: Double,
    val precipitationProbability: Int,
    val pressure: Double,
    val windSpeed: Double,
    val isDay: Int,
    val rain: Double,
    val uvIndex: Double,
    val weatherCode: Int,
)
