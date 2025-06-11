package com.khater.weather.ui.utils

import com.khater.weather.R

/* it's need update in the future as enum class*/

private val weekdayCache = mutableMapOf<String, String>()

fun getWeekdayFromDate(dateString: String): String {
    return weekdayCache[dateString] ?: run {
        val parts = dateString.split("-")
        val year = parts[0].toInt()
        val month = parts[1].toInt()
        val day = parts[2].toInt()

        val q = day
        val m = if (month < 3) month + 12 else month
        val k = if (month < 3) year - 1 else year
        val j = k / 100
        val kMod = k % 100

        val h = (q + ((13 * (m + 1)) / 5) + kMod + (kMod / 4) + (j / 4) - 2 * j) % 7

        val weekdays = arrayOf("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
        val result = weekdays[h]
        weekdayCache[dateString] = result
        result
    }
}

fun formatTime(isoTimeString: String): String {
    val hour = isoTimeString.substringAfter("T").substringBefore(":").toInt()
    return if (hour == 0) "12:00" else "${hour.toString().padStart(2, '0')}:00"
}

fun String.representLocation(): String {
    return this.substringAfter('/')
}

fun getWeatherDescription(weatherCode: Int): String {
    return when (weatherCode) {
        0 -> "Clear sky"
        1, 2, 3 -> "Partly cloudy"
        45, 48 -> "Fog"
        51, 53, 55 -> "Drizzle"
        56, 57 -> "Freezing drizzle"
        61, 63, 65 -> "Rain"
        66, 67 -> "Freezing rain"
        71, 73, 75 -> "Snow"
        77 -> "Snow grains"
        80, 81, 82 -> "Rain showers"
        85, 86 -> "Snow showers"
        95 -> "Thunderstorm"
        96, 99 -> "Thunderstorm with hail"
        else -> "Unknown"
    }
}

fun getWeatherImage(weatherCode: Int, isDay: Boolean): Int {
    return when (weatherCode) {
        0 -> if (isDay) R.drawable.day_clear_sky else R.drawable.night_clear_sky
        1 -> if (isDay) R.drawable.day_mainly_clear else R.drawable.night_mainly_clear
        2 -> if (isDay) R.drawable.day_partly_cloudy else R.drawable.night_partly_cloudy
        3 -> if (isDay) R.drawable.day_overcast else R.drawable.night_overcast
        45 -> if (isDay) R.drawable.day_fog else R.drawable.night_fog
        48 -> if (isDay) R.drawable.day_depositing_rime_fog else R.drawable.night_depositing_rime_fog
        51 -> if (isDay) R.drawable.day_drizzle_light else R.drawable.night_drizzle_light
        53 -> if (isDay) R.drawable.day_drizzle_moderate else R.drawable.night_drizzle_moderate
        55 -> if (isDay) R.drawable.day_drizzle_intensity else R.drawable.night_drizzle_intensity
        56 -> if (isDay) R.drawable.day_freezing_drizzle_light else R.drawable.night_freezing_drizzle_light
        57 -> if (isDay) R.drawable.day_freezing_drizzle_intensity else R.drawable.night_freezing_drizzle_intensity
        61 -> if (isDay) R.drawable.day_rain_slight else R.drawable.night_rain_slight
        63 -> if (isDay) R.drawable.day_rain_moderate else R.drawable.night_rain_moderate
        65 -> if (isDay) R.drawable.day_rain_intensity else R.drawable.night_rain_intensity
        66 -> if (isDay) R.drawable.day_freezing_heavy else R.drawable.night_freezing_heavy
        67 -> if (isDay) R.drawable.day_freezing_loght else R.drawable.night_freezing_heavy
        71 -> if (isDay) R.drawable.day_snow_fall_light else R.drawable.night_snow_fall_light
        73 -> if (isDay) R.drawable.day_snow_fall_moderate else R.drawable.night_snow_fall_moderate
        75 -> if (isDay) R.drawable.day_snow_fall_intensity else R.drawable.night_snow_fall_intensity
        77 -> if (isDay) R.drawable.day_snow_grains else R.drawable.night_snow_grains
        80 -> if (isDay) R.drawable.day_rain_shower_slight else R.drawable.night_rain_shower_slight
        81 -> if (isDay) R.drawable.day_rain_shower_moderate else R.drawable.night_rain_shower_moderate
        82 -> if (isDay) R.drawable.day_rain_shower_violent else R.drawable.night_rain_shower_violent
        85 -> if (isDay) R.drawable.day_snow_grains else R.drawable.night_snow_grains
        86 -> if (isDay) R.drawable.day_snow_shower_heavy else R.drawable.night_snow_shower_heavy
        95 -> if (isDay) R.drawable.day_thunderstrom_slight_or_moderate else R.drawable.night_thunderstrom_slight_or_moderate
        96 -> if (isDay) R.drawable.day_thunderstrom_with_slight_hail else R.drawable.night_thunderstrom_with_slight_hail
        99 -> if (isDay) R.drawable.day_thunderstrom_with_heavy_hail else R.drawable.night_thunderstrom_with_heavy_hail
        else -> if (isDay) R.drawable.day_clear_sky else R.drawable.night_clear_sky
    }
}

