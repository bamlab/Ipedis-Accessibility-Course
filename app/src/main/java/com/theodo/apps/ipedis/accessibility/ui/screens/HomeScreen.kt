package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.theodo.apps.ipedis.accessibility.navigation.Canvas
import com.theodo.apps.ipedis.accessibility.navigation.Detail
import com.theodo.apps.ipedis.accessibility.navigation.FormatedTexts
import com.theodo.apps.ipedis.accessibility.navigation.Forms
import com.theodo.apps.ipedis.accessibility.navigation.Offer
import com.theodo.apps.ipedis.accessibility.navigation.Order
import com.theodo.apps.ipedis.accessibility.navigation.Tabs
import com.theodo.apps.ipedis.accessibility.navigation.Titles
import com.theodo.apps.ipedis.accessibility.ui.components.CustomArticle
import com.theodo.apps.ipedis.accessibility.ui.components.CustomButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomIconButton
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    events: HomeScreenEvents
) {
    val buttons = mapOf(
        "Détails" to events.Détails,
        "Liste" to events.Liste,
        "Ordre" to events.Ordre,
        "Offres" to events.Offres,
        "Graphique" to events.Graphique,
        "Titres" to events.Titres,
        "Formats" to events.Formats,
        "Onglets" to events.Onglets,
        "Formulaires" to events.Formulaires
    )
    Column(modifier.verticalScroll(rememberScrollState())) {
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
            onClick = events.Détails,
            modifier = Modifier.padding(8.dp)
        )
        CustomIconButton(
            image = Icons.Default.Info,
            onClick = events.Détails
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomArticle(
            name = "Article 1"
        )
        Spacer(modifier = Modifier.weight(1f))
        buttons.forEach { (name, function) ->
            Button(
                onClick = function,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(name)
            }
        }

        Spacer(modifier = Modifier.weight(0.5f))
    }
}

data class HomeScreenEvents(
    val Détails: () -> Unit,
    val Liste: () -> Unit,
    val Ordre: () -> Unit,
    val Offres: () -> Unit,
    val Graphique: () -> Unit,
    val Titres: () -> Unit,
    val Formats: () -> Unit,
    val Onglets: () -> Unit,
    val Formulaires: () -> Unit
) {
    companion object {
        fun none() = HomeScreenEvents(
            Détails = {},
            Liste = {},
            Ordre = {},
            Offres = {},
            Graphique = {},
            Titres = {},
            Formats = {},
            Onglets = {},
            Formulaires = {}
        )

        fun default(navController: NavController) = HomeScreenEvents(
            Détails = { navController.navigate(Detail) },
            Liste = { navController.navigate(com.theodo.apps.ipedis.accessibility.navigation.List) },
            Ordre = { navController.navigate(Order) },
            Offres = { navController.navigate(Offer) },
            Graphique = { navController.navigate(Canvas) },
            Titres = { navController.navigate(Titles) },
            Formats = { navController.navigate(FormatedTexts) },
            Onglets = { navController.navigate(Tabs) },
            Formulaires = { navController.navigate(Forms) }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    HomeScreen(events = HomeScreenEvents.none())
}
