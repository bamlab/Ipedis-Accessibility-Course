package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.navigation.Titles
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun TitlesScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        CustomTopAppBar(
            title = {
                Text(Titles.title, Modifier)
            },
            modifier = modifier,
            navigationIcon = { },
            actions = { }
        )
        for (i in 1..20) {
            Text(
                text = "Titre numéro $i",
                modifier = Modifier,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. " +
                    "Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod non, mi. Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, " +
                    "non fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa, scelerisque vitae, consequat in, pretium a, enim. Pellentesque congue.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
private fun TitlesScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    TitlesScreen()
}
