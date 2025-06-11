package com.khater.weather.di.modules

import com.khater.weather.data.source.remote.dataSource.location.LocationDataSource
import com.khater.weather.data.source.remote.dataSource.location.LocationRemoteDataSource
import com.khater.weather.data.source.remote.dataSource.weather.WeatherDataSource
import com.khater.weather.data.source.remote.dataSource.weather.WeatherRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module{
    single<LocationDataSource> { LocationRemoteDataSource(get()) }
    single<WeatherDataSource>{ WeatherRemoteDataSource(get()) }
}