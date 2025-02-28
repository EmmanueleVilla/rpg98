package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun LoadingPreview(modifier: Modifier = Modifier) {
    Loading(
        modifier = Modifier.height(24.dp),
        progress = 0.75f
    )
}

@Composable
fun Loading(
    modifier: Modifier = Modifier,
    progress: Float
) {
    val background = Color(0xFFBFBFBF)
    val grey = Color(0xFF808080)
    val sizePx = with(LocalDensity.current) { size.toPx() }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = background)
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .background(color = background)
                .drawWithContent {
                    drawContent()
                    drawLine(
                        cap = StrokeCap.Square,
                        color = grey,
                        start = Offset(0f, sizePx),
                        end = Offset(0f, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = grey,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(size.width, 0f),
                        end = Offset(size.width, size.height),
                        strokeWidth = sizePx,
                    )
                }
        ) {
            repeat((0..20).count()) {
                Box(
                    Modifier
                        .fillMaxHeight()
                        .weight(1.0f)
                        .padding(horizontal = 1.dp)
                        .background(
                            color = if ((progress * 100) > (it * 5)) {
                                Color(0xFF01017b)
                            } else {
                                Color.Transparent
                            }
                        )
                )
            }
        }
    }
}