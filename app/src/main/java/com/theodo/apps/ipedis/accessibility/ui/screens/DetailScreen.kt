package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.navigation.Detail
import com.theodo.apps.ipedis.accessibility.ui.components.CustomBadgedBox
import com.theodo.apps.ipedis.accessibility.ui.components.CustomIconButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, back: () -> Boolean) {
    Column {
        CustomTopAppBar(
            title = {
                Text(Detail.title)
            },
            modifier = modifier,
            navigationIcon = {
                CustomIconButton(
                    image = Icons.AutoMirrored.Filled.ArrowBack,
                    onClick = { back() }
                )
            },
            actions = {
                CustomBadgedBox(
                    badge = {
                        Text("2")
                    },
                    content = {
                        CustomIconButton(
                            onClick = {},
                            image = Icons.Default.Favorite
                        )
                    }
                )
            }
        )

        Text("Ceci est la page de détail")
    }
}

@Preview
@Composable
private fun DetailScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    DetailScreen(back = { true })
}
