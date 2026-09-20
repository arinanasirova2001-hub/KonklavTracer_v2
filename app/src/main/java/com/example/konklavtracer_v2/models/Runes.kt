package com.example.konklavtracer_v2.models

data class Runes(
    val id: String,
    val name: String,
    val symbol: String,
    val category: RunesCategory,
    val description: String = "",
) : java.io.Serializable

enum class RunesCategory(val displayName: String) {
    PRON("Выразимые"),
    NONPRON("Невыразимые"),
}