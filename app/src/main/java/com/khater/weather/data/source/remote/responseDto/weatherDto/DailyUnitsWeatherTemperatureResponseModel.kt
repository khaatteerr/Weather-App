package com.khater.weather.data.source.remote.responseDto.weatherDto

import com.khater.weather.domain.entities.weatherEntity.DailyUnitsWeather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DailyUnitsWeatherTemperatureResponseModel(
    @SerialName("temperature_2m_max")
    val temperatureMax: String,
    @SerialName("temperature_2m_min")
    val temperatureMin: String,
    @SerialName("time")
    val time: String,
    @SerialName("weather_code")
    val weatherCode: String
){
    fun toDailyUnitsWeatherTemperatureModel():DailyUnitsWeather =
        DailyUnitsWeather(
            temperatureMax = this.temperatureMax,
            temperatureMin = this.temperatureMin,
            time = this.time,
            weatherCode = this.weatherCode
        )
}