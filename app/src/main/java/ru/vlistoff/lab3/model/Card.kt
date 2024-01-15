package ru.vlistoff.lab3.model

import java.util.UUID

data class Card(
    val id : UUID,
    val name : String,
    val type : String,
    val manaCost : String,
    val rarity : String
)
