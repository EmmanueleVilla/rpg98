package com.shadowings.rpg98.sections.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shadowings.rpg98.R
import com.shadowings.rpg98.components.IconMenu
import com.shadowings.rpg98.components.Loading
import com.shadowings.rpg98.components.RpgButton
import com.shadowings.rpg98.components.Section
import com.shadowings.rpg98.components.TopBar
import com.shadowings.rpg98.components.Window
import com.shadowings.rpg98.components.size
import com.shadowings.rpg98.utils.PreviewContainer
import org.koin.androidx.compose.koinViewModel

@Preview(device = Devices.PIXEL_4A)
@Composable
fun LandingPagePreview() {
    PreviewContainer {
        LandingPage()
    }
}

@Composable
fun LandingPage(
    modifier: Modifier = Modifier,
    viewModel: LandingPageVM = koinViewModel(),
    navController: NavHostController = rememberNavController()
) {
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
            TopBar(title = "OS-98")
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Section(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = size * 2),
                    title = "Informazioni"
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(size * 4),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            Modifier
                                .weight(1.0f)
                                .aspectRatio(1.0f),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth(0.75f)
                                    .aspectRatio(1.0f),
                                filterQuality = FilterQuality.None,
                                bitmap = ImageBitmap.imageResource(R.drawable.avatar),
                                contentDescription = "Avatar"
                            )
                            Spacer(Modifier.size(4.dp))
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "IdleProcess",
                                style = MaterialTheme.typography.headlineSmall,
                                textAlign = TextAlign.Center,
                                fontFamily = fontFamily,
                                color = Color.Black,
                            )

                        }
                        Column(
                            Modifier
                                .weight(2.0f)
                                .aspectRatio(2f),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Livello 2",
                                style = MaterialTheme.typography.headlineSmall,
                                textAlign = TextAlign.Left,
                                color = Color.Black,
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
                                text = "120 Bit Rimanenti",
                                style = MaterialTheme.typography.headlineSmall,
                                textAlign = TextAlign.Left,
                                fontFamily = fontFamily,
                                color = Color.Black,
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
                    title = "Stage 0"
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Benvenuto in OS-98:",
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
                            text = "Un tempo stabile e organizzato, ora è frammentato da conflitti tra processi, routine e vecchi script che lottano per sopravvivere.",
                            color = Color.Black,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            fontFamily = fontFamily
                        )
                        Spacer(Modifier.size(4.dp))
                        RpgButton(
                            modifier = Modifier
                                .height(48.dp),
                            text = "Ok"
                        )
                    }
                }
                Spacer(Modifier.size(16.dp))

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconMenu(
                            modifier = Modifier.weight(1f),
                            text = "Sistema",
                            image = R.drawable.menu_system
                        ) {
                            navController.navigate("system")
                        }
                        IconMenu(
                            modifier = Modifier.weight(1f),
                            text = "Risorse",
                            image = R.drawable.menu_resources
                        )
                        IconMenu(
                            modifier = Modifier.weight(1f),
                            text = "Network",
                            image = R.drawable.menu_globe
                        )
                    }
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconMenu(
                            modifier = Modifier.weight(1f),
                            text = "Cerca",
                            image = R.drawable.menu_search
                        )
                        IconMenu(
                            modifier = Modifier.weight(1f),
                            text = "Scansione",
                            image = R.drawable.menu_scan
                        )
                        IconMenu(
                            modifier = Modifier.weight(1f),
                            text = "Cronologia",
                            image = R.drawable.menu_history
                        )
                    }
                }
            }
        }
    }
}