package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shadowings.rpg98.R

@Preview
@Composable
fun TabbedWindowPreview() {
    val selectedIndex = remember { mutableIntStateOf(0) }
    TabbedWindow(
        tabSizes = listOf(
            120.dp,
            90.dp,
            90.dp
        ),
        titles = listOf(
            "Hardware",
            "Dischi",
            "Patch"
        ),
        selectedIndex = selectedIndex,
    )
}

@Composable
fun TabbedWindow(tabSizes: List<Dp>, titles: List<String>, selectedIndex: MutableIntState) {
    val lightGray = Color(0xFFDBDBDB)
    val darkGray = Color(0xFF808080)
    val sizePx = with(LocalDensity.current) { size.toPx() }
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
    val baseY = with(LocalDensity.current) { 32.dp.toPx() }
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFBFBFBF))
            .padding(8.dp)
            .drawWithContent {
                drawContent()
                drawLine(
                    cap = StrokeCap.Square,
                    color = Color.White,
                    start = Offset(0f, baseY + 0f),
                    end = Offset(0f, size.height - sizePx),
                    strokeWidth = sizePx,
                )
                drawLine(
                    cap = StrokeCap.Square,
                    color = Color.Black,
                    start = Offset(size.width, baseY + 0f),
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
                    start = Offset(sizePx, baseY),
                    end = Offset(sizePx, size.height - sizePx),
                    strokeWidth = sizePx,
                )
                drawLine(
                    cap = StrokeCap.Square,
                    color = darkGray,
                    start = Offset(size.width - sizePx, baseY),
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
                drawLine(
                    cap = StrokeCap.Square,
                    color = Color.White,
                    start = Offset(0f, baseY),
                    end = Offset(size.width - sizePx, baseY),
                    strokeWidth = sizePx,
                )
                drawLine(
                    cap = StrokeCap.Square,
                    color = lightGray,
                    start = Offset(sizePx, baseY + sizePx),
                    end = Offset(size.width - sizePx * 2, baseY + sizePx),
                    strokeWidth = sizePx,
                )

                data class Tab(
                    val startX: Float,
                    val endX: Float,
                    val startY: Float,
                    val drawBeginning: Boolean = true,
                )

                val bases = when (selectedIndex.intValue) {
                    0 -> {
                        listOf(
                            Tab(
                                startX = 0f - sizePx * 3,
                                endX = tabSizes[0].toPx() + sizePx * 3,
                                startY = sizePx * 2
                            ),
                            Tab(
                                startX = tabSizes[0].toPx(),
                                endX = tabSizes[0].toPx() + tabSizes[1].toPx(),
                                startY = sizePx * 5,
                                drawBeginning = false
                            ),
                            Tab(
                                startX = tabSizes[0].toPx() + tabSizes[1].toPx(),
                                endX = tabSizes[0].toPx() + tabSizes[1].toPx() + tabSizes[2].toPx(),
                                startY = sizePx * 5
                            )
                        )
                    }

                    else -> {
                        listOf(
                            Tab(
                                startX = 0f,
                                endX = tabSizes[0].toPx(),
                                startY = sizePx * 5
                            ),
                            Tab(
                                startX = tabSizes[0].toPx(),
                                endX = tabSizes[0].toPx() + tabSizes[1].toPx(),
                                startY = sizePx * 5
                            ),
                            Tab(
                                startX = tabSizes[0].toPx() + tabSizes[1].toPx(),
                                endX = tabSizes[0].toPx() + tabSizes[1].toPx() + tabSizes[2].toPx(),
                                startY = sizePx * 5
                            )
                        )
                    }
                }

                bases.forEach {
                    val baseLine = it.startX
                    val nextSize = it.endX
                    val startY = it.startY
                    val begin = it.drawBeginning

                    if (begin) {
                        drawLine(
                            cap = StrokeCap.Square,
                            color = Color.White,
                            start = Offset(
                                baseLine + sizePx * 3,
                                startY
                            ),
                            end = Offset(
                                baseLine + sizePx * 3,
                                32.dp.toPx() - sizePx
                            ),
                            strokeWidth = sizePx,
                        )
                        drawLine(
                            cap = StrokeCap.Square,
                            color = lightGray,
                            start = Offset(
                                baseLine + sizePx * 4,
                                startY
                            ),
                            end = Offset(
                                baseLine + sizePx * 4,
                                32.dp.toPx() - sizePx
                            ),
                            strokeWidth = sizePx,
                        )
                        drawLine(
                            cap = StrokeCap.Square,
                            color = Color.White,
                            start = Offset(
                                baseLine + sizePx * 4,
                                startY - sizePx
                            ),
                            end = Offset(
                                baseLine + sizePx * 4,
                                startY - sizePx
                            ),
                            strokeWidth = sizePx,
                        )
                        drawLine(
                            cap = StrokeCap.Square,
                            color = lightGray,
                            start = Offset(
                                baseLine + sizePx * 5,
                                startY - sizePx
                            ),
                            end = Offset(
                                baseLine + sizePx * 5,
                                startY - sizePx
                            ),
                            strokeWidth = sizePx,
                        )
                    }

                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(
                            baseLine + sizePx * 5 + (if (begin) 0f else sizePx),
                            startY - sizePx * 2
                        ),
                        end = Offset(
                            nextSize,
                            startY - sizePx * 2
                        ),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(
                            baseLine + sizePx * 5 + sizePx,
                            startY - sizePx
                        ),
                        end = Offset(
                            nextSize,
                            startY - sizePx
                        ),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = darkGray,
                        start = Offset(
                            nextSize + sizePx,
                            startY
                        ),
                        end = Offset(
                            nextSize + sizePx,
                            32.dp.toPx() - sizePx
                        ),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(
                            nextSize + sizePx,
                            startY - sizePx
                        ),
                        end = Offset(
                            nextSize + sizePx,
                            startY - sizePx
                        ),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(
                            nextSize + sizePx * 2,
                            startY
                        ),
                        end = Offset(
                            nextSize + sizePx * 2,
                            32.dp.toPx() - sizePx
                        ),
                        strokeWidth = sizePx,
                    )
                }


                if (selectedIndex.intValue == 0) {
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx * 1, 32.dp.toPx()),
                        end = Offset(sizePx * 1, 32.dp.toPx()),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color(0xFFBFBFBF),
                        start = Offset(sizePx * 2, 32.dp.toPx()),
                        end = Offset(tabSizes[0].toPx() + sizePx * 5, 32.dp.toPx()),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color(0xFFBFBFBF),
                        start = Offset(sizePx * 2, 32.dp.toPx() + sizePx),
                        end = Offset(tabSizes[0].toPx() + sizePx * 5, 32.dp.toPx() + sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.Black,
                        start = Offset(tabSizes[0].toPx() + sizePx * 5, 32.dp.toPx()),
                        end = Offset(tabSizes[0].toPx() + sizePx * 5, 32.dp.toPx() + sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = darkGray,
                        start = Offset(tabSizes[0].toPx() + sizePx * 4, 32.dp.toPx()),
                        end = Offset(tabSizes[0].toPx() + sizePx * 4, 32.dp.toPx() + sizePx),
                        strokeWidth = sizePx,
                    )
                }
            }
    ) {
        Row {
            titles.forEachIndexed { index, title ->
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = if (selectedIndex.intValue == index) 22.sp else 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(tabSizes[index])
                        .height(32.dp)
                        .padding(horizontal = 12.dp)
                        .padding(vertical = 4.dp)
                        .padding(top = if (selectedIndex.intValue == index) 0.dp else 5.dp),
                    fontFamily = fontFamily
                )
            }

        }
    }
}