package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shadowings.rpg98.R

@Composable
fun TabFiller(modifier: Modifier) {
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
    val sizePx = with(LocalDensity.current) { size.toPx() }
    val lightGray = Color(0xFFDBDBDB)
    val paddingValues =
        PaddingValues(top = size * 2, start = size * 2, end = size * 2, bottom = 0.dp)
    Box(
        modifier = modifier
            .background(color = Color(0xFFBFBFBF))
            .drawWithContent {
                drawContent()
                drawLine(
                    cap = StrokeCap.Square,
                    color = lightGray,
                    start = Offset(sizePx, size.height - sizePx),
                    end = Offset(size.width - sizePx * 2, size.height - sizePx),
                    strokeWidth = sizePx,
                )
                drawLine(
                    cap = StrokeCap.Square,
                    color = Color.White,
                    start = Offset(0f, size.height),
                    end = Offset(size.width - sizePx, size.height),
                    strokeWidth = sizePx,
                )
            }
            .padding(paddingValues)
    ) {
        Text(
            text = "   ",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 12.dp)
                .padding(vertical = 4.dp),
            fontFamily = fontFamily
        )
    }
}