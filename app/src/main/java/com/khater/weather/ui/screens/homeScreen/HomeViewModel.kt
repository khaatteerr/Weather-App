package com.khater.weather.ui.screens.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khater.weather.domain.usecases.GetWeatherUseCase
import com.khater.weather.ui.screens.homeScreen.uiStates.HomeUiState
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState(isLoading = false))
        private set

    init {
        viewModelScope.launch {
            homeUiState = homeUiState.copy(isLoading = true)

            try {
                val result = getWeatherUseCase.invoke()

                val currentWeatherUiState = result.toCurrentWeatherUiState()
                val todayWeatherUiState = result.toTodayWeatherUiState()
                val weeklyWeatherUiState = result.toDailyForecast()
                homeUiState = homeUiState.copy(
                    currentWeatherUiState = currentWeatherUiState,
                    todayWeatherUiState = todayWeatherUiState,
                    weekWeatherUiState = weeklyWeatherUiState,
                    isDay = result.current.isDay == 1,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                homeUiState = homeUiState.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }
}

