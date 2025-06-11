package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.khater.weather.ui.screens.homeScreen.uiStates.CurrentWeatherUiState
import com.khater.weather.ui.theme.WeatherTheme
import com.khater.weather.ui.utils.animateAlignmentAsState
import com.khater.weather.ui.utils.dropShadow

@Composable
fun CurrentWeatherSection(
    modifier: Modifier = Modifier, columnScrollState: ScrollState,
    currentWeather: CurrentWeatherUiState,
    isDay: Boolean = true
) {
    val animatedDp by animateDpAsState(targetValue = if (columnScrollState.canScrollBackward) 143.dp else (200 + 12 + 143).dp, label = "current weather height", animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessVeryLow))
    val animatedImageHeight by animateDpAsState(targetValue = if (columnScrollState.canScrollBackward) 112.dp else 200.dp, label = "animate image height")
    val animatedImageWidth by animateDpAsState(targetValue = if (columnScrollState.canScrollBackward) 124.dp else 227.dp, label = "animate image width")
    val imageAlignment by animateAlignmentAsState(if (columnScrollState.canScrollBackward) Alignment.CenterStart else Alignment.TopCenter)
    val temperatureAlignment by animateAlignmentAsState(if (columnScrollState.canScrollBackward) Alignment.CenterEnd else Alignment.BottomCenter)

    Box(
        Modifier
            .fillMaxWidth()
            .height(animatedDp)
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .height(animatedImageHeight)
                .width(animatedImageWidth)
                .align(imageAlignment)
                .dropShadow(
                    color = if (isDay) Color(0x33FFC701) else Color(0x337E2FFF),
                    shape = CircleShape,
                    blur = 150.dp,

                    )
        ) {
            Image(
                painter = painterResource( currentWeather .image),
                contentDescription = null,
                modifier = Modifier.zIndex(1f)
            )
        }

        Box(
            Modifier

                .wrapContentSize()
                .align(temperatureAlignment),
         ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = modifier  ,
                    text  = currentWeather.temperature ,
                    style = WeatherTheme.typography.titleLarge,
                    color = WeatherTheme.colors.onBackground,
                    maxLines = 1
                )
                Text(
                    currentWeather .weatherDescription,
                    style = WeatherTheme.typography.titleNormal,
                    color = WeatherTheme.colors.onBackground,
                )
                VerticalSpacer(height = WeatherTheme.size.medium)
                MinMaxTemperature(
                    modifier = Modifier
                        .background(
                            WeatherTheme.colors.onSurface.copy(0.08f),
                            shape = WeatherTheme.shape.button
                        )
                        .padding(
                            vertical = WeatherTheme.size.regular,
                            horizontal = WeatherTheme.size.large
                        ),
                    horizontalArrangementSpace = 8.dp,
                    highTemp =  currentWeather  .maxTemperature ,
                    lowTemp =   currentWeather.minTemperature
                )

            }
        }


    }
}