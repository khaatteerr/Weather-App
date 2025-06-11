package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.khater.weather.ui.screens.homeScreen.uiStates.ExtraWeatherInfoUiState
import com.khater.weather.ui.theme.WeatherTheme

@Composable
fun ExtraWeatherInfoItem(
    modifier: Modifier = Modifier,
    extraWeatherInfoUiState: ExtraWeatherInfoUiState
) {
    Column(
        modifier = modifier
            .height(115.dp)
            .clip(RoundedCornerShape(WeatherTheme.size.large))
            .border(1.dp, WeatherTheme.colors.onSurface.copy(0.08f), RoundedCornerShape(WeatherTheme.size.large))
            .background(WeatherTheme.colors.surface)
            .padding(horizontal = WeatherTheme.size.regular, vertical = WeatherTheme.size.big),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource( extraWeatherInfoUiState.icon),
            contentDescription = "Weather Icon",
            tint = WeatherTheme.colors.secondary,
            modifier = Modifier.size(32.dp)
        )
        VerticalSpacer(height = WeatherTheme.size.regular)
        Text(
            text = extraWeatherInfoUiState.title,
            style = WeatherTheme.typography.labelMedium,
            color = WeatherTheme.colors.onSurface.copy(0.87f)
        )
        VerticalSpacer(height = WeatherTheme.size.small)
        Text(
            text = extraWeatherInfoUiState.description,
            style = WeatherTheme.typography.labelSmall,
            color = WeatherTheme.colors.onSurface.copy(0.6f)
        )
    }

}