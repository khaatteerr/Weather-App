package com.khater.weather.di.modules

import com.khater.weather.domain.usecases.GetWeatherUseCase
import com.khater.weather.ui.screens.homeScreen.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {
        HomeViewModel(get())
    }
    factory {
        GetWeatherUseCase(get(), get())
    }

}