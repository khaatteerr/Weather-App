package com.khater.weather.domain.utils.exceptions

open class WeatherException(message: String) : WeatherExceptions(message) {
    class InvalidWeatherDataException(message: String) : WeatherException(message)
    class WeatherNetworkException(message: String) : WeatherException(message)
    class WeatherApiException(message: String) : WeatherException(message)
}