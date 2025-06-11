package com.khater.weather.data.source.remote.dataSource.weather

import com.khater.weather.data.source.remote.responseDto.weatherDto.WeatherResponseModel


interface WeatherDataSource {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponseModel
}