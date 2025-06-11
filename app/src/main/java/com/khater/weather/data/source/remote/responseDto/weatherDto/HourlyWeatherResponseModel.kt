package com.khater.weather.data.source.remote.responseDto.weatherDto

import com.khater.weather.domain.entities.weatherEntity.HourlyWeather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherResponseModel(
    @SerialName("time")
    val time: List<String>,
    @SerialName("temperature_2m")
    val temperature: List<Double>,
    @SerialName("weather_code")
    val weatherCode: List<Int>,
    @SerialName("is_day")
    val isDay: List<Int>,
) {
    fun toHourlyWeather(): HourlyWeather {
         return HourlyWeather(
             time = this.time.take(24),
             temperature = this.temperature.take(24),
             weatherCode = this.weatherCode.take(24),
             isDay = this.isDay.take(24)
         )
    }
}