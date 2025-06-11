package com.khater.weather.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val darkColorScheme = WeatherColorsScheme(
    primary = DarkPrimaryColor,
    background = DarkBackgroundColor,
    secondary = DarkSecondaryColor,
    onBackground = DarkOnBackgroundColor,
    surface = DarkSurfaceColor,
    onSurface = DarkOnSurfaceColor,
)

private val lightColorScheme = WeatherColorsScheme(
    primary = LightPrimaryColor,
    background = LightBackgroundColor,
    secondary = LightSecondaryColor,
    onBackground = LightOnBackgroundColor,
    surface = LightSurfaceColor,
    onSurface = LightOnSurfaceColor,
)

private val typography = WeatherTypography(
    titleLarge = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 64.sp,
        letterSpacing = 0.25.sp
    ),
    titleNormal = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp
    ),
    body = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.25.sp
       ),

    labelMedium = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.25.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
)

private val shape = WeatherShape(
    container = RoundedCornerShape(24.dp),
    button = RoundedCornerShape(100.dp),
    card = RoundedCornerShape(20.dp)
)

private val size = WeatherSize(
    large = 24.dp,
    extra = 20.dp,
    big = 16.dp,
    medium = 12.dp,
    regular = 8.dp,
    normal = 6.dp,
    small = 2.dp
)


@Composable
fun WeatherTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) darkColorScheme else lightColorScheme
    val rippleIndication = ripple()
    CompositionLocalProvider(
        LocalWeatherColorsScheme provides colorScheme,
        LocalWeatherTypography provides typography,
        LocalWeatherShape provides shape,
        LocalWeatherSize provides size,
        LocalIndication provides rippleIndication,
        content = content
    )
}

object WeatherTheme{
    val colors: WeatherColorsScheme
        @Composable get() = LocalWeatherColorsScheme.current
    val typography: WeatherTypography
        @Composable get() = LocalWeatherTypography.current
    val shape: WeatherShape
        @Composable get() = LocalWeatherShape.current
    val size: WeatherSize
        @Composable get() = LocalWeatherSize.current

}