package com.khater.weather.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

//colors
data class WeatherColorsScheme(
    // main color
    val primary: Color,
    // background gradient color
    val background: Color,
    // icons color
    val secondary: Color,
    // views on background direct
    val onBackground: Color,
    // surface for cards color
    val surface: Color,
    // on surface color
    val onSurface: Color,
)

//typography
data class WeatherTypography(
    val titleLarge: TextStyle,
    val titleNormal: TextStyle,
    val body: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)

//shape
data class WeatherShape(
    val container: Shape,
    val card: Shape,
    val button: Shape,
)

//size
data class WeatherSize(
    val large: Dp, // 24
    val extra: Dp, // 20
    val big: Dp,   // 16
    val medium: Dp,  // 12
    val regular: Dp, // 8
    val normal: Dp,  // 6
    val small: Dp,  // 2
)

val LocalWeatherColorsScheme = staticCompositionLocalOf {
    WeatherColorsScheme(
        primary = Color.Unspecified,
        background = Color.Unspecified,
        secondary = Color.Unspecified,
        onBackground = Color.Unspecified,
        surface = Color.Unspecified,
        onSurface = Color.Unspecified,
    )
}

val LocalWeatherTypography = staticCompositionLocalOf {
    WeatherTypography(
        titleLarge = TextStyle.Default,
        titleNormal = TextStyle.Default,
        body = TextStyle.Default,
        labelMedium = TextStyle.Default,
        labelSmall = TextStyle.Default,
    )

}
val LocalWeatherShape = staticCompositionLocalOf {
    WeatherShape(
        container = RectangleShape,
        card = RectangleShape,
        button = RectangleShape,
    )

}

val LocalWeatherSize = staticCompositionLocalOf {
    WeatherSize(
        large = Dp.Unspecified,
        medium = Dp.Unspecified,
        normal = Dp.Unspecified,
        small = Dp.Unspecified,
        regular = Dp.Unspecified,
        big = Dp.Unspecified,
        extra = Dp.Unspecified,
    )
}





































