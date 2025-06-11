package com.khater.weather.data.source.remote.responseDto.locationDto


import com.khater.weather.domain.entities.locationEntity.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponseModel(
    @SerialName("asn")
    val asn: String,
    @SerialName("city")
    val city: String,
    @SerialName("continent_code")
    val continentCode: String,
    @SerialName("country")
    val country: String,
    @SerialName("country_area")
    val countryArea: Double,
    @SerialName("country_calling_code")
    val countryCallingCode: String,
    @SerialName("country_capital")
    val countryCapital: String,
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("country_code_iso3")
    val countryCodeIso3: String,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("country_population")
    val countryPopulation: Int,
    @SerialName("country_tld")
    val countryTld: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("currency_name")
    val currencyName: String,
    @SerialName("in_eu")
    val inEu: Boolean,
    @SerialName("ip")
    val ip: String,
    @SerialName("languages")
    val languages: String,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("network")
    val network: String,
    @SerialName("org")
    val org: String,
    @SerialName("region_code")
    val regionCode: String,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("utc_offset")
    val utcOffset: String,
    @SerialName("version")
    val version: String
) {
    fun toLocationModel(): Location =
        Location(
            ip = this.ip,
            latitude = this.latitude,
            longitude = this.longitude,
            city = this.city,
            countryName = this.countryName,
        )
}