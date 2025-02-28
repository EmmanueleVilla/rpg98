package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shadowings.rpg98.R

@Preview
@Composable
fun SectionPreview(modifier: Modifier = Modifier) {
    Section(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        title = "Personaggio"
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color(0xFF018083))
        ) {

        }
    }
}

@Composable
fun Section(
    modifier: Modifier = Modifier,
    title: String = "",
    content: @Composable BoxScope.() -> Unit
) {
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
    Box(
        modifier = modifier
            .background(color = Color(0xFFBFBFBF))
            .padding(start = size, top = size)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 6.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .border(size, Color.White)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 8.dp - size,
                        start = 8.dp - size,
                        end = 8.dp + size,
                        bottom = 8.dp + size
                    )
                    .border(size, Color(0xFF808080))
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .background(color = Color(0xFFBFBFBF))
                .padding(horizontal = 6.dp)
        ) {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center),
                fontFamily = fontFamily
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 8.dp + size + 8.dp,
                    top = 8.dp + size + 12.dp + 8.dp,
                    end = 8.dp + size * 2 + 8.dp,
                )
        ) {
            content()
        }
    }
}