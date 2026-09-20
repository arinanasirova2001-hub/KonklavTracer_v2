package com.example.konklavtracer_v2.models

data class Ingredient(
    val id: String,
    val name: String,
    val category: IngredientCategory,
    val description: String = "",
    val source: String = "",
    val taste: String = "",
    val properties: String = "",
    val symbolism: String = "",
    val notes: String = ""
) : java.io.Serializable

enum class IngredientCategory(val displayName: String) {
    HERB("Травы"),
    GREAT_HERB("Великие травы"),
    ANIMAL("Животного происхождения"),
    SPECIAL("Особые")
}