package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shadowings.rpg98.R

@Preview
@Composable
fun TopBarPreview() {
    TopBar(
        Modifier.fillMaxWidth()
    )
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
    val colorStops = arrayOf(
        0.0f to Color(0xFF01017b),
        0.4f to Color(0xFF01017b),
        1f to Color(0xFF1085d2)
    )
    Box(
        modifier = modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(size * 3)
            .background(
                brush = Brush.horizontalGradient(
                    colorStops = colorStops
                )
            )
    ) {
        Text(
            text = "BitWar-98",
            fontFamily = fontFamily,
            color = Color.White,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(horizontal = size * 4)
                .align(Alignment.CenterStart)
        )

        Row(
            modifier = Modifier
                .padding(horizontal = size * 4)
                .align(Alignment.CenterEnd),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Window(
                Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .padding(4.dp)
            ) {
                Text(
                    text = "?",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
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