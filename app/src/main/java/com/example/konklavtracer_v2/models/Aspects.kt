package com.example.konklavtracer_v2.models

import java.io.Serializable

enum class AspectType(val displayName: String, val shortName: String) {
    VIGILANCE("Бдительность", "БДН"),
    PERCEPTION("Восприятие", "ВОС"),
    WILL("Воля", "ВОЛ"),
    AGILITY("Ловкость", "ЛВК"),
    CONSTITUTION("Телосложение", "ТЕЛ"),
    DRIVING("Вождение", "ВОЖ"),
    CRAFT("Ремесло", "РЕМ"),
    MAGIC("Магия", "МАГ"),
    MELEE("Драка", "ДРК"),
    SHOOTING("Стрельба", "СТР"),
    STEALTH("Скрытность", "СКР"),
    HEALING("Лечение", "ЛЕЧ")
}

data class Aspects(
    val vigilance: Int = 0,
    val perception: Int = 0,
    val will: Int = 0,
    val agility: Int = 0,
    val constitution: Int = 0,
    val driving: Int = 0,
    val craft: Int = 0,
    val magic: Int = 0,
    val melee: Int = 0,
    val shooting: Int = 0,
    val stealth: Int = 0,
    val healing: Int = 0
) : Serializable {

    fun getValue(type: AspectType): Int = when(type) {
        AspectType.VIGILANCE -> vigilance
        AspectType.PERCEPTION -> perception
        AspectType.WILL -> will
        AspectType.AGILITY -> agility
        AspectType.CONSTITUTION -> constitution
        AspectType.DRIVING -> driving
        AspectType.CRAFT -> craft
        AspectType.MAGIC -> magic
        AspectType.MELEE -> melee
        AspectType.SHOOTING -> shooting
        AspectType.STEALTH -> stealth
        AspectType.HEALING -> healing
    }

    fun setValue(type: AspectType, value: Int): Aspects = when(type) {
        AspectType.VIGILANCE -> copy(vigilance = value)
        AspectType.PERCEPTION -> copy(perception = value)
        AspectType.WILL -> copy(will = value)
        AspectType.AGILITY -> copy(agility = value)
        AspectType.CONSTITUTION -> copy(constitution = value)
        AspectType.DRIVING -> copy(driving = value)
        AspectType.CRAFT -> copy(craft = value)
        AspectType.MAGIC -> copy(magic = value)
        AspectType.MELEE -> copy(melee = value)
        AspectType.SHOOTING -> copy(shooting = value)
        AspectType.STEALTH -> copy(stealth = value)
        AspectType.HEALING -> copy(healing = value)
    }

    operator fun plus(other: Aspects): Aspects = Aspects(
        vigilance = vigilance + other.vigilance,
        perception = perception + other.perception,
        will = will + other.will,
        agility = agility + other.agility,
        constitution = constitution + other.constitution,
        driving = driving + other.driving,
        craft = craft + other.craft,
        magic = magic + other.magic,
        melee = melee + other.melee,
        shooting = shooting + other.shooting,
        stealth = stealth + other.stealth,
        healing = healing + other.healing
    )

    fun getTotal(): Int = vigilance + perception + will + agility +
            constitution + driving + craft + magic +
            melee + shooting + stealth + healing
}