package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.navigation.Order
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun OrderScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        CustomTopAppBar(
            title = {
                Text(Order.title)
            },
            modifier = Modifier,
            navigationIcon = { },
            actions = { }
        )

        TraversalGroupDemo()
    }
}

@Preview
@Composable
private fun OrderScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    OrderScreen()
}

@Composable
private fun CardBox(
    topSampleText: String,
    bottomSampleText: String,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Column {
            Text(topSampleText)
            Text(bottomSampleText)
        }
    }
}

@Composable
private fun TraversalGroupDemo() {
    val topSampleText1 = "This sentence is in "
    val bottomSampleText1 = "the left column."
    val topSampleText2 = "This sentence is "
    val bottomSampleText2 = "on the right."
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardBox(
            topSampleText1,
            bottomSampleText1
        )
        CardBox(
            topSampleText2,
            bottomSampleText2
        )
    }
}
