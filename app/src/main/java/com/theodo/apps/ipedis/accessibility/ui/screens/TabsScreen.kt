package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.navigation.Tabs
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun TabsScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        CustomTopAppBar(
            title = {
                Text(Tabs.title, Modifier)
            },
            modifier = Modifier,
            navigationIcon = { },
            actions = { }
        )
        LoremIpsumScreen()
    }
}

@Composable
fun LoremIpsumScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Tab 1", "Tab 2")
    val loremTexts = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    )

    Scaffold(
        topBar = {
            CustomTabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    CustomTab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = loremTexts[selectedTabIndex],
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CustomTabRow(selectedTabIndex: Int, content: @Composable RowScope.() -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
    ) {
        content()
    }
}

@Composable
private fun RowScope.CustomTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable (ColumnScope.() -> Unit)
) {
    Column(
        modifier =
        modifier
            .clickable(
                onClick = onClick,
                enabled = enabled
            )
            .border(
                width = if (selected) 4.dp else 0.dp,
                color = MaterialTheme.colorScheme.primary
            )
            .padding(8.dp)
            .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = text
    )
}

@Preview
@Composable
private fun TabsScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    TabsScreen()
}
