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
import com.theodo.apps.ipedis.accessibility.ui.screens.HomeScreen
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme
import kotlinx.serialization.Serializable

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
                            HomeScreen(Modifier.padding(innerPadding))
                        }
                    }

                }
            }
        }
    }
}

@Serializable
object Home