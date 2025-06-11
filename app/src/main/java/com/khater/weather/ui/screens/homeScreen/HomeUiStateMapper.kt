package com.khater.weather.ui.screens.homeScreen

import com.khater.weather.domain.entities.weatherEntity.Weather
import com.khater.weather.ui.screens.homeScreen.uiStates.CurrentWeatherUiState
import com.khater.weather.ui.screens.homeScreen.uiStates.DailyForecast
import com.khater.weather.ui.screens.homeScreen.uiStates.HourlyWeatherUiState
import com.khater.weather.ui.screens.homeScreen.uiStates.TodayWeatherUiState
import com.khater.weather.ui.screens.homeScreen.uiStates.WeeklyWeatherUiState
import com.khater.weather.ui.utils.formatTime
import com.khater.weather.ui.utils.getWeatherDescription
import com.khater.weather.ui.utils.getWeatherImage
import com.khater.weather.ui.utils.getWeekdayFromDate
import com.khater.weather.ui.utils.representLocation


fun Weather.toCurrentWeatherUiState(  ): CurrentWeatherUiState {
    val tempUnit = currentUnits.temperature
    val isDay = current.isDay == 1
    val weatherCode = current.weatherCode

    return CurrentWeatherUiState(
        temperature = "${current.temperature.toInt()}$tempUnit",
        temperatureUnit = tempUnit,
        weatherDescription = getWeatherDescription(weatherCode),
        weatherCode = weatherCode,
        minTemperature = "${daily.temperatureMin[0].toInt()}$tempUnit",
        maxTemperature = "${daily.temperatureMax[0].toInt()}$tempUnit",
        image = getWeatherImage(weatherCode, isDay),
        location = timezone.representLocation(),
        windSpeed = "${current.windSpeed.toInt()} ${currentUnits.windSpeed}",
        humidity = "${current.relativeHumidity.toInt()}${currentUnits.relativeHumidity}",
        rain = "${current.precipitationProbability}${currentUnits.precipitationProbability}",
        uvIndex = "${current.uvIndex.toInt()}${currentUnits.uvIndex}",
        pressure = "${current.pressure.toInt()} ${currentUnits.pressure}",
        feelsLike = "${current.apparentTemperature.toInt()}${currentUnits.apparentTemperature}"
    )
}

fun Weather.toTodayWeatherUiState(  ): TodayWeatherUiState {
    val tempUnit = hourlyUnits.temperature

    val hourlyItems = hourly.time.mapIndexed { index, time ->

        HourlyWeatherUiState(
            temperature = "${hourly.temperature[index].toInt()}$tempUnit",
            time = formatTime(time.toString()) ,
            icon = getWeatherImage(
                weatherCode = hourly.weatherCode[index] ,
                isDay = current.isDay == 1
            )
        )
    }
    return TodayWeatherUiState(hourlyItems = hourlyItems)
}

fun Weather.toDailyForecast(): WeeklyWeatherUiState {
    val maxTempUnit = dailyUnits.temperatureMax
    val minTempUnit = dailyUnits.temperatureMin

    val isDay = current.isDay == 1
    val dailyForecast = daily.time.mapIndexed { index, time ->

        DailyForecast(
            dayName = getWeekdayFromDate(time),
            weatherIcon =  getWeatherImage(
                weatherCode = daily.weatherCode[index],
                isDay = isDay
            ),
            highTemp = "${daily.temperatureMax[index].toInt()}$maxTempUnit",
            lowTemp = "${daily.temperatureMin[index].toInt()}$minTempUnit"
        )
    }
    return WeeklyWeatherUiState(dailyForecast = dailyForecast)
}
