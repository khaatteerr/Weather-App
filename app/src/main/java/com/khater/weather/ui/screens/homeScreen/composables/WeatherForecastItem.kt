package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.khater.weather.ui.theme.WeatherTheme
import com.khater.weather.ui.utils.dropShadow

@Composable
fun WeatherForecastItem(
    dayName: String,
    weatherIcon: Int,
    highTemp: String,
    lowTemp: String,
    isDay: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = WeatherTheme.size.big), contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
             horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Day name
            Text(
                text = dayName,
                style = WeatherTheme.typography.titleNormal,
                color = WeatherTheme.colors.onSurface.copy(0.6f),
                modifier = Modifier
                    .padding(vertical = 22.dp)
                    .weight(1.2f)
            )
            Image(
                painter = painterResource(id = weatherIcon),
                contentDescription = "Weather icon",
                modifier = Modifier
                    .height(32.dp)
                    .dropShadow(
                        color = if (isDay) Color(0x26FFC701) else Color(0x267E2FFF),
                        shape = CircleShape,
                        blur = 150.dp,
                    )
                    .weight(1f),
                contentScale = ContentScale.Inside

            )

            // Temperature range
            MinMaxTemperature(
                modifier = Modifier.weight(1.2f),
                highTemp = highTemp,
                lowTemp = lowTemp
            )

        }

    }
}