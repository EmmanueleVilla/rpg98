package com.shadowings.rpg98.section.system

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
    val selectedIndex = remember { mutableIntStateOf(0) }
    Window(
        modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            TopBar(title = "System")
            Column(
                verticalArrangement = Arrangement.spacedBy((-size * 2))
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy((-6).dp)
                ) {
                    RpgTab(text = "Hardware", index = 0, selectedIndex = selectedIndex)
                    RpgTab(text = "Dischi", index = 1, selectedIndex = selectedIndex)
                    RpgTab(text = "Patch", index = 2, selectedIndex = selectedIndex)
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
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