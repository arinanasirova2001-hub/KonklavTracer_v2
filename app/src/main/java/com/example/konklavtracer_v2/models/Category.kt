package com.example.konklavtracer_v2.models

data class ItemCategory(
    val id: Int,
    val name: String,
    val characterId: Int,
    val sortOrder: Int = 0
)