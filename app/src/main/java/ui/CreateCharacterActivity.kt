package com.example.konklavtracer_v2.ui

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.AspectCalculator
import com.example.konklavtracer_v2.data.DatabaseHelper
import com.example.konklavtracer_v2.data.MagicDatabase
import com.example.konklavtracer_v2.data.RaceDatabase
import com.example.konklavtracer_v2.models.*

class CreateCharacterActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper

    // Шаги
    private lateinit var step1Layout: View
    private lateinit var step2Layout: View

    private lateinit var step3Layout: View

    private lateinit var step4Layout: View

    private lateinit var layoutBaseSpells: LinearLayout

    private lateinit var layoutSpecializations: LinearLayout

    private lateinit var tvSpecializationsNote: TextView

    private val selectedBaseSpells = mutableListOf<BaseSpell>()

    private val universalMagicLevels = mutableMapOf<String, Int>()
    private val selectedAchievements = mutableListOf<String>()

    private val selectedSpecializations = mutableListOf<String>()

    private val specializationSpellsMap = mutableMapOf<String, List<BaseSpell>>()

    private lateinit var tvStepTitle: TextView
    private lateinit var btnBack: Button
    private lateinit var btnNext: Button

    // Шаг 1
    private lateinit var etName: EditText
    private lateinit var spinnerRace: Spinner
    private lateinit var spinnerSubrace: Spinner
    private lateinit var layoutSubrace: LinearLayout
    private lateinit var tvFreePointsInfo: TextView
    private lateinit var layoutAspects: LinearLayout

    private val selectedLovePath = mutableMapOf<String, Any>()

    private val selectedLoveLanguages = mutableMapOf<String, List<String>>()

    private val aspectValues = mutableMapOf<AspectType, Int>()
    private var freePointsRemaining = 0
    private val maxPerAspect = 5

    private val combatTrainingChoices = mutableListOf<String>()

    // Шаг 2
    private lateinit var radioGroupBranch: RadioGroup
    private lateinit var layoutBalanceDirection: LinearLayout
    private lateinit var layoutLifeDirection: LinearLayout
    private lateinit var layoutAnimalType: LinearLayout
    private lateinit var spinnerAnimalType: Spinner

    private val selectedFearlessnessSpells = mutableListOf<String>()
    private var selectedBloodMagic = false

    private lateinit var step5Layout: View

    private var artifactHealthBonus = 0

    private lateinit var step6Layout: View

    private val selectedLoas = mutableMapOf<String, String>()  // Лоа -> выбранный аспект

    private lateinit var layoutUniversalMagic: LinearLayout

    private lateinit var layoutAchievements: LinearLayout


    // Данные для сохранения
    private var characterName = ""
    private var characterRace = ""
    private var characterSubrace = ""

    private var lovePathType = ""
    private var baseAspects = Aspects()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_character)

        dbHelper = DatabaseHelper(this)

        initViews()
        setupStep1()
        setupStep2()
    }

    private fun initViews() {
        step1Layout = findViewById(R.id.step1Layout)
        step2Layout = findViewById(R.id.step2Layout)
        tvStepTitle = findViewById(R.id.tvStepTitle)
        btnBack = findViewById(R.id.btnBack)
        btnNext = findViewById(R.id.btnNext)

        step3Layout = findViewById(R.id.step3Layout)
        step4Layout = findViewById(R.id.step4Layout)
        layoutBaseSpells = findViewById(R.id.layoutBaseSpells)
        layoutSpecializations = findViewById(R.id.layoutSpecializations)
        tvSpecializationsNote = findViewById(R.id.tvSpecializationsNote)

        step5Layout = findViewById(R.id.step5Layout)
        step6Layout = findViewById(R.id.step6Layout)
        layoutUniversalMagic = findViewById(R.id.layoutUniversalMagic)
        layoutAchievements = findViewById(R.id.layoutAchievements)

        // НОВОЕ: Кнопки для артефактного здоровья
        val btnMinusArtifactHealth = findViewById<Button>(R.id.btnMinusArtifactHealth)
        val btnPlusArtifactHealth = findViewById<Button>(R.id.btnPlusArtifactHealth)
        val tvArtifactHealth = findViewById<TextView>(R.id.tvArtifactHealth)

        btnMinusArtifactHealth.setOnClickListener {
            if (artifactHealthBonus > 0) {
                artifactHealthBonus--
                tvArtifactHealth.text = artifactHealthBonus.toString()
            }
        }

        btnPlusArtifactHealth.setOnClickListener {
            artifactHealthBonus++
            tvArtifactHealth.text = artifactHealthBonus.toString()
        }

        btnBack.setOnClickListener {
            when {
                step2Layout.visibility == View.VISIBLE -> showStep(1)
                step3Layout.visibility == View.VISIBLE -> showStep(2)
                step4Layout.visibility == View.VISIBLE -> showStep(3)
                step5Layout.visibility == View.VISIBLE -> {
                    if (hasMagic()) showStep(4) else showStep(2)
                }
                step6Layout.visibility == View.VISIBLE -> showStep(5)
            }
        }

        btnNext.setOnClickListener {
            when {
                step1Layout.visibility == View.VISIBLE -> {
                    if (validateStep1()) showStep(2)
                }
                step2Layout.visibility == View.VISIBLE -> {
                    if (validateStep2()) {
                        if (hasMagic()) {
                            setupStep3()
                            showStep(3)
                        } else {
                            setupStep5()  // Пропускаем шаги 3-4 для немагов
                            showStep(5)
                        }
                    }
                }
                step3Layout.visibility == View.VISIBLE -> {
                    if (validateStep3()) {
                        setupStep4()
                        showStep(4)
                    }
                }
                step4Layout.visibility == View.VISIBLE -> {
                    setupStep5()
                    showStep(5)
                }
                step5Layout.visibility == View.VISIBLE -> {
                    setupStep6()
                    showStep(6)
                }
                step6Layout.visibility == View.VISIBLE -> {
                    saveCharacter()
                }
            }
        }
    }

    private fun showStep(step: Int) {
        step1Layout.visibility = View.GONE
        step2Layout.visibility = View.GONE
        step3Layout.visibility = View.GONE
        step4Layout.visibility = View.GONE
        step5Layout.visibility = View.GONE
        step6Layout.visibility = View.GONE

        when (step) {
            1 -> {
                step1Layout.visibility = View.VISIBLE
                tvStepTitle.text = "Шаг 1: Базовая информация"
                btnBack.visibility = View.GONE
                btnNext.text = "Далее"
            }
            2 -> {
                step2Layout.visibility = View.VISIBLE
                tvStepTitle.text = "Шаг 2: Магия"
                btnBack.visibility = View.VISIBLE
                btnNext.text = "Далее"
            }
            3 -> {
                step3Layout.visibility = View.VISIBLE
                tvStepTitle.text = "Шаг 3: Базовые умения"
                btnBack.visibility = View.VISIBLE
                btnNext.text = "Далее"
            }
            4 -> {
                step4Layout.visibility = View.VISIBLE
                tvStepTitle.text = "Шаг 4: Специалитеты"
                btnBack.visibility = View.VISIBLE
                btnNext.text = "Далее"
            }
            5 -> {
                step5Layout.visibility = View.VISIBLE
                tvStepTitle.text = "Шаг 5: Неветвийная магия"
                btnBack.visibility = View.VISIBLE
                btnNext.text = "Далее"
            }
            6 -> {
                step6Layout.visibility = View.VISIBLE
                tvStepTitle.text = "Шаг 6: Достижения"
                btnBack.visibility = View.VISIBLE
                btnNext.text = "Создать персонажа"
            }
        }
    }

    // ========== ШАГ 1: БАЗОВАЯ ИНФОРМАЦИЯ ==========

    private fun setupStep1() {
        etName = findViewById(R.id.etName)
        spinnerRace = findViewById(R.id.spinnerRace)
        spinnerSubrace = findViewById(R.id.spinnerSubrace)
        layoutSubrace = findViewById(R.id.layoutSubrace)
        tvFreePointsInfo = findViewById(R.id.tvFreePointsInfo)
        layoutAspects = findViewById(R.id.layoutAspects)

        setupRaceSpinner()
        setupAspectList()
    }

    private fun setupRaceSpinner() {
        val raceNames = RaceDatabase.getRaceNames()
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            raceNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRace.adapter = adapter

        spinnerRace.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val raceName = raceNames[position]
                updateSubraceVisibility(raceName)
                resetAspects()
                updateFreePointsInfo()
                updateAspectUI()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        if (raceNames.isNotEmpty()) {
            updateSubraceVisibility(raceNames[0])
            updateFreePointsInfo()
        }
    }

    private fun updateSubraceVisibility(raceName: String) {
        val subraces = RaceDatabase.getSubracesForRace(raceName)

        if (subraces.isNotEmpty()) {
            layoutSubrace.visibility = View.VISIBLE
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                subraces
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSubrace.adapter = adapter

            spinnerSubrace.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    resetAspects()
                    updateFreePointsInfo()
                    updateAspectUI()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        } else {
            layoutSubrace.visibility = View.GONE
        }
    }

    private fun setupAspectList() {
        layoutAspects.removeAllViews()

        for (aspectType in AspectType.values()) {
            val aspectView = LayoutInflater.from(this).inflate(
                R.layout.item_aspect_distribution,
                layoutAspects,
                false
            )

            val tvAspectName = aspectView.findViewById<TextView>(R.id.tvAspectName)
            val tvAspectValue = aspectView.findViewById<TextView>(R.id.tvAspectValue)
            val btnMinus = aspectView.findViewById<Button>(R.id.btnMinus)
            val btnPlus = aspectView.findViewById<Button>(R.id.btnPlus)

            tvAspectName.text = aspectType.displayName
            aspectView.tag = AspectViewHolder(tvAspectValue, aspectType, btnMinus, btnPlus)

            btnMinus.setOnClickListener { decreaseAspect(aspectType) }
            btnPlus.setOnClickListener { increaseAspect(aspectType) }

            layoutAspects.addView(aspectView)
        }

        resetAspects()
        updateFreePointsInfo()
        updateAspectUI()
    }

    private fun resetAspects() {
        for (aspectType in AspectType.values()) {
            aspectValues[aspectType] = 0
        }
    }

    private fun getCurrentRaceName(): String = spinnerRace.selectedItem?.toString() ?: ""

    private fun getCurrentSubraceName(): String? {
        return if (layoutSubrace.visibility == View.VISIBLE) {
            spinnerSubrace.selectedItem?.toString()
        } else {
            null
        }
    }

    private fun getRacialBonus(aspectType: AspectType): Int {
        val raceName = getCurrentRaceName()
        val subraceName = getCurrentSubraceName()
        val totalBonus = RaceDatabase.getTotalBonusForRace(raceName, subraceName)
        return totalBonus.getValue(aspectType)
    }

    private fun getTotalAspectValue(aspectType: AspectType): Int {
        val baseValue = aspectValues[aspectType] ?: 0
        return baseValue + getRacialBonus(aspectType)
    }

    private fun updateFreePointsInfo() {
        val raceName = getCurrentRaceName()
        freePointsRemaining = RaceDatabase.getFreePointsForRace(raceName)
        tvFreePointsInfo.text = "Свободных очков: $freePointsRemaining"
    }

    private fun updateFreePointsText() {
        tvFreePointsInfo.text = "Свободных очков: $freePointsRemaining"
    }

    private fun increaseAspect(aspectType: AspectType) {
        val currentValue = aspectValues[aspectType] ?: 0

        if (freePointsRemaining <= 0) {
            Toast.makeText(this, "Нет свободных очков!", Toast.LENGTH_SHORT).show()
            return
        }

        if (currentValue >= maxPerAspect) {
            Toast.makeText(this, "Максимум $maxPerAspect в одном аспекте!", Toast.LENGTH_SHORT).show()
            return
        }

        aspectValues[aspectType] = currentValue + 1
        freePointsRemaining--
        updateFreePointsText()
        updateAspectUI()
    }

    private fun decreaseAspect(aspectType: AspectType) {
        val currentValue = aspectValues[aspectType] ?: 0

        if (currentValue <= 0) return

        aspectValues[aspectType] = currentValue - 1
        freePointsRemaining++
        updateFreePointsText()
        updateAspectUI()
    }

    private fun updateAspectUI() {
        for (i in 0 until layoutAspects.childCount) {
            val aspectView = layoutAspects.getChildAt(i)
            val holder = aspectView.tag as? AspectViewHolder ?: continue

            val totalValue = getTotalAspectValue(holder.aspectType)
            val racialBonus = getRacialBonus(holder.aspectType)

            if (racialBonus != 0) {
                holder.tvValue.text = "$totalValue (${if (racialBonus > 0) "+" else ""}$racialBonus)"
            } else {
                holder.tvValue.text = totalValue.toString()
            }

            val baseValue = aspectValues[holder.aspectType] ?: 0
            holder.btnMinus.isEnabled = baseValue > 0
            holder.btnPlus.isEnabled = freePointsRemaining > 0 && baseValue < maxPerAspect
        }
    }

    private fun validateStep1(): Boolean {
        val name = etName.text.toString().trim()

        if (name.isEmpty()) {
            Toast.makeText(this, "Введите имя персонажа!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (freePointsRemaining > 0) {
            Toast.makeText(
                this,
                "Распределите все свободные очки! Осталось: $freePointsRemaining",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        characterName = name
        characterRace = getCurrentRaceName()
        characterSubrace = getCurrentSubraceName() ?: ""

        baseAspects = Aspects(
            vigilance = getTotalAspectValue(AspectType.VIGILANCE),
            perception = getTotalAspectValue(AspectType.PERCEPTION),
            will = getTotalAspectValue(AspectType.WILL),
            agility = getTotalAspectValue(AspectType.AGILITY),
            constitution = getTotalAspectValue(AspectType.CONSTITUTION),
            driving = getTotalAspectValue(AspectType.DRIVING),
            craft = getTotalAspectValue(AspectType.CRAFT),
            magic = getTotalAspectValue(AspectType.MAGIC),
            melee = getTotalAspectValue(AspectType.MELEE),
            shooting = getTotalAspectValue(AspectType.SHOOTING),
            stealth = getTotalAspectValue(AspectType.STEALTH),
            healing = getTotalAspectValue(AspectType.HEALING)
        )

        return true
    }

    // ========== ШАГ 2: МАГИЯ ==========

    private fun setupStep2() {
        radioGroupBranch = findViewById(R.id.radioGroupBranch)
        layoutBalanceDirection = findViewById(R.id.layoutBalanceDirection)
        layoutLifeDirection = findViewById(R.id.layoutLifeDirection)
        layoutAnimalType = findViewById(R.id.layoutAnimalType)
        spinnerAnimalType = findViewById(R.id.spinnerAnimalType)

        setupAnimalSpinner()
        setupBranchListener()
    }

    private fun setupAnimalSpinner() {
        val animals = AnimalType.values().map { it.displayName }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            animals
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAnimalType.adapter = adapter
    }

    private fun setupBranchListener() {
        radioGroupBranch.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioNoMagic -> {
                    layoutBalanceDirection.visibility = View.GONE
                    layoutLifeDirection.visibility = View.GONE
                }
                R.id.radioBalance -> {
                    layoutBalanceDirection.visibility = View.VISIBLE
                    layoutLifeDirection.visibility = View.GONE
                }
                R.id.radioWords, R.id.radioFlame -> {
                    layoutBalanceDirection.visibility = View.GONE
                    layoutLifeDirection.visibility = View.GONE
                }
                R.id.radioLife -> {
                    layoutBalanceDirection.visibility = View.GONE
                    layoutLifeDirection.visibility = View.VISIBLE
                }
            }
        }

        // Слушатель для направления Жизни
        val radioGroupLife = findViewById<RadioGroup>(R.id.radioGroupLifeDirection)
        radioGroupLife.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.radioShapeshifter) {
                layoutAnimalType.visibility = View.VISIBLE
            } else {
                layoutAnimalType.visibility = View.GONE
            }
        }
    }

    private fun hasMagic(): Boolean {
        return radioGroupBranch.checkedRadioButtonId != R.id.radioNoMagic
    }

    private fun setupStep3() {
        layoutBaseSpells.removeAllViews()
        selectedBaseSpells.clear()

        val branch = getSelectedBranch()
        val balanceDir = getSelectedBalanceDirection()
        val lifeDir = getSelectedLifeDirection()

        val spells = MagicDatabase.getBaseSpells(branch, balanceDir, lifeDir)

        if (spells.isEmpty()) {
            val tvEmpty = TextView(this).apply {
                text = "Нет базовых умений для выбранной ветви"
                textSize = 16f
                setTextColor(ContextCompat.getColor(this@CreateCharacterActivity, R.color.bir))
                gravity = View.TEXT_ALIGNMENT_CENTER
            }
            layoutBaseSpells.addView(tvEmpty)
            return
        }

        // Сортируем заклинания по уровню
        val sortedSpells = spells.sortedBy { it.level }

        // Создаем список чекбоксов для управления
        val checkboxes = mutableListOf<CheckBox>()
        val spellViews = mutableListOf<View>()

        for (spell in sortedSpells) {
            val spellView = LayoutInflater.from(this).inflate(
                R.layout.item_base_spell,
                layoutBaseSpells,
                false
            )

            val cbSpell = spellView.findViewById<CheckBox>(R.id.cbBaseSpell)
            val tvSpellName = spellView.findViewById<TextView>(R.id.tvSpellName)

            cbSpell.text = ""
            tvSpellName.text = "${spell.name} (${spell.level} уровень)"

            cbSpell.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // При выборе уровня - выбираем все предыдущие
                    selectSpellsUpTo(spell.level, sortedSpells, checkboxes)
                } else {
                    // При снятии выбора - снимаем все последующие
                    deselectSpellsFrom(spell.level, sortedSpells, checkboxes)
                }
            }

            checkboxes.add(cbSpell)
            spellViews.add(spellView)
            layoutBaseSpells.addView(spellView)
        }
    }

    // Вспомогательный метод: выбрать все заклинания до указанного уровня
    private fun selectSpellsUpTo(
        level: Int,
        allSpells: List<BaseSpell>,
        checkboxes: List<CheckBox>
    ) {
        selectedBaseSpells.clear()

        for (i in allSpells.indices) {
            if (allSpells[i].level <= level) {
                checkboxes[i].isChecked = true
                if (!selectedBaseSpells.contains(allSpells[i])) {
                    selectedBaseSpells.add(allSpells[i])
                }
            }
        }
    }

    // Вспомогательный метод: снять выбор с заклинаний начиная с указанного уровня
    private fun deselectSpellsFrom(
        level: Int,
        allSpells: List<BaseSpell>,
        checkboxes: List<CheckBox>
    ) {
        for (i in allSpells.indices) {
            if (allSpells[i].level >= level) {
                checkboxes[i].isChecked = false
                selectedBaseSpells.remove(allSpells[i])
            }
        }
    }

    private fun validateStep3(): Boolean {
        return true  // Можно выбрать любое количество базовых умений
    }

    // Новые методы для шага 4:
    private fun setupStep4() {
        layoutSpecializations.removeAllViews()
        selectedSpecializations.clear()
        specializationSpellsMap.clear()

        val branch = getSelectedBranch()
        val balanceDir = getSelectedBalanceDirection()
        val lifeDir = getSelectedLifeDirection()

        val specializations = MagicDatabase.getSpecializations(branch, balanceDir, lifeDir)

        val hasAllBaseSpells = selectedBaseSpells.size >= 3

        if (hasAllBaseSpells) {
            tvSpecializationsNote.text = "Выберите специалитеты и нажмите для выбора заклинаний:"

            for (spec in specializations) {
                val specView = LayoutInflater.from(this).inflate(
                    R.layout.item_specialization,
                    layoutSpecializations,
                    false
                )

                val cbSpec = specView.findViewById<CheckBox>(R.id.cbSpecialization)
                val tvSpecName = specView.findViewById<TextView>(R.id.tvSpecializationName)
                val btnChooseSpells = specView.findViewById<Button>(R.id.btnChooseSpells)

                cbSpec.text = ""
                tvSpecName.text = spec
                btnChooseSpells.visibility = View.GONE

                cbSpec.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        if (!selectedSpecializations.contains(spec)) {
                            selectedSpecializations.add(spec)
                        }
                        btnChooseSpells.visibility = View.VISIBLE
                    } else {
                        selectedSpecializations.remove(spec)
                        specializationSpellsMap.remove(spec)
                        btnChooseSpells.visibility = View.GONE
                    }
                }

                btnChooseSpells.setOnClickListener {
                    showSpecializationSpellsDialog(spec)
                }

                layoutSpecializations.addView(specView)
            }
        } else {
            tvSpecializationsNote.text = "Для выбора специалитетов нужно освоить все 3 базовых умения"

            val tvEmpty = TextView(this).apply {
                text = "Специалитеты недоступны"
                textSize = 16f
                setTextColor(ContextCompat.getColor(this@CreateCharacterActivity, R.color.bir))
                gravity = View.TEXT_ALIGNMENT_CENTER
                setPadding(32, 32, 32, 32)
            }
            layoutSpecializations.addView(tvEmpty)
        }
    }

    private fun showSpecializationSpellsDialog(specializationName: String) {
        val dialog = android.app.Dialog(this).apply {
            setContentView(R.layout.dialog_specialization_spells)
            window?.setBackgroundDrawable(
                android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT)
            )
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val tvSpecTitle = dialog.findViewById<TextView>(R.id.tvSpecTitle)
        val layoutSpecSpells = dialog.findViewById<LinearLayout>(R.id.layoutSpecSpells)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveSpecSpells)

        tvSpecTitle.text = specializationName

        val spells = MagicDatabase.getSpecializationSpells(specializationName)
        val sortedSpells = spells.sortedBy { it.level }

        // Восстанавливаем выбранные заклинания
        val selectedSpells = specializationSpellsMap[specializationName]?.toMutableList() ?: mutableListOf()

        // Создаем список чекбоксов
        val checkboxes = mutableListOf<CheckBox>()

        for (spell in sortedSpells) {
            val spellView = LayoutInflater.from(this).inflate(
                R.layout.item_base_spell,
                layoutSpecSpells,
                false
            )

            val cbSpell = spellView.findViewById<CheckBox>(R.id.cbBaseSpell)
            val tvSpellName = spellView.findViewById<TextView>(R.id.tvSpellName)

            tvSpellName.text = "${spell.name} (${spell.level} уровень)"

            // Восстанавливаем состояние
            cbSpell.isChecked = selectedSpells.any { it.name == spell.name }

            cbSpell.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Выбираем все предыдущие уровни
                    for (i in sortedSpells.indices) {
                        if (sortedSpells[i].level <= spell.level) {
                            checkboxes[i].isChecked = true
                            if (!selectedSpells.any { it.name == sortedSpells[i].name }) {
                                selectedSpells.add(sortedSpells[i])
                            }
                        }
                    }
                } else {
                    // Снимаем все последующие уровни
                    for (i in sortedSpells.indices) {
                        if (sortedSpells[i].level >= spell.level) {
                            checkboxes[i].isChecked = false
                            selectedSpells.removeAll { it.name == sortedSpells[i].name }
                        }
                    }
                }
            }

            checkboxes.add(cbSpell)
            layoutSpecSpells.addView(spellView)
        }

        btnSave.setOnClickListener {
            specializationSpellsMap[specializationName] = selectedSpells.toList()
            dialog.dismiss()
            Toast.makeText(
                this,
                "Заклинания специалитета сохранены",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.show()
    }

    private fun showFearlessnessDialog() {
        val dialog = android.app.Dialog(this).apply {
            setContentView(R.layout.dialog_simple_spells)
            window?.setBackgroundDrawable(
                android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT)
            )
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val tvTitle = dialog.findViewById<TextView>(R.id.tvDialogTitle)
        val layoutSpells = dialog.findViewById<LinearLayout>(R.id.layoutDialogSpells)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveSpells)

        tvTitle.text = "Бесстрашие"

        val spells = MagicDatabase.fearlessnessSpells
        val tempSelected = mutableListOf<String>()
        tempSelected.addAll(selectedFearlessnessSpells)

        for (spell in spells) {
            val spellView = LayoutInflater.from(this).inflate(
                R.layout.item_base_spell,
                layoutSpells,
                false
            )

            val cbSpell = spellView.findViewById<CheckBox>(R.id.cbBaseSpell)
            val tvSpellName = spellView.findViewById<TextView>(R.id.tvSpellName)

            tvSpellName.text = spell
            cbSpell.isChecked = tempSelected.contains(spell)

            cbSpell.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (!tempSelected.contains(spell)) {
                        tempSelected.add(spell)
                    }
                } else {
                    tempSelected.remove(spell)
                }
            }

            layoutSpells.addView(spellView)
        }

        btnSave.setOnClickListener {
            selectedFearlessnessSpells.clear()
            selectedFearlessnessSpells.addAll(tempSelected)
            dialog.dismiss()
            Toast.makeText(
                this,
                "Заклинания Бесстрашия сохранены",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.show()
    }


    private fun validateStep2(): Boolean {
        return true  // Пока всегда true, можно добавить проверки
    }

    private fun getSelectedBranch(): MagicBranch {
        return when (radioGroupBranch.checkedRadioButtonId) {
            R.id.radioBalance -> MagicBranch.BALANCE
            R.id.radioWords -> MagicBranch.WORDS
            R.id.radioFlame -> MagicBranch.FLAME
            R.id.radioLife -> MagicBranch.LIFE
            else -> MagicBranch.NONE
        }
    }

    private fun getSelectedBalanceDirection(): BalanceDirection? {
        if (radioGroupBranch.checkedRadioButtonId != R.id.radioBalance) return null
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupBalanceDirection)
        return when (radioGroup.checkedRadioButtonId) {
            R.id.radioShadow -> BalanceDirection.SHADOW
            else -> BalanceDirection.LIGHT
        }
    }


    private fun getSelectedLifeDirection(): LifeDirection? {
        if (radioGroupBranch.checkedRadioButtonId != R.id.radioLife) return null
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupLifeDirection)
        return when (radioGroup.checkedRadioButtonId) {
            R.id.radioShapeshifter -> LifeDirection.SHAPESHIFTER
            else -> LifeDirection.SHAMAN
        }
    }

    private fun setupStep5() {
        layoutUniversalMagic.removeAllViews()
        universalMagicLevels.clear()

        val schools = MagicDatabase.universalSchools
        val levels = MagicDatabase.universalLevels

        for (school in schools) {
            when (school) {
                "Вудуизм" -> {
                    // Кнопка для выбора лоа
                    val voodooView = LayoutInflater.from(this).inflate(
                        R.layout.item_universal_magic,
                        layoutUniversalMagic,
                        false
                    )

                    val tvSchoolName = voodooView.findViewById<TextView>(R.id.tvSchoolName)
                    val spinnerLevel = voodooView.findViewById<Spinner>(R.id.spinnerLevel)

                    tvSchoolName.text = school
                    spinnerLevel.visibility = View.GONE

                    val btnChooseLoas = Button(this).apply {
                        text = "Выбрать Лоа"
                        textSize = 14f
                        setTextColor(ContextCompat.getColor(this@CreateCharacterActivity, R.color.bir))
                        setBackgroundResource(R.drawable.itembrightbtn)
                        setOnClickListener {
                            showVoodooLoasDialog()
                        }
                    }

                    (voodooView as LinearLayout).addView(btnChooseLoas)
                    layoutUniversalMagic.addView(voodooView)
                }

                "Тропа любви" -> {
                    // Кнопка для настройки Тропы Любви
                    val loveView = LayoutInflater.from(this).inflate(
                        R.layout.item_universal_magic,
                        layoutUniversalMagic,
                        false
                    )

                    val tvSchoolName = loveView.findViewById<TextView>(R.id.tvSchoolName)
                    val spinnerLevel = loveView.findViewById<Spinner>(R.id.spinnerLevel)

                    tvSchoolName.text = school
                    spinnerLevel.visibility = View.GONE

                    val btnChooseLovePath = Button(this).apply {
                        text = "Настроить Тропу Любви"
                        textSize = 14f
                        setTextColor(ContextCompat.getColor(this@CreateCharacterActivity, R.color.bir))
                        setBackgroundResource(R.drawable.itembrightbtn)
                        setOnClickListener {
                            showLovePathDialog()
                        }
                    }

                    (loveView as LinearLayout).addView(btnChooseLovePath)
                    layoutUniversalMagic.addView(loveView)
                }

                "Бесстрашие" -> {
                    // Кнопка для выбора заклинаний Бесстрашия
                    val fearlessnessView = LayoutInflater.from(this).inflate(
                        R.layout.item_universal_magic,
                        layoutUniversalMagic,
                        false
                    )

                    val tvSchoolName = fearlessnessView.findViewById<TextView>(R.id.tvSchoolName)
                    val spinnerLevel = fearlessnessView.findViewById<Spinner>(R.id.spinnerLevel)

                    tvSchoolName.text = school
                    spinnerLevel.visibility = View.GONE

                    val btnChooseFearlessness = Button(this).apply {
                        text = "Выбрать заклинания"
                        textSize = 14f
                        setTextColor(ContextCompat.getColor(this@CreateCharacterActivity, R.color.bir))
                        setBackgroundResource(R.drawable.itembrightbtn)
                        setOnClickListener {
                            showFearlessnessDialog()
                        }
                    }

                    (fearlessnessView as LinearLayout).addView(btnChooseFearlessness)
                    layoutUniversalMagic.addView(fearlessnessView)
                }

                "Магия крови" -> {
                    // Чекбокс для Магии крови
                    val bloodView = LayoutInflater.from(this).inflate(
                        R.layout.item_universal_magic,
                        layoutUniversalMagic,
                        false
                    )

                    val tvSchoolName = bloodView.findViewById<TextView>(R.id.tvSchoolName)
                    val spinnerLevel = bloodView.findViewById<Spinner>(R.id.spinnerLevel)

                    tvSchoolName.text = school
                    spinnerLevel.visibility = View.GONE

                    val cbBloodMagic = CheckBox(this).apply {
                        text = "Использовать Магию крови"
                        textSize = 14f
                        setTextColor(ContextCompat.getColor(this@CreateCharacterActivity, R.color.bir))
                        isChecked = selectedBloodMagic
                        setOnCheckedChangeListener { _, isChecked ->
                            selectedBloodMagic = isChecked
                        }
                    }

                    (bloodView as LinearLayout).addView(cbBloodMagic)
                    layoutUniversalMagic.addView(bloodView)
                }

                else -> {
                    // Обычная школа с уровнями (включая Ци-киро)
                    val magicView = LayoutInflater.from(this).inflate(
                        R.layout.item_universal_magic,
                        layoutUniversalMagic,
                        false
                    )

                    val tvSchoolName = magicView.findViewById<TextView>(R.id.tvSchoolName)
                    val spinnerLevel = magicView.findViewById<Spinner>(R.id.spinnerLevel)

                    tvSchoolName.text = school

                    val levelNames = levels.map { it.second }
                    val adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item,
                        levelNames
                    )
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinnerLevel.adapter = adapter

                    spinnerLevel.setSelection(0)
                    universalMagicLevels[school] = 0

                    spinnerLevel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            universalMagicLevels[school] = levels[position].first
                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) {}
                    }

                    layoutUniversalMagic.addView(magicView)
                }
            }
        }
    }

