package com.example.konklavtracer_v2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.DatabaseHelper
import com.example.konklavtracer_v2.data.SpellDatabase
import com.example.konklavtracer_v2.models.*
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import com.example.konklavtracer_v2.data.IngredientDatabase
import com.example.konklavtracer_v2.data.RuneDatabase
import com.example.konklavtracer_v2.models.Ingredient
import com.example.konklavtracer_v2.models.MagicSchool
import com.example.konklavtracer_v2.models.Recipe
import com.example.konklavtracer_v2.models.RecipeType
import com.example.konklavtracer_v2.models.Runes
import com.example.konklavtracer_v2.models.SpellEntry

class AbilitiesFragment : Fragment() {
    private lateinit var dbHelper: DatabaseHelper
    private var characterId: Int = -1
    private var character: Character? = null

    companion object {
        fun newInstance(characterId: Int): AbilitiesFragment {
            return AbilitiesFragment().apply {
                arguments = Bundle().apply {
                    putInt("character_id", characterId)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_abilities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterId = arguments?.getInt("character_id") ?: -1
        dbHelper = DatabaseHelper(requireContext())

        loadCharacter()
    }

    override fun onResume() {
        super.onResume()
        loadCharacter()
    }

    private fun loadCharacter() {
        character = dbHelper.getCharacterById(characterId)
        character?.let { char ->
            view?.let { v ->
                displayAbilities(v, char)
            }
        }
    }

    private fun displayAbilities(view: View, char: Character) {
        val layout = view.findViewById<LinearLayout>(R.id.layoutAbilities)
        layout.removeAllViews()

        val magicData = char.magicData

        // ========== ВЕТВИЙНАЯ МАГИЯ ==========
        if (magicData.branch != MagicBranch.NONE) {
            addSectionHeader(layout, "Ветвийная магия")

            // Базовые умения
            if (magicData.baseSpells.isNotEmpty()) {
                addSubHeader(layout, "Базовые умения")
                for (spell in magicData.baseSpells) {
                    addSpellEntry(layout, spell.name, spell.level)
                }
            }

            // Специалитеты
            if (magicData.specializationSpells.isNotEmpty()) {
                addSubHeader(layout, "Специалитеты")
                for ((specName, spells) in magicData.specializationSpells) {
                    addSpellEntry(layout, specName, 0, isBold = true)
                    for (spell in spells) {
                        addSpellEntry(layout, spell.name, spell.level)
                    }
                }
            }
        }

        // ========== ВСЕОБЩАЯ МАГИЯ ==========
        val hasUniversalSpells = magicData.universalMagic.any { it.value > 0 }
        if (hasUniversalSpells) {
            addSectionHeader(layout, "Всеобщая магия")
            for ((school, level) in magicData.universalMagic) {
                if (level > 0) {
                    val levelName = getUniversalLevelName(level)
                    addSchoolEntry(layout, school, levelName)
                }
            }
        }

        // ========== ТРОПА ЛЮБВИ ==========
        if (magicData.loveLanguages.isNotEmpty()) {
            addSectionHeader(layout, "Тропа любви")

            if (magicData.lovePathType.isNotEmpty()) {
                addSubHeader(layout, "Учение: ${magicData.lovePathType}")
            }

            for ((language, gestures) in magicData.loveLanguages) {
                if (gestures.isNotEmpty()) {
                    addSubHeader(layout, language)
                    for (gesture in gestures) {
                        addSpellEntry(layout, gesture, 0)
                    }
                }
            }
        }

        // ========== ВУДУ ==========
        if (magicData.voodooLoas.isNotEmpty()) {
            addSectionHeader(layout, "Вуду")
            for ((loa, aspect) in magicData.voodooLoas) {
                addSpellEntry(layout, "$loa ($aspect)", 0)
            }
        }

        // ========== БЕССТРАШИЕ ==========
        if (magicData.fearlessnessSpells.isNotEmpty()) {
            addSectionHeader(layout, "Бесстрашие")
            for (spell in magicData.fearlessnessSpells) {
                addSpellEntry(layout, spell, 0)
            }
        }

        // ========== МАГИЯ КРОВИ ==========
        if (magicData.hasBloodMagic) {
            addSectionHeader(layout, "Магия крови")
            addSpellEntry(layout, "Общие способности", 0)

            val branchSpells = when (magicData.branch) {
                MagicBranch.FLAME -> listOf("Кипячение крови", "Охлаждение крови", "Красная пелена")
                MagicBranch.LIFE -> listOf("Вкус крови", "Власть Сильного", "Кровотечение", "Прямо в сердце")
                MagicBranch.WORDS -> listOf("Договор на крови", "Зов крови", "Власть крови", "Слабая кровь", "Приказы самоповреждения")
                MagicBranch.BALANCE -> listOf("Баланс сил", "Эскалация", "Жертвенность")
                else -> emptyList()
            }

            if (branchSpells.isNotEmpty()) {
                addSubHeader(layout, "Ветвь: ${magicData.branch.displayName}")
                for (spell in branchSpells) {
                    addSpellEntry(layout, spell, 0)
                }
            }
        }

        // Если ничего нет
        if (layout.childCount == 0) {
            val tvEmpty = TextView(requireContext()).apply {
                text = "У персонажа пока нет способностей"
                textSize = 18f
                setTextColor(ContextCompat.getColor(requireContext(), R.color.bir))
                gravity = android.view.Gravity.CENTER
                setPadding(32, 64, 32, 64)
            }
            layout.addView(tvEmpty)
        }
    }

    private fun addSectionHeader(parent: LinearLayout, title: String) {
        val header = TextView(requireContext()).apply {
            text = title
            textSize = 22f
            setTextColor(ContextCompat.getColor(requireContext(), R.color.bir))
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(8, 24, 8, 12)
        }
        parent.addView(header)
    }

    private fun addSubHeader(parent: LinearLayout, title: String) {
        val header = TextView(requireContext()).apply {
            text = title
            textSize = 18f
            setTextColor(ContextCompat.getColor(requireContext(), R.color.bir))
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(16, 16, 8, 8)
        }
        parent.addView(header)
    }

    private fun addSpellEntry(parent: LinearLayout, name: String, level: Int, isBold: Boolean = false) {
        val tv = TextView(requireContext()).apply {
            var displayText = name
            if (level > 0) {
                displayText += " (${getUniversalLevelName(level)})"
            }
            text = displayText
            textSize = 16f
            setTextColor(ContextCompat.getColor(requireContext(), R.color.bir))
            setPadding(24, 12, 8, 12)
            if (isBold) {
                setTypeface(null, android.graphics.Typeface.BOLD)
            }

            // Делаем кликабельным
            setOnClickListener {
                showSpellFromDatabase(name)
            }
        }
        parent.addView(tv)
    }

    private fun addSchoolEntry(parent: LinearLayout, school: String, levelName: String) {
        val tv = TextView(requireContext()).apply {
            text = "$school — $levelName"
            textSize = 16f
            setTextColor(ContextCompat.getColor(requireContext(), R.color.bir))
            setPadding(24, 12, 8, 12)

            setOnClickListener {
                showSchoolFromDatabase(school)
            }
        }
        parent.addView(tv)
    }

    private fun showSpellFromDatabase(spellName: String) {
        // Ищем заклинание во всех базах
        val spell = SpellDatabase.allSpells.find { it.name.equals(spellName, ignoreCase = true) }

        if (spell != null) {
            showSpellDetail(spell)
        } else {
            // Может быть, это специалитет — ищем школу
            val school = SpellDatabase.getSchoolById(spellName.lowercase().replace(" ", "_"))
            if (school != null) {
                showSchoolDialog(school)
            }
        }
    }

    private fun showSchoolFromDatabase(schoolName: String) {
        // Ищем школу по имени
        val school = (SpellDatabase.branchSchools + SpellDatabase.universalSchools + SpellDatabase.forbiddenSchools)
            .find { it.name.equals(schoolName, ignoreCase = true) }

        if (school != null) {
            showSchoolDialog(school)
        } else {
            // Может, это отдельное заклинание
            val spell = SpellDatabase.allSpells.find { it.name.equals(schoolName, ignoreCase = true) }
            if (spell != null) {
                showSpellDetail(spell)
            }
        }
    }

    private fun showSchoolDialog(school: MagicSchool) {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_spell_detail)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<TextView>(R.id.tvDetailName).text = school.name
        dialog.findViewById<TextView>(R.id.tvDetailInfo).text = "${school.spells.size} заклинаний"
        dialog.findViewById<TextView>(R.id.tvDetailDescription).text = school.description

        dialog.findViewById<LinearLayout>(R.id.layoutRecipe).visibility = View.GONE

        dialog.findViewById<Button>(R.id.btnCloseDetail).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showSpellDetail(spell: SpellEntry) {
        val dialog = Dialog(requireContext()).apply {
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

            // Заголовок
            tvRecipeHeader.text = when (recipe.recipeType) {
                RecipeType.POTION -> "РЕЦЕПТ"
                RecipeType.RUNE -> "ОПИСАНИЕ"
                RecipeType.RITUAL -> "РИТУАЛ"
                RecipeType.GENERAL -> "ДЕТАЛИ"
            }

            // Дозировка / Носитель / Цена
            if (recipe.dosage.isNotEmpty() && recipe.dosage != "—") {
                blockDosage.visibility = View.VISIBLE
                tvDosageLabel.text = when (recipe.recipeType) {
                    RecipeType.POTION -> "Дозировка:"
                    RecipeType.RUNE -> "Носитель:"
                    RecipeType.RITUAL -> "Цена:"
                    RecipeType.GENERAL -> "Дозировка:"
                }
                tvRecipeDosage.text = recipe.dosage
            } else {
                blockDosage.visibility = View.GONE
            }

            // Ингредиенты
            if (recipe.ingredients.isNotEmpty() && recipe.ingredients.first() != "—") {
                blockIngredients.visibility = View.VISIBLE
                tvIngredientsLabel.text = when (recipe.recipeType) {
                    RecipeType.POTION -> "Состав (нажмите на ингредиент):"
                    RecipeType.RUNE -> "Основа:"
                    RecipeType.RITUAL -> "Компоненты:"
                    RecipeType.GENERAL -> "Список:"
                }
                fillIngredientsList(layoutIngredients, recipe.ingredients)
            } else {
                blockIngredients.visibility = View.GONE
            }

            // Приготовление / Начертание / Проведение
            if (recipe.preparation.isNotEmpty() && recipe.preparation != "—") {
                blockPreparation.visibility = View.VISIBLE
                tvPreparationLabel.text = when (recipe.recipeType) {
                    RecipeType.POTION -> "Приготовление:"
                    RecipeType.RUNE -> "Начертание:"
                    RecipeType.RITUAL -> "Проведение:"
                    RecipeType.GENERAL -> "Описание:"
                }
                tvRecipePreparation.text = recipe.preparation
            } else {
                blockPreparation.visibility = View.GONE
            }

            // Длительность
            if (recipe.duration.isNotEmpty() && recipe.duration != "—") {
                blockDuration.visibility = View.VISIBLE
                tvRecipeDuration.text = when (recipe.recipeType) {
                    RecipeType.POTION -> "Время действия: ${recipe.duration}\nПодливать: ${if (recipe.canBeAdded) "да" else "нет"}"
                    RecipeType.RUNE -> "Длительность: ${recipe.duration}"
                    RecipeType.RITUAL -> "Длительность: ${recipe.duration}"
                    RecipeType.GENERAL -> "Длительность: ${recipe.duration}"
                }
            } else {
                blockDuration.visibility = View.GONE
            }

            // Комментарии
            if (recipe.comments.isNotEmpty()) {
                tvRecipeComments.visibility = View.VISIBLE
                tvRecipeComments.text = recipe.comments
            } else {
                tvRecipeComments.visibility = View.GONE
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
            val ingredientView = TextView(requireContext()).apply {
                text = "• $ingredientName"
                textSize = 14f
                setTextColor(ContextCompat.getColor(requireContext(), R.color.bir))
                setPadding(16, 8, 8, 8)
                setOnClickListener {
                    val rune = RuneDatabase.allRunes.find {
                        ingredientName.startsWith(it.name, ignoreCase = true)
                    }
                    val ingredient = IngredientDatabase.allIngredients.find {
                        it.name.contains(ingredientName.substringBefore(" ("), ignoreCase = true) ||
                                ingredientName.contains(it.name.substringBefore(" ("), ignoreCase = true)
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
        val dialog = Dialog(requireContext()).apply {
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
        val dialog = Dialog(requireContext()).apply {
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

    private fun getUniversalLevelName(level: Int): String {
        return when (level) {
            1 -> "I уровень"
            2 -> "II уровень"
            3 -> "III уровень"
            4 -> "Мастер"
            5 -> "Архимаг"
            else -> "Уровень $level"
        }
    }
}