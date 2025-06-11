package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khater.weather.ui.screens.homeScreen.uiStates.ExtraWeatherInfoUiState
import com.khater.weather.ui.theme.WeatherTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExtraWeatherSection(modifier: Modifier = Modifier, extraWeatherInfoUiState: List<ExtraWeatherInfoUiState>) {

    FlowRow(
        modifier = modifier.padding(horizontal = WeatherTheme.size.medium),
        horizontalArrangement = Arrangement.spacedBy(WeatherTheme.size.normal),
        verticalArrangement = Arrangement.spacedBy(WeatherTheme.size.normal),
        maxItemsInEachRow = 3
    ) {
        extraWeatherInfoUiState.forEach {
            ExtraWeatherInfoItem(
                extraWeatherInfoUiState = it,
                modifier = Modifier.weight(1f)
            )
        }

    }
}