package com.example.konklavtracer_v2.data
import android.util.Log
import com.example.konklavtracer_v2.models.Aspects
import com.example.konklavtracer_v2.models.Race

object RaceDatabase {

    val races = listOf(
        // ========== ЛЮДИ ==========
        Race(
            name = "Маг",
            isMage = true,
            freePoints = 4,
            baseBonuses = Aspects()  // Нет бонусов, 4 свободных очка
        ),

        // ========== ЭЛЬФЫ ==========
        Race(
            name = "Эльфы",
            freePoints = 2,
            baseBonuses = Aspects(perception = 1),  // +1 восприятие всем эльфам
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

        // ========== ВААШ ==========
        Race(
            name = "Вааш",
            freePoints = 2,
            baseBonuses = Aspects(magic = 1),  // +1 к магии у всех вааш
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

        // ========== ОГРИНЫ ==========
        Race(
            name = "Огрины",
            freePoints = 2,
            subraces = mapOf(
                "Орки" to Aspects(melee = 1, constitution = 1),
                "Огры" to Aspects(constitution = 2),
                "Тролли" to Aspects(constitution = 3, agility = -1),
                "Гоблины" to Aspects(
                    stealth = 1,
                    craft = 1,
                    vigilance = 1,
                    constitution = -1
                ),
                "Гремлины" to Aspects(
                    stealth = 1,
                    craft = 1,
                    vigilance = 1,
                    constitution = -1
                )
            )
        ),

        // ========== ДЕМОНЫ ==========
        Race(
            name = "Демоны",
            freePoints = 2,
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

        // ========== ДВАРФЫ ==========
        Race(
            name = "Дварфы",
            freePoints = 2,
            baseBonuses = Aspects(constitution = 1, craft = 1)
        ),

        // ========== МОРЯНЕ ==========
        Race(
            name = "Моряне",
            freePoints = 2,
            baseBonuses = Aspects(magic = 1, agility = 1)
        ),

        // ========== ИНСЕКТОИДЫ ==========
        Race(
            name = "Инсектоиды",
            freePoints = 2,
            baseBonuses = Aspects(will = 1, constitution = 1)
        ),

        // ========== ПОЛУРОСЛИКИ ==========
        Race(
            name = "Полурослики",
            freePoints = 2,
            baseBonuses = Aspects(shooting = 1, stealth = 1)
        ),

        // ========== МОРЛАУ ==========
        Race(
            name = "Морлау",
            freePoints = 2,
            baseBonuses = Aspects(vigilance = 1, agility = 1)
        ),

        // ========== ПСОГЛАВЦЫ ==========
        Race(
            name = "Псоглавцы",
            freePoints = 2,
            baseBonuses = Aspects(agility = 1, vigilance = 1)
        ),

        // ========== ВЕРВОЛЬФЫ ==========
        Race(
            name = "Вервольфы",
            freePoints = 2,
            baseBonuses = Aspects(agility = 1, vigilance = 1)
        ),

        // ========== ДУХИ ==========
        Race(
            name = "Духи",
            freePoints = 2,
            baseBonuses = Aspects(perception = 1, magic = 1)
        ),

        // ========== АВТОМАТОНЫ ==========
        Race(
            name = "Автоматоны",
            freePoints = 2,
            baseBonuses = Aspects(will = 1, craft = 1)
        ),

        // ========== ЗВЕЗДЫ ==========
        Race(
            name = "Звезды",
            freePoints = 2,
            baseBonuses = Aspects(magic = 2, perception = 1, stealth = -1)
        ),

        // ========== ДРАКОНЫ ==========
        Race(
            name = "Драконы",
            freePoints = 2,
            baseBonuses = Aspects(constitution = 2, magic = 1, stealth = -1)
        ),

        // ========== ВАМПИРЫ ==========
        Race(
            name = "Вампиры",
            freePoints = 2,
            baseBonuses = Aspects(constitution = 1, agility = 1, will = -1)
        ),

        // ========== ВЕЛИКАНЫ ==========
        Race(
            name = "Великаны",
            freePoints = 2,
            baseBonuses = Aspects(constitution = 3, agility = -1)
        ),

        // ========== ФЕИ ==========
        Race(
            name = "Феи",
            freePoints = 2,
            baseBonuses = Aspects(
                magic = 1,
                agility = 1,
                perception = 1,
                constitution = -1
            )
        ),

        // ========== ГАРПИИ ==========
        Race(
            name = "Гарпии",
            freePoints = 2,
            baseBonuses = Aspects(magic = 1, agility = 1)
        ),

        // ========== КЕНТАВРЫ ==========
        Race(
            name = "Кентавры",
            freePoints = 2,
            baseBonuses = Aspects(constitution = 2, agility = 1, stealth = -1)
        ),

        // ========== МУРИДЫ ==========
        Race(
            name = "Муриды",
            freePoints = 2,
            baseBonuses = Aspects(agility = 2, stealth = 2, constitution = -2)
        ),

        // ========== ДОППЕЛЬГАНГЕРЫ ==========
        Race(
            name = "Доппельгангеры",
            freePoints = 2,
            baseBonuses = Aspects(stealth = 2, agility = 1, will = -1)
        ),

        // ========== АНГЕЛЫ ==========
        Race(
            name = "Ангелы",
            freePoints = 2,
            baseBonuses = Aspects(constitution = 2, perception = 1, stealth = -1)
        )
    )

    // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ==========

    fun getRaceByName(name: String): Race? {
        return races.find { it.name == name }
    }

    fun getRaceNames(): List<String> {
        return races.map { it.name }
    }

    fun getSubracesForRace(raceName: String): List<String> {
        val race = getRaceByName(raceName) ?: return emptyList()
        return race.subraces.keys.toList()
    }

    fun getTotalBonusForRace(raceName: String, subraceName: String? = null): Aspects {
        val race = getRaceByName(raceName) ?: return Aspects()
        var totalBonus = race.baseBonuses

        if (subraceName != null && race.subraces.containsKey(subraceName)) {
            totalBonus = totalBonus + race.subraces[subraceName]!!
        }

        return totalBonus
    }

    fun getFreePointsForRace(raceName: String): Int {
        val race = getRaceByName(raceName)
        val points = race?.freePoints ?: 0
        Log.d("RaceDatabase", "Раса: $raceName, свободных очков: $points")
        return points
    }
}