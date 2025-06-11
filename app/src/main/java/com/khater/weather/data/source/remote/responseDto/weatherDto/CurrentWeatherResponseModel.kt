package com.khater.weather.data.source.remote.responseDto.weatherDto

import com.khater.weather.domain.entities.weatherEntity.CurrentWeather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponseModel(
    @SerialName("time")
    val time: String,
    @SerialName("interval")
    val interval: Int,
    @SerialName("temperature_2m")
    val temperature: Double,
    @SerialName("relative_humidity_2m")
    val relativeHumidity: Int,
    @SerialName("apparent_temperature")
    val apparentTemperature: Double,
    @SerialName("precipitation_probability")
    val precipitationProbability: Int,
    @SerialName("pressure_msl")
    val pressure: Double,
    @SerialName("wind_speed_10m")
    val windSpeed: Double,
    @SerialName("is_day")
    val isDay: Int,
    @SerialName("rain")
    val rain: Double,
    @SerialName("uv_index")
    val uvIndex: Double,
    @SerialName("weather_code")
    val weatherCode: Int,

) {
    fun toCurrentWeatherModel(): CurrentWeather =
        CurrentWeather(
            time = this.time,
            interval = this.interval,
            temperature = this.temperature,
            relativeHumidity = this.relativeHumidity,
            apparentTemperature = this.apparentTemperature,
            precipitationProbability = this.precipitationProbability,
            pressure = this.pressure,
            windSpeed = this.windSpeed,
            isDay = this.isDay,
            rain = this.rain,
            uvIndex = this.uvIndex,
            weatherCode = this.weatherCode
        )
}

