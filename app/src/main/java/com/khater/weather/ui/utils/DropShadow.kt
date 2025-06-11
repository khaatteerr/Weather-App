package com.khater.weather.ui.utils

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.dropShadow(
    shape: Shape,
    color: Color = Black.copy(0.25f),
    blur: Dp = 150.dp,
    offsetY: Dp = 5.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 10.dp
) = this.drawBehind {
    val shadowSize = Size(size.width + spread.toPx(), size.height + spread.toPx())
    val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)
    val paint = Paint()

    paint.color = color


    if (blur.toPx() > 0) {
        paint.asFrameworkPaint().apply {
            // Apply blur to the Paint
            maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
        }
    }
    drawIntoCanvas { canvas ->
        canvas.save()
        (spread.toPx() / 2f).let {
            canvas.translate(offsetX.toPx() - it, offsetY.toPx() - it)
        }
        canvas.drawOutline(shadowOutline, paint)
        canvas.restore()
    }

}