package com.khater.weather.data.networking

import com.khater.weather.data.utils.NetworkException
import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.serialization.*

suspend inline fun <reified T> responseToBody(response: HttpResponse): T {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                response.body<T>()
            } catch (e: NoTransformationFoundException) {
                throw NetworkException.SerializationException(e)
            } catch (e: JsonConvertException) {
                throw NetworkException.SerializationException(e)
            }
        }

        408 -> throw NetworkException.RequestTimeoutException()
        429 -> throw NetworkException.TooManyRequestsException()
        in 500..599 -> throw NetworkException.ServerErrorException()
        else -> throw NetworkException.UnknownNetworkException()
    }
}