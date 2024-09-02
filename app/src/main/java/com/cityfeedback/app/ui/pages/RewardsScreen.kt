package com.cityfeedback.app.ui.pages
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cityfeedback.app.ui.components.BottomNavigationBar

data class RewardItem(
    val name: String,
    val description: String,
    val points: Int
)

@Composable
fun RewardsScreen() {
    val rewards = listOf(
        RewardItem(name = "Netflix", description = "Um mês de Netflix grátis.", points = 15),
        RewardItem(name = "GNC", description = "Um par de ingressos.", points = 35),
        RewardItem(name = "Burger King", description = "WHOPPER + batata e beb", points = 20),
        RewardItem(name = "Renner", description = "15% de desconto na loja 1", points = 40),
        RewardItem(name = "PetVet", description = "Primeira consulta grátis.", points = 25),
        RewardItem(name = "Bob's", description = "Um milkshake.", points = 20),
        RewardItem(name = "Bob's", description = "Um milkshake.", points = 20),
        RewardItem(name = "Bob's", description = "Um milkshake.", points = 20),
        RewardItem(name = "Bob's", description = "Um milkshake.", points = 20)
    )

    Scaffold(
        bottomBar = {}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Recompensas",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2994F7)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color(0xFF1565C0)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "225",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1565C0)
                    )
                }
            }


            LazyColumn(
                modifier = Modifier.fillMaxHeight()
            ) {
                item {
                    Spacer(modifier = Modifier.height(5.dp))
                }
                items(rewards) { reward ->
                    RewardCard(reward)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun RewardCard(reward: RewardItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
      colors = CardColors(
          containerColor = Color.White,
          contentColor = Color.Transparent,
          disabledContentColor = Color.Transparent,
          disabledContainerColor = Color.Transparent,
          )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = reward.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = reward.description,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "${reward.points}",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )

                Text(
                    text = "PT",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RewardsScreenPreview() {
    RewardsScreen()
}