// ========== ШАГ 6: ДОСТИЖЕНИЯ ==========

    private fun setupStep6() {
        layoutAchievements.removeAllViews()
        selectedAchievements.clear()
        combatTrainingChoices.clear()

        val achievements = listOf(
            // Транспорт
            "Наземная или воздушная техника",
            "Ездовое животное",
            "Участие в гонках",
            "Океанавтика",

            // Службы
            "Служба шикари/агентом/разведчиком/шпионом",
            "Служба егерем",
            "Служба рерум",
            "Служба в арбитраже",
            "Служба в силовых структурах",

            // Профессии
            "Профессия",
            "Физическая подготовка",
            "Образование/обучение",
            "Преподавание",
            "Работа врачом/лекарем",
            "Машинариум",
            "Журналист, юрист, оценщик",
            "Выдающиеся достижения в ремесле",

            // Предметы
            "Зелье папоротника",
            "Плод Лив",
            "Предметы от ментального воздействия",
            "Магистеривая мутация",

            // Особые
            "Зоркоглазые перевёртыши",
            "Крупные перевёртыши",
            "Ловкие перевёртыши",
            "Мелкие перевёртыши",
            "Внимательные перевёртыши"
        )

        for (achievement in achievements) {
            val achievementView = LayoutInflater.from(this).inflate(
                R.layout.item_achievement,
                layoutAchievements,
                false
            )

            val cbAchievement = achievementView.findViewById<CheckBox>(R.id.cbAchievement)
            val tvAchievementName = achievementView.findViewById<TextView>(R.id.tvAchievementName)

            cbAchievement.text = ""
            tvAchievementName.text = achievement

            cbAchievement.setOnCheckedChangeListener { _, isChecked ->
                if (achievement == "Боевая подготовка") {
                    // Особый случай - показываем диалог
                    if (isChecked) {
                        showCombatTrainingDialog()
                    } else {
                        combatTrainingChoices.clear()
                    }
                } else {
                    if (isChecked) {
                        if (!selectedAchievements.contains(achievement)) {
                            selectedAchievements.add(achievement)
                        }
                    } else {
                        selectedAchievements.remove(achievement)
                    }
                }
            }

            layoutAchievements.addView(achievementView)
        }

        // Добавляем боевую подготовку отдельно
        val combatView = LayoutInflater.from(this).inflate(
            R.layout.item_achievement,
            layoutAchievements,
            false
        )

        val cbAchievement = combatView.findViewById<CheckBox>(R.id.cbAchievement)
        val tvCombatName = combatView.findViewById<TextView>(R.id.tvAchievementName)

        cbAchievement.text = ""
        tvCombatName.text = "Боевая подготовка"

        cbAchievement.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showCombatTrainingDialog()
            } else {
                combatTrainingChoices.clear()
            }
        }

        layoutAchievements.addView(combatView)
    }

    private fun showCombatTrainingDialog() {
        val dialog = android.app.Dialog(this).apply {
            setContentView(R.layout.dialog_combat_training)
            window?.setBackgroundDrawable(
                android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT)
            )
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val radioGroupCombat = dialog.findViewById<RadioGroup>(R.id.radioGroupCombat)
        val radioGroupPhysical = dialog.findViewById<RadioGroup>(R.id.radioGroupPhysical)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveCombatTraining)

        btnSave.setOnClickListener {
            combatTrainingChoices.clear()

            // Выбор боевого навыка
            when (radioGroupCombat.checkedRadioButtonId) {
                R.id.radioMelee -> combatTrainingChoices.add("Драка")
                R.id.radioShooting -> combatTrainingChoices.add("Стрельба")
            }

            // Выбор физического навыка
            when (radioGroupPhysical.checkedRadioButtonId) {
                R.id.radioConstitution -> combatTrainingChoices.add("Телосложение")
                R.id.radioAgility -> combatTrainingChoices.add("Ловкость")
            }

            dialog.dismiss()
            Toast.makeText(
                this,
                "Боевая подготовка сохранена: ${combatTrainingChoices.joinToString(", ")}",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.show()
    }

    private fun showLovePathDialog() {
        val dialog = android.app.Dialog(this).apply {
            setContentView(R.layout.dialog_love_path)
            window?.setBackgroundDrawable(
                android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT)
            )
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val radioGroupLovePath = dialog.findViewById<RadioGroup>(R.id.radioGroupLovePath)
        val layoutLoveLanguages = dialog.findViewById<LinearLayout>(R.id.layoutLoveLanguages)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveLovePath)

        // Восстанавливаем выбранный путь
        if (lovePathType == "Кротость") {
            radioGroupLovePath.check(R.id.radioMeekness)
        } else {
            radioGroupLovePath.check(R.id.radioPassion)
        }

        // Создаем список языков
        layoutLoveLanguages.removeAllViews()
        val tempSelectedLanguages = mutableMapOf<String, List<String>>()

        // Копируем существующие данные
        for ((lang, gestures) in selectedLoveLanguages) {
            tempSelectedLanguages[lang] = gestures.toList()
        }

        for (language in MagicDatabase.loveLanguages.keys) {
            val langView = LayoutInflater.from(this).inflate(
                R.layout.item_love_language,
                layoutLoveLanguages,
                false
            )

            val cbLanguage = langView.findViewById<CheckBox>(R.id.cbLoveLanguage)
            val tvLanguageName = langView.findViewById<TextView>(R.id.tvLoveLanguageName)
            val btnChooseGestures = langView.findViewById<Button>(R.id.btnChooseGestures)

            tvLanguageName.text = language

            // Восстанавливаем состояние
            cbLanguage.isChecked = selectedLoveLanguages.containsKey(language)
            btnChooseGestures.visibility = if (cbLanguage.isChecked) View.VISIBLE else View.GONE

            cbLanguage.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (!tempSelectedLanguages.containsKey(language)) {
                        tempSelectedLanguages[language] = emptyList()
                    }
                    btnChooseGestures.visibility = View.VISIBLE
                } else {
                    tempSelectedLanguages.remove(language)
                    btnChooseGestures.visibility = View.GONE
                }
            }

            btnChooseGestures.setOnClickListener {
                showLoveGesturesDialog(language, tempSelectedLanguages)
            }

            layoutLoveLanguages.addView(langView)
        }

        btnSave.setOnClickListener {
            lovePathType = if (radioGroupLovePath.checkedRadioButtonId == R.id.radioMeekness) {
                "Кротость"
            } else {
                "Страсть"
            }

            selectedLoveLanguages.clear()
            selectedLoveLanguages.putAll(tempSelectedLanguages)

            dialog.dismiss()
            Toast.makeText(
                this,
                "Тропа Любви сохранена",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.show()
    }

    private fun showLoveGesturesDialog(
        language: String,
        tempSelectedLanguages: MutableMap<String, List<String>>
    ) {
        val dialog = android.app.Dialog(this).apply {
            setContentView(R.layout.dialog_love_gestures)
            window?.setBackgroundDrawable(
                android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT)
            )
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val tvTitle = dialog.findViewById<TextView>(R.id.tvLoveLanguageTitle)
        val layoutGestures = dialog.findViewById<LinearLayout>(R.id.layoutGestures)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveGestures)

        tvTitle.text = language

        val gestures = MagicDatabase.loveLanguages[language] ?: emptyList()
        val selectedGestures = tempSelectedLanguages[language]?.toMutableList() ?: mutableListOf()

        for (gesture in gestures) {
            val gestureView = LayoutInflater.from(this).inflate(
                R.layout.item_base_spell,
                layoutGestures,
                false
            )

            val cbGesture = gestureView.findViewById<CheckBox>(R.id.cbBaseSpell)
            val tvGestureName = gestureView.findViewById<TextView>(R.id.tvSpellName)

            tvGestureName.text = gesture
            cbGesture.isChecked = selectedGestures.contains(gesture)

            cbGesture.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (!selectedGestures.contains(gesture)) {
                        selectedGestures.add(gesture)
                    }
                } else {
                    selectedGestures.remove(gesture)
                }
            }

            layoutGestures.addView(gestureView)
        }

        btnSave.setOnClickListener {
            tempSelectedLanguages[language] = selectedGestures.toList()
            dialog.dismiss()
            Toast.makeText(
                this,
                "Жесты сохранены",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.show()
    }




    // ========== СОХРАНЕНИЕ ==========

    private fun saveCharacter() {
        val branch = getSelectedBranch()
        val balanceDir = getSelectedBalanceDirection()
        val lifeDir = getSelectedLifeDirection()

        var animalType: AnimalType? = null
        if (lifeDir == LifeDirection.SHAPESHIFTER) {
            val position = spinnerAnimalType.selectedItemPosition
            animalType = AnimalType.values().getOrNull(position)
        }

        val magicData = MagicData(
            branch = branch,
            balanceDirection = balanceDir,
            lifeDirection = lifeDir,
            animalType = animalType,
            baseSpells = selectedBaseSpells,
            specializations = selectedSpecializations,
            specializationSpells = specializationSpellsMap,
            universalMagic = universalMagicLevels,
            voodooLoas = selectedLoas,
            lovePathType = lovePathType,
            loveLanguages = selectedLoveLanguages,
            fearlessnessSpells = selectedFearlessnessSpells,  // ДОБАВЛЕНО
            hasBloodMagic = selectedBloodMagic  // ДОБАВЛЕНО
        )

        // Рассчитываем итоговые аспекты с учетом всех бонусов
        val finalAspects = AspectCalculator.calculateFinalAspects(
            baseAspects = baseAspects,
            magicData = magicData,
            achievements = selectedAchievements,
            combatTrainingChoices = combatTrainingChoices
        )

        // Рассчитываем здоровье на основе ИТОГОВЫХ аспектов
        val baseHealth = AspectCalculator.calculateHealth(
            finalAspects = finalAspects,
            magicData = magicData,
            achievements = selectedAchievements
        )

        val maxHealth = baseHealth + artifactHealthBonus



        val character = Character(
            name = characterName,
            race = characterRace,
            subrace = characterSubrace,
            baseAspects = baseAspects,
            finalAspects = finalAspects,  // Теперь с бонусами
            magicData = magicData,
            maxHealth = maxHealth,
            currentHealth = maxHealth,
            artifactHealthBonus = artifactHealthBonus
        )

        val characterId = dbHelper.addCharacter(character)

        if (characterId > 0) {
            Toast.makeText(this, "Персонаж создан!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CharacterSheetActivity::class.java).apply {
                putExtra("character_id", characterId.toInt())
            }
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Ошибка при создании персонажа", Toast.LENGTH_SHORT).show()
        }

        val combatBonuses = AspectCalculator.calculateCombatTrainingBonuses(combatTrainingChoices)

    }

    private fun showVoodooLoasDialog() {
        val dialog = android.app.Dialog(this).apply {
            setContentView(R.layout.dialog_voodoo_loas)
            window?.setBackgroundDrawable(
                android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT)
            )
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val layoutLoas = dialog.findViewById<LinearLayout>(R.id.layoutLoas)
        val btnSave = dialog.findViewById<Button>(R.id.btnSaveLoas)

        val loas = MagicDatabase.voodooLoas
        val tempSelectedLoas = mutableMapOf<String, String>()

        // Восстанавливаем выбранные лоа
        for (loa in loas) {
            val loaView = LayoutInflater.from(this).inflate(
                R.layout.item_loa,
                layoutLoas,
                false
            )

            val cbLoa = loaView.findViewById<CheckBox>(R.id.cbLoa)
            val tvLoaName = loaView.findViewById<TextView>(R.id.tvLoaName)
            val radioGroupOgun = loaView.findViewById<RadioGroup>(R.id.radioGroupOgun)
            val radioGroupDamballa = loaView.findViewById<RadioGroup>(R.id.radioGroupDamballa)

            tvLoaName.text = loa

            // Восстанавливаем состояние
            cbLoa.isChecked = selectedLoas.containsKey(loa)

            if (loa == "Огун") {
                radioGroupOgun.visibility = if (cbLoa.isChecked) View.VISIBLE else View.GONE
                if (selectedLoas[loa] == "Драка") {
                    radioGroupOgun.check(R.id.radioOgunMelee)
                } else {
                    radioGroupOgun.check(R.id.radioOgunConstitution)
                }
            }

            if (loa == "Дамбала") {
                radioGroupDamballa.visibility = if (cbLoa.isChecked) View.VISIBLE else View.GONE
                if (selectedLoas[loa] == "Бдительность") {
                    radioGroupDamballa.check(R.id.radioDamballaVigilance)
                } else {
                    radioGroupDamballa.check(R.id.radioDamballaPerception)
                }
            }

            cbLoa.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Определяем бонус по умолчанию
                    when (loa) {
                        "Папа Легба" -> tempSelectedLoas[loa] = "Восприятие"
                        "Барон Самеди" -> tempSelectedLoas[loa] = "Ловкость"
                        "Маман Бриджит" -> tempSelectedLoas[loa] = "Лечение"
                        "Огун" -> {
                            radioGroupOgun.visibility = View.VISIBLE
                            tempSelectedLoas[loa] = if (radioGroupOgun.checkedRadioButtonId == R.id.radioOgunMelee) "Драка" else "Телосложение"
                        }
                        "Дамбала" -> {
                            radioGroupDamballa.visibility = View.VISIBLE
                            tempSelectedLoas[loa] = if (radioGroupDamballa.checkedRadioButtonId == R.id.radioDamballaVigilance) "Бдительность" else "Восприятие"
                        }
                    }
                } else {
                    tempSelectedLoas.remove(loa)
                    if (loa == "Огун") radioGroupOgun.visibility = View.GONE
                    if (loa == "Дамбала") radioGroupDamballa.visibility = View.GONE
                }
            }

            // Слушатели для радио-групп
            radioGroupOgun.setOnCheckedChangeListener { _, checkedId ->
                if (cbLoa.isChecked) {
                    tempSelectedLoas[loa] = if (checkedId == R.id.radioOgunMelee) "Драка" else "Телосложение"
                }
            }

            radioGroupDamballa.setOnCheckedChangeListener { _, checkedId ->
                if (cbLoa.isChecked) {
                    tempSelectedLoas[loa] = if (checkedId == R.id.radioDamballaVigilance) "Бдительность" else "Восприятие"
                }
            }

            layoutLoas.addView(loaView)
        }

        btnSave.setOnClickListener {
            selectedLoas.clear()
            selectedLoas.putAll(tempSelectedLoas)
            dialog.dismiss()
            Toast.makeText(
                this,
                "Лоа сохранены: ${selectedLoas.size}",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.show()
    }

    private data class AspectViewHolder(
        val tvValue: TextView,
        val aspectType: AspectType,
        val btnMinus: Button,
        val btnPlus: Button
    )
}