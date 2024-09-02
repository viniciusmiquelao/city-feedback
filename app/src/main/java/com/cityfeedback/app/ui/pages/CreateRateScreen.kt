package com.cityfeedback.app.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.TextFieldValue
import com.cityfeedback.app.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateRateScreen() {
    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("Selecione a categoria") }
    val categories = listOf("Sáude", "Educação", "Segurança", "Transporte")

    var comment by remember { mutableStateOf(TextFieldValue("")) }
    var rating by remember { mutableStateOf(0) }



    Scaffold (
        bottomBar = {
            Button(
                onClick = {

                },
                colors = ButtonColors(contentColor = Primary, containerColor = Primary, disabledContentColor = Primary, disabledContainerColor = Primary,),
                modifier = Modifier.
                      fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.systemBars)
                    .padding(16.dp)
                    .height(50.dp)
            ){
                Text(text = "Enviar Avaliação", color = Color.White, fontSize = 16.sp)
            }
        }
    ) {
            paddingValues ->   Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Criar avaliação",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E88E5)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Categoria",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
            )

            Spacer(modifier = Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = selectedCategory,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            tint = Color.Gray,
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = null
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        focusedContainerColor = Color(0xFFDDDDDD),
                        unfocusedContainerColor = Color(0xFFDDDDDD),

                        ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                        .height(50.dp)
                        .background(Color.Transparent)
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    categories.forEach { category ->
                        DropdownMenuItem(
                            text = { Text(text = category) },
                            onClick = {
                                selectedCategory = category
                                expanded = false
                            },
                            modifier = Modifier.fillMaxWidth().height(50.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Comentário",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
            )

            BasicTextField(
                value = comment,
                onValueChange = { comment = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(50.dp)
                    .background(Color(0xFFDDDDDD), shape = MaterialTheme.shapes.small)
                    .padding(16.dp),
                textStyle = TextStyle(color = Color.Black)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Nota",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
            )

            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(5) { index ->
                    IconButton(onClick = { rating = index + 1 }) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = if (index < rating) Color(0xFF1E88E5) else Color.Gray
                        )
                    }
                }
            }



        }
    }
}