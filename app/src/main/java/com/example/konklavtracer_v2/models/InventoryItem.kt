package com.example.konklavtracer_v2.models

data class InventoryItem(
    val id: Int,
    val name: String,
    val description: String = "",
    val quantity: Int = 1,
    val isEquipped: Boolean = false,
    val categoryId: Int? = null
)