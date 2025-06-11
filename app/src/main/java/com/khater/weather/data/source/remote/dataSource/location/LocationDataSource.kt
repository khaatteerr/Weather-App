package com.khater.weather.data.source.remote.dataSource.location

import com.khater.weather.data.source.remote.responseDto.locationDto.IpAddressResponseModel
import com.khater.weather.data.source.remote.responseDto.locationDto.LocationResponseModel

interface LocationDataSource {
    suspend fun getCurrentLocation(ipAddress: String): LocationResponseModel
    suspend fun getIpAddress(): IpAddressResponseModel
}