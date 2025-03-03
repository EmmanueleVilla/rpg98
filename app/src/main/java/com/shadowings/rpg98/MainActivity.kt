package com.shadowings.rpg98

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shadowings.rpg98.components.size
import com.shadowings.rpg98.section.system.SystemPage
import com.shadowings.rpg98.sections.landing.LandingPage
import com.shadowings.rpg98.ui.theme.Rpg98Theme
import org.koin.compose.KoinContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.GREEN
            ),
            navigationBarStyle = SystemBarStyle.dark(
                android.graphics.Color.GREEN
            )
        )

        setContent {
            KoinContext() {
                Rpg98Theme {
                    val navController = rememberNavController()
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color(0xFF018083))
                                .padding(innerPadding)
                                .padding(size * 2)
                        ) {
                            NavHost(
                                modifier = Modifier,
                                startDestination = "landing",
                                navController = navController
                            ) {
                                composable("landing") {
                                    LandingPage(
                                        modifier = Modifier.fillMaxSize(),
                                        navController = navController
                                    )
                                }
                                composable("system",
                                    enterTransition = {
                                        scaleIn(
                                            initialScale = 0.5f,
                                            animationSpec = tween(200)
                                        )
                                    },
                                    exitTransition = { fadeOut(animationSpec = tween(150)) }
                                ) {
                                    SystemPage()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}