package com.shadowings.rpg98.sections.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shadowings.rpg98.R
import com.shadowings.rpg98.components.Loading
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
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
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
                Row(
                    horizontalArrangement = Arrangement.spacedBy(size * 4),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        Modifier
                            .weight(1.0f)
                            .aspectRatio(1.0f)
                            .background(color = Color(0xFF018083)),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "LVL",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "2",
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontFamily
                        )
                    }
                    Column(
                        Modifier.weight(2.0f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Angelicaah",
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontFamily
                        )
                        Spacer(Modifier.height(12.dp))
                        Loading(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(32.dp),
                            progress = 0.75f
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "120/250 xp",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily
                        )
                    }
                }
            }
        }
    }
}