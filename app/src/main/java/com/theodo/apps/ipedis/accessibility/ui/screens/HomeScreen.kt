package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.theodo.apps.ipedis.accessibility.navigation.Canvas
import com.theodo.apps.ipedis.accessibility.navigation.Detail
import com.theodo.apps.ipedis.accessibility.navigation.Offer
import com.theodo.apps.ipedis.accessibility.navigation.Order
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
            onClick = events.goDetail,
            modifier = Modifier.padding(8.dp)
        )
        CustomIconButton(
            image = Icons.Default.Info,
            onClick = events.goDetail
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomArticle(
            name = "Article 1"
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier.horizontalScroll(rememberScrollState())) {
            CustomButton(
                text = "Voir la liste",
                onClick = events.goList,
                modifier = Modifier.padding(8.dp)
            )
            CustomButton(
                text = "Voir l'ordre",
                onClick = events.goOrder,
                modifier = Modifier.padding(8.dp)
            )
            CustomButton(
                text = "Voir les offres",
                onClick = events.goOffer,
                modifier = Modifier.padding(8.dp)
            )
            CustomButton(
                text = "Voir le Canvas",
                onClick = events.goCanvas,
                modifier = Modifier.padding(8.dp)
            )
            CustomButton(
                text = "Titres",
                onClick = events.goToTitles,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.weight(0.5f))
    }
}

data class HomeScreenEvents(
    val goDetail: () -> Unit,
    val goList: () -> Unit,
    val goOrder: () -> Unit,
    val goOffer: () -> Unit,
    val goCanvas: () -> Unit,
    val goToTitles: () -> Unit
) {
    companion object {
        fun none() = HomeScreenEvents(
            goDetail = {},
            goList = {},
            goOrder = {},
            goOffer = {},
            goCanvas = {},
            goToTitles = {}
        )

        fun default(navController: NavController) = HomeScreenEvents(
            goDetail = { navController.navigate(Detail) },
            goList = { navController.navigate(com.theodo.apps.ipedis.accessibility.navigation.List) },
            goOrder = { navController.navigate(Order) },
            goOffer = { navController.navigate(Offer) },
            goCanvas = { navController.navigate(Canvas) },
            goToTitles = { navController.navigate(Titles) }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    HomeScreen(events = HomeScreenEvents.none())
}
