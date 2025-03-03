package com.shadowings.rpg98.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shadowings.rpg98.R

@Preview
@Composable
fun IconMenuPreview() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFBFBFBF)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconMenu(
            modifier = Modifier.fillMaxWidth(0.5f),
            text = "Sistema",
            image = R.drawable.menu_system
        )
        IconMenu(
            modifier = Modifier.fillMaxWidth(),
            text = "Sistema",
            image = R.drawable.menu_system,
            pressed = true
        )
    }
}

@Composable
fun IconMenu(
    modifier: Modifier = Modifier,
    text: String,
    image: Int,
    pressed: Boolean = false,
    onClick: () -> Unit = {}
) {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    val isPressed = remember { mutableStateOf(pressed) }
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )
    Column(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    isPressed.value = true
                    try {
                        awaitRelease()
                    } catch (e: Exception) {
                        isPressed.value = false
                    }
                },
                onTap = {
                    isPressed.value = false
                    onClick.invoke()
                }
            )
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .aspectRatio(1f)
                .padding(4.dp),
            filterQuality = FilterQuality.None,
            bitmap = ImageBitmap.imageResource(image),
            colorFilter = if (isPressed.value) ColorFilter.tint(
                Color(0xFF000080),
                BlendMode.Overlay
            ) else null,
            contentDescription = "System",
        )
        Spacer(Modifier.size(4.dp))
        Text(
            text = text,
            color = if (isPressed.value) Color.White else Color.Black,
            fontSize = 22.sp,
            minLines = 1,
            maxLines = 1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(
                    if (isPressed.value) {
                        Color(0xFF000080)
                    } else {
                        Color.Transparent
                    }
                )
                .drawWithContent {
                    drawContent()
                    if (isPressed.value) {
                        drawLine(
                            strokeWidth = 2.dp.toPx(),
                            color = Color.Yellow,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            pathEffect = pathEffect
                        )
                        drawLine(
                            strokeWidth = 2.dp.toPx(),
                            color = Color.Yellow,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            pathEffect = pathEffect
                        )
                        drawLine(
                            strokeWidth = 2.dp.toPx(),
                            color = Color.Yellow,
                            start = Offset(size.width, size.height),
                            end = Offset(0f, size.height),
                            pathEffect = pathEffect
                        )
                        drawLine(
                            strokeWidth = 2.dp.toPx(),
                            color = Color.Yellow,
                            start = Offset(0f, size.height),
                            end = Offset(0f, 0f),
                            pathEffect = pathEffect
                        )
                    }
                }
                .padding(4.dp),
            fontFamily = fontFamily
        )
    }
}