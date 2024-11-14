package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.R
import com.theodo.apps.ipedis.accessibility.navigation.Detail
import com.theodo.apps.ipedis.accessibility.ui.components.CustomBadgedBox
import com.theodo.apps.ipedis.accessibility.ui.components.CustomButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomIconButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, back: () -> Boolean) {
    var moreVisible by remember { mutableStateOf(false) }
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
        Spacer(modifier = Modifier.height(100.dp))
        Text("Nos offres", style = MaterialTheme.typography.headlineMedium)
        Image(
            painter = painterResource(id = R.drawable.nosoffres),
            contentDescription = imageContentDescription,
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.FillHeight
        )
        CustomButton(text = "En savoir plus", onClick = { moreVisible = true })
        if (moreVisible) {
            Text("Voici plus d'informations sur nos offres")
        }
    }
}

private val imageContentDescription = "Nos offres d'emploi"

@Preview
@Composable
private fun DetailScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    DetailScreen(back = { true })
}
