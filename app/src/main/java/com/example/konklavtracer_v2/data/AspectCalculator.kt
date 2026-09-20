package com.example.konklavtracer_v2.data

import com.example.konklavtracer_v2.models.*

object AspectCalculator {

    // Бонусы от ветвийной магии
    fun calculateMagicBonuses(magicData: MagicData): Aspects {
        var bonuses = Aspects()

        // === МАГИЯ ===

        // Базовые умения (если есть хотя бы 2)
        if (magicData.baseSpells.size >= 2) {
            bonuses = bonuses.copy(magic = bonuses.magic + 1)
        }

        // Специалитеты 2го уровня (за каждый)
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (spells.any { it.level >= 2 }) {
                bonuses = bonuses.copy(magic = bonuses.magic + 1)
            }
        }

        // Мастерство (уровень 4)
        magicData.universalMagic.forEach { (school, level) ->
            if (level >= 4) {
                bonuses = bonuses.copy(magic = bonuses.magic + 1)
            }
        }

        // Архимагия (уровень 5)
        magicData.universalMagic.forEach { (school, level) ->
            if (level >= 5) {
                bonuses = bonuses.copy(magic = bonuses.magic + 1)
            }
        }

        // Магия крови 2й уровень
        if ((magicData.universalMagic["Магия крови"] ?: 0) >= 2) {
            bonuses = bonuses.copy(magic = bonuses.magic + 1)
        }

        // === ДРАКА ===

        // Военное дело (каждый уровень)
        val militaryLevel = magicData.universalMagic["Военное дело"] ?: 0
        if (militaryLevel >= 1) {
            bonuses = bonuses.copy(melee = bonuses.melee + militaryLevel)
        }

        // Специалитеты Истинное пламя (Первородный огонь) или Энергия взрывов от 2го уровня
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName == "Первородный огонь" || specName == "Энергия взрывов") {
                if (spells.any { it.level >= 2 }) {
                    bonuses = bonuses.copy(melee = bonuses.melee + 1)
                }
            }
        }

        // === СТРЕЛЬБА ===

        // Аэротургия от 2 уровня (специалитет)
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName == "Аэротургия") {
                if (spells.any { it.level >= 2 }) {
                    bonuses = bonuses.copy(shooting = bonuses.shooting + 1)
                }
            }
        }

        // === ТЕЛОСЛОЖЕНИЕ ===

        // Геомантия (специалитет жизни) от 2го уровня
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName == "Геомантия") {
                if (spells.any { it.level >= 2 }) {
                    bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                }
            }
        }

        // Воины Света (специалитет равновесия) от 2го уровня
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName == "Воины Света") {
                if (spells.any { it.level >= 2 }) {
                    bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                }
            }
        }

        // Костемагия от 2го уровня
        if ((magicData.universalMagic["Костемагия"] ?: 0) >= 2) {
            bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
        }

        // === СКРЫТНОСТЬ ===

        // Умбрамантия 2 уровень
        if ((magicData.universalMagic["Умбрамантия"] ?: 0) >= 2) {
            bonuses = bonuses.copy(stealth = bonuses.stealth + 1)
        }

        // Арбористика 2 уровень (специалитет)
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName == "Арбористика") {
                if (spells.any { it.level >= 2 }) {
                    bonuses = bonuses.copy(stealth = bonuses.stealth + 1)
                }
            }
        }

        // === ВОЛЯ ===

        // Специалитеты: воля, подавление воли, слово разума, слово силы, власть над бурей
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName in listOf("Воля", "Контроль Воли", "Слова разума", "Слова силы", "Власть над бурей")) {
                if (spells.isNotEmpty()) {
                    bonuses = bonuses.copy(will = bonuses.will + 1)
                }
            }
        }

        // Бесстрашие от 2х заклинаний
        if ((magicData.universalMagic["Бесстрашие"] ?: 0) >= 2) {
            bonuses = bonuses.copy(will = bonuses.will + 1)
        }

        // === БДИТЕЛЬНОСТЬ ===

        // Специалитет Слов Справедливости
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName == "Слова справедливости") {
                if (spells.isNotEmpty()) {
                    bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
                }
            }
        }

        // Следопытство (уровень 2+)
        if ((magicData.universalMagic["Следопытство"] ?: 0) >= 2) {
            bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
        }

        // Рунология 2й уровень
        if ((magicData.universalMagic["Рунология"] ?: 0) >= 2) {
            bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
        }

        // Зельеварение 2й уровень
        if ((magicData.universalMagic["Зельеваренье"] ?: 0) >= 2) {
            bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
        }

        // === ВОСПРИЯТИЕ ===

        // Следопытство 2 уровень
        if ((magicData.universalMagic["Следопытство"] ?: 0) >= 2) {
            bonuses = bonuses.copy(perception = bonuses.perception + 1)
        }

        // Магические навыки ветвийные
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName in listOf("Зеленое пламя", "Огненное прорицание", "Анимистика", "Слова решимости")) {
                if (spells.isNotEmpty()) {
                    bonuses = bonuses.copy(perception = bonuses.perception + 1)
                }
            }
        }

        // Зачарование 2й уровень
        if ((magicData.universalMagic["Зачарование"] ?: 0) >= 2) {
            bonuses = bonuses.copy(perception = bonuses.perception + 1)
        }

        // === ЛЕЧЕНИЕ ===

        // Целительство (каждый уровень)
        val healingLevel = magicData.universalMagic["Целительство"] ?: 0
        if (healingLevel >= 1) {
            bonuses = bonuses.copy(healing = bonuses.healing + healingLevel)
        }

        // Специалитеты криомантии, гидромантии (Гидрософистика), витамантии от 2го уровня
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName in listOf("Криомания", "Гидрософистика", "Витаминтия")) {
                if (spells.any { it.level >= 2 }) {
                    bonuses = bonuses.copy(healing = bonuses.healing + 1)
                }
            }
        }

        magicData.voodooLoas.forEach { (loa, aspect) ->
            // Каждый лоа даёт -1 к воле
            bonuses = bonuses.copy(will = bonuses.will - 1)

            // И +1 к своему аспекту
            when (aspect) {
                "Восприятие" -> bonuses = bonuses.copy(perception = bonuses.perception + 1)
                "Ловкость" -> bonuses = bonuses.copy(agility = bonuses.agility + 1)
                "Лечение" -> bonuses = bonuses.copy(healing = bonuses.healing + 1)
                "Телосложение" -> bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                "Драка" -> bonuses = bonuses.copy(melee = bonuses.melee + 1)
                "Бдительность" -> bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
            }
        }

        // Бесстрашие от 2х заклинаний
        if (magicData.fearlessnessSpells.size >= 2) {
            bonuses = bonuses.copy(will = bonuses.will + 1)
        }

