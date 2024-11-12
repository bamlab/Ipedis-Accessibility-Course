package com.theodo.apps.ipedis.accessibility.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun CustomIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null,
    image: ImageVector
) {
    Icon(
        imageVector = image,
        contentDescription = description,
        modifier =
        modifier
            .size(48.dp)
            .padding(12.dp)
            .customClick(onClick)
    )
}

@Preview
@Composable
private fun CustomIconButtonPreview() = IpedisAndroidAccessibilityCourseTheme {
    CustomIconButton(
        onClick = {},
        description = "Favorite",
        image = Icons.Default.Favorite
    )
}
