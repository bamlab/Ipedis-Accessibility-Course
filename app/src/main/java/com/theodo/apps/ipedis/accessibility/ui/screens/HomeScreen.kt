package com.theodo.apps.ipedis.accessibility.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.ui.components.CustomButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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
        val context = LocalContext.current
        CustomButton(
            text = "Click me",
            onClick = { Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show() },
            modifier = Modifier
        )
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    HomeScreen()
}
