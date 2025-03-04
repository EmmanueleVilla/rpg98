package com.shadowings.rpg98.section.system

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shadowings.rpg98.R
import com.shadowings.rpg98.components.TabbedWindow
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
    val selectedIndex = remember { mutableIntStateOf(0) }
    Window(
        modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            TopBar(title = "System")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
            ) {

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
        }
    }
}