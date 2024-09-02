package com.cityfeedback.app.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.cityfeedback.app.models.CepResponse
import com.cityfeedback.app.models.Profile
import com.cityfeedback.app.models.Rate
import kotlinx.coroutines.launch


var profile = Profile(
    name = "Adriano Barros",
    points = 225,
    urlPhoto = "https://imgur.com/09KV50K.png",
    cep = "36021080",
    historic = listOf(
        Rate(category = "Educação", rate = 5, comment = "Gostei muito da mudança"),
        Rate(category = "Saúde", rate = 5, comment = "Amei o atendimento no UPA"),
    ),
)


@Composable
fun ProfileScreen() {
    var cepResponse by remember { mutableStateOf<CepResponse?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(profile.cep) {
        coroutineScope.launch {
            try {
                val response = RetrofitInstance.api.getCepInfo(profile.cep)
                cepResponse = response
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = "Erro ao buscar CEP"
                cepResponse = null
            } finally {
                isLoading = false
            }
        }
    }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color(0xFF2994F7))
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Perfil",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2994F7),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = rememberAsyncImagePainter(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(profile.urlPhoto)
                                    .crossfade(true)
                                    .build()
                            ),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = profile.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray,
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = Color(0xFF1565C0)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${profile.points} pts",
                                fontSize = 20.sp,
                                color =  Color(0xFF1565C0),
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        cepResponse?.let {
                            Text(
                                text = "CEP: ${it.cep}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2994F7),
                            )
                            Text(
                                text = "${it.logradouro}, ${it.bairro}",
                                fontSize = 16.sp,
                                color = Color.Gray,
                            )
                            Text(
                                text = "${it.localidade} - ${it.uf}",
                                fontSize = 16.sp,
                                color = Color.Gray,
                            )
                        } ?: run {
                            if (errorMessage != null) {
                                Text(
                                    text = errorMessage ?: "Erro ao buscar CEP",
                                    color = Color.Red
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                text = "Histórico",
                                fontSize = 20.sp,
                                color = Color(0xFF2994F7),
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            profile.historic.forEach { rate ->
                                HistoryItem(title = rate.category, description = rate.comment, rating = rate.rate)
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HistoryItem(title: String, description: String, rating: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Transparent
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color(0xFF1565C0)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = rating.toString(),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1565C0)
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
