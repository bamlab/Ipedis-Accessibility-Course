package com.theodo.apps.ipedis.accessibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theodo.apps.ipedis.accessibility.navigation.Canvas
import com.theodo.apps.ipedis.accessibility.navigation.Detail
import com.theodo.apps.ipedis.accessibility.navigation.FormatedTexts
import com.theodo.apps.ipedis.accessibility.navigation.Home
import com.theodo.apps.ipedis.accessibility.navigation.List
import com.theodo.apps.ipedis.accessibility.navigation.Offer
import com.theodo.apps.ipedis.accessibility.navigation.Order
import com.theodo.apps.ipedis.accessibility.navigation.Tabs
import com.theodo.apps.ipedis.accessibility.navigation.Titles
import com.theodo.apps.ipedis.accessibility.ui.screens.CanvasScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.DetailScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.FormatedTextsScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.HomeScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.HomeScreenEvents
import com.theodo.apps.ipedis.accessibility.ui.screens.ListScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.OfferScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.OrderScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.TabsScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.TitlesScreen
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

class MainActivity : ComponentActivity() {

    companion object {
        /**
         * The screen to launch when the app is started.
         * You can change this value to any of the [Screen] objects in order to deploy and try your changes more easily.
         */
        private val launcherScreen = Tabs
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IpedisAndroidAccessibilityCourseTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = launcherScreen) {
                        composable<Home> {
                            HomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                events = HomeScreenEvents.default(navController)
                            )
                        }
                        composable<List> {
                            ListScreen(Modifier.padding(innerPadding))
                        }
                        composable<Order> {
                            OrderScreen(Modifier.padding(innerPadding))
                        }
                        composable<Detail> {
                            DetailScreen(Modifier.padding(innerPadding)) {
                                navController.popBackStack()
                            }
                        }
                        composable<Offer> {
                            OfferScreen(Modifier.padding(innerPadding)) {
                                navController.popBackStack()
                            }
                        }
                        composable<Canvas> {
                            CanvasScreen(Modifier.padding(innerPadding))
                        }
                        composable<Titles> {
                            TitlesScreen(Modifier.padding(innerPadding))
                        }
                        composable<FormatedTexts> {
                            FormatedTextsScreen(Modifier.padding(innerPadding))
                        }
                        composable<Tabs> {
                            TabsScreen(Modifier.padding(innerPadding))
                        }
                    }
                }
            }
        }
    }
}
