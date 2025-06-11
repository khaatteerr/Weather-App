package com.khater.weather.data.networking

import com.khater.weather.data.utils.NetworkException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import java.net.UnknownHostException
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall( execute: suspend () -> HttpResponse): T {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        throw NetworkException.NoInternetConnectionException(e)
    } catch (e: UnknownHostException) {
        throw NetworkException.NoInternetConnectionException(e)
    } catch (e: SerializationException) {
        throw NetworkException.SerializationException(e)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        throw NetworkException.UnknownNetworkException()
    }

    return responseToBody(response)
}