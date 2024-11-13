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
import com.theodo.apps.ipedis.accessibility.navigation.Detail
import com.theodo.apps.ipedis.accessibility.navigation.Home
import com.theodo.apps.ipedis.accessibility.navigation.List
import com.theodo.apps.ipedis.accessibility.navigation.Order
import com.theodo.apps.ipedis.accessibility.ui.screens.DetailScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.HomeScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.ListScreen
import com.theodo.apps.ipedis.accessibility.ui.screens.OrderScreen
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IpedisAndroidAccessibilityCourseTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = Home) {
                        composable<Home> {
                            HomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                goDetail = {
                                    navController.navigate(Detail)
                                },
                                goList = {
                                    navController.navigate(List)
                                },
                                goOrder = {
                                    navController.navigate(Order)
                                }
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
                    }
                }
            }
        }
    }
}
