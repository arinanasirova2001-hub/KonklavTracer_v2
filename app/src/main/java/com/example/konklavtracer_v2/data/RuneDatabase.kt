package com.example.konklavtracer_v2.data

import com.example.konklavtracer_v2.models.Runes
import com.example.konklavtracer_v2.models.RunesCategory

object RuneDatabase {

    val allRunes = listOf(
        // ========== ВЫРАЗИМЫЕ РУНЫ ==========
        Runes(
            id = "alatyr",
            name = "Алатырь",
            category = RunesCategory.PRON,
            symbol = "",
            description = "(А) — первый, власть, вождь, драгоценность, корона, белый цвет"
        ),
        Runes(
            id = "bereginya",
            name = "Берегиня",
            category = RunesCategory.PRON,
            symbol = "",
            description = "(Б) — мать, физическая защита, оберег, физическое воплощение"
        ),
        Runes(
            id = "veter",
            name = "Ветер",
            category = RunesCategory.PRON,
            symbol = "⇑",
            description = "(В) — стихия воздуха, ветер, скорость, движение"
        ),
        Runes(
            id = "krada",
            name = "Крада",
            category = RunesCategory.PRON,
            symbol = "ᚴ",
            description = "(Г/К) — сокрытие, морок, тайна, секрет"
        ),
        Runes(
            id = "dar",
            name = "Дар [Тюрсуз]",
            category = RunesCategory.PRON,
            symbol = "ᚦ",
            description = "(Д) — энергия, дар (как магия), подарок"
        ),
        Runes(
            id = "est",
            name = "Есть",
            symbol = "",
            category = RunesCategory.PRON,
            description = "(Е/Ё) — бесповоротность, непреложность, настоящее, сейчас, покуда"
        ),
        Runes(
            id = "gebo",
            name = "Гебо [Слово, Глагол]",
            category = RunesCategory.PRON,
            symbol = "ᚷ",
            description = "(Ж) — слово, звук, поэзия, текст"
        ),
        Runes(
            id = "eivaz",
            name = "Эйваз [Земля]",
            category = RunesCategory.PRON,
            symbol = "ᛖ",
            description = "(Э) — стихия земли, основа, твердь, родина, тело"
        ),
        Runes(
            id = "izhe",
            name = "Иже [Ист, Исток]",
            category = RunesCategory.PRON,
            symbol = "ᛁ",
            description = "(И) — стихия воды, лед, холод, дорога, север, вверх"
        ),
        Runes(
            id = "loguz",
            name = "Логуз [Леля, Од]",
            category = RunesCategory.PRON,
            symbol = "ᛚ",
            description = "(Л) — обновление, юность, весна, она, женщина"
        ),
        Runes(
            id = "alguz",
            name = "Алгуз",
            symbol = "ᛘ",
            category = RunesCategory.PRON,
            description = "(М) — мир, люди, мужчина, он"
        ),
        Runes(
            id = "nuzhda",
            name = "Нужда",
            symbol = "ᚿ",
            category = RunesCategory.PRON,
            description = "(Н) — необходимость, жажда, потребность, желание, отсутствие, голод"
        ),
        Runes(
            id = "opora",
            name = "Опора",
            category = RunesCategory.PRON,
            symbol = "ᚯ",
            description = "(О) — помощь, здоровье, целительство, пища"
        ),
        Runes(
            id = "perun",
            name = "Перун",
            category = RunesCategory.PRON,
            symbol = "ᚢ",
            description = "(П) — защитник, гроза, стихия молний, магическая защита, восток, вправо"
        ),
        Runes(
            id = "raido",
            name = "Райдо [Рцы, Радуга]",
            category = RunesCategory.PRON,
            symbol = "ᚱ",
            description = "(Р) — жизнь, природа, животное"
        ),
        Runes(
            id = "sovud",
            name = "Совуд",
            category = RunesCategory.PRON,
            symbol = "ᛋ",
            description = "(С) — закон, право, суд, справедливость"
        ),
        Runes(
            id = "treba",
            name = "Треба [Тайгваз]",
            category = RunesCategory.PRON,
            symbol = "ᛏ",
            description = "(Т) — стремление, жертва, неудержимость, действо"
        ),
        Runes(
            id = "ud",
            name = "Уд",
            category = RunesCategory.PRON,
            symbol = "ᛷ",
            description = "(У) — недуг, увечье, болезнь, беда"
        ),
        Runes(
            id = "feu",
            name = "Феу",
            category = RunesCategory.PRON,
            symbol = "ᛓ",
            description = "(Ф) — растение, маг, отшельник"
        ),
        Runes(
            id = "dzhera",
            name = "Джера",
            category = RunesCategory.PRON,
            symbol = "ᛃ",
            description = "(Х) — рок, судьба, цикл, колесо, прошлое, время, удача, дух"
        ),
        Runes(
            id = "chern",
            name = "Чернь",
            category = RunesCategory.PRON,
            symbol = "ᛣ",
            description = "(Ц/Ч) — война, тень, мрак, смерть, запад, удар, влево"
        ),
        Runes(
            id = "manaz",
            name = "Маназ",
            symbol = "ᛗ",
            category = RunesCategory.PRON,
            description = "(Ш/Щ) — разум, мысль, сознание"
        ),
        Runes(
            id = "berkano",
            name = "Беркано [Веде]",
            category = RunesCategory.PRON,
            symbol = "ᛒ",
            description = "(Ъ/Ь/Ы) — око, предсказание, будущее"
        ),
        Runes(
            id = "zelo",
            name = "Зело",
            symbol = "ᛇ",
            category = RunesCategory.PRON,
            description = "(Э) — любовь, рождение, союз, страсть"
        ),
        Runes(
            id = "kano",
            name = "Кано",
            symbol = "ᚲ",
            category = RunesCategory.PRON,
            description = "(Ю) — стихия огня, сила, рост, могущество, кровь, юг, вниз"
        ),
        Runes(
            id = "ofila",
            name = "Офила",
            symbol = "ᛟ",
            category = RunesCategory.PRON,
            description = "(Я) — фейри, божество, перст, часть тела"
        ),

        // ========== НЕВЫРАЗИМЫЕ РУНЫ ==========
        Runes(
            id = "ansuz",
            name = "Ансуз",
            symbol = "ᚫ",
            category = RunesCategory.NONPRON,
            description = "Знак, символ, магия, волшебство, чары"
        ),
        Runes(
            id = "dagaz",
            name = "Дагаз",
            symbol = "ᛞ",
            category = RunesCategory.NONPRON,
            description = "Добро, мудрость, чистота помыслов"
        ),
        Runes(
            id = "ksi",
            name = "Кси",
            symbol = "ᛝ",
            category = RunesCategory.NONPRON,
            description = "Нифилим, проклятие, тёмная магия, зло"
        ),
        Runes(
            id = "nagalaz",
            name = "Нагалаз",
            symbol = "ᚺ",
            category = RunesCategory.NONPRON,
            description = "Единство, слияние, объединение"
        ),
        Runes(
            id = "nauphiz",
            name = "Науфиз",
            symbol = "ᛀ",
            category = RunesCategory.NONPRON,
            description = "Аскетизм, умеренность, одиночество"
        ),
        Runes(
            id = "perf",
            name = "Перф",
            symbol = "ᛈ",
            category = RunesCategory.NONPRON,
            description = "Покой, вселенная, звезда, концентрация, прошлое, бестелесное"
        ),
        Runes(
            id = "ovo",
            name = "Ово [Вунджо]",
            symbol = "ᚹ",
            category = RunesCategory.NONPRON,
            description = "Ноль, неделимое, бесценное, бесконечное ничто"
        )
    )

    // ========== МЕТОДЫ ==========

    fun getRunesByCategory(category: RunesCategory): List<Runes> {
        return allRunes.filter { it.category == category }
    }

    fun getRuneById(id: String): Runes? {
        return allRunes.find { it.id == id }
    }

    fun searchRunes(query: String): List<Runes> {
        return allRunes.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.description.contains(query, ignoreCase = true)
        }
    }
}