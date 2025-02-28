package com.shadowings.rpg98.sections.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shadowings.rpg98.components.Section
import com.shadowings.rpg98.components.TopBar
import com.shadowings.rpg98.components.Window
import com.shadowings.rpg98.components.size

@Preview
@Composable
fun LandingPagePreview() {
    LandingPage()
}

@Composable
fun LandingPage(modifier: Modifier = Modifier) {
    Window(
        modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            TopBar()

            Section(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = size * 2),
                title = "Personaggio"
            ) {
                Row {
                    Box(
                        Modifier
                            .weight(1.0f)
                            .height(100.dp)
                            .background(color = Color(0xFF018083))
                    ) {

                    }
                    Column(
                        Modifier.weight(2.0f)
                    ) {

                    }
                }
            }
        }
    }
}