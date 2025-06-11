package com.khater.weather.data.source.remote.responseDto.weatherDto

import com.khater.weather.domain.entities.weatherEntity.DailyWeather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DailyWeatherTemperatureResponseModel(
    @SerialName("temperature_2m_max")
    val temperatureMax: List<Double>,
    @SerialName("temperature_2m_min")
    val temperatureMin: List<Double>,
    @SerialName("time")
    val time: List<String>,
    @SerialName("weather_code")
    val weatherCode: List<Int>
) {
    fun toDailyWeatherTemperatureModel(): DailyWeather =
        DailyWeather(
            temperatureMax = this.temperatureMax,
            temperatureMin = this.temperatureMin,
            time = this.time,
            weatherCode = this.weatherCode
        )
}