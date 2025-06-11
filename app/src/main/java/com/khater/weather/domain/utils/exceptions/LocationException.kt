package com.khater.weather.domain.utils.exceptions

open class LocationException(message: String) : WeatherExceptions(message) {
    class InvalidLocationDataException(message: String) : LocationException(message)
    class LocationNetworkException(message: String) : LocationException(message)
    class LocationApiException(message: String) : LocationException(message)
}