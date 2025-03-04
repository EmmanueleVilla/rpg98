package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    val selectedIndex = remember { mutableIntStateOf(2) }
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
                if (selectedIndex.intValue == 0) {
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(tabSizes[0].toPx() + sizePx * 4, baseY),
                        end = Offset(size.width - sizePx, baseY),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(tabSizes[0].toPx() + sizePx * 5, baseY + sizePx),
                        end = Offset(size.width - sizePx * 2, baseY + sizePx),
                        strokeWidth = sizePx,
                    )
                }
                if (selectedIndex.intValue == 1) {
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(0f, baseY),
                        end = Offset(tabSizes[0].toPx(), baseY),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(tabSizes[0].toPx() + tabSizes[1].toPx() + sizePx * 5, baseY),
                        end = Offset(size.width - sizePx * 2, baseY),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx, baseY + sizePx),
                        end = Offset(tabSizes[0].toPx(), baseY + sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(
                            tabSizes[0].toPx() + tabSizes[1].toPx() + sizePx * 5,
                            baseY + sizePx
                        ),
                        end = Offset(size.width - sizePx * 2, baseY + sizePx),
                        strokeWidth = sizePx,
                    )
                }
                if (selectedIndex.intValue == 2) {
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(0f, baseY),
                        end = Offset(tabSizes[0].toPx() + tabSizes[1].toPx(), baseY),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(
                            tabSizes[0].toPx() + tabSizes[1].toPx() + tabSizes[2].toPx() + sizePx * 5,
                            baseY
                        ),
                        end = Offset(size.width - sizePx * 2, baseY),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(sizePx, baseY + sizePx),
                        end = Offset(tabSizes[0].toPx() + tabSizes[1].toPx(), baseY + sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = lightGray,
                        start = Offset(
                            tabSizes[0].toPx() + tabSizes[1].toPx() + tabSizes[2].toPx() + sizePx * 5,
                            baseY + sizePx
                        ),
                        end = Offset(size.width - sizePx * 2, baseY + sizePx),
                        strokeWidth = sizePx,
                    )
                }


                data class Tab(
                    val startX: Float,
                    val endX: Float,
                    val startY: Float,
                    val drawBeginning: Boolean = true,
                    val drawEnd: Boolean = true
                )

                val sel = selectedIndex.intValue

                val bases = List(tabSizes.size) { index ->
                    Tab(
                        startX = tabSizes.subList(0, index)
                            .map { it.toPx() }.sum() - if (sel == index) sizePx * 3 else 0f,
                        endX = tabSizes.subList(0, (index + 1))
                            .map { it.toPx() }.sum() + if (sel == index) sizePx * 3 else 0f,
                        startY = sizePx * if (sel == index) 2 else 5,
                        drawEnd = sel != (index + 1),
                        drawBeginning = sel != (index - 1)
                    )
                }

                bases.forEach {
                    val baseLine = it.startX
                    val nextSize = it.endX
                    val startY = it.startY
                    val begin = it.drawBeginning
                    val end = it.drawEnd

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
                    if (end) {
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
                }

                val addEndPointX =
                    tabSizes.subList(0, selectedIndex.intValue + 1).map { it.toPx() }
                        .sum() + sizePx * 4
                val addStartPointX =
                    tabSizes.subList(0, selectedIndex.intValue).map { it.toPx() }
                        .sum() + sizePx

                drawLine(
                    cap = StrokeCap.Square,
                    color = Color.Black,
                    start = Offset(addEndPointX + sizePx, 32.dp.toPx()),
                    end = Offset(addEndPointX + sizePx, 32.dp.toPx() + sizePx),
                    strokeWidth = sizePx,
                )
                drawLine(
                    cap = StrokeCap.Square,
                    color = darkGray,
                    start = Offset(addEndPointX, 32.dp.toPx()),
                    end = Offset(addEndPointX, 32.dp.toPx() + sizePx),
                    strokeWidth = sizePx,
                )
                drawLine(
                    cap = StrokeCap.Square,
                    color = lightGray,
                    start = Offset(
                        addStartPointX,
                        32.dp.toPx()
                    ),
                    end = Offset(
                        addStartPointX,
                        32.dp.toPx() + sizePx
                    ),
                    strokeWidth = sizePx,
                )
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
                        .padding(start = 8.dp)
                        .clickable {
                            selectedIndex.value = index
                        }
                        .padding(top = if (selectedIndex.intValue == index) 0.dp else 5.dp),
                    fontFamily = fontFamily
                )
            }

        }
    }
}