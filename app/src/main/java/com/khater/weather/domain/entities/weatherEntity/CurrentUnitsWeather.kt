package com.khater.weather.domain.entities.weatherEntity

data class CurrentUnitsWeather(
    val time: String,
    val interval: String,
    val temperature: String,
    val relativeHumidity: String,
    val apparentTemperature: String,
    val precipitationProbability: String,
    val pressure: String,
    val windSpeed: String,
    val isDay: String,
    val rain: String,
    val uvIndex: String,
    val weatherCode: String,
)
