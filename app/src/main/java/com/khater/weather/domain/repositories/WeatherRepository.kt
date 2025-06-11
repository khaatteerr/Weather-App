package com.khater.weather.domain.repositories

import com.khater.weather.domain.entities.weatherEntity.Weather


interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): Weather

}