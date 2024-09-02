package com.cityfeedback.app.ui.components
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import com.cityfeedback.app.models.ScreenEnum
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp


@Composable
fun BottomNavigationBar(
    currentScreen: ScreenEnum,
    onScreenSelected: (ScreenEnum) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                spotColor = Color.Black,
            )

    ) {
    NavigationBar(
        containerColor = Color.White,
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Início",

                )
            },
            label = {
                Text("Feed")
            },
            selected = currentScreen == ScreenEnum.Home,
            colors = NavigationBarItemDefaults.colors(
               selectedIconColor = MaterialTheme.colorScheme.onSurface,
            ),
            onClick = { onScreenSelected(ScreenEnum.Home) }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Recompensas",

                )
            },
            label = {
                Text("Recompensas")
            },
            selected = currentScreen == ScreenEnum.Rewards,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onSurface,
            ),
            onClick = { onScreenSelected(ScreenEnum.Rewards) }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Perfil",
                )
            },
            label = {
                Text("Perfil")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onSurface,
            ),
            selected = currentScreen == ScreenEnum.Profile,
            onClick = { onScreenSelected(ScreenEnum.Profile) }
        )
    }
    }
}
