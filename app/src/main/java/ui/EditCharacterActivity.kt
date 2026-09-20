package com.example.konklavtracer_v2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.konklavtracer_v2.R

class EditCharacterActivity : AppCompatActivity() {
    private var characterId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_character)

        characterId = intent.getIntExtra("character_id", -1)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Редактирование"
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}