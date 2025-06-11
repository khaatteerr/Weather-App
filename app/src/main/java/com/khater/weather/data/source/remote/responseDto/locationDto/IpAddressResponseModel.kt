package com.khater.weather.data.source.remote.responseDto.locationDto

import com.khater.weather.domain.entities.locationEntity.IpAddress
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IpAddressResponseModel(
    @SerialName("ip")
    val ipAddress: String,
) {
    fun toIpAddressModel(): IpAddress =
        IpAddress(
            ipAddress = this.ipAddress,
        )
}