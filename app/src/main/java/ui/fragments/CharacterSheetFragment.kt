package com.example.konklavtracer_v2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.DatabaseHelper
import com.example.konklavtracer_v2.models.AspectType
import com.example.konklavtracer_v2.models.Character
import kotlin.math.max
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class CharacterSheetFragment : Fragment() {
    private lateinit var dbHelper: DatabaseHelper
    private var characterId: Int = -1
    private var character: Character? = null

    companion object {
        fun newInstance(characterId: Int): CharacterSheetFragment {
            return CharacterSheetFragment().apply {
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
        return inflater.inflate(R.layout.fragment_character_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterId = arguments?.getInt("character_id") ?: -1
        dbHelper = DatabaseHelper(requireContext())

        loadCharacter()
        setupResourceButtons(view)
    }

    override fun onResume() {
        super.onResume()
        loadCharacter()
    }

    private fun loadCharacter() {
        character = dbHelper.getCharacterById(characterId)
        character?.let { char ->
            view?.let { v ->
                updateBasicInfo(v, char)
                updateHealthCheckboxes(v, char)
                updateAspects(v, char)
                updateResources(v, char)
            }
        }
    }

    private fun updateBasicInfo(view: View, char: Character) {
        view.findViewById<TextView>(R.id.tvCharacterName).text = char.name

        val raceText = if (char.subrace.isNotEmpty()) {
            "${char.race} (${char.subrace})"
        } else {
            char.race
        }
        view.findViewById<TextView>(R.id.tvCharacterRace).text = "Раса: $raceText"

        // Отображение здоровья
        view.findViewById<TextView>(R.id.tvHealthValue).text = "${char.currentHealth} / ${char.maxHealth}"

        // Кнопка редактирования здоровья
        view.findViewById<ImageView>(R.id.ivEditHealth).setOnClickListener {
            showEditHealthDialog(char)
        }
    }

    private fun showEditHealthDialog(char: Character) {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_edit_health)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val tvCurrentMaxHealth = dialog.findViewById<TextView>(R.id.tvCurrentMaxHealth)
        val etNewMaxHealth = dialog.findViewById<EditText>(R.id.etNewMaxHealth)
        val btnCancel = dialog.findViewById<Button>(R.id.btnCancelHealth)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveHealth)

        tvCurrentMaxHealth.text = "Текущее максимальное здоровье: ${char.maxHealth}"
        etNewMaxHealth.setText(char.maxHealth.toString())

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        btnSave.setOnClickListener {
            val newMaxHealth = etNewMaxHealth.text.toString().toIntOrNull()

            if (newMaxHealth == null || newMaxHealth < 1) {
                Toast.makeText(requireContext(), "Введите корректное значение", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Обновляем максимальное здоровье
            val updatedChar = char.copy(
                maxHealth = newMaxHealth,
                currentHealth = if (char.currentHealth > newMaxHealth) newMaxHealth else char.currentHealth,
                updatedAt = System.currentTimeMillis()
            )

            dbHelper.updateCharacter(updatedChar)
            character = updatedChar
            loadCharacter()

            Toast.makeText(
                requireContext(),
                "Максимальное здоровье изменено на $newMaxHealth",
                Toast.LENGTH_SHORT
            ).show()

            dialog.dismiss()
        }

        dialog.show()
    }

    private fun updateHealthCheckboxes(view: View, char: Character) {
        val healthLayout = view.findViewById<LinearLayout>(R.id.layoutHealth)
        healthLayout.removeAllViews()
        healthLayout.orientation = LinearLayout.VERTICAL

        val maxPerRow = 10
        var currentRow: LinearLayout? = null

        for (i in 1..char.maxHealth) {
            if ((i - 1) % maxPerRow == 0) {
                currentRow = LinearLayout(requireContext()).apply {
                    orientation = LinearLayout.HORIZONTAL
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                }
                healthLayout.addView(currentRow)
            }

            val container = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.VERTICAL
                gravity = android.view.Gravity.CENTER
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(2, 2, 2, 2)
                }
            }

            val checkBox = CheckBox(requireContext()).apply {
                buttonDrawable = ContextCompat.getDrawable(context, R.drawable.checkbox_selector)
                isChecked = i <= char.currentHealth

                setOnCheckedChangeListener { _, isChecked ->
                    val newHealth = if (isChecked) {
                        if (char.currentHealth < i) i else char.currentHealth
                    } else {
                        if (char.currentHealth >= i) i - 1 else char.currentHealth
                    }

                    character = char.copy(currentHealth = newHealth)
                    character?.let { dbHelper.updateCharacter(it) }
                    loadCharacter()
                }
            }

            val numberText = TextView(requireContext()).apply {
                text = i.toString()
                setTextColor(ContextCompat.getColor(context, R.color.bir))
                textSize = 10f
                gravity = android.view.Gravity.CENTER
            }

            container.addView(checkBox)
            container.addView(numberText)
            currentRow?.addView(container)
        }
    }

    private fun updateAspects(view: View, char: Character) {
        val aspectsLayout = view.findViewById<LinearLayout>(R.id.layoutAspects)
        aspectsLayout.removeAllViews()

        for (aspectType in AspectType.values()) {
            val aspectView = LayoutInflater.from(requireContext()).inflate(
                R.layout.item_aspect_display,
                aspectsLayout,
                false
            )

            val tvAspectName = aspectView.findViewById<TextView>(R.id.tvAspectName)
            val tvAspectValue = aspectView.findViewById<TextView>(R.id.tvAspectValue)
            val ivRollDice = aspectView.findViewById<ImageView>(R.id.ivRollDice)

            tvAspectName.text = aspectType.displayName
            tvAspectValue.text = char.finalAspects.getValue(aspectType).toString()

            // Обычный клик — бросок кубиков
            aspectView.setOnClickListener {
                showDiceRollDialog(aspectType, char.finalAspects.getValue(aspectType))
            }

            ivRollDice.setOnClickListener {
                showDiceRollDialog(aspectType, char.finalAspects.getValue(aspectType))
            }

            // Долгое нажатие — редактирование аспекта
            aspectView.setOnLongClickListener {
                showEditAspectDialog(aspectType, char)
                true
            }

            aspectsLayout.addView(aspectView)
        }
    }

    private fun showEditAspectDialog(aspectType: AspectType, char: Character) {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_edit_aspect)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val tvAspectName = dialog.findViewById<TextView>(R.id.tvEditAspectName)
        val tvAspectValue = dialog.findViewById<TextView>(R.id.tvEditAspectValue)
        val btnMinus = dialog.findViewById<Button>(R.id.btnMinusAspect)
        val btnPlus = dialog.findViewById<Button>(R.id.btnPlusAspect)
        val btnCancel = dialog.findViewById<Button>(R.id.btnCancelAspect)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveAspect)

        tvAspectName.text = aspectType.displayName

        var currentValue = char.finalAspects.getValue(aspectType)
        tvAspectValue.text = currentValue.toString()

        btnMinus.setOnClickListener {
            if (currentValue > 0) {
                currentValue--
                tvAspectValue.text = currentValue.toString()
            }
        }

        btnPlus.setOnClickListener {
            currentValue++
            tvAspectValue.text = currentValue.toString()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        btnSave.setOnClickListener {
            // Обновляем аспект
            val updatedAspects = char.finalAspects.setValue(aspectType, currentValue)
            val updatedChar = char.copy(
                finalAspects = updatedAspects,
                updatedAt = System.currentTimeMillis()
            )

            dbHelper.updateCharacter(updatedChar)
            character = updatedChar
            loadCharacter()

            Toast.makeText(
                requireContext(),
                "${aspectType.displayName} изменён на $currentValue",
                Toast.LENGTH_SHORT
            ).show()

            dialog.dismiss()
        }

        dialog.show()
    }

    private fun updateResources(view: View, char: Character) {
        view.findViewById<TextView>(R.id.tvCopper).text = char.copper.toString()
        view.findViewById<TextView>(R.id.tvSilver).text = char.silver.toString()
        view.findViewById<TextView>(R.id.tvGold).text = char.gold.toString()
        view.findViewById<TextView>(R.id.tvArrows).text = char.arrows.toString()
    }

    private fun showDiceRollDialog(aspectType: AspectType, aspectValue: Int) {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_dice_roll)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val tvAspectName = dialog.findViewById<TextView>(R.id.tvAspectName)
        val tvRollResult = dialog.findViewById<TextView>(R.id.tvRollResult)
        val btnRollDice = dialog.findViewById<Button>(R.id.btnRollDice)
        val btnCloseDice = dialog.findViewById<Button>(R.id.btnCloseDice)

        val diceViews = listOf(
            dialog.findViewById<ImageView>(R.id.ivDice1),
            dialog.findViewById<ImageView>(R.id.ivDice2),
            dialog.findViewById<ImageView>(R.id.ivDice3),
            dialog.findViewById<ImageView>(R.id.ivDice4)
        )

        tvAspectName.text = "${aspectType.displayName}: $aspectValue"

        btnRollDice.setOnClickListener {
            // Бросаем 4 кубика
            var diceResult = 0
            val diceValues = mutableListOf<Int>()

            for (i in 0 until 4) {
                val roll = when (kotlin.random.Random.nextInt(3)) {
                    0 -> {  // Плюс
                        diceResult += 1
                        1
                    }
                    1 -> {  // Минус
                        diceResult -= 1
                        -1
                    }
                    else -> {  // Ноль
                        0
                    }
                }
                diceValues.add(roll)
            }

            // Обновляем картинки кубиков
            for (i in 0 until 4) {
                val drawable = when (diceValues[i]) {
                    1 -> R.drawable.dice_plus
                    -1 -> R.drawable.dice_minus
                    else -> R.drawable.dice_zero
                }
                diceViews[i].setImageResource(drawable)
            }

            // Показываем результат
            val totalResult = diceResult + aspectValue
            tvRollResult.text = "Итог: $totalResult"
            tvRollResult.visibility = View.VISIBLE
        }

        btnCloseDice.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun setupResourceButtons(view: View) {
        setupResourceControls(
            view,
            R.id.btnPlus10Copper, R.id.btnPlusCopper,
            R.id.btnMinusCopper, R.id.btnMinus10Copper,
            R.id.tvCopper,
            { character?.copper ?: 0 },
            { value -> character = character?.copy(copper = value) }
        )

        setupResourceControls(
            view,
            R.id.btnPlus10Silver, R.id.btnPlusSilver,
            R.id.btnMinusSilver, R.id.btnMinus10Silver,
            R.id.tvSilver,
            { character?.silver ?: 0 },
            { value -> character = character?.copy(silver = value) }
        )

        setupResourceControls(
            view,
            R.id.btnPlus10Gold, R.id.btnPlusGold,
            R.id.btnMinusGold, R.id.btnMinus10Gold,
            R.id.tvGold,
            { character?.gold ?: 0 },
            { value -> character = character?.copy(gold = value) }
        )

        setupResourceControls(
            view,
            R.id.btnPlus10Arrows, R.id.btnPlusArrows,
            R.id.btnMinusArrows, R.id.btnMinus10Arrows,
            R.id.tvArrows,
            { character?.arrows ?: 0 },
            { value -> character = character?.copy(arrows = value) }
        )
    }

    private fun setupResourceControls(
        view: View,
        plus10BtnId: Int,
        plusBtnId: Int,
        minusBtnId: Int,
        minus10BtnId: Int,
        valueViewId: Int,
        getValue: () -> Int,
        setValue: (Int) -> Unit
    ) {
        val plus10Btn = view.findViewById<Button>(plus10BtnId)
        val plusBtn = view.findViewById<Button>(plusBtnId)
        val minusBtn = view.findViewById<Button>(minusBtnId)
        val minus10Btn = view.findViewById<Button>(minus10BtnId)
        val valueView = view.findViewById<TextView>(valueViewId)

        plus10Btn.setOnClickListener {
            val newValue = getValue() + 10
            setValue(newValue)
            updateCharacterAndUI(valueView, newValue)
        }

        plusBtn.setOnClickListener {
            val newValue = getValue() + 1
            setValue(newValue)
            updateCharacterAndUI(valueView, newValue)
        }

        minusBtn.setOnClickListener {
            val newValue = max(0, getValue() - 1)
            setValue(newValue)
            updateCharacterAndUI(valueView, newValue)
        }

        minus10Btn.setOnClickListener {
            val newValue = max(0, getValue() - 10)
            setValue(newValue)
            updateCharacterAndUI(valueView, newValue)
        }
    }

    private fun updateCharacterAndUI(textView: TextView, value: Int) {
        textView.text = value.toString()
        character?.let { dbHelper.updateCharacter(it) }
    }
}