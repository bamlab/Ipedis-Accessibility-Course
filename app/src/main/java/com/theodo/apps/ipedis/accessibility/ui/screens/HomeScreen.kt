package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.ui.components.CustomArticle
import com.theodo.apps.ipedis.accessibility.ui.components.CustomButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomIconButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column {
        CustomTopAppBar(
            title = {
                Text("Home")
            },
            modifier = modifier,
            navigationIcon = { },
            actions = { }
        )

        Spacer(modifier = Modifier.weight(0.5f))
        CustomButton(
            text = "Voir le détail",
            onClick = onClick,
            modifier = Modifier
        )
        CustomIconButton(
            image = Icons.Default.Info,
            onClick = onClick
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomArticle(
            name = "Article 1"
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    HomeScreen(onClick = {})
}
