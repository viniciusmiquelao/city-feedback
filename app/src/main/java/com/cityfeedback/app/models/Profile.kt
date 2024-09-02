package com.cityfeedback.app.models

data class Profile(
    val name: String,
    val urlPhoto: String,
    val points: Int,
    val cep: String,
    val historic: List<Rate>,
)