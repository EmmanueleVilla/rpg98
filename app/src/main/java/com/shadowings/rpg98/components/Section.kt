package com.shadowings.rpg98.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
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
        modifier = Modifier,
        title = "Personaggio"
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
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
    val background = Color(0xFFBFBFBF)
    val grey = Color(0xFF808080)
    val sizePx = with(LocalDensity.current) { size.toPx() }
    val fontFamily =
        FontFamily(
            Font(
                R.font.windows
            )
        )

    Box(
        modifier = modifier
            .background(color = background)
    ) {
        Box(
            modifier = modifier
                .background(color = background)
                .padding(8.dp)
                .padding(top = 6.dp)
                .drawWithContent {
                    drawContent()
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(sizePx, sizePx),
                        end = Offset(sizePx, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(size.width, sizePx),
                        end = Offset(size.width, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(sizePx, sizePx),
                        end = Offset(size.width, sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = Color.White,
                        start = Offset(sizePx, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = grey,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height - sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = grey,
                        start = Offset(0f, 0f),
                        end = Offset(size.width - sizePx, 0f),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = grey,
                        start = Offset(0f, size.height - sizePx),
                        end = Offset(size.width - sizePx, size.height - sizePx),
                        strokeWidth = sizePx,
                    )
                    drawLine(
                        cap = StrokeCap.Square,
                        color = grey,
                        start = Offset(size.width - sizePx, 0f),
                        end = Offset(size.width - sizePx, size.height - sizePx),
                        strokeWidth = sizePx,
                    )
                }
        ) {

            Box(
                modifier = Modifier
                    .padding(8.dp + 6.dp + size)
            ) {
                content()
            }

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
    }

}