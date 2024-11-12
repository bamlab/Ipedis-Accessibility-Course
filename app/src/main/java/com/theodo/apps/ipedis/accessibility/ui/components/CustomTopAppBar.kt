package com.theodo.apps.ipedis.accessibility.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme
import com.theodo.apps.ipedis.accessibility.ui.theme.Purple40

@Composable
fun CustomTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors().copy(
        containerColor = Purple40,
        scrolledContainerColor = Purple40,
        navigationIconContentColor = Color.White,
        titleContentColor = Color.White,
        actionIconContentColor = Color.White

    )
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.containerColor)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CompositionLocalProvider(LocalContentColor provides colors.titleContentColor) {
            navigationIcon()
            title()
            actions()
        }
    }
}

@Preview
@Composable
private fun CustomTopAppBarPreview() = IpedisAndroidAccessibilityCourseTheme {
    Column {
        CustomTopAppBar(
            title = { Text("Title") },
            navigationIcon = { Text("Nav Icon") },
            actions = {
                Text("Action 1")
                Text("Action 2")
            }
        )
    }
}