package com.khater.weather.domain.entities.locationEntity

data class Location(
    val ip: String,
    val city: String,
    val countryName: String,
    val latitude: Double,
    val longitude: Double,
 )
