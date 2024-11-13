package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.ui.components.CustomArticle
import com.theodo.apps.ipedis.accessibility.ui.components.CustomButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomIconButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    goDetail: () -> Unit = {},
    goList: () -> Unit = {},
    goOrder: () -> Unit = {}
) {
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
            onClick = goDetail,
            modifier = Modifier.padding(8.dp)
        )
        CustomIconButton(
            image = Icons.Default.Info,
            onClick = goDetail
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomArticle(
            name = "Article 1"
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            text = "Voir la liste",
            onClick = goList,
            modifier = Modifier.padding(8.dp)
        )
        CustomButton(
            text = "Voir l'ordre",
            onClick = goOrder,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    HomeScreen()
}
