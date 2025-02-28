package com.shadowings.rpg98.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun Rpg98Theme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = darkColorScheme().copy(
            background = Color(0xFF018083),
            surface = Color(0xFF018083),
        ),
        typography = Typography,
        content = content
    )
}