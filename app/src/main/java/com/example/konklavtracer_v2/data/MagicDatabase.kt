package com.example.konklavtracer_v2.data

import com.example.konklavtracer_v2.models.*

object MagicDatabase {

    // Базовые умения для каждой ветви
    val baseSpells = mapOf(
        MagicBranch.BALANCE to mapOf(
            BalanceDirection.LIGHT to listOf(
                BaseSpell("Слепящий свет", 1, "Яркая вспышка ослепляет противника"),
                BaseSpell("Лезвия света", 2, "Создает острые лезвия из света"),
                BaseSpell("Защитный купол", 3, "Создает защитный барьер")
            ),
            BalanceDirection.SHADOW to listOf(
                BaseSpell("Пожирание", 1, "Поглощает тьму вокруг"),
                BaseSpell("Атака теней", 2, "Тени атакуют врага"),
                BaseSpell("Кромешная тьма", 3, "Погружает область в полную тьму")
            )
        ),
        MagicBranch.WORDS to mapOf(
            null to listOf(
                BaseSpell("Глагол повелительного наклонения", 1, "Простой приказ"),
                BaseSpell("Словосочетание", 2, "Более сложная команда"),
                BaseSpell("Уд", 3, "Древнее слово силы")
            )
        ),
        MagicBranch.FLAME to mapOf(
            null to listOf(
                BaseSpell("Огненный шар", 1, "Шар пламени"),
                BaseSpell("Молния", 2, "Разряд электричества"),
                BaseSpell("Волна огня", 3, "Стена пламени")
            )
        ),
        MagicBranch.LIFE to mapOf(
            LifeDirection.SHAMAN to listOf(
                BaseSpell("Оберег предков", 1, "Защита от духов"),
                BaseSpell("Корни", 2, "Сковывающие корни"),
                BaseSpell("Улей", 3, "Призыв роя")
            ),
            LifeDirection.SHAPESHIFTER to listOf(
                BaseSpell("Звероформа", 1, "Превращение в животное"),
                BaseSpell("Челюсти", 2, "Мощный укус"),
                BaseSpell("Рёв/Топот/Клёкот", 3, "Звуковая атака")
            )
        )
    )

    val lovePaths = listOf(
        "Страсть",
        "Кротость"
    )

    // Языки любви и их жесты
    val loveLanguages = mapOf(
        "Вербалы" to listOf(
            "Я люблю тебя",
            "Я с тобой",
            "Ты потрясающая/потрясающий",
            "У тебя всё получится",
            "Я слушаю"
        ),
        "Эмпаты" to listOf(
            "Я тебя вижу",
            "Совместный опыт",
            "Твои мысли",
            "Разная любовь",
            "Большое сердце"
        ),
        "Спасатели" to listOf(
            "Усиленное исцеление",
            "Вместе",
            "Не бойся",
            "Я тебя чувствую"
        ),
        "Дарители" to listOf(
            "Любит-не-любит",
            "Омела",
            "Парные амулеты",
            "Эммусуби",
            "Еда",
            "Зелье сопричастия",
            "Узы любви"
        ),
        "Кинестеты" to listOf(
            "Объятия",
            "Поцелуи",
            "Секс"
        )
    )

    // Специалитеты для каждой ветви
    val specializations = mapOf(
        MagicBranch.BALANCE to mapOf(
            BalanceDirection.LIGHT to listOf(
                "Воины Света",
                "Воля",
                "Контроль Воли"
            ),
            BalanceDirection.SHADOW to listOf(
                "Воины Тени",
                "Воля",
                "Контроль Воли"
            )
        ),
        MagicBranch.WORDS to mapOf(
            null to listOf(
                "Слова разума",
                "Слова решимости",
                "Слова силы",
                "Слова справедливости"
            )
        ),
        MagicBranch.FLAME to mapOf(
            null to listOf(
                "Первородный огонь",
                "Энергия взрывов",
                "Власть над бурей",
                "Магнетизм",
                "Криомания",
                "Зеленое пламя",
                "Огненное прорицание",
                "Плазмамантия"
            )
        ),
        MagicBranch.LIFE to mapOf(
            LifeDirection.SHAMAN to listOf(
                "Арбористика",
                "Анимистика",
                "Витаминтия",
                "Гидрософистика",
                "Аэротургия",
                "Геомантия"
            ),
            LifeDirection.SHAPESHIFTER to listOf(
                "Арбористика",
                "Анимистика",
                "Витаминтия",
                "Гидрософистика",
                "Аэротургия",
                "Геомантия"
            )
        )
    )

