package com.shadowings.rpg98

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shadowings.rpg98.section.system.SystemPage
import com.shadowings.rpg98.sections.landing.LandingPage
import com.shadowings.rpg98.ui.theme.Rpg98Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                Color.GREEN
            ),
            navigationBarStyle = SystemBarStyle.dark(
                Color.GREEN
            )
        )

        setContent {
            Rpg98Theme {
                val controller = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        startDestination = "landing",
                        navController = controller
                    ) {
                        composable("landing") {
                            LandingPage()
                        }
                        composable("sytem") {
                            SystemPage()
                        }
                    }
                }
            }
        }
    }
}