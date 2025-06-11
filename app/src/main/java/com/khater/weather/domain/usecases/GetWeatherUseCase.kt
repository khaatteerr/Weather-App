package com.khater.weather.domain.usecases

import com.khater.weather.domain.entities.locationEntity.Location
import com.khater.weather.domain.entities.weatherEntity.Weather
import com.khater.weather.domain.repositories.LocationRepository
import com.khater.weather.domain.repositories.WeatherRepository

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository) {

    suspend operator fun invoke(): Weather {
        val location = getLocation()
        return try {

            weatherRepository.getWeather(location.latitude, location.longitude)
        }catch (e: Exception){
            throw e
        }
    }

    private suspend fun getLocation(): Location{
        return try {
            locationRepository.getLocation()
        }catch (e: Exception){
            throw e
        }
    }

}