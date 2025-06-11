package com.khater.weather.data.repositories

import com.khater.weather.data.source.remote.dataSource.weather.WeatherDataSource
import com.khater.weather.data.utils.toWeatherException
import com.khater.weather.domain.entities.weatherEntity.Weather
import com.khater.weather.domain.repositories.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource,
 ) : WeatherRepository {
    override suspend fun getWeather(
        latitude: Double,
        longitude: Double
    ): Weather {
        try {
            val result = weatherDataSource.getWeather(
                latitude = latitude,
                longitude = longitude
            )
            return result.toWeatherModel()
        } catch (exception: Exception) {
            throw exception.toWeatherException()
        }
    }


}