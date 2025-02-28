package com.shadowings.rpg98.sections.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        Image(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .aspectRatio(1.0f),
                            filterQuality = FilterQuality.None,
                            bitmap = ImageBitmap.imageResource(R.drawable.avatar),
                            contentDescription = "Avatar"
                        )
                        Spacer(Modifier.size(4.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "lvl 2",
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center,
                            fontFamily = fontFamily
                        )

                    }
                    Column(
                        Modifier.weight(2.0f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "r4m.exe",
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Left,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontFamily
                        )
                        Loading(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(32.dp),
                            progress = 0.75f
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "120 Exp Rimanente",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Left,
                            fontFamily = fontFamily
                        )
                    }
                }
            }
            Spacer(Modifier.size(16.dp))
            Section(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = size * 2),
                title = "Stage I"
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Boot Sector Corrotto:",
                        color = Color.Black,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        fontFamily = fontFamily
                    )
                    Text(
                        text = "Il sistema operativo sta tentando di eseguire un avvio pulito, ma un errore critico ha interrotto il processo. Difenditi dai protocolli di ripristino automatico!",
                        color = Color.Black,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontFamily = fontFamily
                    )
                    Spacer(Modifier.size(4.dp))
                    Window(
                        Modifier
                            .height(48.dp)
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "Combatti!",
                            color = Color.Black,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            fontFamily = fontFamily
                        )
                    }
                }
            }
            Spacer(Modifier.size(16.dp))
            Box(
                Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Window(
                    Modifier
                        .height(48.dp)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Sistema",
                        color = Color.Black,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        fontFamily = fontFamily
                    )
                }
            }
            Box(
                Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Window(
                    Modifier
                        .height(48.dp)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Risorse",
                        color = Color.Black,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        fontFamily = fontFamily
                    )
                }
            }
            Box(
                Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Window(
                    Modifier
                        .height(48.dp)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Scansione",
                        color = Color.Black,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        fontFamily = fontFamily
                    )
                }
            }
            Box(
                Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Window(
                    Modifier
                        .height(48.dp)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Cronologia",
                        color = Color.Black,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        fontFamily = fontFamily
                    )
                }
            }
        }
    }
}