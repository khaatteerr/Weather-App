package com.khater.weather.data.source.remote.responseDto.weatherDto

import com.khater.weather.domain.entities.weatherEntity.Weather
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WeatherResponseModel(
    @SerialName("current")
    val current: CurrentWeatherResponseModel,
    @SerialName("current_units")
    val currentUnits: CurrentUnitsWeatherResponseModel,
    @SerialName("daily")
    val daily: DailyWeatherTemperatureResponseModel,
    @SerialName("daily_units")
    val dailyUnits: DailyUnitsWeatherTemperatureResponseModel,
    @SerialName("elevation")
    val elevation: Double,
    @SerialName("generationtime_ms")
    val generationTime: Double,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnitsResponseModel,
    @SerialName("hourly")
    val hourlyWeather: HourlyWeatherResponseModel

){
    fun toWeatherModel(): Weather =
        Weather(
            current = this.current.toCurrentWeatherModel(),
            currentUnits = this.currentUnits.toCurrentUnitsWeatherModel(),
            daily = this.daily.toDailyWeatherTemperatureModel(),
            dailyUnits = this.dailyUnits.toDailyUnitsWeatherTemperatureModel(),
            elevation = this.elevation,
            generationTime = this.generationTime,
            latitude = this.latitude,
            longitude = this.longitude,
            timezone = this.timezone,
            timezoneAbbreviation = this.timezoneAbbreviation,
            utcOffsetSeconds = this.utcOffsetSeconds,
            hourly = this.hourlyWeather.toHourlyWeather(),
            hourlyUnits = this.hourlyUnits.toHourlyUnits()
        )
}

