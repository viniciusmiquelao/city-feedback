package com.cityfeedback.app.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cityfeedback.app.models.ScreenEnum
import com.cityfeedback.app.ui.components.BottomNavigationBar

@Composable
fun MainScreen(navController: NavController) {
    var currentScreen by remember { mutableStateOf(ScreenEnum.Home) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentScreen = currentScreen,
                onScreenSelected = { screen: ScreenEnum -> currentScreen = screen }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Spacer(modifier = Modifier.padding(paddingValues))
            when (currentScreen) {
                ScreenEnum.Home -> {
                    HomeScreen(navController)
                }
                ScreenEnum.Rewards -> {
                    RewardsScreen()
                }
                ScreenEnum.Profile -> {
                    ProfileScreen()
                }
            }
        }
    }
}