    // Заклинания специалитетов
    val specializationSpells = mapOf(
        "Воины Света" to listOf(
            BaseSpell("Световой рывок", 1),
            BaseSpell("Световые клинки", 2),
            BaseSpell("Форма света", 3)
        ),
        "Воля" to listOf(
            BaseSpell("Провокация", 1),
            BaseSpell("Оппортунизм", 2),
            BaseSpell("Купол воли", 3)
        ),
        "Контроль Воли" to listOf(
            BaseSpell("Подавление воли", 1),
            BaseSpell("Волей-неволей", 2),
            BaseSpell("Забрать волю", 3)
        ),
        "Воины Тени" to listOf(
            BaseSpell("Морфей", 1),
            BaseSpell("Инферметатум", 2),
            BaseSpell("Слабость", 3)
        ),
        "Слова разума" to listOf(
            BaseSpell("Массовый приказ", 1),
            BaseSpell("Внушение", 2),
            BaseSpell("Прямой контроль", 3)
        ),
        "Слова решимости" to listOf(
            BaseSpell("Вдохновение", 1),
            BaseSpell("Свет разума", 2),
            BaseSpell("Сковать тьму", 3)
        ),
        "Слова силы" to listOf(
            BaseSpell("Боль", 1),
            BaseSpell("Анепия", 2),
            BaseSpell("Шум", 3)
        ),
        "Слова справедливости" to listOf(
            BaseSpell("Обвинение", 1),
            BaseSpell("Протест", 2),
            BaseSpell("Приговор", 3)
        ),
        "Первородный огонь" to listOf(
            BaseSpell("Ожог", 1),
            BaseSpell("Конус пламени", 2),
            BaseSpell("Огненная плеть", 3)
        ),
        "Энергия взрывов" to listOf(
            BaseSpell("Кража", 1),
            BaseSpell("Залп энергии", 2),
            BaseSpell("Взрыв дара", 3)
        ),
        "Власть над бурей" to listOf(
            BaseSpell("Шок", 1),
            BaseSpell("Щит молний", 2),
            BaseSpell("Цепная молния", 3)
        ),
        "Магнетизм" to listOf(
            BaseSpell("Заряд статики", 1),
            BaseSpell("Притяжение", 2),
            BaseSpell("Магнетизм", 3)
        ),
        "Криомания" to listOf(
            BaseSpell("Гололед", 1),
            BaseSpell("Ледяная Шрапнель", 2),
            BaseSpell("Криостазис", 3)
        ),
        "Зеленое пламя" to listOf(
            BaseSpell("Ощущение эмоций", 1),
            BaseSpell("Видение эмоций", 2),
            BaseSpell("Забирание эмоций", 3)
        ),
        "Огненное прорицание" to listOf(
            BaseSpell("Наделение эмоцией", 1),
            BaseSpell("Возвращение эмоций", 2),
            BaseSpell("Наделение сильным чувством", 3)
        ),
        "Плазмамантия" to listOf(
            BaseSpell("Заря", 1),
            BaseSpell("Драконий доспех", 2),
            BaseSpell("Живой огонь / Сверхновая", 3)
        ),
        "Арбористика" to listOf(
            BaseSpell("Едкая пыльца", 1),
            BaseSpell("Корневища / Острые листья", 2),
            BaseSpell("Вырастить лес", 3)
        ),
        "Анимистика" to listOf(
            BaseSpell("Тотем", 1),
            BaseSpell("Воплощение духа", 2),
            BaseSpell("Развоплощение", 3)
        ),
        "Витаминтия" to listOf(
            BaseSpell("Шипы", 1),
            BaseSpell("Выкручивание плоти", 2),
            BaseSpell("Управление плотью", 3)
        ),
        "Гидрософистика" to listOf(
            BaseSpell("Очищающие воды", 1),
            BaseSpell("Стоячая вода", 2),
            BaseSpell("Осушение", 3)
        ),
        "Аэротургия" to listOf(
            BaseSpell("Точность", 1),
            BaseSpell("Объятья ветра", 2),
            BaseSpell("Удушение", 3)
        ),
        "Геомантия" to listOf(
            BaseSpell("Каменный кулак", 1),
            BaseSpell("Расщелина", 2),
            BaseSpell("Жернова", 3)
        )
    )

