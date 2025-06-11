package com.khater.weather.ui.screens.homeScreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.khater.weather.R
import com.khater.weather.ui.theme.WeatherTheme

@Composable
fun LocationSection(modifier: Modifier = Modifier,location:String) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.location),
            contentDescription = "Location Icon",
            modifier = Modifier.size(24.dp),
            tint = WeatherTheme.colors.onSurface
        )
        Text(
            location,
            style = WeatherTheme.typography.titleNormal,
            color = WeatherTheme.colors.onSurface
        )
    }
}