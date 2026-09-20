package com.example.konklavtracer_v2.models

import kotlin.collections.get

data class Race(
    val name: String,
    val isMage: Boolean = false,
    val freePoints: Int = 2,  // По умолчанию 2, для магов 4
    val baseBonuses: Aspects = Aspects(),
    val subraces: Map<String, Aspects> = emptyMap()
){
    fun getSubraceBonuses(subraceName: String?): Aspects {
        return subraces[subraceName] ?: Aspects()
    }
}

object RaceDatabase {
    val races = listOf(
        // Люди-маги
        Race(
            name = "Маг",
            isMage = true,
            // 4 свободных очка, нет расовых бонусов
        ),

        // Эльфы
        Race(
            name = "Эльфы",
            baseBonuses = Aspects(perception = 1),
            subraces = mapOf(
                "Эстаидель" to Aspects(constitution = 1),
                "Вартаидель" to Aspects(constitution = 1),
                "Дроу" to Aspects(magic = 1),
                "Айаронаидель" to Aspects(agility = 1),
                "Аэдх" to Aspects(magic = 1),
                "Лесные" to Aspects(stealth = 1),
                "Лунные" to Aspects(vigilance = 1)
            )
        ),

        // Вааш
        Race(
            name = "Вааш",
            baseBonuses = Aspects(magic = 1),
            subraces = mapOf(
                "Крок" to Aspects(melee = 1),
                "Тоад" to Aspects(shooting = 1),
                "Драк" to Aspects(magic = 1),
                "Турт" to Aspects(constitution = 1),
                "Дино" to Aspects(constitution = 1),
                "Лизаго" to Aspects(agility = 1),
                "Гекко" to Aspects(agility = 1),
                "Снак" to Aspects(stealth = 1)
            )
        ),

        // Огрины
        Race(
            name = "Огрины",
            subraces = mapOf(
                "Орки" to Aspects(melee = 1, constitution = 1),
                "Огры" to Aspects(constitution = 2),
                "Тролли" to Aspects(constitution = 3, agility = -1),
                "Гоблины" to Aspects(stealth = 1, craft = 1, vigilance = 1, constitution = -1),
                "Гремлины" to Aspects(stealth = 1, craft = 1, vigilance = 1, constitution = -1)
            )
        ),

        // Демоны
        Race(
            name = "Демоны",
            subraces = mapOf(
                "Гнев" to Aspects(melee = 1, constitution = 1),
                "Огненные великаны" to Aspects(melee = 1, constitution = 1),
                "Уныние" to Aspects(vigilance = 1, perception = 1),
                "Лень" to Aspects(constitution = 1, stealth = 1),
                "Чревоугодие" to Aspects(constitution = 2),
                "Похоть" to Aspects(agility = 1, perception = 1),
                "Гордыня" to Aspects(will = 2),
                "Жадность" to Aspects(craft = 3, will = -1),
                "Зависть" to Aspects(perception = 1, vigilance = 2, will = -1)
            )
        ),

        // Простые расы (без подрас)
        Race(name = "Дварфы", baseBonuses = Aspects(constitution = 1, craft = 1)),
        Race(name = "Моряне", baseBonuses = Aspects(magic = 1, agility = 1)),
        Race(name = "Инсектоиды", baseBonuses = Aspects(will = 1, constitution = 1)),
        Race(name = "Полурослики", baseBonuses = Aspects(shooting = 1, stealth = 1)),
        Race(name = "Морлау", baseBonuses = Aspects(vigilance = 1, agility = 1)),
        Race(name = "Псоглавцы", baseBonuses = Aspects(agility = 1, vigilance = 1)),
        Race(name = "Вервольфы", baseBonuses = Aspects(agility = 1, vigilance = 1)),
        Race(name = "Духи", baseBonuses = Aspects(perception = 1, magic = 1)),
        Race(name = "Автоматоны", baseBonuses = Aspects(will = 1, craft = 1)),
        Race(name = "Звезды", baseBonuses = Aspects(magic = 2, perception = 1, stealth = -1)),
        Race(name = "Драконы", baseBonuses = Aspects(constitution = 2, magic = 1, stealth = -1)),
        Race(name = "Вампиры", baseBonuses = Aspects(constitution = 1, agility = 1, will = -1)),
        Race(name = "Великаны", baseBonuses = Aspects(constitution = 3, agility = -1)),
        Race(name = "Феи", baseBonuses = Aspects(
            magic = 1,
            agility = 1,
            perception = 1,
            constitution = -1
        )
        ),
        Race(name = "Гарпии", baseBonuses = Aspects(magic = 1, agility = 1)),
        Race(name = "Кентавры", baseBonuses = Aspects(constitution = 2, agility = 1, stealth = -1)),
        Race(name = "Муриды", baseBonuses = Aspects(agility = 2, stealth = 2, constitution = -2)),
        Race(name = "Доппельгангеры", baseBonuses = Aspects(stealth = 2, agility = 1, will = -1)),
        Race(name = "Ангелы", baseBonuses = Aspects(constitution = 2, perception = 1, stealth = -1))
    )

    fun getRaceByName(name: String): Race? = races.find { it.name == name }

    fun getFreePoints(raceName: String): Int {
        return if (raceName == "Маг") 4 else 2
    }
}