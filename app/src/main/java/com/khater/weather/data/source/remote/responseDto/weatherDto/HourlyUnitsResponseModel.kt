package com.khater.weather.data.source.remote.responseDto.weatherDto

import com.khater.weather.domain.entities.weatherEntity.HourlyUnits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.collections.take

@Serializable
data class HourlyUnitsResponseModel(
    @SerialName("time")
    val time: String,
    @SerialName("temperature_2m")
    val temperature: String
){
    fun toHourlyUnits(): HourlyUnits {
        return HourlyUnits(
            time = this.time.take(24),
            temperature = this.temperature.take(24)
        )
}
}