package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shadowings.rpg98.utils.PreviewContainer

@Preview(device = Devices.PIXEL_7A)
@Composable
fun TabWindowPreview() {
    PreviewContainer {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFBFBFBF))
                .padding(16.dp),
        ) {
            TabWindow(
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(Modifier.height(16.dp))
            TabWindow(
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
fun TabWindow(
    modifier: Modifier = Modifier,
) {
    val lightGray = Color(0xFFDBDBDB)
    val darkGray = Color(0xFF808080)
    val sizePx = with(LocalDensity.current) { size.toPx() }

    Box(
        modifier = modifier
    ) {
        Box(
            modifier = modifier
                .background(color = Color(0xFFBFBFBF))
                .drawWithContent {
                    drawContent()
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height - sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(0f, 0f),
                        end = Offset(size.width - sizePx, 0f),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(size.width, 0f),
                        end = Offset(size.width, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(0f, size.height),
                        end = Offset(size.width - sizePx, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx, sizePx),
                        end = Offset(sizePx, size.height - sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx, sizePx),
                        end = Offset(size.width - sizePx, sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = darkGray,
                        start = Offset(size.width - sizePx, sizePx),
                        end = Offset(size.width - sizePx, size.height - sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = darkGray,
                        start = Offset(sizePx, size.height - sizePx),
                        end = Offset(size.width - sizePx, size.height - sizePx),
                        strokeWidth = sizePx,
                    )
                }

        )
    }
}