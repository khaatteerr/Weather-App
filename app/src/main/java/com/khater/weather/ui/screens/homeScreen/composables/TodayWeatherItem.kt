package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.khater.weather.ui.screens.homeScreen.uiStates.HourlyWeatherUiState
import com.khater.weather.ui.theme.WeatherTheme
import com.khater.weather.ui.utils.dropShadow

@Composable
fun TodayWeatherItem(modifier: Modifier = Modifier, hourlyWeatherUiState: HourlyWeatherUiState,isDay:Boolean = false) {

    Box(
        modifier = modifier
            .height(120.dp)
            .width(88.dp)

            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(120.dp)
                .width(88.dp)
                .clip(RoundedCornerShape(WeatherTheme.size.extra))
                .background(WeatherTheme.colors.surface)
                .border(
                    1.dp,
                    WeatherTheme.colors.onSurface.copy(0.08f),
                    RoundedCornerShape(WeatherTheme.size.extra)
                ).dropShadow(
                    color = if (isDay) Color(0x26FFC701) else Color(0x267E2FFF),
                    shape = CircleShape,
                    blur = 150.dp,
                    spread = 0.dp,
                    offsetY = (-50).dp
                )
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(vertical = WeatherTheme.size.big),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = hourlyWeatherUiState.temperature,
                    style = WeatherTheme.typography.titleNormal,
                    color = WeatherTheme.colors.onSurface.copy(0.87f)
                )
                Text(
                    text = hourlyWeatherUiState.time,
                    style = WeatherTheme.typography.titleNormal,
                    color = WeatherTheme.colors.onSurface.copy(0.6f)
                )
            }

        }

            Image(
                painter = painterResource(hourlyWeatherUiState.icon),
                contentDescription = null,
                modifier = Modifier.height(58.dp)
                    .zIndex(1f).offset(y = (-12).dp).align(Alignment.TopCenter)
            )

    }

}

