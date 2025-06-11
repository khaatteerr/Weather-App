package com.khater.weather.data.utils

object Constants {
    const val WEATHER_BASE_URL = "https://api.open-meteo.com/v1/forecast"
    const val LOCATION_ADDRESS_BASE_URL = "https://ipapi.co/%s/json/"
    const val IP_ADDRESS_BASE_URL = "https://api.ipify.org?format=json"
    const val TIME_ZONE = "auto"
    const val HOURLY = "temperature_2m,weather_code,is_day"
    const val WEATHER_DAILY_PARAMETER = "weather_code,temperature_2m_max,temperature_2m_min"
    const val WEATHER_CURRENT_PARAMETER = "temperature_2m,relative_humidity_2m,apparent_temperature,precipitation_probability,pressure_msl,wind_speed_10m,is_day,rain,uv_index,weather_code"
}