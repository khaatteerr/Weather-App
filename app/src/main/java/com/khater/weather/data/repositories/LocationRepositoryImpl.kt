package com.khater.weather.data.repositories

import com.khater.weather.data.source.remote.dataSource.location.LocationDataSource
import com.khater.weather.data.utils.toLocationExceptions
import com.khater.weather.domain.entities.locationEntity.IpAddress
import com.khater.weather.domain.entities.locationEntity.Location
import com.khater.weather.domain.repositories.LocationRepository

class LocationRepositoryImpl(
    private val locationRepository: LocationDataSource
) : LocationRepository{
    override suspend fun getIpAddress(): IpAddress {
        return try {
            locationRepository.getIpAddress().toIpAddressModel()
        } catch (exception: Exception) {
            throw exception.toLocationExceptions()
        }
    }

    override suspend fun getLocation(): Location {
        return try {
            val ipAddress = getIpAddress().ipAddress
            locationRepository.getCurrentLocation(ipAddress).toLocationModel()
        } catch (exception: Exception) {
            throw exception.toLocationExceptions()
        }
    }
}