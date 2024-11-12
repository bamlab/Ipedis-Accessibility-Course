package com.theodo.apps.ipedis.accessibility.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme
import com.theodo.apps.ipedis.accessibility.ui.theme.Purple40

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = Color.White,
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(Purple40)
            .padding(8.dp)
            .padding(horizontal = 12.dp)
            .customClick(onClick)
    )
}

@Preview
@Composable
private fun CustomButtonPreview() = IpedisAndroidAccessibilityCourseTheme {
    Column {
        CustomButton(
            text = "toto",
            onClick = {}
        )
        Button(onClick = {}) {
            Text("toto")
        }
    }
}
