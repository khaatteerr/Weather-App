package com.khater.weather.domain.repositories

import com.khater.weather.domain.entities.locationEntity.IpAddress
import com.khater.weather.domain.entities.locationEntity.Location

interface LocationRepository {
    suspend fun getIpAddress(): IpAddress
    suspend fun getLocation(): Location
}