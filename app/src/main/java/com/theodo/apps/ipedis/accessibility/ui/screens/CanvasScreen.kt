package com.theodo.apps.ipedis.accessibility.ui.screens

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CanvasScreen(modifier: Modifier = Modifier) {
    LinesOfCodeGraph(lines = listOf(30, 12, 2, 34, 50), modifier)
}

@Composable
fun LinesOfCodeGraph(lines: List<Int>, modifier: Modifier = Modifier) {
    val maxLines = lines.maxOrNull() ?: 1
    val barColor = Color.Blue
    val backgroundColor = Color.DarkGray

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Lignes de code par semaine",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.semantics { heading() }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 4.dp)
            ) {
                val barWidth = size.width / lines.size
                lines.forEachIndexed { index, lineCount ->
                    val barHeight = (lineCount.toFloat() / maxLines) * size.height
                    val xOffset = index * barWidth
                    val yOffset = size.height - barHeight

                    drawIntoCanvas { canvas ->
                        canvas.drawRoundRect(
                            left = xOffset + 4.dp.toPx(),
                            top = yOffset,
                            right = xOffset + barWidth - 4.dp.toPx(),
                            bottom = size.height,
                            radiusX = 4.dp.toPx(),
                            radiusY = 4.dp.toPx(),
                            paint = androidx.compose.ui.graphics.Paint().apply { color = barColor }
                        )
                    }

                    // Draw text annotations for each bar
                    translate(left = xOffset + barWidth / 2) {
                        drawIntoCanvas {
                            it.nativeCanvas.drawText(
                                "$lineCount lignes",
                                0f,
                                yOffset - 8.dp.toPx(),
                                Paint().apply {
                                    color = Color.White.toArgb()
                                    textSize = 12.sp.toPx()
                                    textAlign = android.graphics.Paint.Align.CENTER
                                }
                            )
                            it.nativeCanvas.drawText(
                                "Semaine ${index + 1}",
                                0f,
                                size.height + 12.dp.toPx(),
                                Paint().apply {
                                    color = Color.White.toArgb()
                                    textSize = 12.sp.toPx()
                                    textAlign = android.graphics.Paint.Align.CENTER
                                }
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomStart)
            ) {
                Box(
                    modifier = Modifier
                        .height(238.dp)
                        .fillMaxWidth()
                        .semantics {
                            contentDescription = lines
                                .mapIndexed { _, lineCount ->
                                    "$lineCount lignes, "
                                }
                                .reduce(String::plus)
                        }
                )
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .fillMaxWidth()
                        .semantics {
                            contentDescription = List(lines.size) { index ->
                                "Semaine ${index + 1},  "
                            }
                                .reduce(String::plus)
                        }
                )
            }
        }
    }
}