// Магия крови
        if (magicData.hasBloodMagic) {
            bonuses = bonuses.copy(magic = bonuses.magic + 1)
        }

        // Ци-киро от 2го уровня
        if ((magicData.universalMagic["Ци-киро"] ?: 0) >= 2) {
            bonuses = bonuses.copy(agility = bonuses.agility + 1)  // Или какой аспект?
        }


        // Тропа Любви
        if (magicData.loveLanguages.isNotEmpty()) {
            val totalGestures = magicData.loveLanguages.values.sumOf { it.size }
            if (totalGestures >= 2) {
                bonuses = bonuses.copy(perception = bonuses.perception + 1)
            }
        }

        return bonuses
    }

    // Бонусы от достижений
    fun calculateAchievementBonuses(achievements: List<String>): Aspects {
        var bonuses = Aspects()

        for (achievement in achievements) {
            when (achievement) {
                // Транспорт
                "Наземная или воздушная техника" -> {
                    bonuses = bonuses.copy(driving = bonuses.driving + 1)
                }
                "Ездовое животное" -> {
                    bonuses = bonuses.copy(driving = bonuses.driving + 1)
                    bonuses = bonuses.copy(agility = bonuses.agility + 1)
                }
                "Участие в гонках" -> {
                    bonuses = bonuses.copy(driving = bonuses.driving + 1)
                }
                "Океанавтика" -> {
                    bonuses = bonuses.copy(shooting = bonuses.shooting + 1)
                    bonuses = bonuses.copy(agility = bonuses.agility + 1)
                    bonuses = bonuses.copy(driving = bonuses.driving + 1)
                }

                // Службы
                "Служба шикари/агентом/разведчиком/шпионом" -> {
                    bonuses = bonuses.copy(stealth = bonuses.stealth + 1)
                    bonuses = bonuses.copy(will = bonuses.will + 1)
                }
                "Служба егерем" -> {
                    bonuses = bonuses.copy(stealth = bonuses.stealth + 1)
                }
                "Служба рерум" -> {
                    bonuses = bonuses.copy(will = bonuses.will + 1)
                }
                "Служба в арбитраже" -> {
                    bonuses = bonuses.copy(will = bonuses.will + 1)
                }
                "Служба в силовых структурах" -> {
                    bonuses = bonuses.copy(shooting = bonuses.shooting + 1)
                }

                // Профессии
                "Профессия" -> {
                    bonuses = bonuses.copy(craft = bonuses.craft + 1)
                }

                "Физическая подготовка" -> {
                    bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                }
                "Образование/обучение" -> {
                    bonuses = bonuses.copy(craft = bonuses.craft + 1)
                }
                "Преподавание" -> {
                    bonuses = bonuses.copy(craft = bonuses.craft + 1)
                }
                "Работа врачом/лекарем" -> {
                    bonuses = bonuses.copy(healing = bonuses.healing + 1)
                }
                "Машинариум" -> {
                    bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
                }
                "Журналист, юрист, оценщик" -> {
                    bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
                }
                "Выдающиеся достижения в ремесле" -> {
                    bonuses = bonuses.copy(craft = bonuses.craft + 1)
                }

                // Предметы
                "Зелье папоротника" -> {
                    bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                }

                "Плод Лив" -> {
                    bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                }
                "Предметы от ментального воздействия" -> {
                    bonuses = bonuses.copy(will = bonuses.will + 1)
                }

                // Особые
                "Зоркоглазые перевёртыши" -> {
                    bonuses = bonuses.copy(shooting = bonuses.shooting + 1)
                }
                "Крупные перевёртыши" -> {
                    bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                }
                "Ловкие перевёртыши" -> {
                    bonuses = bonuses.copy(agility = bonuses.agility + 1)
                }
                "Мелкие перевёртыши" -> {
                    bonuses = bonuses.copy(stealth = bonuses.stealth + 1)
                }
                "Внимательные перевёртыши" -> {
                    bonuses = bonuses.copy(vigilance = bonuses.vigilance + 1)
                }
                "Магистеривая мутация" -> {
                    bonuses = bonuses.copy(magic = bonuses.magic + 1)
                    bonuses = bonuses.copy(constitution = bonuses.constitution - 1)
                }
            }
        }

        return bonuses
    }

    // Бонусы от боевой подготовки
    fun calculateCombatTrainingBonuses(choices: List<String>): Aspects {
        var bonuses = Aspects()

        for (choice in choices) {
            when (choice) {
                "Драка" -> bonuses = bonuses.copy(melee = bonuses.melee + 1)
                "Стрельба" -> bonuses = bonuses.copy(shooting = bonuses.shooting + 1)
                "Телосложение" -> bonuses = bonuses.copy(constitution = bonuses.constitution + 1)
                "Ловкость" -> bonuses = bonuses.copy(agility = bonuses.agility + 1)
            }
        }

        return bonuses
    }

    // Общий расчет
    fun calculateFinalAspects(
        baseAspects: Aspects,
        magicData: MagicData,
        achievements: List<String>,
        combatTrainingChoices: List<String> = emptyList()
    ): Aspects {
        val magicBonuses = calculateMagicBonuses(magicData)
        val achievementBonuses = calculateAchievementBonuses(achievements)
        val combatBonuses = calculateCombatTrainingBonuses(combatTrainingChoices)

        return baseAspects + magicBonuses + achievementBonuses + combatBonuses
    }

    fun calculateHealth(
        finalAspects: Aspects,
        magicData: MagicData,
        achievements: List<String> = emptyList()
    ): Int {
        var health = 5  // База

        // +1 за физ подготовку
        if (achievements.contains("Физическая подготовка")) {
            health += 1
        }

        // +1 за 3 ур. военного дела, но только если нет физ подготовки
        val militaryLevel = magicData.universalMagic["Военное дело"] ?: 0
        if (militaryLevel >= 3 && !achievements.contains("Физическая подготовка")) {
            health += 1
        }

        // +1 за первый уровень специалитета (один раз)
        if (magicData.specializationSpells.values.any { spells ->
                spells.any { it.level >= 1 }
            }) {
            health += 1
        }

        // +1 за каждый полностью изученный специалитет
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (spells.size >= 3) {  // Все 3 уровня изучены
                health += 1
            }
        }

        // +1 если перевёртыш тип зверя "парнокопытные"
        if (magicData.animalType == AnimalType.UNGULATE) {
            health += 1
        }

        // +1 за первый уровень специалитета "Анимизм" (Анимистика)
        magicData.specializationSpells.forEach { (specName, spells) ->
            if (specName == "Анимистика" && spells.any { it.level >= 1 }) {
                health += 1
            }
        }

        return health
    }

    fun calculateBlocks(finalAspects: Aspects): Triple<Float, Float, Float> {
        val blockMelee = (finalAspects.constitution + finalAspects.magic) / 2f
        val blockRanged = (finalAspects.agility + finalAspects.magic) / 2f
        val blockMagic = finalAspects.magic.toFloat()
        return Triple(blockMelee, blockRanged, blockMagic)
    }
}