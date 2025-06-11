package com.khater.weather.di.modules

import com.khater.weather.data.repositories.LocationRepositoryImpl
import com.khater.weather.data.repositories.WeatherRepositoryImpl
import com.khater.weather.domain.repositories.LocationRepository
import com.khater.weather.domain.repositories.WeatherRepository
import com.khater.weather.ui.screens.homeScreen.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {

    single<WeatherRepository> { WeatherRepositoryImpl(get() ) }
    single<LocationRepository> { LocationRepositoryImpl(get() ) }


}