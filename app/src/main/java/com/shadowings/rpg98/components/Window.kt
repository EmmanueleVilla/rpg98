package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp
import com.shadowings.rpg98.R

val size = 2.dp

@Preview
@Composable
fun WindowPreview(modifier: Modifier = Modifier) {
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
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

@Composable
fun Window(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = modifier
            .background(color = Color(0xFFBFBFBF))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(size * 2)
                .align(Alignment.TopCenter)
                .background(color = Color(0xFFFFFFFF))
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(size * 2)
                .align(Alignment.CenterStart)
                .background(color = Color(0xFFFFFFFF))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(size * 2)
                .align(Alignment.BottomCenter)
                .background(color = Color(0xFF808080))
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(size * 2)
                .align(Alignment.CenterEnd)
                .background(color = Color(0xFF808080))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(size)
                .align(Alignment.TopCenter)
                .background(color = Color(0xFFDBDBDB))
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(size)
                .align(Alignment.CenterStart)
                .background(color = Color(0xFFDBDBDB))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(size)
                .align(Alignment.BottomCenter)
                .background(color = Color(0xFF000000))
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(size)
                .align(Alignment.CenterEnd)
                .background(color = Color(0xFF000000))
        )
        content()
    }
}