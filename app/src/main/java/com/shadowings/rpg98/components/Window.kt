package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val size = 2.dp

@Preview
@Composable
fun WindowPreview(modifier: Modifier = Modifier) {
    Window(
        modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            TopBar()
        }
    }
}

@Composable
fun Window(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
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