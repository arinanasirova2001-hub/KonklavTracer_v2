package com.example.konklavtracer_v2.models

// Ветвь магии
enum class MagicBranch(val displayName: String) {
    NONE("Без магии"),
    BALANCE("Равновесие"),
    WORDS("Слова"),
    FLAME("Пламя"),
    LIFE("Жизнь")
}

// Направление для Равновесия
enum class BalanceDirection(val displayName: String) {
    LIGHT("Свет"),
    SHADOW("Тень")
}

// Направление для Жизни
enum class LifeDirection(val displayName: String) {
    SHAMAN("Шаман"),
    SHAPESHIFTER("Перевёртыш")
}

// Животное для перевёртыша
enum class AnimalType(val displayName: String, val passiveAbility: String = "") {
    CANINE("Собаки, волки, гиены", "Регенерация — 1 HP каждые 5 минут (не в бою)"),
    UNGULATE("Парнокопытные", "+1 единица жизней"),
    FELINE("Кошачьи", "Атаки со спины +1 урон"),
    FLYING("Летуны", "Могут летать")
}

// Базовое умение
data class BaseSpell(
    val name: String,
    val level: Int,
    val description: String = ""
)

// Специалитет с уровнями
data class Specialization(
    val name: String,
    val levels: List<SpellLevel> = emptyList()
)




data class SpellLevel(
    val level: Int,
    val name: String,
    val description: String = ""
)

// Данные магии персонажа
data class MagicData(
    val branch: MagicBranch = MagicBranch.NONE,
    val balanceDirection: BalanceDirection? = null,
    val lifeDirection: LifeDirection? = null,
    val animalType: AnimalType? = null,
    val baseSpells: List<BaseSpell> = emptyList(),
    val specializations: List<String> = emptyList(),
    val specializationSpells: Map<String, List<BaseSpell>> = emptyMap(),
    val universalMagic: Map<String, Int> = emptyMap(),
    val voodooLoas: Map<String, String> = emptyMap(),
    val lovePathType: String = "",
    val loveLanguages: Map<String, List<String>> = emptyMap(),
    val fearlessnessSpells: List<String> = emptyList(),
    val hasBloodMagic: Boolean = false
) : java.io.Serializable

enum class MagicCategory(val displayName: String) {
    BRANCH("Ветвийная магия"),
    UNIVERSAL("Всеобщая магия"),
    FORBIDDEN("Запрещённая магия")
}

data class MagicSchool(
    val id: String,
    val name: String,
    val category: MagicCategory,
    val branch: MagicBranch? = null,
    val direction: String? = null,
    val description: String = "Описание появится позже",
    val spells: List<SpellEntry> = emptyList()
)

data class SpellEntry(
    val id: String,
    val name: String,
    val category: MagicCategory,
    val branch: MagicBranch? = null,
    val direction: String? = null,
    val specialization: String? = null,
    val level: Int = 0,
    val slot: Int = 0,
    val school: String? = null,
    val subgroup: String? = null,
    val description: String = "Описание появится позже",
    val castingTime: String = "",
    val range: String = "",
    val duration: String = "",
    val damage: String? = null,
    val block: Int = 0,
    val requirements: String? = null,
    val recipe: Recipe? = null
)
enum class RecipeType {
    POTION,
    RUNE,
    RITUAL,
    GENERAL
}

data class Recipe(
    val dosage: String = "",
    val ingredients: List<String> = emptyList(),
    val preparation: String = "",
    val duration: String = "",
    val comments: String = "",
    val canBeAdded: Boolean = false,
    val recipeType: RecipeType = RecipeType.POTION
) : java.io.Serializable