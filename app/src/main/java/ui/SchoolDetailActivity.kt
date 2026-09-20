package com.example.konklavtracer_v2.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.SpellDatabase
import com.example.konklavtracer_v2.models.MagicSchool
import com.example.konklavtracer_v2.models.SpellEntry
import com.example.konklavtracer_v2.data.IngredientDatabase
import com.example.konklavtracer_v2.data.RuneDatabase
import com.example.konklavtracer_v2.models.Ingredient
import com.example.konklavtracer_v2.models.RecipeType
import com.example.konklavtracer_v2.models.Runes

class SchoolDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_detail)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val schoolId = intent.getStringExtra("school_id") ?: return
        val school = SpellDatabase.getSchoolById(schoolId) ?: run {
            finish()
            return
        }

        supportActionBar?.title = school.name
        findViewById<TextView>(R.id.tvSchoolDescription).text = school.description

        val layoutLevels = findViewById<LinearLayout>(R.id.layoutLevels)
        layoutLevels.removeAllViews()

        // Выбираем способ отображения в зависимости от школы
        when (school.id) {
            "voodoo" -> setupGroupedSpells(
                school, layoutLevels,
                listOf("Общие", "Легба", "Самеди", "Бриджит", "Огун", "Дамбала")
            )
            "blood_magic" -> setupGroupedSpells(
                school, layoutLevels,
                listOf("Общее", "Кровь Слова", "Кровь Пламени", "Кровь Жизни", "Кровь Равновесия")
            )
            "love_path" -> setupGroupedSpells(
                school, layoutLevels,
                listOf(
                    "Влюблённость", "Вербалы", "Эмпаты", "Спасатели",
                    "Дарители", "Кинестеты", "Тропа Любви", "Жертва любви"
                )
            )
            "alchemy" -> setupAlchemySpells(school, layoutLevels)
            else -> setupRegularSpells(school, layoutLevels)
        }
    }

    // ========== ОБЫЧНАЯ ШКОЛА (по уровням) ==========

    private fun setupRegularSpells(school: MagicSchool, layoutLevels: LinearLayout) {
        val spellsByLevel = school.spells.groupBy { it.level }.toSortedMap()

        for ((level, spells) in spellsByLevel) {
            val levelView = LayoutInflater.from(this).inflate(
                R.layout.item_school_level,
                layoutLevels,
                false
            )

            val tvLevelName = levelView.findViewById<TextView>(R.id.tvLevelName)
            tvLevelName.text = "Уровень $level"

            val layoutSpells = levelView.findViewById<LinearLayout>(R.id.layoutSpells)
            layoutSpells.visibility = View.GONE

            levelView.setOnClickListener {
                if (layoutSpells.visibility == View.GONE) {
                    layoutSpells.visibility = View.VISIBLE

                    if (layoutSpells.childCount == 0) {
                        for (spell in spells) {
                            addSpellView(layoutSpells, spell)
                        }
                    }
                } else {
                    layoutSpells.visibility = View.GONE
                }
            }

            layoutLevels.addView(levelView)
        }
    }

    // ========== ГРУППИРОВКА ПО ПОДКАТЕГОРИЯМ (Вуду, Магия крови, Тропа любви) ==========

    private fun setupGroupedSpells(
        school: MagicSchool,
        layoutLevels: LinearLayout,
        order: List<String>
    ) {
        val spellsBySubgroup = school.spells.groupBy { it.subgroup ?: "Общее" }

        for (subgroupName in order) {
            val spells = spellsBySubgroup[subgroupName] ?: continue

            val header = TextView(this).apply {
                text = subgroupName
                textSize = 20f
                setTextColor(ContextCompat.getColor(this@SchoolDetailActivity, R.color.bir))
                setTypeface(null, android.graphics.Typeface.BOLD)
                setPadding(16, 24, 16, 12)
            }
            layoutLevels.addView(header)

            for (spell in spells) {
                addSpellView(layoutLevels, spell)
            }
        }
    }

    // ========== ЗЕЛЬЕВАРЕНЬЕ (по уровням + рецепты) ==========

    private fun setupAlchemySpells(school: MagicSchool, layoutLevels: LinearLayout) {
        // Группируем зелья по подгруппам (уровни)
        val spellsBySubgroup = school.spells.groupBy { it.subgroup ?: "Без уровня" }

        // Порядок подгрупп
        val order = listOf(
            "Зелья I уровня",
            "Зелья II уровня",
            "Зелья III уровня",
            "Мастерство"
        )

        for (subgroupName in order) {
            val spells = spellsBySubgroup[subgroupName] ?: continue

            // Заголовок подгруппы
            val levelView = LayoutInflater.from(this).inflate(
                R.layout.item_school_level,
                layoutLevels,
                false
            )

            val tvLevelName = levelView.findViewById<TextView>(R.id.tvLevelName)
            tvLevelName.text = subgroupName

            val layoutSpells = levelView.findViewById<LinearLayout>(R.id.layoutSpells)
            layoutSpells.visibility = View.GONE

            levelView.setOnClickListener {
                if (layoutSpells.visibility == View.GONE) {
                    layoutSpells.visibility = View.VISIBLE

                    if (layoutSpells.childCount == 0) {
                        for (spell in spells) {
                            addSpellView(layoutSpells, spell)
                        }
                    }
                } else {
                    layoutSpells.visibility = View.GONE
                }
            }

            layoutLevels.addView(levelView)
        }
    }

    // ========== ДОБАВЛЕНИЕ ЗАКЛИНАНИЯ В СПИСОК ==========

    private fun addSpellView(parent: LinearLayout, spell: SpellEntry) {
        val spellView = LayoutInflater.from(this).inflate(
            R.layout.item_spell_entry,
            parent,
            false
        )

        spellView.findViewById<TextView>(R.id.tvSpellName).text = spell.name
        spellView.findViewById<TextView>(R.id.tvSpellCategory).text = ""
        spellView.findViewById<TextView>(R.id.tvSpellLevel).visibility = View.GONE

        spellView.setOnClickListener {
            showSpellDetail(spell)
        }

        parent.addView(spellView)
    }

    // ========== ДИАЛОГ ЗАКЛИНАНИЯ (с рецептом) ==========

    private fun showSpellDetail(spell: SpellEntry) {
        val dialog = Dialog(this).apply {
            setContentView(R.layout.dialog_spell_detail)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<TextView>(R.id.tvDetailName).text = spell.name

        val infoText = buildString {
            if (spell.level > 0) append("Уровень ${spell.level}")
            if (spell.block > 0) {
                if (isNotEmpty()) append(" | ")
                append("Блок ${spell.block}")
            }
        }
        dialog.findViewById<TextView>(R.id.tvDetailInfo).text = infoText
        dialog.findViewById<TextView>(R.id.tvDetailDescription).text = spell.description

        val layoutRecipe = dialog.findViewById<LinearLayout>(R.id.layoutRecipe)

        if (spell.recipe != null) {
            layoutRecipe.visibility = View.VISIBLE
            val recipe = spell.recipe

            val tvRecipeHeader = dialog.findViewById<TextView>(R.id.tvRecipeHeader)
            val blockDosage = dialog.findViewById<LinearLayout>(R.id.blockDosage)
            val blockIngredients = dialog.findViewById<LinearLayout>(R.id.blockIngredients)
            val blockPreparation = dialog.findViewById<LinearLayout>(R.id.blockPreparation)
            val blockDuration = dialog.findViewById<LinearLayout>(R.id.blockDuration)
            val tvRecipeComments = dialog.findViewById<TextView>(R.id.tvRecipeComments)

            val tvDosageLabel = dialog.findViewById<TextView>(R.id.tvRecipeDosageLabel)
            val tvRecipeDosage = dialog.findViewById<TextView>(R.id.tvRecipeDosage)
            val tvIngredientsLabel = dialog.findViewById<TextView>(R.id.tvIngredientsLabel)
            val layoutIngredients = dialog.findViewById<LinearLayout>(R.id.layoutIngredients)
            val tvPreparationLabel = dialog.findViewById<TextView>(R.id.tvPreparationLabel)
            val tvRecipePreparation = dialog.findViewById<TextView>(R.id.tvRecipePreparation)
            val tvRecipeDuration = dialog.findViewById<TextView>(R.id.tvRecipeDuration)

            when (recipe.recipeType) {
                RecipeType.POTION -> {
                    tvRecipeHeader.text = "РЕЦЕПТ"

                    blockDosage.visibility = View.VISIBLE
                    tvDosageLabel.text = "Дозировка:"
                    tvRecipeDosage.text = recipe.dosage

                    blockIngredients.visibility = View.VISIBLE
                    tvIngredientsLabel.text = "Состав (нажмите на ингредиент):"
                    fillIngredientsList(layoutIngredients, recipe.ingredients)

                    blockPreparation.visibility = View.VISIBLE
                    tvPreparationLabel.text = "Приготовление:"
                    tvRecipePreparation.text = recipe.preparation

                    blockDuration.visibility = View.VISIBLE
                    tvRecipeDuration.text = "Время действия: ${recipe.duration}\nПодливать: ${if (recipe.canBeAdded) "да" else "нет"}"

                    if (recipe.comments.isNotEmpty()) {
                        tvRecipeComments.visibility = View.VISIBLE
                        tvRecipeComments.text = "Комментарии: ${recipe.comments}"
                    } else {
                        tvRecipeComments.visibility = View.GONE
                    }
                }

                RecipeType.RUNE -> {
                    tvRecipeHeader.text = "ОПИСАНИЕ"

                    if (recipe.dosage.isNotEmpty() && recipe.dosage != "—") {
                        blockDosage.visibility = View.VISIBLE
                        tvDosageLabel.text = "Носитель:"
                        tvRecipeDosage.text = recipe.dosage
                    } else {
                        blockDosage.visibility = View.GONE
                    }

                    if (recipe.ingredients.isNotEmpty() && recipe.ingredients.first() != "—") {
                        blockIngredients.visibility = View.VISIBLE
                        tvIngredientsLabel.text = "Основа:"
                        fillIngredientsList(layoutIngredients, recipe.ingredients)
                    } else {
                        blockIngredients.visibility = View.GONE
                    }

                    if (recipe.preparation.isNotEmpty() && recipe.preparation != "—") {
                        blockPreparation.visibility = View.VISIBLE
                        tvPreparationLabel.text = "Начертание:"
                        tvRecipePreparation.text = recipe.preparation
                    } else {
                        blockPreparation.visibility = View.GONE
                    }

                    if (recipe.duration.isNotEmpty() && recipe.duration != "—") {
                        blockDuration.visibility = View.VISIBLE
                        tvRecipeDuration.text = "Длительность: ${recipe.duration}"
                    } else {
                        blockDuration.visibility = View.GONE
                    }

                    if (recipe.comments.isNotEmpty()) {
                        tvRecipeComments.visibility = View.VISIBLE
                        tvRecipeComments.text = recipe.comments
                    } else {
                        tvRecipeComments.visibility = View.GONE
                    }
                }

                RecipeType.RITUAL -> {
                    tvRecipeHeader.text = "РИТУАЛ"

                    if (recipe.dosage.isNotEmpty() && recipe.dosage != "—") {
                        blockDosage.visibility = View.VISIBLE
                        tvDosageLabel.text = "Цена:"
                        tvRecipeDosage.text = recipe.dosage
                    } else {
                        blockDosage.visibility = View.GONE
                    }

                    if (recipe.ingredients.isNotEmpty() && recipe.ingredients.first() != "—") {
                        blockIngredients.visibility = View.VISIBLE
                        tvIngredientsLabel.text = "Компоненты:"
                        fillIngredientsList(layoutIngredients, recipe.ingredients)
                    } else {
                        blockIngredients.visibility = View.GONE
                    }

                    if (recipe.preparation.isNotEmpty() && recipe.preparation != "—") {
                        blockPreparation.visibility = View.VISIBLE
                        tvPreparationLabel.text = "Проведение:"
                        tvRecipePreparation.text = recipe.preparation
                    } else {
                        blockPreparation.visibility = View.GONE
                    }

                    blockDuration.visibility = View.GONE
                    tvRecipeComments.visibility = View.GONE
                }

                RecipeType.GENERAL -> {
                    tvRecipeHeader.text = "ДЕТАЛИ"

                    blockDosage.visibility = View.GONE
                    blockIngredients.visibility = View.GONE

                    if (recipe.preparation.isNotEmpty() && recipe.preparation != "—") {
                        blockPreparation.visibility = View.VISIBLE
                        tvPreparationLabel.visibility = View.GONE
                        tvRecipePreparation.text = recipe.preparation
                    } else {
                        blockPreparation.visibility = View.GONE
                    }

                    blockDuration.visibility = View.GONE
                    tvRecipeComments.visibility = View.GONE
                }
            }
        } else {
            layoutRecipe.visibility = View.GONE
        }

        dialog.findViewById<Button>(R.id.btnCloseDetail).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun fillIngredientsList(parent: LinearLayout, ingredients: List<String>) {
        parent.removeAllViews()
        for (ingredientName in ingredients) {
            val ingredientView = TextView(this).apply {
                text = "• $ingredientName"
                textSize = 14f
                setTextColor(ContextCompat.getColor(this@SchoolDetailActivity, R.color.bir))
                setPadding(16, 8, 8, 8)
                setOnClickListener {
                    // Ищем в рунах
                    val rune = RuneDatabase.allRunes.find { rune ->
                        ingredientName.startsWith(rune.name, ignoreCase = true) ||
                                ingredientName.contains(rune.name, ignoreCase = true)
                    }

                    // Ищем в ингредиентах
                    val ingredient = IngredientDatabase.allIngredients.find { ing ->
                        ing.name.contains(ingredientName.substringBefore(" ("), ignoreCase = true) ||
                                ingredientName.contains(ing.name.substringBefore(" ("), ignoreCase = true)
                    }

                    when {
                        rune != null -> showRuneDetail(rune)
                        ingredient != null -> showIngredientDetail(ingredient)
                    }
                }
            }
            parent.addView(ingredientView)
        }
    }

    private fun showRuneDetail(rune: Runes) {
        val dialog = Dialog(this).apply {
            setContentView(R.layout.dialog_rune_detail)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<TextView>(R.id.tvRuneName).text = rune.name
        dialog.findViewById<TextView>(R.id.tvRuneSymbol).text = rune.symbol
        dialog.findViewById<TextView>(R.id.tvRuneDescription).text = rune.description

        dialog.findViewById<Button>(R.id.btnCloseRune).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showIngredientDetail(ingredient: Ingredient) {
        val dialog = Dialog(this).apply {
            setContentView(R.layout.dialog_ingredient_detail)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<TextView>(R.id.tvIngredientName).text = ingredient.name
        dialog.findViewById<TextView>(R.id.tvIngredientDescription).text = ingredient.description
        dialog.findViewById<TextView>(R.id.tvIngredientSource).text = "Источник: ${ingredient.source}"
        dialog.findViewById<TextView>(R.id.tvIngredientTaste).text = "Вкус: ${ingredient.taste}"
        dialog.findViewById<TextView>(R.id.tvIngredientProperties).text = "Свойства: ${ingredient.properties}"
        dialog.findViewById<TextView>(R.id.tvIngredientSymbolism).text = "Символизм: ${ingredient.symbolism}"

        if (ingredient.notes.isNotEmpty()) {
            dialog.findViewById<TextView>(R.id.tvIngredientNotes).text = "Примечание: ${ingredient.notes}"
            dialog.findViewById<TextView>(R.id.tvIngredientNotes).visibility = View.VISIBLE
        } else {
            dialog.findViewById<TextView>(R.id.tvIngredientNotes).visibility = View.GONE
        }

        dialog.findViewById<Button>(R.id.btnCloseIngredient).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
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