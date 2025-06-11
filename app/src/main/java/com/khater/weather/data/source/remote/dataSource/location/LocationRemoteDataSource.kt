package com.khater.weather.data.source.remote.dataSource.location

import com.khater.weather.data.networking.safeCall
import com.khater.weather.data.source.remote.responseDto.locationDto.IpAddressResponseModel
import com.khater.weather.data.source.remote.responseDto.locationDto.LocationResponseModel
import com.khater.weather.data.utils.Constants.IP_ADDRESS_BASE_URL
import com.khater.weather.data.utils.Constants.LOCATION_ADDRESS_BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class LocationRemoteDataSource(
    private val httpClient: HttpClient
) : LocationDataSource {

    override suspend fun getCurrentLocation(
        ipAddress: String
    ): LocationResponseModel =
        safeCall<LocationResponseModel> { httpClient.get(LOCATION_ADDRESS_BASE_URL.format(ipAddress)) }

    override suspend fun getIpAddress(): IpAddressResponseModel =
        safeCall<IpAddressResponseModel> { httpClient.get(IP_ADDRESS_BASE_URL) }

}