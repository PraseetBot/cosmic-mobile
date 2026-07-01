package com.cosmic.mobile.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.cosmic.mobile.ui.navigation.CosmicNavigation
import com.cosmic.mobile.ui.theme.CosmicMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CosmicMobileTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CosmicApp()
                }
            }
        }
    }
}

@Composable
fun CosmicApp() {
    val navController = rememberNavController()
    CosmicNavigation(navController = navController)
}
