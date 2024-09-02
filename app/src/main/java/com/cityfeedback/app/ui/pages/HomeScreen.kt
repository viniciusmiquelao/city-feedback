package com.cityfeedback.app.ui.pages
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.cityfeedback.app.models.HomeScreenItem
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.rememberScrollState
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    val items = listOf(
        HomeScreenItem(
            title = "Avalie nossa cidade",
            description = "Acumule avaliações e ganhe recompensas",
            imageUrl = "https://imgur.com/dGWNx9q.png",
            backgroundColor = Color.Transparent
        ),
        HomeScreenItem(
            title = "Evento cultural",
            description = "Presencie essa obra prima",
            imageUrl = "https://imgur.com/Mrio4qi.png",
                    backgroundColor = Color.Transparent
        ),
        HomeScreenItem(
            title = "Vacinação contra a Gripe",
            description = "começa 15/10",
            imageUrl = "https://svgshare.com/s/19p8",
            backgroundColor = Color(0xFF0D47A1)
        ),
        HomeScreenItem(
            title = "Campeonato de futebol de salão",
            description = "dia 07/09",
            imageUrl = "https://svgshare.com/s/19q1",
            backgroundColor = Color(0xFF1976D2)
        )
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.background,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Início",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2994F7)
            )

            Spacer(modifier = Modifier.height(16.dp))

            HomeScreenCard(item = items[0], onClick = {
                navController.navigate("create_review")
            })
            Spacer(modifier = Modifier.height(16.dp))

            HomeScreenCard(item = items[1])
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeScreenCard(
                    item = items[2],
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                HomeScreenCard(
                    item = items[3],
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun HomeScreenCard(item: HomeScreenItem, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable(onClick != null) {
                onClick?.invoke()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = item.backgroundColor)
    ) {
        Box {
            if (item.backgroundColor == Color.Transparent) {
                Image(
                    painter = rememberAsyncImagePainter(item.imageUrl),
                    contentDescription = item.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = item.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(2f, 2f),
                            blurRadius = 4f
                        )
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    color = Color.White,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(2f, 2f),
                            blurRadius = 4f
                        )
                    )
                )
            }
        }
    }
}




