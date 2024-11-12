package com.theodo.apps.ipedis.accessibility.ui.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun CustomBadgedBox(
    badge: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    BadgedBox(
        badge = { Badge(content = badge) },
        modifier = modifier,
        content = content
    )
}

@Preview
@Composable
private fun CustomBadgedBoxPreview() = IpedisAndroidAccessibilityCourseTheme {
    CustomBadgedBox(
        badge = {
            Text("2")
        },
        content = {
            CustomIconButton(
                onClick = {},
                description = "Favorite",
                image = Icons.Default.Favorite
            )
        }
    )
}
