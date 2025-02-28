package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shadowings.rpg98.R
import com.shadowings.rpg98.utils.PreviewContainer

@Preview(device = Devices.PIXEL_7A)
@Composable
fun RpgButtonPreview() {
    PreviewContainer {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFBFBFBF))
                .padding(16.dp),
        ) {
            RpgButton(
                modifier = Modifier
                    .fillMaxWidth(),
                pressed = false
            )
            Spacer(Modifier.height(16.dp))
            RpgButton(
                modifier = Modifier
                    .fillMaxWidth(),
                pressed = true
            )
        }
    }
}

@Composable
fun RpgButton(
    modifier: Modifier = Modifier,
    text: String = "",
    pressed: Boolean = false
) {
    val isPressed = remember { mutableStateOf(pressed) }

    val paddingValues = if (isPressed.value) {
        PaddingValues(top = size * 2, start = size * 2, end = size * 2, bottom = size * 2)
    } else {
        PaddingValues(0.dp)
    }
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )

    val lightGray = Color(0xFFDBDBDB)
    val darkGray = Color(0xFF808080)
    val sizePx = with(LocalDensity.current) { size.toPx() }

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed.value = true
                        try {
                            awaitRelease()
                        } catch (e: Exception) {
                            isPressed.value = false
                        }
                    },
                    onTap = {
                        isPressed.value = false
                    }
                )
            }
            .background(
                color = if (isPressed.value) {
                    Color.Black
                } else Color.Transparent
            )
            .padding(paddingValues)
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
        {
            Text(
                text = text,
                color = Color.Black,
                fontSize = if (isPressed.value) {
                    20.sp
                } else {
                    22.sp
                },
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                fontFamily = fontFamily
            )
        }
    }
}