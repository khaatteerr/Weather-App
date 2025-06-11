package com.khater.weather.ui.screens.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.khater.weather.R
import com.khater.weather.ui.screens.homeScreen.composables.CurrentWeatherSection
import com.khater.weather.ui.screens.homeScreen.composables.ExtraWeatherSection
import com.khater.weather.ui.screens.homeScreen.composables.LocationSection
import com.khater.weather.ui.screens.homeScreen.composables.TodaySection
import com.khater.weather.ui.screens.homeScreen.composables.VerticalSpacer
import com.khater.weather.ui.screens.homeScreen.composables.WeatherForecastCard
import com.khater.weather.ui.screens.homeScreen.uiStates.ExtraWeatherInfoUiState
import com.khater.weather.ui.screens.homeScreen.uiStates.HomeUiState
import com.khater.weather.ui.theme.WeatherTheme


@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(homeUiState: HomeUiState) {
    val columnScrollState = rememberScrollState()
    val currentWeather = homeUiState.currentWeatherUiState
    val todayWeather = homeUiState.todayWeatherUiState
    val weekWeather = homeUiState.weekWeatherUiState
    val isDay = homeUiState.isDay

    Column(
        Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        WeatherTheme.colors.primary,
                        WeatherTheme.colors.background
                    )
                )
            )
            .verticalScroll(columnScrollState)
    ) {
        VerticalSpacer(height = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())


            // location section
            VerticalSpacer(height = WeatherTheme.size.large)
            LocationSection(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                location =  currentWeather.location
            )


            // current weather section
            VerticalSpacer(height = WeatherTheme.size.medium)
            CurrentWeatherSection(modifier = Modifier, columnScrollState, currentWeather,isDay)

            // Extra Weather Section
            VerticalSpacer(height = WeatherTheme.size.large)
            val extraWeatherInfoUiState = remember   {

            listOf(
                ExtraWeatherInfoUiState(
                    icon = R.drawable.wind ,
                    title =  currentWeather.windSpeed,
                    description = "Wind"
                ),
                ExtraWeatherInfoUiState(
                    icon = R.drawable.humidity ,
                    title = currentWeather.humidity,
                    description = "Humidity"
                ),
                ExtraWeatherInfoUiState(
                    icon = R.drawable.rain ,
                    title =  currentWeather.rain,
                    description = "Rain"
                ),
                ExtraWeatherInfoUiState(
                    icon = R.drawable.uv_index ,
                    title =  currentWeather.uvIndex,
                    description = "UV Index"
                ),
                ExtraWeatherInfoUiState(
                    icon = R.drawable.pressure ,
                    title =  currentWeather.pressure,
                    description = "Pressure"
                ),
                ExtraWeatherInfoUiState(
                    icon =   R.drawable.temperature ,
                    title = currentWeather.feelsLike,
                    description = "Feels like"
                ),

                )
        }
            ExtraWeatherSection(extraWeatherInfoUiState = extraWeatherInfoUiState)


            // today section
            VerticalSpacer(height = WeatherTheme.size.large)
            TodaySection(hourlyWeather =  todayWeather.hourlyItems, isDay = isDay)

            // next 7 days section
            VerticalSpacer(height = WeatherTheme.size.large)
            WeatherForecastCard(forecasts =  weekWeather.dailyForecast, isDay = isDay)

            // bottom padding
            VerticalSpacer(height = 32.dp)
        }


}