    // Неветвийная магия (школы)
    val universalSchools = listOf(
        "Рунология",
        "Зельеваренье",
        "Зачарование",
        "Целительство",
        "Магия крови",
        "Костемагия",
        "Бесстрашие",
        "Военное дело",
        "Следопытство",
        "Тропа любви", // НОВАЯ (пока заглушка)
        "Вудуизм"
    )


    // Заклинания Бесстрашия (горизонтальная прокачка)
    val fearlessnessSpells = listOf(
        "Бесстрашие",
        "Щит бесстрашия",
        "Взгляд бесстрашия",
        "Бесстрашие Эйгара",
        "Страхогон",
        "Бесстрашие Финдли",
        "Длань бесстрашия"
    )

    // Заклинания Магии крови по ветвям
    val bloodMagicSpells = mapOf(
        MagicBranch.FLAME to listOf(
            "Кипячение крови",
            "Охлаждение крови",
            "Красная пелена"
        ),
        MagicBranch.LIFE to listOf(
            "Вкус крови",
            "Власть сильного",
            "Кровотечение",
            "Прямо в сердце"
        ),
        MagicBranch.WORDS to listOf(
            "Договор на крови",
            "Зов крови",
            "Власть крови",
            "Слабая кровь",
            "Приказ самоповреждения"
        ),
        MagicBranch.BALANCE to listOf(
            "Баланс сил",
            "Эскалация",
            "Жертвенность"
        )
    )

    val voodooLoas = listOf(
        "Папа Легба",
        "Барон Самеди",
        "Маман Бриджит",
        "Огун",
        "Дамбала"
    )

    // Уровни для неветвийной магии
    val universalLevels = listOf(
        0 to "0",
        1 to "1",
        2 to "2",
        3 to "3",
        4 to "Мастер",
        5 to "Архимаг"
    )

    // Метод для получения базовых заклинаний
    fun getBaseSpells(
        branch: MagicBranch,
        balanceDir: BalanceDirection? = null,
        lifeDir: LifeDirection? = null
    ): List<BaseSpell> {
        return when (branch) {
            MagicBranch.BALANCE -> {
                val direction = balanceDir ?: BalanceDirection.LIGHT
                baseSpells[branch]?.get(direction) ?: emptyList()
            }
            MagicBranch.LIFE -> {
                val direction = lifeDir ?: LifeDirection.SHAMAN
                baseSpells[branch]?.get(direction) ?: emptyList()
            }
            else -> {
                baseSpells[branch]?.get(null) ?: emptyList()
            }
        }
    }

    // Метод для получения специалитетов
    fun getSpecializations(
        branch: MagicBranch,
        balanceDir: BalanceDirection? = null,
        lifeDir: LifeDirection? = null
    ): List<String> {
        return when (branch) {
            MagicBranch.BALANCE -> {
                val direction = balanceDir ?: BalanceDirection.LIGHT
                specializations[branch]?.get(direction) ?: emptyList()
            }
            MagicBranch.LIFE -> {
                val direction = lifeDir ?: LifeDirection.SHAMAN
                specializations[branch]?.get(direction) ?: emptyList()
            }
            else -> {
                specializations[branch]?.get(null) ?: emptyList()
            }
        }
    }

    // Метод для получения заклинаний специалитета
    fun getSpecializationSpells(specializationName: String): List<BaseSpell> {
        return specializationSpells[specializationName] ?: emptyList()
    }
}