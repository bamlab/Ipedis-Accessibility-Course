package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.R
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun OfferScreen(modifier: Modifier = Modifier, back: () -> Boolean) {
    Column(modifier = modifier) {
        IconButton(
            onClick = { back() }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Retour écran précédent"
            )
        }

        val imageContentDescription = "Nos offres d'emploi"

        Image(
            painter = painterResource(id = R.drawable.nosoffresfrancetravail),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        LazyColumn {
            items(count = 4) {
                Text(
                    text = "Offre d'emploi n°$it",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.height(50.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun OfferScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    OfferScreen(back = { true })
}
