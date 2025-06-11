package com.khater.weather.data.source.remote.responseDto.weatherDto

import com.khater.weather.domain.entities.weatherEntity.CurrentUnitsWeather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnitsWeatherResponseModel(
    @SerialName("time")
    val time: String,
    @SerialName("interval")
    val interval: String,
    @SerialName("temperature_2m")
    val temperature: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity: String,
    @SerialName("apparent_temperature")
    val apparentTemperature: String,
    @SerialName("precipitation_probability")
    val precipitationProbability: String,
    @SerialName("pressure_msl")
    val pressure: String,
    @SerialName("wind_speed_10m")
    val windSpeed: String,
    @SerialName("is_day")
    val isDay: String,
    @SerialName("rain")
    val rain: String,
    @SerialName("uv_index")
    val uvIndex: String,
    @SerialName("weather_code")
    val weatherCode: String,
) {
    fun toCurrentUnitsWeatherModel(): CurrentUnitsWeather =
        CurrentUnitsWeather(
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
            weatherCode = this.weatherCode,
        )
}