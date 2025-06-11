package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.khater.weather.R
import com.khater.weather.ui.theme.WeatherTheme

@Composable
fun MinMaxTemperature(modifier: Modifier = Modifier,
        horizontalArrangementSpace:Dp = 4.dp, highTemp: String, lowTemp: String) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(horizontalArrangementSpace)
    ) {


        Icon(
            painter = painterResource(R.drawable.arrow_up),
            contentDescription = "Arrow Up",
            modifier = Modifier.size(12.dp),
            tint = WeatherTheme.colors.onSurface.copy(0.87f)
        )

        Text(
            text = highTemp,
            color = WeatherTheme.colors.onSurface.copy(0.87f),
            style = WeatherTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
        )
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(14.dp)
                .background(WeatherTheme.colors.onSurface.copy(0.24f))
        )
        Icon(
            painter = painterResource(R.drawable.arrow_down),
            contentDescription = "Arrow Down",
            modifier = Modifier.size(12.dp),
            tint = WeatherTheme.colors.onSurface.copy(0.87f)
        )
        Text(
            text = lowTemp,
            color = WeatherTheme.colors.onSurface.copy(0.87f),
            style = WeatherTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
        )

    }
}