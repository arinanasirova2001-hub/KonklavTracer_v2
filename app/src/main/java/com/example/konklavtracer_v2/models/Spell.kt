package com.example.konklavtracer_v2.models

data class Spell(
    val id: Int = 0,
    val name: String = "",
    val level: Int = 0,
    val school: String = "",
    val castingTime: String = "",
    val range: String = "",
    val duration: String = "",
    val description: String = "",
    val damage: String? = null,
    val isCustom: Boolean = false
) : java.io.Serializable