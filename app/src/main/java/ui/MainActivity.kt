package com.example.konklavtracer_v2.ui

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.DatabaseHelper
import com.example.konklavtracer_v2.models.Character
import com.example.konklavtracer_v2.utils.DialogUtils


class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)

        val btnNewCharacter = findViewById<Button>(R.id.btnNewCharacter)
        btnNewCharacter.setOnClickListener {
            startActivity(Intent(this, CreateCharacterActivity::class.java))
        }

        loadCharacters()
    }

    override fun onResume() {
        super.onResume()
        loadCharacters()
    }

    private fun loadCharacters() {
        val layoutCharacters = findViewById<LinearLayout>(R.id.layoutCharacters)
        layoutCharacters.removeAllViews()

        val characters = dbHelper.getAllCharacters()

        if (characters.isEmpty()) {
            val tvEmpty = TextView(this).apply {
                text = "Нет созданных персонажей\n\nНажмите на кнопку ниже,\nчтобы создать первого героя!"
                setTextAppearance(R.style.prostotext)
                gravity = Gravity.CENTER
                textSize = 18f
                setPadding(32, 64, 32, 64)
                setTextColor(ContextCompat.getColor(context, R.color.bir))
            }
            layoutCharacters.addView(tvEmpty)
            return
        }

        for (character in characters) {
            val characterItemView = LayoutInflater.from(this).inflate(
                R.layout.item_character,
                layoutCharacters,
                false
            )

            // Заполняем данные
            val tvCharacterName = characterItemView.findViewById<TextView>(R.id.tvCharacterName)
            tvCharacterName.text = character.name

            val tvCharacterRace = characterItemView.findViewById<TextView>(R.id.tvCharacterRace)
            val raceText = if (character.subrace.isNotEmpty()) {
                "${character.race} (${character.subrace})"
            } else {
                character.race
            }
            tvCharacterRace.text = "Раса: $raceText"

            val tvCharacterHealth = characterItemView.findViewById<TextView>(R.id.tvCharacterHealth)
            tvCharacterHealth.text = "HP: ${character.currentHealth} / ${character.maxHealth}"

            // Обработка нажатия
            characterItemView.setOnClickListener {
                val intent = Intent(this@MainActivity, CharacterSheetActivity::class.java).apply {
                    putExtra("character_id", character.id)
                }
                startActivity(intent)
            }

            // Обработка долгого нажатия для удаления
            characterItemView.setOnLongClickListener {
                showDeleteConfirmation(character)
                true
            }

            layoutCharacters.addView(characterItemView)
        }
    }

    private fun showDeleteConfirmation(character: Character) {
        DialogUtils.showDeleteDialog(
            context = this,
            title = "Удалить персонажа?",
            message = "Персонаж \"${character.name}\" будет удалён. Это действие нельзя отменить.",
            onConfirm = {
                dbHelper.deleteCharacter(character.id)
                loadCharacters()
            }
        )
    }
}