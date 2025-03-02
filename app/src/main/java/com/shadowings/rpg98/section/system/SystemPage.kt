package com.shadowings.rpg98.section.system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.shadowings.rpg98.R
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF018083))
            .padding(size * 2)
    ) {
        Window(
            modifier.fillMaxSize()
        ) {
            Column(
                Modifier.fillMaxSize()
            ) {
                TopBar()
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // TODO TABS HERE
                }
            }
        }
    }
}