package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.zIndex
import com.shadowings.rpg98.R
import com.shadowings.rpg98.utils.PreviewContainer

@Preview(device = Devices.PIXEL_7A)
@Composable
fun RpgTabPreview() {
    val selectedIndex = remember { mutableIntStateOf(0) }
    PreviewContainer {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFBFBFBF))
                .padding(16.dp),
        ) {
            RpgTab(
                modifier = Modifier
                    .width(100.dp),
                selectedIndex = selectedIndex,
                index = 0
            )
            Spacer(Modifier.height(16.dp))
            RpgTab(
                modifier = Modifier
                    .width(100.dp),
                selectedIndex = selectedIndex,
                index = 0
            )
        }
    }
}

@Composable
fun RpgTab(
    modifier: Modifier = Modifier,
    text: String = "",
    selectedIndex: MutableIntState,
    index: Int
) {
    val isPressed = remember { mutableStateOf(false) }

    val paddingValues = if (selectedIndex.intValue != index) {
        PaddingValues(top = size * 2, start = size * 2, end = size * 2, bottom = 0.dp)
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
            .zIndex(if (selectedIndex.intValue == index) 10f else 0f)
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
                        selectedIndex.intValue = index
                    }
                )
            }
            .background(
                color = Color.Transparent
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
                        start = Offset(0f, sizePx * 3),
                        end = Offset(0f, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(sizePx * 3, 0f),
                        end = Offset(size.width - sizePx * 3, 0f),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(size.width, sizePx * 3),
                        end = Offset(size.width, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx, sizePx * 2),
                        end = Offset(sizePx, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx * 2, sizePx),
                        end = Offset(size.width - sizePx * 3, sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = darkGray,
                        start = Offset(size.width - sizePx, sizePx * 3),
                        end = Offset(size.width - sizePx, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(sizePx, sizePx * 2),
                        end = Offset(sizePx, sizePx * 2),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(sizePx * 2, sizePx),
                        end = Offset(sizePx * 2, sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx * 2, sizePx * 2),
                        end = Offset(sizePx * 2, sizePx * 2),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = darkGray,
                        start = Offset(size.width - sizePx * 2, sizePx * 2),
                        end = Offset(size.width - sizePx * 2, sizePx * 2),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(size.width - sizePx, sizePx * 2),
                        end = Offset(size.width - sizePx, sizePx * 2),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(size.width - sizePx * 2, sizePx),
                        end = Offset(size.width - sizePx * 2, sizePx),
                        strokeWidth = sizePx,
                    )
                    if (selectedIndex.intValue != index) {
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
                    } else {
                        drawLine(
                            cap = StrokeCap.Square,
                            color = Color(0xFFBFBFBF),
                            start = Offset(sizePx, size.height - sizePx),
                            end = Offset(size.width - sizePx * 2, size.height - sizePx),
                            strokeWidth = sizePx,
                        )
                        drawLine(
                            cap = StrokeCap.Square,
                            color = Color(0xFFBFBFBF),
                            start = Offset(0f, size.height),
                            end = Offset(size.width - sizePx, size.height),
                            strokeWidth = sizePx,
                        )
                    }
                }

        )
        {
            Text(
                text = text,
                color = Color.Black,
                fontSize = if (selectedIndex.intValue != index) {
                    20.sp
                } else {
                    22.sp
                },
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 12.dp)
                    .padding(vertical = 4.dp),
                fontFamily = fontFamily
            )
        }
    }
}