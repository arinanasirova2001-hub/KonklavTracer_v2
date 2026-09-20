package com.example.konklavtracer_v2.models

data class Note(
    val id: Int = 0,
    val characterId: Int? = null,
    val title: String = "",
    val content: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) : java.io.Serializable