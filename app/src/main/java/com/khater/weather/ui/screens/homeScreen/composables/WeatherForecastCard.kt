package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khater.weather.ui.screens.homeScreen.uiStates.DailyForecast
import com.khater.weather.ui.theme.WeatherTheme

@Composable
fun WeatherForecastCard(
    modifier: Modifier = Modifier,
    forecasts: List<DailyForecast>,
    isDay: Boolean = false
) {
    SectionLabel(
        text = "Next 7 days",
        modifier = Modifier.padding(horizontal = WeatherTheme.size.medium)
    )
    VerticalSpacer(height = WeatherTheme.size.medium)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = WeatherTheme.size.medium),
        colors = CardDefaults.cardColors(
            containerColor = WeatherTheme.colors.surface
        ),
        shape = WeatherTheme.shape.container,
        border = BorderStroke(1.dp, WeatherTheme.colors.onSurface.copy(0.08f))
    ) {
        Column {
            forecasts.forEachIndexed { index, forecast ->
                WeatherForecastItem(
                    dayName = forecast.dayName,
                    weatherIcon = forecast.weatherIcon,
                    highTemp = forecast.highTemp,
                    lowTemp = forecast.lowTemp,
                    isDay = isDay
                )

                // Add border between items (except for the last item)
                if (index < forecasts.size - 1) {
                    HorizontalDivider(
                        color = WeatherTheme.colors.onSurface.copy(0.08f),
                        thickness = 1.dp,
                    )
                }
            }
        }
    }
}