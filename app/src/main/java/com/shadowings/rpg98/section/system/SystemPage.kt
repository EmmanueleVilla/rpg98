package com.shadowings.rpg98.section.system

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shadowings.rpg98.R
import com.shadowings.rpg98.components.RpgTab
import com.shadowings.rpg98.components.TabWindow
import com.shadowings.rpg98.components.TopBar
import com.shadowings.rpg98.components.Window
import com.shadowings.rpg98.components.size
import com.shadowings.rpg98.utils.PreviewContainer
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun SystemPagePreview() {
    PreviewContainer {
        SystemPage()
    }
}

@Composable
fun SystemPage(
    modifier: Modifier = Modifier,
    viewModel: SystemPageVM = koinViewModel()
) {
    val lightGray = Color(0xFFDBDBDB)
    val darkGray = Color(0xFF808080)
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
    val sizePx = with(LocalDensity.current) { size.toPx() }
    val selectedIndex = remember { mutableIntStateOf(1) }
    Window(
        modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            TopBar(title = "System")
            Column(
                //verticalArrangement = Arrangement.spacedBy(-size)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.spacedBy((-6).dp)
                    ) {
                        RpgTab(
                            text = "Hardware",
                            modifier = Modifier.width(120.dp),
                            index = 0,
                            selectedIndex = selectedIndex
                        )
                        RpgTab(
                            text = "Dischi",
                            modifier = Modifier.width(90.dp),
                            index = 1,
                            selectedIndex = selectedIndex
                        )
                        RpgTab(
                            text = "Patch",
                            modifier = Modifier.width(90.dp),
                            index = 2,
                            selectedIndex = selectedIndex
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                        .drawWithContent {
                            drawContent()
                            if (selectedIndex.intValue == 0) {
                                drawLine(
                                    color = Color.White,
                                    start = Offset(120.dp.toPx() - sizePx, 0f),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = sizePx,
                                )
                                drawLine(
                                    color = lightGray,
                                    start = Offset(120.dp.toPx() - sizePx, sizePx),
                                    end = Offset(size.width - sizePx, sizePx),
                                    strokeWidth = sizePx,
                                )
                                drawLine(
                                    color = Color.Black,
                                    start = Offset(120.dp.toPx(), -sizePx),
                                    end = Offset(120.dp.toPx(), sizePx * 2),
                                    strokeWidth = sizePx,
                                )
                                drawLine(
                                    color = darkGray,
                                    start = Offset(120.dp.toPx() - sizePx, -sizePx),
                                    end = Offset(120.dp.toPx() - sizePx, sizePx * 2),
                                    strokeWidth = sizePx,
                                )
                            }
                            if (selectedIndex.intValue == 1) {
                                drawLine(
                                    color = Color.White,
                                    start = Offset(0f, 0f),
                                    end = Offset(120.dp.toPx() - sizePx * 2.5f, 0f),
                                    strokeWidth = sizePx,
                                )
                                drawLine(
                                    color = lightGray,
                                    start = Offset(sizePx, sizePx),
                                    end = Offset(120.dp.toPx() - sizePx * 1.5f, sizePx),
                                    strokeWidth = sizePx,
                                )

                                drawLine(
                                    color = Color.White,
                                    start = Offset(204.dp.toPx() - sizePx, 0f),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = sizePx,
                                )
                                drawLine(
                                    color = lightGray,
                                    start = Offset(204.dp.toPx() - sizePx, sizePx),
                                    end = Offset(size.width - sizePx, sizePx),
                                    strokeWidth = sizePx,
                                )
                                drawLine(
                                    color = Color.Black,
                                    start = Offset(204.dp.toPx(), -sizePx),
                                    end = Offset(204.dp.toPx(), sizePx * 2),
                                    strokeWidth = sizePx,
                                )
                                drawLine(
                                    color = darkGray,
                                    start = Offset(204.dp.toPx() - sizePx, -sizePx),
                                    end = Offset(204.dp.toPx() - sizePx, sizePx * 2),
                                    strokeWidth = sizePx,
                                )
                            }
                        }
                ) {
                    TabWindow(
                        Modifier.fillMaxSize()
                    )
                }

                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                }
            }
        }
    }
}