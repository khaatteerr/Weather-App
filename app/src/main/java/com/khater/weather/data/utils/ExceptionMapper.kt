package com.khater.weather.data.utils

import com.khater.weather.domain.utils.exceptions.LocationException
import com.khater.weather.domain.utils.exceptions.WeatherException

fun Throwable.toWeatherException(): WeatherException {
    return when (val exceptions = this) {

        is NetworkException.SerializationException ->
            WeatherException.InvalidWeatherDataException(exceptions.message.toString())

        is NetworkException.TooManyRequestsException -> WeatherException.WeatherApiException(
            exceptions.message.toString()
        )

        is NetworkException.ServerErrorException -> WeatherException.WeatherApiException(exceptions.message.toString())


        is NetworkException.RequestTimeoutException -> WeatherException.WeatherNetworkException(
            exceptions.message.toString()
        )

        is NetworkException.UnknownNetworkException -> WeatherException.WeatherNetworkException(
            exceptions.message.toString()
        )

        is NetworkException.NoInternetConnectionException -> WeatherException.WeatherNetworkException(
            exceptions.message.toString()
        )

        else -> WeatherException.WeatherApiException(exceptions.message.toString())
    }
}


fun Throwable.toLocationExceptions(): LocationException {
    return when (val exceptions = this) {

        is NetworkException.SerializationException ->
            LocationException.InvalidLocationDataException(exceptions.message.toString())

        is NetworkException.TooManyRequestsException -> LocationException.LocationApiException(
            exceptions.message.toString()
        )

        is NetworkException.ServerErrorException -> LocationException.LocationApiException(
            exceptions.message.toString()
        )

        is NetworkException.RequestTimeoutException -> LocationException.LocationNetworkException(
            exceptions.message.toString()
        )

        is NetworkException.UnknownNetworkException -> LocationException.LocationNetworkException(
            exceptions.message.toString()
        )

        is NetworkException.NoInternetConnectionException -> LocationException.LocationNetworkException(
            exceptions.message.toString()
        )

        else -> LocationException.LocationApiException(exceptions.message.toString())
    }
}
