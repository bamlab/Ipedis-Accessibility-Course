package com.theodo.apps.ipedis.accessibility.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.navigation.List
import com.theodo.apps.ipedis.accessibility.ui.components.CustomListItem
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    Column {
        CustomTopAppBar(
            title = {
                Text(List.title)
            },
            modifier = modifier,
            navigationIcon = { },
            actions = { }
        )

        val context = LocalContext.current
        LazyColumn {
            items(10) {
                CustomListItem(
                    name = "Item $it",
                    modifier = Modifier,
                    onClick = {
                        Toast.makeText(context, "Item $it clicked", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    HomeScreen()
}
