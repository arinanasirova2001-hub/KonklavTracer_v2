package com.example.konklavtracer_v2.models

import java.io.Serializable

data class Character(
    val id: Int = 0,
    val name: String = "",
    val race: String = "",
    val subrace: String = "",
    val baseAspects: Aspects = Aspects(),
    val finalAspects: Aspects = Aspects(),
    val magicData: MagicData = MagicData(),  // НОВОЕ ПОЛЕ
    val maxHealth: Int = 10,
    val artifactHealthBonus: Int = 0,
    val currentHealth: Int = 10,
    val arrows: Int = 0,
    val copper: Int = 0,
    val silver: Int = 0,
    val gold: Int = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) : Serializable {

    fun calculateHealth(): Int {
        return (finalAspects.constitution * 2) + 10
    }
}