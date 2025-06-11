package com.khater.weather.data.utils

open class NetworkException(message: String? = null, cause: Throwable? = null): Exception(message) {
    class NoInternetConnectionException(cause: Throwable? = null) : NetworkException("No internet connection", cause)
    class SerializationException(cause: Throwable? = null) : NetworkException("Failed to serialize response", cause)
    class RequestTimeoutException : NetworkException("Request timed out")
    class TooManyRequestsException : NetworkException("Too many requests")
    class ServerErrorException : NetworkException("Server error occurred")
    class UnknownNetworkException : NetworkException("Unknown network error")
}