package com.example.konklavtracer_v2.data

import com.example.konklavtracer_v2.models.*

object SpellDatabase {

    // ========== ВЕТВИЙНАЯ МАГИЯ ==========

    val balanceLightSchool = MagicSchool(
        id = "balance_light",
        name = "Равновесие: Свет",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.BALANCE,
        direction = "Свет",
        description = "Свет — путь защиты и исцеления. Маги света черпают силу из чистых эмоций и стремятся оберегать всё живое.",
        spells = listOf(
            SpellEntry(
                id = "balance_light_1",
                name = "Слепящий свет",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Свет",
                level = 1,
                description = "Яркая вспышка света ослепляет противника на короткое время."
            ),
            SpellEntry(
                id = "balance_light_2",
                name = "Лезвия света",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Свет",
                level = 2,
                description = "Создает острые лезвия из чистой энергии света."
            ),
            SpellEntry(
                id = "balance_light_3",
                name = "Защитный купол",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Свет",
                level = 3,
                description = "Создает защитный барьер из света вокруг мага."
            )
        )
    )

    val balanceShadowSchool = MagicSchool(
        id = "balance_shadow",
        name = "Равновесие: Тень",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.BALANCE,
        direction = "Тень",
        description = "Тень — путь скрытности и контроля. Маги тени используют страх и тьму как оружие.",
        spells = listOf(
            SpellEntry(
                id = "balance_shadow_1",
                name = "Пожирание",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Тень",
                level = 1,
                description = "Поглощает тьму вокруг, восстанавливая силы мага."
            ),
            SpellEntry(
                id = "balance_shadow_2",
                name = "Атака теней",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Тень",
                level = 2,
                description = "Тени обретают физическую форму и атакуют врага."
            ),
            SpellEntry(
                id = "balance_shadow_3",
                name = "Кромешная тьма",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Тень",
                level = 3,
                description = "Погружает область в полную, непроглядную тьму."
            )
        )
    )

    val wordsSchool = MagicSchool(
        id = "words",
        name = "Слова",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.WORDS,
        description = "Слова — искусство управления реальностью через речь. Каждое слово имеет силу, и маг должен тщательно выбирать их.",
        spells = listOf(
            SpellEntry(
                id = "words_1",
                name = "Глагол повелительного наклонения",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                level = 1,
                description = "Простой приказ, который цель обязана выполнить."
            ),
            SpellEntry(
                id = "words_2",
                name = "Словосочетание",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                level = 2,
                description = "Более сложная команда из нескольких слов."
            ),
            SpellEntry(
                id = "words_3",
                name = "Уд",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                level = 3,
                description = "Древнее слово силы, способное менять реальность."
            )
        )
    )

    val flameSchool = MagicSchool(
        id = "flame",
        name = "Пламя",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Пламя — стихия разрушения и очищения. Маги пламени подчиняют себе огонь, молнии и энергию.",
        spells = listOf(
            SpellEntry(
                id = "flame_1",
                name = "Огненный шар",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.FLAME,
                level = 1,
                description = "Шар пламени, наносящий урон."
            ),
            SpellEntry(
                id = "flame_2",
                name = "Молния",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.FLAME,
                level = 2,
                description = "Разряд электричества, поражающий цель."
            ),
            SpellEntry(
                id = "flame_3",
                name = "Волна огня",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.FLAME,
                level = 3,
                description = "Стена пламени, сжигающая всё на пути."
            )
        )
    )

    val lifeShamanSchool = MagicSchool(
        id = "life_shaman",
        name = "Жизнь: Шаман",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        direction = "Шаман",
        description = "Шаманы общаются с духами и силами природы, защищая свой народ.",
        spells = listOf(
            SpellEntry(
                id = "life_shaman_1",
                name = "Оберег предков",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.LIFE,
                direction = "Шаман",
                level = 1,
                description = "Защита от духов предков."
            ),
            SpellEntry(
                id = "life_shaman_2",
                name = "Корни",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.LIFE,
                direction = "Шаман",
                level = 2,
                description = "Сковывающие корни."
            ),
            SpellEntry(
                id = "life_shaman_3",
                name = "Улей",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.LIFE,
                direction = "Шаман",
                level = 3,
                description = "Призыв роя."
            )
        )
    )

    val lifeShapeshifterSchool = MagicSchool(
        id = "life_shapeshifter",
        name = "Жизнь: Перевёртыш",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        direction = "Перевёртыш",
        description = "Перевёртыши могут принимать облик зверей, перенимая их силу и инстинкты.",
        spells = listOf(
            SpellEntry(
                id = "life_shapeshifter_1",
                name = "Звероформа",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.LIFE,
                direction = "Перевёртыш",
                level = 1,
                description = "Превращение в животное."
            ),
            SpellEntry(
                id = "life_shapeshifter_2",
                name = "Челюсти",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.LIFE,
                direction = "Перевёртыш",
                level = 2,
                description = "Мощный укус."
            ),
            SpellEntry(
                id = "life_shapeshifter_3",
                name = "Рёв/Топот/Клёкот",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.LIFE,
                direction = "Перевёртыш",
                level = 3,
                description = "Звуковая атака."
            )
        )
    )


        //Всеобщая магия
    val runologySchool = MagicSchool(
        id = "runology",
        name = "Рунология",
        category = MagicCategory.UNIVERSAL,
        description = "Рунология — древняя магическая наука, основанная на начертании магических символов — рун. Простые руны описаны в разделе «Руны». Здесь собраны рунические сочетания: стафы, знаки, печати и алгоритмы.",
        spells = listOf(
            // ========== УРОВЕНЬ I ==========
            SpellEntry(
                id = "runology_alphabet",
                name = "Рунический алфавит",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "Изучение всех рунических символов и их значений. Каждая руна может означать несколько значений: например, Алатырь — это и лидер, и цифра 1, и начало, и драгоценность, и белый цвет. Все простые руны описаны в разделе «Руны» справочника.",
                recipe = Recipe(
                    dosage = "",
                    ingredients = emptyList(),
                    preparation = "Переписать рунический алфавит на отдельный носитель (бумага, дерево, камень). Пройти испытание у наставника: разгадать послание из рун и составить ответ. Учить рунологии может маг на ступень выше по мастерству, чем вы.",
                    duration = "",
                    comments = "На данном уровне доступны отдельные рунические символы с фиксированным значением, строчные стафы из трёх символов и знаки, составленные из четырех символов. Стаф обязательно должен быть выделен.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_sul_1",
                name = "Стаф «Сул» (Морок) — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "Сокрытие малого предмета. При наложении стафа на предмет, он становится невидим, если он недвижим.",
                recipe = Recipe(
                    dosage = "Малый предмет",
                    ingredients = listOf(
                        "Крада",
                        "Ансуз",
                        "Есть"
                    ),
                    preparation = "Нанести стаф на предмет.",
                    duration = "Пока предмет недвижим",
                    comments = "Сокрытие малого предмета.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_sul_2",
                name = "Стаф «Сул» (Морок) — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "Сокрытие большого предмета. При наложении стафа на предмет, он становится невидим, если он недвижим.",
                recipe = Recipe(
                    dosage = "Большой предмет",
                    ingredients = listOf(
                        "Крада",
                        "Ансуз",
                        "Есть",
                        "Нужда",
                        "Беркано"
                    ),
                    preparation = "Нанести стаф на предмет.",
                    duration = "Пока предмет недвижим",
                    comments = "Сокрытие большого предмета.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_sul_3",
                name = "Стаф «Сул» (Морок) — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "Сокрытие личности. При наложении стафа на личность, она становится невидима, если она недвижима.",
                recipe = Recipe(
                    dosage = "Личность",
                    ingredients = listOf(
                        "Крада",
                        "Ансуз",
                        "Есть",
                        "Нужда",
                        "Беркано",
                        "Феу",
                        "Алатырь"
                    ),
                    preparation = "Нанести стаф на личность.",
                    duration = "Пока личность недвижима",
                    comments = "Сокрытие личности предмета.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_osestaf_1",
                name = "Стаф «Осестаф» (Видящий) — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "Обнаруживает скрытые каким-либо образом предметы в радиусе 5 метров.",
                recipe = Recipe(
                    dosage = "Предмет с отверстием или из прозрачного материала",
                    ingredients = listOf(
                        "Беркано",
                        "Ансуз",
                        "Крада"
                    ),
                    preparation = "Нанести на предмет с отверстием или из прозрачного материала.",
                    duration = "—",
                    comments = "1 уровень — обнаружение мелкого предмета, сокрытого первым уровнем морока.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_osestaf_2",
                name = "Стаф «Осестаф» (Видящий) — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "Обнаруживает скрытые каким-либо образом предметы.",
                recipe = Recipe(
                    dosage = "Предмет с отверстием или из прозрачного материала",
                    ingredients = listOf(
                        "Беркано",
                        "Ансуз",
                        "Крада",
                        "Есть",
                        "Дар"
                    ),
                    preparation = "Нанести на предмет с отверстием или из прозрачного материала.",
                    duration = "—",
                    comments = "2 уровень — обнаружение предмета, сокрытого вторым уровнем морока.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_osestaf_3",
                name = "Стаф «Осестаф» (Видящий) — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "Обнаруживает скрытые каким-либо образом крупыне предметы или личность под третьим уровнем морока.",
                recipe = Recipe(
                    dosage = "Предмет с отверстием или из прозрачного материала",
                    ingredients = listOf(
                        "Беркано",
                        "Ансуз",
                        "Крада",
                        "Есть",
                        "Дар",
                        "Феу",
                        "Офила"
                    ),
                    preparation = "Нанести на предмет с отверстием или из прозрачного материала.",
                    duration = "—",
                    comments = "3 уровень — обнаружение крупного предмета или личности, сокрытого третьим уровнем морока.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_oseforbanstaf_1",
                name = "Стаф «Осефорбанстаф» (Видящий) — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "Обнаруживает проклятья",
                recipe = Recipe(
                    dosage = "Предмет с отверстием или из прозрачного материала",
                    ingredients = listOf(
                        "Беркано",
                        "Ансуз",
                        "Кси"
                    ),
                    preparation = "Нанести на предмет с отверстием или из прозрачного материала.",
                    duration = "—",
                    comments = "Обнаруживает проклятье 1 уровня но не раскрывает его смысл, лишь наличие",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_oseforbanstaf_2",
                name = "Стаф «Осефорбанстаф» (Видящий) — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "Обнаруживает проклятья",
                recipe = Recipe(
                    dosage = "Предмет с отверстием или из прозрачного материала",
                    ingredients = listOf(
                        "Беркано",
                        "Ансуз",
                        "Кси",
                        "Уд",
                        "Чернь"
                    ),
                    preparation = "Нанести на предмет с отверстием или из прозрачного материала.",
                    duration = "—",
                    comments = "Обнаруживает проклятье 2 уровня но не раскрывает его смысл, лишь наличие",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_oseforbanstaf_3",
                name = "Стаф «Осефорбанстаф» (Видящий) — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "Обнаруживает проклятья",
                recipe = Recipe(
                    dosage = "Предмет с отверстием или из прозрачного материала",
                    ingredients = listOf(
                        "Беркано",
                        "Ансуз",
                        "Кси",
                        "Уд",
                        "Чернь",
                        "Алатырь",
                        "Феу"
                    ),
                    preparation = "Нанести на предмет с отверстием или из прозрачного материала.",
                    duration = "—",
                    comments = "Обнаруживает проклятье 3 уровня но не раскрывает его смысл, лишь наличие",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),


            SpellEntry(
                id = "runology_barrier_1",
                name = "Стаф «Барьер» — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "Стеной над начертанным на земле стафом барьера возрастает энергия. Барьер в высоту около 3 метров, а в длину — по размеру начертанного стафа. Любая атака снимает барьеру 1 единицу прочности. При этом совершать одну и ту же атаку нельзя, их необходимо чередовать.",
                recipe = Recipe(
                    dosage = "Земля",
                    ingredients = listOf(
                        "Ансуз",
                        "Перун",
                        "Берегиня"
                    ),
                    preparation = "Начертить стаф на земле.",
                    duration = "Пока не разрушен",
                    comments = "1 уровень — барьер обладает 10 единицами прочности.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_barrier_2",
                name = "Стаф «Барьер» — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "Стеной над начертанным на земле стафом барьера возрастает энергия. Барьер в высоту около 3 метров, а в длину — по размеру начертанного стафа. Любая атака снимает барьеру 1 единицу прочности. При этом совершать одну и ту же атаку нельзя, их необходимо чередовать.",
                recipe = Recipe(
                    dosage = "Земля",
                    ingredients = listOf(
                        "Ансуз",
                        "Перун",
                        "Берегиня",
                        "Есть",
                        "Опора"
                    ),
                    preparation = "Начертить стаф на земле.",
                    duration = "Пока не разрушен",
                    comments = "2 уровень — барьер обладает 20 единицами прочности.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_barrier_3",
                name = "Стаф «Барьер» — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "Стеной над начертанным на земле стафом барьера возрастает энергия. Барьер в высоту около 3 метров, а в длину — по размеру начертанного стафа. Любая атака снимает барьеру 1 единицу прочности. При этом совершать одну и ту же атаку нельзя, их необходимо чередовать.",
                recipe = Recipe(
                    dosage = "Земля",
                    ingredients = listOf(
                        "Ансуз",
                        "Перун",
                        "Берегиня",
                        "Есть",
                        "Опора",
                        "Эйваз",
                        "Крада"
                    ),
                    preparation = "Начертить стаф на земле.",
                    duration = "Пока не разрушен",
                    comments = "3 уровень — барьер обладает 30 единицами прочности.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),


            SpellEntry(
                id = "runology_livetstaf_1",
                name = "Стаф «Ливестаф» (жизненный стаф) — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "При наложении на человека не дают ему умереть в критическом состоянии по истечении 5 минут",
                recipe = Recipe(
                    dosage = "Личность или оберег",
                    ingredients = listOf(
                        "Берегиня",
                        "Райдо",
                        "Опора"
                    ),
                    preparation = "Начертить стаф на личности или амулете",
                    duration = "Пока на личности",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_endromstaf_1",
                name = "Стаф «Эндромстаф» (сонный стаф) — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "При наложении на личность защищает его сон от вмешательст извне",
                recipe = Recipe(
                    dosage = "Личность или оберег",
                    ingredients = listOf(
                        "Берегиня",
                        "Перф",
                        "Маназ"
                    ),
                    preparation = "Начертить стаф на амулете",
                    duration = "Пока на личности",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_ond_1",
                name = "Стаф «Онд» (Агрессия)",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "Если символ нанесён на предмет или на личность, символ заставляет носителя вести себя агрессивно — он огрызается, сквернословит и так далее. До драки такое воздействие вряд ли приведёт.",
                recipe = Recipe(
                    dosage = "Предмет / личность",
                    ingredients = listOf(
                        "Кано",
                        "Чернь",
                        "Маназ"
                    ),
                    preparation = "Нанести стаф на предмет или личность.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_altruism_1",
                name = "Стаф «Альтруизм»",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "Если символ нанесён на предмет или на личность, символ заставляет носителя вести себя доброжелательно.",
                recipe = Recipe(
                    dosage = "Предмет / личность",
                    ingredients = listOf(
                        "Кано",
                        "Дагаз",
                        "Опора"
                    ),
                    preparation = "Нанести стаф на предмет или личность.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_demon_seal_1",
                name = "Печать от демонов — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области демон будет обездвижен. ",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Офила",
                        "Чернь"
                    ),
                    preparation = "Нанести печать на предмет или область. Для перезарядки собрать энергию Дара в ладони спиралевидным движением и обвести контуры знака заново.",
                    duration = "Пока демон касается",
                    comments = "1 уровень — обездвиживание низших демонов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_demon_seal_2",
                name = "Печать от демонов — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области демон будет обездвижен.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Офила",
                        "Чернь",
                        "Ансуз",
                        "Перф"
                    ),
                    preparation = "Нанести печать на предмет или область. Для перезарядки собрать энергию Дара в ладони спиралевидным движением и обвести контуры знака заново.",
                    duration = "Пока демон касается",
                    comments = "2 уровень — обездвиживание демонов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_demon_seal_3",
                name = "Печать от демонов — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области демон будет обездвижен. Эффект ловушки работает, пока демон касается символа. При получении урона обездвиженный демон освобождается от действия печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Офила",
                        "Чернь",
                        "Ансуз",
                        "Перф",
                        "Алатырь",
                        "Есть"
                    ),
                    preparation = "Нанести печать на предмет или область. Для перезарядки собрать энергию Дара в ладони спиралевидным движением и обвести контуры знака заново.",
                    duration = "Пока демон касается",
                    comments = "3 уровень — обездвиживание высших демонов и архидемонов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_nifilim_seal_1",
                name = "Печать от нифилим — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области нифилим будет обездвижен. При получении урона обездвиженный нифилим освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Кси",
                        "Ансуз"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока нифилим касается",
                    comments = "1 уровень — обездвиживание низших страхов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_nifilim_seal_2",
                name = "Печать от нифилим — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области нифилим будет обездвижен. При получении урона обездвиженный нифилим освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Кси",
                        "Ансуз",
                        "Перф",
                        "Перун"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока нифилим касается",
                    comments = "2 уровень — обездвиживание нифилим и адептов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_nifilim_seal_3",
                name = "Печать от нифилим — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области нифилим будет обездвижен. При получении урона обездвиженный нифилим освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Кси",
                        "Ансуз",
                        "Перф",
                        "Перун",
                        "Есть",
                        "Алатырь"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока нифилим касается",
                    comments = "3 уровень — обездвиживание высших нифилим.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),


            SpellEntry(
                id = "runology_spirit_seal_1",
                name = "Печать от духов — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области дух будет обездвижен. Знак работает только в том плане реальности, в котором он находится. При получении урона обездвиженный дух освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Чернь",
                        "Джера"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока дух касается",
                    comments = "1 уровень — обездвиживание низших духов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_spirit_seal_2",
                name = "Печать от духов — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области дух будет обездвижен. Знак работает только в том плане реальности, в котором он находится. При получении урона обездвиженный дух освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Чернь",
                        "Джера",
                        "Есть",
                        "Ансуз"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока дух касается",
                    comments = "1 уровень — обездвиживание духов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_spirit_seal_3",
                name = "Печать от духов — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "При нанесении на предмет или область коснувшийся этого предмета или области дух будет обездвижен. Знак работает только в том плане реальности, в котором он находится. При получении урона обездвиженный дух освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Чернь",
                        "Джера",
                        "Есть",
                        "Ансуз",
                        "Перф",
                        "Алатырь"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока дух касается",
                    comments = "3 уровень — обездвиживание высших духов.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_shadow_seal_1",
                name = "Печать от теней — I уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "При нанесении на предмет или область коснувшаяся этого предмета или области тень будет обездвижена. Знак работает только в том плане реальности, в котором он находится. При получении урона обездвиженная тень освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Перун",
                        "Чернь"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока тень касается",
                    comments = "1 уровень — обездвиживание низших теней.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_shadow_seal_2",
                name = "Печать от теней — II уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "При нанесении на предмет или область коснувшаяся этого предмета или области тень будет обездвижена. Знак работает только в том плане реальности, в котором он находится. При получении урона обездвиженная тень освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Перун",
                        "Чернь",
                        "Кси",
                        "Джера"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока тень касается",
                    comments = "2 уровень — обездвиживание теней.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_shadow_seal_3",
                name = "Печать от теней — III уровень",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "При нанесении на предмет или область коснувшаяся этого предмета или области тень будет обездвижена. Знак работает только в том плане реальности, в котором он находится. При получении урона обездвиженная тень освобождается от этой печати.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Перун",
                        "Чернь",
                        "Кси",
                        "Джера",
                        "Ансуз",
                        "Уд"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока тень касается",
                    comments = "3 уровень — обездвиживание высших теней.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_stiky",
                name = "Липучка",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень I",
                level = 1,
                description = "При касании знака к объекту или личности этот объект или личность прилипают к знаку. Без механического или магического вмешательства освободится не получится",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Феу",
                        "Нагалаз",
                        "Эйваз",
                        "Крада"
                    ),
                    preparation = "Нанести печать на предмет или область.",
                    duration = "Пока знак не разрушат",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),


            // ========== УРОВЕНЬ II ==========

            SpellEntry(
                id = "runology_fel_2",
                name = "Рунический знак «Фел» (Ловушка)",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "При касании знака ловушки личность или существо обездвиживаются (не работает на нифилим, нежить, демонов и бестелесных существ). Эффект ловушки работает, пока существо или личность касаются него, но высвободиться из неё самостоятельно невозможно. При получении урона обездвиженный освобождается от действия ловушки.",
                recipe = Recipe(
                    dosage = "Предмет / область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Офила",
                        "Феу",
                        "Есть",
                        "Треба"
                    ),
                    preparation = "Нанести знак на предмет или область.",
                    duration = "Пока существо касается",
                    comments = "Все рунические ловушки и печати одноразовые, но их можно перезарядить энергией.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_sky_fear",
                name = "Стаф Ужас с небес",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "Если символ нанесён на личность или предмет, то носитель символа боится выходить под открытое небо",
                recipe = Recipe(
                    dosage = "Предмет / личность",
                    ingredients = listOf(
                        "Ветер",
                        "Кси",
                        "Нужда",
                        "Перф",
                        "Маназ"
                    ),
                    preparation = "Нанести знак на предмет или личность.",
                    duration = "Пока существо касается",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_dead_slayer",
                name = "Стаф Бессмертные смертны",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "Если символ нанесён на оружие или снаряд, то это оружие может наносить урон нежити",
                recipe = Recipe(
                    dosage = "Оружие / снаряд",
                    ingredients = listOf(
                        "Треба",
                        "Уд",
                        "Зело",
                        "Ансуз",
                        "Чернь"
                    ),
                    preparation = "Нанести знак на оружие или снаряд",
                    duration = "",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_undead_seal_2",
                name = "Печать от нежити",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень II",
                level = 2,
                description = "При нанесении на предмет или область коснувшаяся этого предмета или область нежить будет обездвижена. ",
                recipe = Recipe(
                    dosage = "Предмет / Область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Кси",
                        "Ченрь",
                        "Офила",
                        "Алгуз"
                    ),
                    preparation = "Область или носитель",
                    duration = "",
                    comments = "поднятая неразумная нежить обездвиживается",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_undead_seal_3",
                name = "Печать от нежити",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "При нанесении на предмет или область коснувшаяся этого предмета или область нежить будет обездвижена. ",
                recipe = Recipe(
                    dosage = "Предмет / Область",
                    ingredients = listOf(
                        "Нужда",
                        "Ветер",
                        "Кси",
                        "Ченрь",
                        "Офила",
                        "Алгуз",
                        "Есть",
                        "Кано"
                    ),
                    preparation = "Область или носитель",
                    duration = "",
                    comments = "поднятая разумная нежить обездвиживается",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),


            // ========== УРОВЕНЬ III ==========
            SpellEntry(
                id = "runology_vane_3",
                name = "Рунический знак «Вэйн» (Путь, телепортация)",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "При начертании знака в двух точках ступивший на знак телепортируется ко второму начертанному символу. Символа два — один является входом, другой выходом (движение возможно в двух направлениях). Для того чтобы переместиться, портал должен быть заряжен даром (заряжен должен быть именно вход) — около 10-20 ДАР в зависимости от веса (не более 200 кг). Активировать рунический портал может только рунолог, который его начертил.",
                recipe = Recipe(
                    dosage = "Две точки на поверхности",
                    ingredients = listOf(
                        "Ветер",
                        "Эйваз",
                        "Алгуз",
                        "Треба",
                        "Иже",
                        "Перф",
                        "Алгуз",
                        "Ово"
                    ),
                    preparation = "Начертить знак в двух точках. Зарядить вход даром.",
                    duration = "—",
                    comments = "Не более 200 кг.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_shield_break_3",
                name = "Рунический знак пробивания щита",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "Носителем является всегда оружие ближнего боя. На каждый удар такого оружия потребуется отдельный блок, а не один на несколько атак. Если существо способно сражаться когтями и на его руках (лапах) нанесён этот знак, на каждую атаку когтями тоже необходим отдельный блок.",
                recipe = Recipe(
                    dosage = "Оружие ближнего боя",
                    ingredients = listOf(
                        "Чернь",
                        "Кано",
                        "Треба",
                        "Алатырь",
                        "Нужда",
                        "Берегиня",
                        "Уд",
                        "Ансуз"
                    ),
                    preparation = "Нанести на оружие ближнего боя.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),

            SpellEntry(
                id = "runology_rune_mind_3",
                name = "Рунический знак «Рунный разум»",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Уровень III",
                level = 3,
                description = "Знак защищает вмешательство в сознание и обеспечивает ментальную защиту против любой магии, кроме заклинаний ветви Слова.",
                recipe = Recipe(
                    dosage = "Носитель",
                    ingredients = listOf(
                        "Берегиня",
                        "Нужда",
                        "Треба",
                        "Маназ",
                        "Перф",
                        "Перун",
                        "Крада",
                        "Дагаз"
                    ),
                    preparation = "Нанести знак на носитель.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),


            // ========== МАСТЕРСТВО ==========
            SpellEntry(
                id = "runology_rune_life_master",
                name = "Рунический знак «Рунная жизнь»",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Мастерство",
                level = 4,
                description = "Знак увеличивает максимальный запас носителя на 1 единицу.",
                recipe = Recipe(
                    dosage = "Носитель",
                    ingredients = listOf(
                        "Перун",
                        "Берегиня",
                        "Совуд",
                        "Опора",
                        "Логуз",
                        "Райдо",
                        "Кано",
                        "Ансуз"
                    ),
                    preparation = "Нанести знак на носитель.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_causal_staff_master",
                name = "Стаф причинно-следственных связей",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Мастерство",
                level = 4,
                description = "Этот стаф активирует действие следующего после него рунического сочетания при срабатывании или выполнении смысла сочетания, стоящего до него в алгоритмическом.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Нужда",
                        "Логуз",
                        "Джера",
                        "Перф",
                        "Треба",
                        "Беркано"
                    ),
                    preparation = "Используется только в составе рунического алгоритма.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_until_staff_master",
                name = "Рунический стаф «Пока не»",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Мастерство",
                level = 4,
                description = "Этот стаф сохраняет работу сочетания, стоящего до него, пока не сработает или не выполнится смысл следующего после него сочетания.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Треба",
                        "Перф",
                        "Ансуз",
                        "Есть",
                        "Нагалаз"
                    ),
                    preparation = "Используется только в составе рунического алгоритма.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_lock_staff_master",
                name = "Рунический стаф «Замок»",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Мастерство",
                level = 4,
                description = "Дверь или вместилище закрыто, пока не сработает условие алгоритма. Замок может быть начертан только в составе рунического алгоритма, чтобы у замка было условие.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Есть",
                        "Ансуз",
                        "Берегиня",
                        "Перун",
                        "Крадо",
                        "Нужда",
                        "Ветер"
                    ),
                    preparation = "Используется только в составе рунического алгоритма.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_combination_master",
                name = "Объединение рунических сочетаний",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Мастерство",
                level = 4,
                description = "Позволяет объединять несколько рунических сочетаний в единое зачарование, то есть наложение нескольких рунических зачарований на одном носителе.",
                recipe = Recipe(
                    dosage = "Носитель",
                    ingredients = listOf("Несколько рунических сочетаний"),
                    preparation = "Объединить сочетания в единое зачарование по правилам: все сочетания заключаются в горизонтальные или вертикальные линии, стафы выделяются отдельными горизонтальными линиями, все символы одной высоты.",
                    duration = "—",
                    comments = "Смыслы сочетаний в объединении разделены — невозможно из самостоятельных сочетаний создать новый смысл.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            ),
            SpellEntry(
                id = "runology_create_master",
                name = "Создание собственных рунических сочетаний",
                category = MagicCategory.UNIVERSAL,
                school = "Рунология",
                subgroup = "Мастерство",
                level = 4,
                description = "Мастер рунологии может создавать собственные рунические сочетания и алгоритмы.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf("Знание всех рун"),
                    preparation = "Составить 3 новых рунических сочетания 2 или 3-го уровня. Составить 3 алгоритма, каждый из которых как минимум на треть состоит из составленных сочетаний.",
                    duration = "—",
                    comments = "Наставник вправе усложнить испытание.",
                    canBeAdded = false,
                    recipeType = RecipeType.RUNE
                )
            )
        )
    )

    val machineariumSchool = MagicSchool(
        id = "machinearium",
        name = "Машинариум",
        category = MagicCategory.UNIVERSAL,
        description = "Машинариум — особый вид ремесла, служащий для создания различных устройств и изобретений. Сочетает в себе различные виды науки и магических искусств для создания уникальных механизмов. Личность, занимающуюся этим видом деятельности, называют машинариумом (иногда с уточнением: био-машинариум, электро-машинариум, машинариум-оптик и т.д.).",
        spells = listOf(
            SpellEntry(
                id = "machinearium_basics",
                name = "Основы машинариума",
                category = MagicCategory.UNIVERSAL,
                school = "Машинариум",
                subgroup = "Основы",
                level = 1,
                description = "Для овладения этим видом профессии необходимо иметь знания о законах природы, магии, знать свойства материалов и обладать находчивостью. Начинающие машинариумы должны знать принцип работы простых механизмов и, если найдут чертёж, могут без труда собрать его.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Знания о законах природы",
                        "Знания о магии",
                        "Знания о свойствах материалов",
                        "Находчивость"
                    ),
                    preparation = "При должном стремлении машинариум может создавать собственные уникальные устройства, обладающие особыми свойствами. Для этого машинариум должен провести исследование, состоящее из нескольких этапов (каждый этап чипуется у мастера).",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "machinearium_stage_1_docs",
                name = "Этап 1: Техническая документация",
                category = MagicCategory.UNIVERSAL,
                school = "Машинариум",
                subgroup = "Этапы исследования",
                level = 1,
                description = "Машинариум должен расписать идею своего изобретения, изложить принцип его работы. Техническая документация обязательно должна быть аккуратно оформлена, вся информация должна быть изложена понятно и структурированно.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Описание идеи изобретения",
                        "Принцип работы"
                    ),
                    preparation = "Пример оформления изложен в главе «Известные простые механизмы».",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "machinearium_stage_2_drawing",
                name = "Этап 2: Чертёж",
                category = MagicCategory.UNIVERSAL,
                school = "Машинариум",
                subgroup = "Этапы исследования",
                level = 1,
                description = "Машинариум подготавливает чертёж (рисунок) будущего устройства. В нём необходимо указать обязательные материалы и элементы, которые должны использоваться в механизме. Рисунок должен быть выполнен аккуратно.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Чертёж (рисунок) устройства",
                        "Обязательные материалы",
                        "Обязательные элементы"
                    ),
                    preparation = "Рисунок должен быть выполнен аккуратно. Пример оформления — «Самописец» (см. стр. с примером).",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "machinearium_stage_3_prototype",
                name = "Этап 3: Опытный образец",
                category = MagicCategory.UNIVERSAL,
                school = "Машинариум",
                subgroup = "Этапы исследования",
                level = 1,
                description = "Удостоверившись, что в предыдущих этапах нет ошибок, а все расчёты верны, машинариум должен создать опытный образец. Он должен соответствовать чертежу и быть соразмерным.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Материалы по чертежу",
                        "Соблюдение соразмерности"
                    ),
                    preparation = "От аккуратности сборки напрямую зависит, насколько успешно будет работать устройство. Если в конструкции есть слабые места, это негативно скажется на работе устройства и даже может быть опасно. В будущем опытный образец можно будет отладить, чтобы улучшить его работу.",
                    duration = "—",
                    comments = "Чтобы собрать существующее устройство, необходимо обладать технической документацией и чертежами. Опытные машинариумы могут попробовать собрать устройство, имея только один из этих документов, или разобраться в принципе работы готового устройства и сделать реплику, но это не гарантирует стабильность работы механизма.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "machinearium_qualification",
                name = "Квалификация",
                category = MagicCategory.UNIVERSAL,
                school = "Машинариум",
                subgroup = "Квалификация",
                level = 1,
                description = "Машинариум, владеющий какой-либо профессией, может создать более удачную версию механизма. Например, кузнец может отлить более качественные детали, огранщик может сделать более совершенные линзы и т.д.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Профессия машинариума (кузнец, огранщик и т.д.)",
                        "Предрасположенность ветви магии:",
                        "• Жизнь — кристаллы души, биоинженерия, металлы (металломагия), дерево, камни",
                        "• Пламя — плавление, электрика, взрывы, энергетика",
                        "• Слово — акустика; может только по технической документации разработать чертёж и наоборот",
                        "• Равновесие — оптика, энергетика"
                    ),
                    preparation = "Для некоторых особо сложных устройств необходимо, чтобы в его создании участвовал специалист какой-то профессии или маг определённой ветви.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

        )
    )


    val alchemySchool = MagicSchool(
        id = "alchemy",
        name = "Зельеваренье",
        category = MagicCategory.UNIVERSAL,
        description = "Зельеваренье — искусство создания магических зелий и эликсиров. Каждое зелье требует определённых ингредиентов и времени. Для изготовления зелий необходимо знать рецепт и иметь все ингредиенты.",
        spells = listOf(
            // ========== ЗЕЛЬЯ I УРОВНЯ ==========
            SpellEntry(
                id = "alchemy_healing_balm",
                name = "Живительный бальзам",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Восстанавливает 1 единицу БД при ранениях и поддерживает жизнь при критическом ранении на 10 минут.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Листья Древа Жизни (черный чай)",
                        "Молотый коготь грифона (мускатный орех)",
                        "Молоко грифона (молоко)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Мята",
                        "Вода"
                    ),
                    preparation = "Поставить воду на огонь, кинуть листья Древа Жизни, варить до насыщенного темно-коричневого оттенка. Не выключая огня добавить молоко грифона, цвет зелья должен стать светлее. Добавить щепоть молотого когтя грифона и перемешать. Снять с огня. Добавьте несколько капель экстракта Алии, чтобы связать компоненты, и мяту.",
                    duration = "—",
                    comments = "Принимать теплым или горячим",
                    canBeAdded = false
                )
            ),
            SpellEntry(
                id = "alchemy_morpheus_gift",
                name = "Дар Морфея",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Усыпляет, погружает в магический сон, дарит приятные сновидения, оказывает успокаивающий эффект. Позволяет быстро выспаться и набраться сил. Иногда используется в лечебных целях, так как во время сна тяжело раненный получает отсрочку от смертельного исхода.",
                recipe = Recipe(
                    dosage = "бокал",
                    ingredients = listOf(
                        "Сон-бутон (валерьянка)",
                        "Сон-трава (душица)",
                        "Листья Древа Жизни (черный чай)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Мята",
                        "Фиалковая эссенция (мед)",
                        "Вода"
                    ),
                    preparation = "Заварить листья Древа Жизни и сон-траву в соотношении 2:1. Нагрейте до 60-70 градусов, но не доводите до кипения. Снимите с огня, добавьте столовую ложку фиалковой эссенции, перемешайте. Добавьте 10-15 капель экстракта сон-бутона на бокал, перемешайте. Добавьте несколько капель экстракта Алии, чтобы связать компоненты. Добавьте мяту.",
                    duration = "7 часов",
                    comments = "Принимать теплым. Сон может прервать только «Пробуждающее зелье» или ранение на 2 единицы БД.",
                    canBeAdded = true
                )
            ),
            SpellEntry(
                id = "alchemy_awakening",
                name = "Пробуждающее зелье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Прекращение сна, наложенного зельем или заклятием.",
                recipe = Recipe(
                    dosage = "бокал",
                    ingredients = listOf(
                        "Кофе",
                        "Апельсин или грейпфрут",
                        "Меланж (пряности для кофе)",
                        "Чешуя холодной змеи (лед)",
                        "Мятный сироп",
                        "Вода"
                    ),
                    preparation = "В турке варится кофе с меланжем. Высокий стакан наполнить чешуей холодной змеи. Налить на лед мятный сироп, подождать, пока он опустится на дно. Влить свежевыжатый апельсиновый/грейпфрутовый сок. Третьим слоем аккуратно через марлю влить кофе. Перед употреблением перемешать.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false
                )
            ),
            SpellEntry(
                id = "alchemy_wind",
                name = "Ветер",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Под действием зелья вы становитесь недосягаемым для всех видов атак, кроме света, молний и слов, пока находитесь в движении. Пока вы находитесь в движении, вы не можете колдовать заклинания.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Лунный настой (минералка)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Чешуя холодной змеи (лед)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Базилик",
                        "Мята"
                    ),
                    preparation = "Аккуратно влить лунный настой в емкость, добавить ложку порошка турбудиса, несколько листьев базилика и мяты. Добавьте несколько капель экстракта Алии, чтобы зелье приобрело красный оттенок. Добавить чешую холодной змеи. На доске мелом начертить руну Ветер. Стряхнуть надпись в бокал, дунуть на зелье.",
                    duration = "5 минут",
                    comments = "Принимать охлажденным",
                    canBeAdded = false
                )
            ),
            SpellEntry(
                id = "alchemy_light_of_hope",
                name = "Свет надежды",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Возвращает надежду, веру в лучшее. Помогает пострадавшим от Страха, после магического упадка сил или болезней. Навевает лучшие воспоминания из детства, дарит ощущение легкости.",
                recipe = Recipe(
                    dosage = "бокал",
                    ingredients = listOf(
                        "Молоко грифона (молоко)",
                        "Индиго (синий пищевой краситель)",
                        "Шоколад",
                        "Полынь",
                        "Мята",
                        "Вода"
                    ),
                    preparation = "Настоять полынь (залить ее кипятком). Сварить жидкий шоколад (1 доля шоколада на 2 доли воды), добавить молоко грифона (1 доля), снять зелье с огня. Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Добавить личное счастливое число капель полыни того, кто будет пить зелье.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false
                )
            ),
            SpellEntry(
                id = "alchemy_dragon_breath",
                name = "Драконье дыхание",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Дает прилив отваги и смелости, которая заставляет плевать на опасности и сомнения, толкает на подвиги, защиту чего-либо и борьбу с несправедливостью.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Сок глазных яблок долгопята (яблочный сок)",
                        "Навоз драконида (душистый перец-горошек)",
                        "Плоды калуа (смородина)",
                        "Сердечная жила драконида (молотый красный перец)",
                        "Индиго (синий пищевой краситель)",
                        "Слюна виверны (соус табаско)",
                        "Базилик"
                    ),
                    preparation = "Сок глазных яблок разогревается на медленном огне, но не доводя до кипения. Ингредиенты опускаются по очереди: плоды калуа — навоз драконида — сердечная жила драконида. Добавьте несколько капель индиго, чтобы связать компоненты. Далее 1 капля слюны виверны и пара листиков базилика.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = true
                )
            ),
            SpellEntry(
                id = "alchemy_bone_growth",
                name = "Костерест",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Сращивает сломанные кости. Восстанавливает 1 единицу боевого духа.",
                recipe = Recipe(
                    dosage = "бокал",
                    ingredients = listOf(
                        "Слюна симаргла (лаймовый сок)",
                        "Настойка женьшеня",
                        "Лунный настой (минералка)",
                        "Чешуя холодной змеи (лед)",
                        "Экстракт Алии (красный пищевой краситель)"
                    ),
                    preparation = "Лунный настой аккуратно залейте в емкость. В смесь влейте 8 капель слюны симаргла и 3 капли настойки женьшеня. Добавьте несколько капель экстракта Алии, чтобы связать компоненты. Добавьте столько чешуи холодной змеи, чтобы охладить зелье, но не «размыть» вкус.",
                    duration = "—",
                    comments = "Принимать холодным",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_alchhi",
                name = "Алчхи-зелье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Выпивший зелье смачно чихает. Если личность при этом пытается что-то сказать, то чихи идут через каждые два-три слова. Если личность будет молчать, то чихает каждые 5 секунд. Если личность не чихает, то теряет 1 единицу БД каждую минуту действия зелья.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Пух котилька (сладкая вата)",
                        "Лунный настой (минералка)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Экстракт Алии (красный пищевой краситель)"
                    ),
                    preparation = "Влить лунный настой в небольшую емкость (кружка, пиала и т.п.). Добавить щепотку порошка турбудиса. Пощекотать свой нос пухом котилька, опустить пух в настой до растворения первого. Чихнуть.",
                    duration = "5 минут",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_fedot",
                name = "Зелье Федота",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Выпивший зелье неустанно икает. Если личность при этом пытается что-то сказать, то ики идут через каждые два-три слова. Если личность будет молчать, то икает каждые 5 секунд. Если личность не икает, то теряет 1 единицу БД каждую минуту действия зелья.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Печенье",
                        "Лунный настой (минералка)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Экстракт Алии (красный пищевой краситель)"
                    ),
                    preparation = "Лунный настой налить в невысокую пиалу. Добавить щепотку порошка турбудиса. Подержать на ветру, приговаривая: «Икота, икота, перейди на Федота, с Федота на Якова, с Якова на *имя того, кому хотите наслать икоту*». Затем дунуть. Заговоренным зельем побрызгать на печенье, затем предложить его жертве.",
                    duration = "3 минуты",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_ryglo",
                name = "Рыгло",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Выпивший зелье неприлично рыгает. Если личность будет молчать, то рыгает каждые 30 секунд. Если личность не рыгает, то теряет 1 единицу БД каждую минуту действия зелья.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "—"
                    ),
                    preparation = "—",
                    duration = "3 минуты",
                    comments = "",
                    canBeAdded = true
                )
            ),
            SpellEntry(
                id = "alchemy_smeshnika",
                name = "Смешника",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Выпивший зелье разражается громким заразительным хохотом на любую шутку, даже несмешную, фразу, даже отдаленно напоминающую что-то забавное.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Сок глазных яблок долгопята (яблочный сок)",
                        "Лунный настой (минералка)",
                        "Хрустальная амброзия (сахар)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Индиго (синий пищевой краситель)",
                        "Настойка женьшеня"
                    ),
                    preparation = "Данное зелье обязательно варится в компании хотя бы из двух человек. На протяжении всего приготовления рассказывать шутки и анекдоты. Если они не будут смешными, зелье теряет свойства и не работает. В сок добавить чайную ложку амброзии, щепотку порошка турбудиса, размешать. В отдельную посуду налить лунный настой. В него добавить сок, смешанный с амброзией и порошком. Добавьте несколько капель индиго и экстракта Алии, чтобы зелье приобрело фиолетовый оттенок. В напиток капнуть 3 капли настойки женьшеня, громко рассмейтесь вместе с компанией.",
                    duration = "30 минут",
                    comments = "",
                    canBeAdded = true
                )
            ),
            SpellEntry(
                id = "alchemy_zapletyk",
                name = "Заплетык",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "У выпившего зелье, что называется, заплетык языкается. Личность и двух слов связать не может, что ни говори — все звучит как бред. Из-за небольшого когнитивного искажения пишет личность также непонятно и неразборчиво на какой-то тарабарщине.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Белая слизь (сгущенка)",
                        "Молоко грифона (молоко)",
                        "Кофе",
                        "Пыльца аратензии (корица)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Индиго (синий пищевой краситель)",
                        "Мята",
                        "Вода"
                    ),
                    preparation = "Весь процесс приготовления зелья озвучивать на тарабарщине, как будто вы разучились говорить. Заварить кофе в турке. Добавить щепоть аратензии. Нагреть молоко со столовой ложкой мяты на медленном огне, не доводить до кипения. Добавить столовую ложку белой слизи, хаотично перемешивать. Влить молоко в кофе, вновь хаотично перемешивать. Добавьте несколько капель индиго и экстракта Алии, чтобы зелье приобрело фиолетовый оттенок.",
                    duration = "15 минут",
                    comments = "",
                    canBeAdded = true
                )
            ),
            SpellEntry(
                id = "alchemy_slovobludie",
                name = "Словоблудие",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Выпивший зелье становится чертовски словоохотливым, невзначай разбалтывает секреты, испытывает неимоверный сплетнический зуд и стремится перемывать косточки самым разнообразным личностям, конечно же за их спиной. Также хочется заговорить со всеми подряд, рассказать о своей жизни, потравить байки.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Лунный настой (минералка)",
                        "Плоды калуа (смородина)",
                        "Хрустальная амброзия (сахар)",
                        "Белая слизь (сгущенка)",
                        "Порошок турбудиса (лимонная кислота)"
                    ),
                    preparation = "Весь процесс приготовления зелья рассказывать сплетни и секреты. Растолочь плоды калуа в емкости, перемешать с хрустальной амброзией и порошком турбудиса. В лунный настой добавить чайную ложку белой слизи, аккуратно перемешать. Добавить «варенье» из плодов калуа, взболтать.",
                    duration = "30 минут",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_slotykach",
                name = "Слотыкач",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Лишает тактильных ощущений, человек не может идти без опоры, спотыкается.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Холодная вода",
                        "Сон-трава (душица)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Фиалковая эссенция (мед)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Вода"
                    ),
                    preparation = "Все время варки зелья необходимо вертеть волчок либо другой похожий предмет. При добавлении всех ингредиентов варево нужно непрерывно размешивать то по часовой стрелке, то против. Сделать отвар из сон-травы (залить ее кипятком). Добавить специальной ложкой фиалковую эссенцию. Дать немного остыть. Влить холодной воды с добавлением щепотки порошка турбудиса в соотношении 2:1 (отвар:вода). Все время готовки приговаривать: «Кручу-верчу, запутать хочу!»",
                    duration = "30 минут",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_zaty_kach",
                name = "Затыкач",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Жвачка сплепляет челюсти, личность может только мычать.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Жвачка",
                        "Бумага",
                        "Нить"
                    ),
                    preparation = "На протяжении всей готовки зельевар молчит. Жвачка заворачивается в бумагу с надписью: «silencio aigrit est», связывается облизанной нитью. Необходимо дунуть на сверток, затем развернуть. Зельевар вновь может говорить. Угостить жвачкой жертву.",
                    duration = "30 минут",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_gemorroyka",
                name = "Геморройка",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Личность (личности) не могут сидеть, только стоять или лежать.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Насыщенная минералами вода (минералка)",
                        "Хвоя",
                        "Игла или шило"
                    ),
                    preparation = "Игла или шило с еловой хвоей 15 минут настаиваются в насыщенной минералами воде. Зельем натирается поверхность, на которую садятся.",
                    duration = "полчаса",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_violet_decoction",
                name = "Фиалковый отвар",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья I уровня",
                level = 1,
                description = "Нейтрализует действие слабого яда легкой токсичности.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Фиалковая эссенция (мед)",
                        "Молоко грифона (молоко)",
                        "Глаза ящерицы (анчан)",
                        "Личинки твердолобика (изюм)",
                        "Когти котилька (кокосовая стружка)",
                        "Вода"
                    ),
                    preparation = "Сделать отвар из личинок твердолобика и когтей котилька (залить их кипятком, воды должно быть столько, чтобы она только покрыла личинки и чайную ложку когтей), оставить настаиваться. Заварить Глаза ящерицы, умеренно крепко, чтобы цвет стал насыщенным синим. Влить через марлю ранее приготовленный отвар в соотношении 3:1 (Глаза ящерицы:отвар). Добавить стопку холодного молока грифона (дозировка на стакан). Влить 1 специальную ложку фиалковой эссенции.",
                    duration = "—",
                    comments = "Мгновенно отрезвляет, снимает эффекты алкоголя",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_makovka",
                name = "Маковка",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Используется как обезболивающее. Приглушает чувства и ощущения, в том числе болевые. Лёгкий галлюциноген. 2 глотка: обезболивает слабые и средние по тяжести ранения (1-3 единицы урона). 4 глотка: выпивший зелье не чувствует тяжелые ранения, а также не может осязать мир вокруг. Личность не чувствует боли и может сражаться даже с 1 единицей БД. После прекращения действия Маковки все ваши ранения дают о себе знать.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Белая слизь (сгущенка)",
                        "Сон-трава (душица)",
                        "Молоко грифона (молоко)",
                        "Кора ивы (гвоздика)",
                        "Лист Холодного куста (мелисса)",
                        "Индиго (синий пищевой краситель)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Мак (пищевой)",
                        "Вода"
                    ),
                    preparation = "Сделайте отвар из сон-травы (залить сон-траву кипятком), оставьте в сторону настаиваться на 5 минут. Поставьте молоко на огонь и, как нагреется, добавьте в него белую слизь. Ослабьте огонь до минимума. Непрерывно помешивайте и всыпьте щепоть коры ивы. Всё так же помешивая, тонкой струйкой влейте в молочную смесь отвар из сон-травы в соотношении 2:1 (молоко:отвар). Снимите с огня. Добавьте чайную ложку мака и несколько листьев Холодного куста. Добавьте несколько капель индиго и экстракта Алии, чтобы связать компоненты.",
                    duration = "полчаса",
                    comments = "Принимать теплым. Наркотик. Вызывает привыкание со второго употребления. Из-за снижения болевого порога вы можете не заметить, как получили критическое ранение.",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_tomato",
                name = "Томатное зелье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Прибавляет выпившему зелье 3 единицы БД, пока их не снимут. При дальнейшем лечении эти единицы не восстановятся. Без вреда здоровью можно принять только одно томатное зелье. В случае, если личность принимает второе, случается передозировка. Кожа начинает вздуваться и лопаться, как от поедания гардарийских томатов, личность получает 1 урон. Повторное безопасное применение возможно после потери всех дополнительных БД от томатного зелья.",
                recipe = Recipe(
                    dosage = "бокал",
                    ingredients = listOf(
                        "Мякоть гардрийского томата (большой помидор)",
                        "Сок гардрийского томата (томатный сок)",
                        "Сердечная жила драконида (молотый красный перец)",
                        "Молотый коготь грифона (мускатный орех)",
                        "Слюна виверны (соус табаско)"
                    ),
                    preparation = "В охлажденный сок гардарийского томата добавьте мякоть этого же томата. На бокал сока капните 3 капли слюны виверны, щепоть сердечной жилы драконида и молотого когтя грифона, перемешайте.",
                    duration = "—",
                    comments = "Принимать холодным или комнатной температуры",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_somnia_creaturae",
                name = "Somnia enim creaturae",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Отвар предназначен для успокоения нрава различного рода небольших по размеру и несильных тварей (аслиды, дракониды, вурмы, различные млекопитающие, вольпертингеры и т.п.). Зверь, которому в пасть влили отвар, становится сонным и вялым, неагрессивным.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Экстракт сон-бутона (валерьянка)",
                        "Сон-трава (душица)",
                        "Листья Холодного куста (мелисса)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Вода"
                    ),
                    preparation = "Варить в сумерки, вечером. Залить кипятком сон-траву и листья Холодного куста в соотношении 3:1 (сон-трава:Холодный куст), дать настояться. Добавить 8 капель экстракта сон-бутона и перемешать по часовой стрелке 8 раз. Добавьте несколько капель экстракта Алии, чтобы зелье приобрело красный оттенок. Охладить. Произнести формулу: «Dormi, creatura, dormi, oculos tuos».",
                    duration = "2 часа",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_black_blood",
                name = "Черная кровь",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Под действием зелья кровь становится ядовита для чудовищ, вурдалаков и нежити, питающихся кровью и внутренними органами. Выпитая отравленная кровь вызывает сильную интоксикацию и приводит к смерти (каждые 10 минут у жертвы –1 жизнь).",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Корень мандрагоры (имбирь)",
                        "Слюна виверны (соус табаско)",
                        "Улун",
                        "Вода"
                    ),
                    preparation = "—",
                    duration = "—",
                    comments = "Оказывает отравляющее действие на использующего (–1 жизнь у вас), вызывает слабость, головокружение, озноб, ослабление концентрации, невозможность использовать сложные заклинания (третий уровень и выше).",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_light_star_serum",
                name = "Сыворотка светлой звезды",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Рассеивает наложенные на другого человека чары воздействия (легкого и среднего уровня), а также зелий, влияющих на разум.",
                recipe = Recipe(
                    dosage = "бокал",
                    ingredients = listOf(
                        "Слезы единорога (Ессентуки)",
                        "Лунный настой (минералка)",
                        "Желчь наводной серпницы (апельсиновый сок)",
                        "Индиго (синий пищевой краситель)",
                        "Настойка женьшеня",
                        "Хвоя"
                    ),
                    preparation = "Влить лунный настой в отдельную емкость, бросить в него хвою, отставить в сторону. Желчь наводной серпницы добавить 10 капель слез единорога и 3 капли настойки женьшеня (дозировки на бокал желчи). Достать из лунного настоя 2 хвоинки. Влить лунный настой в желчь в соотношении 1:3 (настой:желчь). Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Аккуратно размешать. Тому, кто будет пить зелье, уколоть виски двумя хвоинками, затем дать зелье.",
                    duration = "—",
                    comments = "Личность под воздействием не может самостоятельно использовать зелье, так как не осознает, что находится под воздействием. Также побочным эффектом является полное игнорирование эффекта зелья «Стекольное зеркальшко».",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_moroch_sourdough",
                name = "Морочащая закваска",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Выпивший зелье принимает все, сказанное другими, за чистую монету, становится простодушным, ни в чем не ищет подвоха. В свою очередь, если выпившему задают вопросы, правдиво отвечает на них, забывает, как хитрить и увертываться.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Глаза ящерицы (анчан)",
                        "Белая слизь (сгущенка)",
                        "Лист Холодного куста (мелисса)",
                        "Сон-трава (душица)",
                        "Молоко грифона (молоко)"
                    ),
                    preparation = "Заварить Глаза ящерицы. Нагреть молоко. Не снимая его с огня, добавить по столовой ложке листьев Холодного куста и сон-травы. Варить на минимальном огне минуту-другую. Добавить чайную ложку белой слизи, перемешать. Влить заваренные Глаза ящерицы в молоко в соотношении 2:1 (Глаза:молоко). При варке чередовать размешивание 8 раз по часовой стрелке и против.",
                    duration = "1 час",
                    comments = "Принимать теплым",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_osmomysl",
                name = "Осмомысл",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Вы ощущаете, что кто-то очень умный и хитрый заморочил вам голову! Включайте своего внутреннего детектива и расследуйте все мало-мальски подозрительное, разнюхивайте странное и следите за подозрительными, как Вам безусловно кажется, личностями.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Глаза ящерицы (анчан)",
                        "Белая слизь (сгущенка)",
                        "Мята",
                        "Молотый коготь грифона (мускатный орех)"
                    ),
                    preparation = "Заварить Глаза ящерицы и чайную ложку мяты. Добавить чайную ложку белой слизи, перемешать. Всыпать щепоть молотого когтя грифона. На протяжении варки вслух загадывать загадки.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_fun_juice",
                name = "Веселящий сок",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Галлюциноген, мгновенно опьяняющий, вызывающий помутнение сознания, выражающееся в повышенной любвеобильности и симпатии.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Лунный настой (минералка)",
                        "Сок глазных яблок долгопята (яблочный сок)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Индиго (синий пищевой краситель)",
                        "Базилик",
                        "Мята",
                        "Чешуя холодной змеи (лед)"
                    ),
                    preparation = "При каждом добавлении ингредиентов как бы заигрывайте с зельем, применяйте свои пикаперские навыки. Можно рассказывать похабные истории или сальные шуточки, пока варится зелье. В стакан сока глазных яблок всыпьте щепоть порошка турбудиса, размешайте. Влейте сок в лунный настой в соотношении 3:1 (сок:настой). Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Добавьте свежие базилик и мяту, немного чешуи холодной змеи.",
                    duration = "1 час",
                    comments = "Легкий наркотик, при частом употреблении вызывает привыкание (более 1 бокала в сутки)",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_pearl_of_words",
                name = "Жемчуг слов",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Выпивший осознаёт ценность слов. Как следствие, он серьезно думает над тем, что и кому он говорит, и тратит свои драгоценные слова только на тех, с кем необходимо поговорить, либо на тех, кого он очень уважает. В высоком смысле добавляет выпившему покоя, сосредоточенности и осмысленности действий и слов. В бытовом — прекращает «словесный понос».",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Одолень-трава (зеленый чай)",
                        "Молоко грифона (молоко)",
                        "Пыльца аратензии (молотая корица)",
                        "Ваниль (ванилин)",
                        "Хрустальная амброзия (сахар)",
                        "Молотый коготь грифона (мускатный орех)",
                        "Индиго (синий пищевой краситель)",
                        "Вода",
                        "Жемчуг (жемчужное изделие на нитке)"
                    ),
                    preparation = "Вскипятить воду. Заварить одолень-траву (умеренно крепко). Пока она заваривается, нагреть молоко. Добавить в молоко амброзию, ваниль, аратензию, молотый коготь. На дно бокала положить жемчужину (на нитке, чтобы после легко извлечь), влить отвар одолень-травы. Добавить к нему молоко (около 1/4-1/3). Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Все операции производить в молчании. После перемешивания зелья, оно считается готовым, и зельевар снова может говорить.",
                    duration = "полчаса",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_stone_heart",
                name = "Каменное сердце",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Выпившая зелье личность становится очень сдержанной, почти безэмоциональной, холодной.",
                recipe = Recipe(
                    dosage = "стопка",
                    ingredients = listOf(
                        "Плоды калуа (смородина)",
                        "Индиго (синий пищевой краситель)",
                        "Хрустальная амброзия (сахар)",
                        "Листья Холодного куста (мелисса)",
                        "Сон-трава (душица)",
                        "Молотый коготь грифона (мускатный орех)",
                        "Камень (тщательно промытый!)",
                        "Чешуя холодной змеи (лед)",
                        "Вода"
                    ),
                    preparation = "Положить камень на дно котла. Залить воды. Насыпать ягоды калуа (много, т.к. по сути, варим компот). Довести до кипения, уменьшить огонь до минимума. Шкурки ягод должны лопнуть. Добавить амброзию. Потом — листья Холодного куста, сон-траву. Варить 20 минут. Снять с огня. Добавить мускат. Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Мешать восемь раз против часовой стрелки, шепча: «И вот мне приснилось, что сердце мое не болит».",
                    duration = "1 час",
                    comments = "Вызывает привыкание, если за сутки выпито больше одной дозы, а за флань — больше трех. Без дозировки зелья личность становится агрессивной, раздражительной. Антидот — зелье «Motus aniāae».",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_motus_aniaae",
                name = "Motus aniāae",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Выпивший становится очень чувствительным, не может защищаться от собственных эмоций, воспринимает их очень болезненно. Антидот — зелье «Каменное сердце».",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Собственные слезы",
                        "Фиалковая эссенция (мед)",
                        "Омела (жасмин)",
                        "Индиго (синий пищевой краситель)",
                        "Вода",
                        "Пыльца аратензии (молотая корица)",
                        "Меланж (пряности для кофе)",
                        "Хвоя",
                        "Воск"
                    ),
                    preparation = "Из воска лепим сердечко, внутрь которого вонзаем иголку хвои. В отвар омелы (омелу залить кипятком) добавляем по щепоти аратензии и меланжа, ложку фиалковой эссенции. Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Затем в небольшую плошечку помещаем сердце с шипом, и пускаем плошку плавать в котел с зельем, капнув на сердце собственные слезы. Ждем, пока сердце растает, затем выкидываем и хвою, и расплавленный воск. Зелье готово.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_glass_mirror",
                name = "Стекольное зеркальшко",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья II уровня",
                level = 2,
                description = "Дает ясность сознания, позволяет видеть сквозь чары иллюзии, морока.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Желчь наводной серпницы (апельсиновый сок)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Лунный настой (минералка)",
                        "Личинки твердолобика (изюм)",
                        "Корень мандрагоры (имбирь)",
                        "Настойка женьшеня",
                        "Вода"
                    ),
                    preparation = "Сделать отвар из личинок твердолобика (залить личинки кипятком, воды должно быть столько, чтобы она только покрыла личинки). Настоять, затем остудить. В желчь наводной серпницы добавить 3 капли настойки женьшеня, щепоть порошка турбудиса и пол чайной ложки кашицы из корня мандрагоры. Смеси должно получиться две стопки. В емкость (стакан) налить лунный настой. Добавить сперва 1 стопку отвара из личинок твердолобика. Затем добавить смесь желчи, аккуратно перемешать. На доске мелом начертить стаф Сул (Морок) того уровня, который Вам доступен в рунологии. Перечеркнуть его, стряхнуть надпись в зелье.",
                    duration = "полчаса",
                    comments = "",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_savior",
                name = "Спаситель",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Восстановление 3 единиц БД, способен излечить критическое ранение.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Очи первоцвета (молочный улун)",
                        "Молоко единорога (миндальное молоко)",
                        "Стебель аратензии (палочка корицы)",
                        "Корень мандрагоры (имбирь)",
                        "Молотый коготь грифона (мускатный орех)",
                        "Навоз драконида (душистый перец-горошек)",
                        "Хрустальная амброзия (сахар)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Кора ивы (гвоздика)"
                    ),
                    preparation = "Вскипятите воду, когда закипит, добавьте кору ивы, аратензию, молотый коготь грифона и навоз драконида. Кипятите в течение 10 минут. Пока смесь варится, мелко порубите кусочек корня мандрагоры, чтобы получилась столовая ложка измельченной мякоти, добавьте ее в воду. Через 3 минуты добавьте молоко, чайную ложку хрустальной амброзии и кипятите еще в течение 5 минут. Затем выключите огонь. Добавьте Очи первоцвета, оставьте завариваться. Добавьте несколько капель экстракта Алии, чтобы связать компоненты. На доске мелом начертить рунический стаф — жизненный стаф. Стряхнуть надпись в котел.",
                    duration = "—",
                    comments = "Принимать горячим",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_alaban_elixir",
                name = "Эликсир Алабана",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Восстановление всех единиц БД, но только из состояния критического ранения. После приема данного зелья наступает сильная интоксикация организма. Вы не можете принимать зелья следующие 2 часа.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Лист Древа Жизни (черный чай)",
                        "Порошок корня мандрагоры (тертый имбирь)",
                        "Молотый коготь грифона (мускатный орех)",
                        "Фиалковая эссенция (мед)",
                        "Плод каратуса (лимон)",
                        "Кровь единорога (мороженая вишня)",
                        "Стебель аратензии (палочка корицы)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Мята",
                        "Вода"
                    ),
                    preparation = "Зелье варится днем, пока не зашло солнце. Вскипятите воду и добавьте порошок корня мандрагоры, молотый коготь грифона и стебель аратензии, пусть варятся. Засыпьте листья Древа Жизни и ослабьте огонь до минимума. Закиньте несколько кружков плода каратуса. Через пару минут выключите огонь, добавьте ложку фиалковой эссенции, 3 часа простоявшей на солнце, и перемешайте. Добавьте несколько капель экстракта Алии, чтобы связать компоненты. Добавьте мяту.",
                    duration = "—",
                    comments = "Принимать горячим. После приема наступает сильная интоксикация — нельзя принимать зелья 2 часа.",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_somnia_bestia",
                name = "Somnia enim bestia",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Отвар предназначен для успокоения нрава различного рода больших по размеру и сильных бестий (виверны, химериты, саламандры, лукоркасы, церберы, магические приматы и т.п.). Зверь, которому в пасть влили отвар, становится сонным и вялым, неагрессивным.",
                recipe = Recipe(
                    dosage = "бокал",
                    ingredients = listOf(
                        "Экстракт сон-бутона (валерьянка)",
                        "Сон-трава (душица)",
                        "Белая слизь (сгущенка)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Мята",
                        "Вода, настоянная на кладбище"
                    ),
                    preparation = "В большую колбу налить воду и в течение суток настаивать на кладбище. Варить в ночь. Вскипятить воду с кладбища и залить ею сон-траву и мяту в соотношении 2:1 (сон-трава:мята). Добавить ложку белой слизи, перемешать по часовой стрелке 8 раз. Добавить 8 капель экстракта сон-бутона. Добавьте несколько капель экстракта Алии, чтобы зелье приобрело красный оттенок. Охладить. Произнести формулу: «Dormi, bestia, dormi, oculos tuos, leniret spiritum tuum».",
                    duration = "1 час",
                    comments = "Принимать холодным",
                    canBeAdded = true
                )
            ),
            SpellEntry(
                id = "alchemy_polyjuice",
                name = "Оборотное зелье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Полное перевоплощение в личность, чья телесная частичка была использована в зелье. Не превращает одежду. Перевоплотиться можно лишь в примерно схожую по массе личность. Невозможно превратиться в животное или существо. Оборотное зелье не скрывает шрамы.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Сушеные крылья фей (каркаде)",
                        "Сердечная жила драконида (красный молотый перец)",
                        "Корень мандрагоры (имбирь)",
                        "Личинки твердолобика (изюм)",
                        "Кровь единорога (мороженая вишня)",
                        "Биологический материал личности, в которую хотите обратиться",
                        "Вода"
                    ),
                    preparation = "Сделать отвар из личинок твердолобика (залить их кипятком), оставить настаиваться. Заварить сушеные крылья фей, всыпать щепоть сердечной жилы драконида и пол чайной ложки кашицы корня мандрагоры. Влить отвар из личинок, перемешивать против часовой стрелки. Растолочь замороженную кровь единорога и добавить в смесь. Оставить в темное место настаиваться трое суток. После — добавить биологический материал. Перед употреблением каждой дозы зелья произносить формулу: «Обернись к ним *именем личности, чей биологический материал был использован*, ко мне — ложью».",
                    duration = "1 час",
                    comments = "Интоксикация. С каждым повторным употреблением интоксикация увеличивается. После 3 доз каждое употребление зелья отнимает по 1 единице БД.",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_recall_serum",
                name = "Сыворотка «Вспомнить все»",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Способствует восстановлению стертых или измененных участков памяти. Восстанавливает 1 забытое воспоминание. Спасает от зелья «Блаженное забытье».",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Вода",
                        "Одолень-трава (зеленый чай)",
                        "Лист Холодного куста (мелисса)",
                        "Мята",
                        "Порошок корня мандрагоры (молотый имбирь)",
                        "Кора ивы (гвоздика молотая)",
                        "Индиго (синий пищевой краситель)",
                        "Цедра плода каратуса (лимон)",
                        "Навоз драконида (душистый перец-горошек)"
                    ),
                    preparation = "Начертить схематический лабиринт. Поставить в его центр кубок. Кипящую воду снять с огня. Добавить щепоть корня мандрагоры. Добавить листья одолень-травы — полгорсти. Снова поставить на огонь. В кипящий состав кинуть листья Холодного куста, щепоть молотой коры ивы, два шарика навоза. Затем натертую свежую цедру (1/8 плода) и свежевыжатый сок каратуса (столовая ложка). Через секунду добавить неполную чайную ложку мяты и сразу снять с огня. Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Перелить в стеклянный или хрустальный сосуд, который стоит в центре схемы лабиринта. Произнести заклинание: «Ad perpetuat rei metoriaт». Оставить до полного остывания. Если хотите вспомнить забытое воспоминание, то назовите его.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_blissful_oblivion",
                name = "Блаженное забытье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Зелье забвения. Можно забыть одно событие, случившееся в текущем индикте. Неподвластно составу: призвание личности, её миссия, её вера, её мировоззренческие убеждения, её идеалы. Остальное по выбору личности она может забыть.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Белая слизь (сгущенка)",
                        "Молоко единорога (миндальное молоко)",
                        "Экстракт сон-бутона (валерьянка)",
                        "Можжевеловые ягоды",
                        "Индиго (синий пищевой краситель)",
                        "Мята",
                        "Вода",
                        "Нитки и иголка",
                        "Сухие ягоды или бусины"
                    ),
                    preparation = "Нанизать на нитку бусины воспоминаний. Сделать отвар из мяты (залить её кипятком). Добавить туда столовую ложку белой слизи, медленно размешать. Положить в отвар нить воспоминаний. Всыпать несколько можжевеловых ягод. Молоко единорога нагреть и остудить, добавить 10-15 капель экстракта сон-бутона. Начертить на листе бумаги схему лабиринта. Через марлю добавить в молоко отвар. Добавьте несколько капель индиго, чтобы зелье приобрело синий оттенок. Час настаивать в центре лабиринта. Этот час молчать.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_all_purpose",
                name = "Всевозможное зелье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Открывает доступ к заклинаниям на уровень выше тех, что ты знаешь на 3 последующих заклинания, включая небоевые и заклинания-щиты.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Настойка женьшеня",
                        "Одолень-трава (зеленый чай)",
                        "Жуковица (сливки)",
                        "Золотая смола (желтый пищевой краситель)",
                        "Кровь единорога (вишня)",
                        "Личинки твердолобика (изюм)",
                        "Слюна виверны (соус табаско)",
                        "Вода",
                        "Элемент Ветви того, кто выпьет зелье (Пламя — огонь; Жизнь — лист Древа Жизни; Слово — отдать приказ в котел: «варись!»; Равновесие: Свет — луч света, Тень — накрыть зелье ладонью)"
                    ),
                    preparation = "Заварить одолень-траву вместе с личинками твердолобика. Оставить настаиваться. Достать согреваться 3 кусочка замороженной крови единорога. Нагреть стопку жуковицы, не доводить до кипения. Добавить 3 капли слюны виверны. В отвар одолень-травы и личинок добавить 3 капли настойки женьшеня. Влить жуковицу со слюной виверны. Перемешать 3 раза по часовой стрелке и 3 раза против. Добавить первый кусочек крови и также перемешать. Со вторым и третьим перемешать также. Добавьте несколько капель золотой смолы, чтобы зелье приобрело желтый или янтарный оттенок. Добавить элемент Ветви.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_cleansing_elixir",
                name = "Очищающий эликсир",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Прекращает действие эффектов предыдущих эликсиров (кроме исцеляющих), не считается зельем, в числе тех, что приводят к интоксикации, а также нейтрализует действие среднего яда.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Настойка женьшеня",
                        "Молоко единорога (миндальное молоко)",
                        "Фиалковая эссенция (мед)",
                        "Одолень-трава (зеленый чай)"
                    ),
                    preparation = "Перед приготовлением зелья и после тщательно промыть все необходимые приборы. Заварить одолень-траву достаточно крепко. Когда заварится, добавьте 5 капель настойки женьшеня (дозировка на стакан), перемешать. Подогреть молоко единорога, добавить ложку фиалковой эссенции, взбить до состояния легкой пенки. Добавить в ранее приготовленный отвар из одолень-травы.",
                    duration = "—",
                    comments = "Мгновенно отрезвляет, снимает эффекты алкоголя",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_berserk",
                name = "Берсерк",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Зелье устраняет чувство страха и повышает болевой порог. Выпивший зелье практически не отдает себе отчет в своих действиях, рвется в бой, но все-таки может отличить союзников от противников. Использование зелья уменьшает БД на 1 единицу.",
                recipe = Recipe(
                    dosage = "колба",
                    ingredients = listOf(
                        "Кровь вервольфа (вишневый сок)",
                        "Сердечная жила драконида (красный молотый перец)",
                        "Слюна виверны (соус табаско)",
                        "Молотый коготь грифона (мускатный орех)",
                        "Меланж (пряности для кофе)"
                    ),
                    preparation = "Поставить на медленный огонь кровь вервольфа. Смешать по щепоти сердечной жилы драконида, молотого когтя грифона и меланжа в отдельной емкости, добавить в нагретую кровь вервольфа. Довести до кипения, и сразу же снять с огня. Быстро добавить 3 капли слюны виверны. На доске мелом начертить рунический знак Онд (Агрессия). Стряхнуть надпись в котел.",
                    duration = "1 час",
                    comments = "Принимать горячим. Вызывает привыкание со второго употребления. Если во время действия зелья вас лишили всех жизней, то после окончания действия зелья вы получаете критический урон и, при отсутствии лечения, умираете.",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_love_potion",
                name = "Приворотное зелье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Создает сильное любовное влечение, зачастую ставит объект влечения на первое место, пробуждает желание видеть этого человека, быть рядом с ним. Человек принимает свое влечение за истинную любовь, не желает отказывается от своего чувства, витает в облаках.",
                recipe = Recipe(
                    dosage = "от одной чайной ложки — чем больше ложек, тем сильнее действие",
                    ingredients = listOf(
                        "Фиалковая эссенция (мед)",
                        "Ядовитые плоды (шиповник)",
                        "Меланж (пряности для кофе)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Индиго (синий пищевой краситель)",
                        "Алая роза",
                        "Ваниль (ванилин)",
                        "Пыльца аратензии (корица)",
                        "Вода",
                        "Ромашка"
                    ),
                    preparation = "Сделать отвар ядовитых плодов с фиалковой эссенцией и меланжем (залить их кипятком и оставить настаиваться). Остудить до слегка теплого состояния. Добавить щепоть порошка турбудиса и пару щепоток ванили. Закопать в землю на 1-2 суток. Сделать экстракт алой розы, поставить в голову кровати (под подушку, под кровать) на сутки. Соединить экстракт с основой, добавьте несколько капель индиго и экстракта Алии, чтобы зелье приобрело фиолетовый оттенок. Добавьте пепел от листа бумаги, где написано имя того, к кому надо приворожить. В емкость с зельем кинуть лепестки ромашки, на которых нагадано: «Любит». Перелить через сито в колбу. Поцеловать колбу.",
                    duration = "от двух часов",
                    comments = "Тройная доза приворотного зелья строжайше карается законом, как подчинение чужой воли. Антидот — «Отворотное зелье».",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_love_antidote",
                name = "Отворотное зелье",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Противоядие к «Приворотному зелью» (действует сразу), также приглушает чувство любви и симпатии.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Фиалковая эссенция (мед)",
                        "Ядовитые плоды (шиповник)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Экстракт Алии (красный пищевой краситель)",
                        "Индиго (синий пищевой краситель)",
                        "Белая роза",
                        "Разрыв-трава (крапива)",
                        "Листья холодного куста (мелисса)",
                        "Вода",
                        "Ромашка"
                    ),
                    preparation = "Фиалковую эссенцию и ядовитые плоды варить на воде полчаса, снять с огня. Добавить порошок турбудиса, листья холодного куста. Остудить, затем закопать в землю на 1-2 суток. Экстрагировать белую розу и разрыв-траву вместе. Поставить в ноги кровати (под матрас в ногах) на сутки. Соединить с основой, добавьте несколько капель индиго и экстракта Алии. Добавить лепестки ромашки, на которых нагадано: «Не любит», и пепел бумаги с именем объекта отворота, выпить.",
                    duration = "от двух часов",
                    comments = "",
                    canBeAdded = true
                )
            ),
            SpellEntry(
                id = "alchemy_bound_together",
                name = "Скованные одним зельем",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Два волшебника, выпив из парных склянок, не смогут отходить друг от друга дальше, чем на 2 метра. Обе личности должны принять зелье с различием во времени не больше двух часов. При попытке ухода одной из личностей в другой план реальности (Тени, Альхера), если связанная с ним личность не делает того же, переход не будет осуществлен. Связь может порвать смерть одной из связанных личностей.",
                recipe = Recipe(
                    dosage = "глоток на каждого",
                    ingredients = listOf(
                        "Вода",
                        "Мате",
                        "Кристаллизованная хрустальная амброзия (кубики сахара)",
                        "Почка Древа Жизни (любой зеленый чай, скрученный в крупный шарик)",
                        "Фиалковая эссенция (мед)"
                    ),
                    preparation = "Заварить мате (довести воду до кипения, потом всыпать мате). Снять с огня. Добавить в горячую основу фиалковую эссенцию. Добавить 5 кристаллов амброзии — по одному! Перед добавлением следующего мешать по часовой стрелке до растворения кристалла. Разлить по двум склянкам. Пока зелье горячее, добавить в каждую склянку по одной почке столетнего дуба. Затем полностью остудить все, по очереди дуя на зелье в обеих склянках.",
                    duration = "3 часа",
                    comments = "",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_living_death",
                name = "Напиток живой смерти",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Погружает выпившего в летаргический сон, неотличимый от смерти. Жизненные процессы замедляются настолько, что личность кажется мертвой. В таком состоянии жертва может находится около сотни лет, затем ресурсы организма истощаются, если не поддерживать жизнь в теле жертвы, и та умирает. Антидота нет.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Кровь (гранатовый сок)",
                        "Экстракт сон-бутона (валерьянка)",
                        "Мята",
                        "Сон-трава (душица)",
                        "Порошок турбудиса (лимонная кислота)",
                        "Меланж (пряности для кофе)",
                        "Перепонка с крыльев детеныша виверны (кожица с дольки апельсина)",
                        "Можжевеловые ягоды",
                        "Вода, настоянная на кладбище",
                        "Собственные слезы"
                    ),
                    preparation = "В большую колбу налить воду и в течение суток настаивать на кладбище. Сон-траву и мяту заварить в воде с кладбища, добавить 10-15 капель экстракта сон-бутона и порошок турбудиса на кончике ножа. Томить на медленном огне. Добавить щепоть меланжа и несколько ягод можжевельника. Положить 3-4 перепонки с крыльев детеныша виверны. Снять с огня. Добавить 13 капель крови и 4 собственных слезы. Выкинуть перепонки.",
                    duration = "около сотни лет",
                    comments = "Антидота нет",
                    canBeAdded = true
                )
            ),

            SpellEntry(
                id = "alchemy_agony_needle",
                name = "Игла агонии",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "1 глоток — относительно безопасная доза, обостряет чувствительность. Мир становится очень ярким, прикосновения к чему-то приятному доставляют огромное удовольствие. До 3-х глотков — чувствительность повышается, становясь все болезненней. 5 глотков — колющий эффект сильного электрического разряда от любого прикосновения к вам живого существа. 7 глотков — колющий эффект сильного электрического разряда от любого соприкосновения с одеждой, поверхностью и т.д. Нестерпимая боль, агония. Больше 7 глотков — болевой шок, потеря сознания на 15 минут. После 7 глотков выпивший яд источает Страх.",
                recipe = Recipe(
                    dosage = "несколько глотков",
                    ingredients = listOf(
                        "Кровь (гранатовый сок)",
                        "Кровь вервольфа (вишневый сок)",
                        "Слезы единорога (Ессентуки)",
                        "Сердечная жила драконида (красный молотый перец)",
                        "Кофе",
                        "Молотый коготь грифона (мускатный орех)",
                        "Плод каратуса или его сок (лимон)",
                        "Вода"
                    ),
                    preparation = "Основа 1: Кровь вервольфа нагревается с перетертой жилой драконида и щепоткой молотого когтя грифона, не доводится до кипения. Основа 2: Кофе с соком плода каратуса. Смешиваем основы в пропорции 2:1. Произносим формулу: «Пер круццо ад люццо». Добавляем столько капель крови, сколько единиц жизни у предполагаемой личности, что выпьет зелье. В два раза меньше капель слез единорога.",
                    duration = "полчаса",
                    comments = "После 7 глотков выпивший яд источает Страх",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_gom_jabbar",
                name = "Гом джаббар",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Зелья III уровня",
                level = 3,
                description = "Паралитический яд. При попадании в кровь жертвы парализует ее. Каждую последующую минуту у жертвы убывает по одной единице БД. Всего -5 единиц БД, если до истечения времени действия яда не было оказано лечения заклинанием Исцеления от ядов или принят Безоаровый камень.",
                recipe = Recipe(
                    dosage = "капля",
                    ingredients = listOf(
                        "Кровь (гранатовый сок)",
                        "Листья холодного куста (мелисса)",
                        "Сушеные крылья фей (каркаде)",
                        "Сердечная жила драконида (молотый красный перец)",
                        "Вода"
                    ),
                    preparation = "Заварить сушеные крылья фей с листьями Холодного куста в соотношении 3:1. В стопку крови добавить щепоть сердечной жилы драконида. Влить отвар из крыльев фей и Холодного куста в соотношении 2:1 (кровь:отвар). На доске мелом начертить рунический знак Фел. Стряхнуть надпись в зелье.",
                    duration = "5 минут",
                    comments = "Яд наносится на иглу, нож, клинок. В процессе отравления выделяется Страх",
                    canBeAdded = false
                )
            ),

            SpellEntry(
                id = "alchemy_fortune",
                name = "Фортуна",
                category = MagicCategory.UNIVERSAL,
                school = "Зельеваренье",
                subgroup = "Мастерство",
                level = 4,
                description = "Жидкая удача. На выездных играх дух удачи оберегает игрока, выпившего зелье, от урона или эффекта заклинаний, если тот не поставил блок или поставил его неправильно. Это работает 3 раза за время действия зелья. На водилках удачливый игрок 3 раза может изменить значения на брошенных кубиках в свою пользу, словом, перекидать мастера.",
                recipe = Recipe(
                    dosage = "пузырек",
                    ingredients = listOf(
                        "Тотем с духом удачи — Хаминья",
                        "Червона рута (улун Бай Я Цилань)",
                        "Коготь грифона (мускатный орех)",
                        "Кровь единорога (вишня)",
                        "Молоко единорога (миндальное молоко)",
                        "Фиалковая эссенция (мед)",
                        "Сахар",
                        "Можжевельник"
                    ),
                    preparation = "Зельевар должен войти в помещение или подойти к котлу с правой ноги. Все действия, касающиеся приготовления зелья, делать правой рукой. Жечь можжевеловые ветви, чтобы выстроить связь с духами. В чашу с молоком единорога, перемешанным с фиалковой эссенцией, опустите тотем Хаминьи. С улыбкой рассыпьте сахар по кругу и в его центр поставьте чашу. Залейте червону руту кипятком и дайте завариться вместе с кровью единорога. Подождите около 5 минут. Через сито или марлю влейте в отдельную чашу отвар. Далее тонкой струйкой в отвар влейте молоко единорога, придерживая тотем. В это время произносите формулу: «spiritus felicis, oscule me, quia captus es chervona ruta». Ложкой по поверхности зелья нарисовать руну Джера.",
                    duration = "9 часов",
                    comments = "Побочный эффект: головокружение и самоуверенность. Следующие 1,5 часа игрок не может принимать другие зелья. Если в течение этого времени игрок принимает хотя бы одно зелье, то наступает интоксикация.",
                    canBeAdded = false
                )
            ),


        // Сюда будем добавлять следующие зелья
        )
    )

    val enchantmentSchool = MagicSchool(
        id = "enchantment",
        name = "Зачарование",
        category = MagicCategory.UNIVERSAL,
        description = "Зачарование (чары) — артефактология, наука о создании магических предметов. Позволяет накладывать на предметы магические эффекты. Каждое зачарование уникально и создаётся по общим правилам, описанным ниже.",
        spells = listOf(
            // ========== ОСНОВЫ ЗАЧАРОВАНИЯ ==========

            SpellEntry(
                id = "enchantment_components",
                name = "Компоненты зачарования",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Основы",
                level = 1,
                description = "Без хотя бы одного из компонентов зачарование не произойдёт.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "1. Волшебник — существо, владеющее магией",
                        "2. Ингредиент(ы) с магическими свойствами или подходящие по смыслу",
                        "3. Зачаровываемый объект",
                        "4. Обозначенное место проведения зачарования (очерчено чёткими линиями, верёвками и т.п.)",
                        "5. Слова зачарования (манифестация) — словесное объяснение эффекта",
                        "",
                        "Ритуальное действие — ряд действий, визуализирующих эффект. Считается одним из компонентов-ингредиентов (но чары не могут состоять только из ритуальных действий)."
                    ),
                    preparation = "Для проведения ритуала зачарования магу необходимо определённое количество компонентов: 1 уровень — минимум 2 ингредиента; 2 уровень — минимум 4 ингредиента; 3 уровень — минимум 6 ингредиентов. Предметов может быть больше — это влияет на точность зачарования.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_levels",
                name = "Уровни чар",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Основы",
                level = 1,
                description = "Зачарования делятся на три уровня. Чтобы обучиться зачарованиям, вам нужен тот, кто знает дисциплину хотя бы на одну ступень выше вас.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "I УРОВЕНЬ:",
                        "• Одноразовые зачарования — после использования зачарование исчезает.",
                        "• Либо эффект действует продолжительное время, но незначителен.",
                        "• Либо предмет — расходный материал (кристаллы, наполненные даром).",
                        "• Эффект носит простой магический характер.",
                        "",
                        "II УРОВЕНЬ:",
                        "• Перезаряжаемые зачарования — для перезарядки нужно снова напитать даром.",
                        "• Либо эффект имеет продолжительный характер и умеренную силу.",
                        "• Наложение маскирующих чар, создание магического оружия и т.д.",
                        "",
                        "III УРОВЕНЬ:",
                        "• Постоянный артефакт — не требует перезарядки.",
                        "• Либо артефакт может быть одноразовым, если это заложено в идею.",
                        "• Сложные магические зачарования, наложение чар большой силы.",
                        "",
                        "IV СТУПЕНЬ (Легендарные артефакты):",
                        "• Артефакты огромной мощи, созданные великими магами.",
                        "• Зачарования, наложенные большим количеством волшебников."
                    ),
                    preparation = "Обучение: наставник должен придумать и дать вам задание, провести занятие в свойственной ему манере.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_examples",
                name = "Таблица известных чар",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Основы",
                level = 1,
                description = "Примеры известных и широко применяемых чар. Это не полный перечень — он даёт понимание того, какие чары бывают. Создание авторских артефактов высоко ценится.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "ЧАРЫ ПОИСКА (требуют Следопытство):",
                        "• Артефакты поиска и связанные с местами вещи",
                        "",
                        "ЗАЩИТНЫЕ ЧАРЫ:",
                        "• Зачарованная соль отгоняет низших демонов и нифилим (одноразовый)",
                        "• Предмет, защищающий от контроля эмоций",
                        "• Артефакты защиты разума",
                        "",
                        "ЧАРЫ ТЕЛЕПОРТАЦИИ:",
                        "• Портальная сфера — телепортирует в указанную точку",
                        "• Для создания нужно указать место и использовать предметы оттуда",
                        "• Базовая грузоподъёмность 100 кг + по 100 кг за каждый доп. предмет",
                        "",
                        "ЧАРЫ СОХРАНЕНИЯ ВОСПОМИНАНИЙ:",
                        "• Кристалл памяти (для себя, для человека/феи/места)",
                        "• Ритуал чтения кристалла памяти",
                        "",
                        "ЧАРЫ ИЛЛЮЗИЙ:",
                        "• Иллюзия внешности (заколка, резинка)",
                        "• Иллюзия облика (с использованием частей тела)",
                        "• Иллюзия большого объекта / движущегося объекта",
                        "• Создание образа предмета",
                        "",
                        "ЧАРЫ ОРУЖИЯ:",
                        "• Зачарование оружия",
                        "",
                        "ЧАРЫ, РАССЕИВАЮЩИЕ МОРОК:",
                        "• Видящие линзы — видят скрытые предметы и иллюзии",
                        "• Артефакт, рассеивающий морок на предмете или личности",
                        "• Артефакт, рассеивающий магию на местности или большом предмете",
                        "",
                        "ЧАРЫ МАНИПУЛЯЦИИ С ЭНЕРГИЕЙ:",
                        "• Кристалл, заполненный даром"
                    ),
                    preparation = "Создавая артефакт не из списка, маг должен утвердить уровень артефакта с мастером игры.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_forbidden",
                name = "Что нельзя сделать",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Основы",
                level = 1,
                description = "Ограничения в зачаровании.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "1. Нельзя создать магический артефакт, повторяющий эффекты боевых заклинаний (например, посох, выпускающий огненный шар — это костемагия).",
                        "2. Нельзя создать артефакт, выбивающийся из логики игрового мира.",
                        "3. Нельзя создать артефакт, действие которого нельзя предотвратить.",
                        "4. Нельзя создать артефакт, дублирующий свойства известных рун (не считая посохи)."
                    ),
                    preparation = "",
                    duration = "—",
                    comments = "Маскировочные чары не дают невидимость. Если чары изменяют пропорции тела — только зрительно.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== ОСОБЫЕ АРТЕФАКТЫ ==========
            SpellEntry(
                id = "enchantment_staffs",
                name = "Посохи",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Особые артефакты",
                level = 1,
                description = "Посох — магический артефакт, зачарованный на некое действие. Посох может носить и боевые заклинания, но только в виде сгустка наносящей урон энергии. Урон равен 1 единице жизни. Не-маг пользоваться посохом не может, если тот не имеет зарядов.",
                recipe = Recipe(
                    dosage = "Посох",
                    ingredients = listOf("Компоненты зачарования по уровню"),
                    preparation = "Стандартный ритуал зачарования.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_darostrels",
                name = "Дарострелы",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Особые артефакты",
                level = 1,
                description = "Пистолеты и ружья от мира магов. Некоторые дарострелы являются посохами особенной формы, но имеют такой же эффект.",
                recipe = Recipe(
                    dosage = "Дарострел",
                    ingredients = listOf("Компоненты зачарования по уровню"),
                    preparation = "Стандартный ритуал зачарования.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_legendary",
                name = "Легендарные артефакты",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Особые артефакты",
                level = 1,
                description = "Артефакты огромной мощи, созданные великими магами. Сюда же относят зачарования, наложенные большим количеством волшебников.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf("Компоненты зачарования"),
                    preparation = "Стандартный ритуал зачарования, но требуется участие великих магов или большое количество волшебников.",
                    duration = "—",
                    comments = "Четвёртая ступень зачарования.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== ВАЖНЫЕ ДАТЫ ==========
            SpellEntry(
                id = "enchantment_yule",
                name = "Йоль",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "20-23 день Рингейра. Создание артефактов для борьбы с тёмными силами. Холод, голод, истинный свет и огонь.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_imbole",
                name = "Имболк",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "Переход с ночи 25 дня Нинула на 1 день Эркоира. Лучшее время для защитной и сберегательной магии.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_ostara",
                name = "Остара",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "19-22 день Гваэрона. Время магии исцеления и жизни в целом.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_beltaine",
                name = "Белтейн",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "Ночь с 25 дня Гвирита на 1 день Нотиля. Магия любви, привороты, любовные узы и амулеты обручального толка. Очень могущественная магия. В Белтейн очень тонка грань между мирами.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_litha",
                name = "Лита",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "19-23 день Нарыи. Чары, связанные с электричеством, грозами, дождями, погодными условиями, огнём.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_lughnasadh",
                name = "Лугнасад",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "Первый день Метелаира. Поисковые, вегвизирские, указующие, путевые зачарования и символы. В этот день можно зачаровать артефакты звёздным светом.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_mabon",
                name = "Мабон",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "21-24 день Эркуэля. Чары, связанные с богатством, плодородием и плодовитостью.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "enchantment_samhain",
                name = "Самайн",
                category = MagicCategory.UNIVERSAL,
                school = "Зачарование",
                subgroup = "Важные даты",
                level = 1,
                description = "Ночь первого дня Эррива. Чары, связанные с мёртвыми, духами, душой мира и Альхерой.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = emptyList(),
                    preparation = "В этот день можно создавать значительные артефакты.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            )
        )
    )

    val healingSchool = MagicSchool(
        id = "healing",
        name = "Целительство",
        category = MagicCategory.UNIVERSAL,
        description = "Целительство — искусство исцеления ран и болезней. Каждое заклинание изучается отдельно, но все они требуют физического контакта с раненым.",
        spells = listOf(
            // ========== УРОВЕНЬ I ==========
            SpellEntry(
                id = "healing_cuts",
                name = "Колюще-режущие травмы",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень I",
                level = 1,
                description = "Исцеляет колюще-режущие травмы. Уровень 1.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение колюще-режущих травм"),
                    preparation = "Необходимо навести левую руку на рану, а правой совершить три круговых движения по часовой стрелке над тыльной стороной левой ладони.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),
            SpellEntry(
                id = "healing_bruises",
                name = "Ушибы",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень I",
                level = 1,
                description = "Исцеляет ушибы. Уровень 1.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение ушибов"),
                    preparation = "Вытянутые в стороны руки, не сгибая, сводим по горизонтали, ладони открыты и направлены в сторону объекта, затем разводим их по вертикали и сводим обратно, а после прикладываем скрещенные ладони к ушибу.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),
            SpellEntry(
                id = "healing_burns",
                name = "Ожоги",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень I",
                level = 1,
                description = "Исцеляет ожоги. Уровень 1.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение ожогов"),
                    preparation = "Руки вытянуты вперед, ладони раскрыты в сторону объекта, описываем двумя ладонями перевернутую восьмерку (знак бесконечности), левая ладонь начинает движение по диагонали вверх, правая ладонь соответственно по диагонали вниз. После того как ладони вновь встретились прикладываем их к ожогу.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),

            // ========== УРОВЕНЬ II ==========
            SpellEntry(
                id = "healing_mental",
                name = "Ментальные",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень II",
                level = 2,
                description = "Исцеляет ментальные повреждения. Уровень 2.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение ментальных травм"),
                    preparation = "Проводим обеими руками по бокам головы, движения начинаем от затылка, проводя по контуру головы к подбородку, затем доводим руки до солнечного сплетения, постепенно собирая ладонь в кулаки и резко выбрасываем их в стороны.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),
            SpellEntry(
                id = "healing_fractures",
                name = "Переломы и трещины",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень II",
                level = 2,
                description = "Исцеляет переломы и трещины. Уровень 2.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение переломов и трещин"),
                    preparation = "Вытянутые в стороны руки сводим по горизонтали, сгибая их в локтях. После напрягаем пальцы, сгибаем их и совершаем три движения «подгонка сустава» — (одну кисть поворачиваем на себя, другую от себя). После прикладываем раскрытые ладони к перелому.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),

            SpellEntry(
                id = "healing_poisons",
                name = "Яды",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень II",
                level = 3,
                description = "Исцеляет отравления. Уровень 3.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение отравлений"),
                    preparation = "Руками с вибрирующими кистями очень медленно по очереди ведем от пупка ко рту и резко выбрасываем их в стороны.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),

            // ========== УРОВЕНЬ III ==========
            SpellEntry(
                id = "healing_critical",
                name = "Критическая",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень III",
                level = 3,
                description = "Исцеляет критические ранения. Уровень 3.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение критических ран"),
                    preparation = "Обеими руками три раза медленно проводим от пят к макушке и в конце сводим руки на сердце.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),
            SpellEntry(
                id = "healing_fear",
                name = "Страх",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень III",
                level = 3,
                description = "Исцеляет от страха. Уровень 3.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Лечение страха"),
                    preparation = "Руками по очереди совершаются резкие движения, во время которых кисти разжимаются раскрывая ладони, после раскрытая ладонь медленно отводится, вначале одной рукой к голове, затем другой к сердцу.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),
            SpellEntry(
                id = "healing_regrowth",
                name = "Приращивание",
                category = MagicCategory.UNIVERSAL,
                school = "Целительство",
                subgroup = "Уровень III",
                level = 3,
                description = "Приращивает оторванные конечности или восстанавливает ткани. Уровень 3.",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf("Приращивание конечностей"),
                    preparation = "Обе руки в начальной позиции: кисть одной руки обхватывает запястье другой, затем не разрывая соединительную точку у основания ладоней, руки сводятся по кругу к верхней точке так, что должна получиться так называемая галочка, где раскрытые ладони направлены друг к другу. Затем ладони ведутся дальше по кругу к позиции обратной стартовой: одна рука вновь обхватывает запястье другой. Только если в стартовой позиции к вам ближе была правая рука, в конечной к вам ближе будет левая. Затем круговыми движениями не разрывая соединительную точку, обе руки прикладываются к разрыву, одна ладонь должна прийти в положение поверх другой.",
                    duration = "1 час",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            )
        )
    )

    val trackingSchool = MagicSchool(
        id = "tracking",
        name = "Следопытство",
        category = MagicCategory.UNIVERSAL,
        description = "Следопытство — магическое искусство, призванное находить и распознавать следы магического присутствия. Следопыт способен находить признаки использования магии или присутствия существа, наделённого магией. Искусный следопыт может определить, что за магия была использована, а также сокрыть следы своего присутствия.",
        spells = listOf(
            // ========== УРОВЕНЬ I ==========
            SpellEntry(
                id = "tracking_1",
                name = "Следопыт-аксолотль (Уровень 1)",
                category = MagicCategory.UNIVERSAL,
                school = "Следопытство",
                subgroup = "Уровень I",
                level = 1,
                description = "Обнаруживает объект в радиусе 1 км. Позволяет создавать чары «Магический компас» и обнаруживать магический след.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Создание чар «Магический компас»",
                        "Обнаружение магического следа"
                    ),
                    preparation = "Механика: все существа, связанные с магией, оставляют магический след. Чтобы читать следы (маркеры), необходимо обладать соответствующим уровнем следопытства. Если у вас его нет — вы не видите маркеров.",
                    duration = "—",
                    comments = "Радиус обнаружения объекта: 1 км. Маркер — бумажка с символами, описывающими характеристики: принадлежность к магии (маг/не-маг), раса, ветвь и прочее.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== УРОВЕНЬ II ==========
            SpellEntry(
                id = "tracking_2",
                name = "Следопыт-каракал (Уровень 2)",
                category = MagicCategory.UNIVERSAL,
                school = "Следопытство",
                subgroup = "Уровень II",
                level = 2,
                description = "Обнаруживает объект в радиусе 10 км. Позволяет стирать магический след.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Стирание магического следа"
                    ),
                    preparation = "Стирание магических следов выполняется убиранием маркеров с места и произвольным отыгрышем (заметите след ногой или натащите веток, если вы в лесу — проявите фантазию).",
                    duration = "—",
                    comments = "Радиус обнаружения объекта: 10 км.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== УРОВЕНЬ III ==========
            SpellEntry(
                id = "tracking_3",
                name = "Следопыт-неясыть (Уровень 3)",
                category = MagicCategory.UNIVERSAL,
                school = "Следопытство",
                subgroup = "Уровень III",
                level = 3,
                description = "Обнаруживает объект в пределах 1 мира. Позволяет создавать ложный магический след.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Создание ложного магического следа"
                    ),
                    preparation = "",
                    duration = "—",
                    comments = "Радиус обнаружения объекта: 1 мир.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== ОБЩАЯ МЕХАНИКА ==========
            SpellEntry(
                id = "tracking_markers",
                name = "Магические следы (маркеры)",
                category = MagicCategory.UNIVERSAL,
                school = "Следопытство",
                subgroup = "Механика",
                level = 1,
                description = "Все существа, связанные с магией, так или иначе оставляют магический след. Также ЛЮБОЕ существо оставляет следы физические. Производя какую-либо деятельность, вы оставляете следы.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Следы (маркеры) оставляют, если:",
                        "1. Вы выпустили в этом месте не менее 3 заклинаний (включая щиты).",
                        "2. Если вы произвели магический ритуал, либо наложили проклятье, либо начертили руны.",
                        "3. Если вы создали некое магическое действие, которое потребовало много энергии.",
                        "4. Если вы применили магию крови.",
                        "5. Если вы прорицали.",
                        "6. Если использовали магию, основанную на страхе (заклинания адептов Нифилим).",
                        "7. Если разбили портальную сферу."
                    ),
                    preparation = "Маркер представляет собой бумажку, на которой написаны ваши характеристики: принадлежность к магии (маг/не-маг), раса, ветвь и прочее. Написаны они с помощью символов. Также следы могут указывать направление движения с помощью отдельного символа.",
                    duration = "—",
                    comments = "Условность: если ваше действие не требует сокрытия (о нём могут знать все и это не является тайной, заговором, преступлением), то его маркировать не надо. Но если действие подразумевает, что оно для кого-то негативно, либо скрыто, либо является тайной — маркировать след нужно. Допускается маркировка следа после события.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            )
        )
    )

    val cikiroSchool = MagicSchool(
        id = "cikiro",
        name = "Ци-киро",
        category = MagicCategory.UNIVERSAL,
        description = "Ци-киро — боевое искусство, техника рукопашного боя, с помощью которой можно блокировать потоки ци в организме соперника и парализовать его или лишить магических способностей. Ци — течение Дара через организм. Киро — битва.",
        spells = listOf(
            // ========== УРОВНИ ВЛАДЕНИЯ ==========
            SpellEntry(
                id = "cikiro_level_1",
                name = "I уровень Ци-киро",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Уровни владения",
                level = 1,
                description = "Развитие ловкости, изучение потоков Дар по организму и точек его концентрации, боевые упражнения по воздействию на точки (тайцзицюань и кюшо-джитсу).",
                recipe = Recipe(
                    dosage = "Белая лента",
                    ingredients = listOf(
                        "Паралич части тела (1 час)",
                        "Снятие паттерна (понять, что делает человек и к какой чакре относится паттерн)"
                    ),
                    preparation = "Уровень владения отмечается белой лентой на левом запястье либо лбу.",
                    duration = "1 час",
                    comments = "Развитие ловкости, изучение потоков Дар по организму и точек его концентрации.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "cikiro_level_2",
                name = "II уровень Ци-киро",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Уровни владения",
                level = 2,
                description = "Изучение философии, упражнения цигун, медитации, упражнения в техниках нэйцзин.",
                recipe = Recipe(
                    dosage = "Красная лента",
                    ingredients = listOf(
                        "Кратковременное лишение противника магии по уровням и типам (1 час)"
                    ),
                    preparation = "Уровень владения отмечается красной лентой на левом запястье либо лбу.",
                    duration = "1 час",
                    comments = "Изучение философии, упражнения цигун, медитации, упражнения в техниках нэйцзин.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "cikiro_level_3",
                name = "III уровень Ци-киро",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Уровни владения",
                level = 3,
                description = "Раскрытие чакры (чакр).",
                recipe = Recipe(
                    dosage = "Чёрная лента",
                    ingredients = listOf(
                        "Лишение противника всей магии (до момента обратного приёма)"
                    ),
                    preparation = "Уровень владения отмечается чёрной лентой на левом запястье либо лбу.",
                    duration = "До обратного приёма",
                    comments = "Раскрытие чакры (чакр).",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "cikiro_mastery",
                name = "Мастерство Ци-киро",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Уровни владения",
                level = 4,
                description = "Укрепление силы духа.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf("Укрепление силы духа"),
                    preparation = "",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== ГРУППЫ ДВИЖЕНИЙ ==========
            SpellEntry(
                id = "cikiro_branch_magic",
                name = "Ветвийная магия",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Группы движений",
                level = 1,
                description = "При блокировании уровня магии движение и точка касания всегда одно, однако само касание должно быть произведено одним, двумя или тремя пальцами, в соответствии с уровнем. Пример: чтобы блокировать второй уровень магии Жизни, необходимо коснуться мага в основание шеи двумя пальцами, предварительно совершив нужные движения.",
                recipe = Recipe(
                    dosage = "Одна ладонь",
                    ingredients = listOf(
                        "Чакры Ветвийной магии:",
                        "Земля (Жизнь)",
                        "Огонь (Пламя)",
                        "Свет (Равновесие)",
                        "Мысль (Слово)",
                        "Магия"
                    ),
                    preparation = "Одной ладонью совершить круговое движение вокруг другой ладони. Второй ладонью произвести касание.",
                    duration = "—",
                    comments = "При блокировании уровня магии движение и точка касания всегда одно, однако само касание должно быть произведено одним, двумя или тремя пальцами в соответствии с уровнем.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "cikiro_universal_magic",
                name = "Всеобщая магия",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Группы движений",
                level = 1,
                description = "Атакующей ладонью сделать спираль в воздухе.",
                recipe = Recipe(
                    dosage = "Ладонь",
                    ingredients = listOf(
                        "Чакры всеобщей магии:",
                        "Воздух",
                        "Творчество",
                        "Разум",
                        "Любовь"
                    ),
                    preparation = "Атакующей ладонью сделать спираль в воздухе.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "cikiro_fear",
                name = "Страх",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Группы движений",
                level = 1,
                description = "Скрестить руки перед собой с растопыренными пальцами, резким движением развести руки в стороны.",
                recipe = Recipe(
                    dosage = "Обе руки",
                    ingredients = listOf(
                        "Чакра Страха"
                    ),
                    preparation = "Скрестить руки перед собой с растопыренными пальцами, резким движением развести руки в стороны.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "cikiro_physical",
                name = "Физическое воздействие на тело",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Группы движений",
                level = 1,
                description = "Атакующей ладонью сделать восьмёрку параллельно плоскости земли. Для паралича нужно полной ладонью охватить часть тела, которую желает поразить ци-боец.",
                recipe = Recipe(
                    dosage = "Ладонь",
                    ingredients = listOf(
                        "Чакры физического тела:",
                        "Вода",
                        "Звук",
                        "Сознание"
                    ),
                    preparation = "Атакующей ладонью сделать восьмёрку параллельно плоскости земли. Для паралича нужно полной ладонью охватить часть тела, которую желает поразить ци-боец.",
                    duration = "—",
                    comments = "Для паралича нужно полной ладонью охватить часть тела.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== ЧАКРЫ НА ТЕЛЕ ==========
            SpellEntry(
                id = "cikiro_chakras",
                name = "Чакры на теле",
                category = MagicCategory.UNIVERSAL,
                school = "Ци-киро",
                subgroup = "Чакры",
                level = 1,
                description = "Чакры — центры силы и сознания, расположенные внутри человеческого тела и связывающие его метафизическую и биофизическую энергии. Каждая из них имеет тесную связь с какой-либо эмоцией и может быть открыта или закрыта.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Земли (Жизнь) — 7 шейный позвонок — выживание — блокирует Боль",
                        "Огня (Пламя) — Живот — сила воли — блокируется чувство стыда",
                        "Света (Равновесие) — Правое плечо (Спереди — Свет, Сзади — Тень), Воля — Левое плечо — Равновесие — блокирует неуверенность",
                        "Мысли (Слово) — Макушка — Дружба — блокирует Жадность",
                        "Магия — Лоб — Связь с миром — блокирует Страх",
                        "Воздуха (Целительство) — Левая ключица — любовь — блокирует скорбь",
                        "Творчество (Чары) — Правое предплечье — Страсть — блокирует Ревность",
                        "Разум (Руны) — Левое предплечье — Ясность ума — блокирует Агрессию",
                        "Любовь (Магия любви) — Поясница — Чувства — блокирует Ненависть",
                        "Непознанное (Страх) — Спина — Страх — блокирует Смех",
                        "Звука (голос) — Правая ключица — правда — блокирует ложь",
                        "Воды (−1 жизнь) — Бедро — радость — блокирует чувство вины",
                        "Сознание (оглушение) — Правое колено — Умение учиться — блокирует Каприз"
                    ),
                    preparation = "",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            )
        )
    )

    val bonemagicSchool = MagicSchool(
        id = "bonemagic",
        name = "Костемагия",
        category = MagicCategory.UNIVERSAL,
        description = "Костемагия — древнее магическое искусство, появившееся до возникновения рун и чар. Кость — мощный концентратор магии, хранящий волновую структуру энергии Дара вплоть до своего полного уничтожения. Даже после сжигания имеет магическую ценность из-за высвободившейся энергии. Кости помнят.",
        spells = listOf(
            // ========== УРОВЕНЬ I ==========
            SpellEntry(
                id = "bonemagic_runology_boost",
                name = "Усиление Рунологии",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "В случае с рунами, резьба по кости усиливает эффект стафа или знака на один уровень. Мастерство рунологии при использовании кости как носителя символа, стафа, знака или сочетания удваивается. Рунический алфавит, вырезанный на кости, пригоден для достоверного предсказания линий вероятности.",
                recipe = Recipe(
                    dosage = "Кость",
                    ingredients = listOf(
                        "Резьба по кости",
                        "Рунический стаф, знак или сочетание"
                    ),
                    preparation = "Резьба должна быть выполнена на предметах, которые являются с точки зрения игры костями. Иметь похожую фактуру и цвет.",
                    duration = "—",
                    comments = "Усиливает эффект стафа или знака на один уровень.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_enchantment_boost",
                name = "Усиление Чар",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "В чарах кость используется как магический предмет-проводник. Кость может быть связана с конкретным типом магии, если она принадлежала личности или магическому существу, обладавшему этой магией. Кость символизирует всю личность или магическое существо, если необходимо наложить зачарование на эту личность. Кости — атрибуты прозрения.",
                recipe = Recipe(
                    dosage = "Кость",
                    ingredients = listOf(
                        "Кость личности или магического существа",
                        "Компоненты зачарования"
                    ),
                    preparation = "Использование кости фаланги пальца позволяет наложить чары на всю личность. Кости используют для чар прозрения будущего и при создании вероятноскопов.",
                    duration = "—",
                    comments = "Внимание: кости тесно связаны с воплощением личности и часто становятся объектом проклятий. Кости преступников, убийц, черномантов могут стать основой для проклятий. Знаменитое «Проклятье Сауфра» было сделано с использованием костей некромантов.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_prahomol",
                name = "Прахомол",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "Прахомолы создают костяную крошку, которая используется в алхимии, зачарованиях и создании артефактов. Костяное крошево используется в металлургии, чтобы придать железу различные эффекты.",
                recipe = Recipe(
                    dosage = "Костяная крошка",
                    ingredients = listOf(
                        "Кость"
                    ),
                    preparation = "Крошка из большого пальца личности позволяет создавать оружие, которое ранит духов. Прах из кости пламенника заставит лезвие гореть в руках костемага. Костяная крошка магических существ может быть мутагеном при обработке костемагом.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_dreamcatcher",
                name = "Ловец снов",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "Защитный амулет, оберегает сон личности от вмешательства. Имеется в виду любое вмешательство — нифилим, ментальное, магия Равновесия. Ловец снов позволяет магу пробудиться, если ему угрожает опасность. Каждый ловец снов индивидуален и работает только на личность, которой принадлежит.",
                recipe = Recipe(
                    dosage = "Амулет",
                    ingredients = listOf(
                        "Перья",
                        "Кость",
                        "Крафтовые материалы"
                    ),
                    preparation = "Найти кость, обвести её на бумаге, разрисовать узором, сжечь в безопасном месте (на улице), подержать Ловец снов над дымом. Сжигать кость не нужно, если она не ваша личная.",
                    duration = "—",
                    comments = "Отыгрыш: если игрок проникает в комнату со спящим, у которого есть ловец снов, он обязан разбудить последнего. Разбудить нужно не резко и без касаний, например голосом.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_nightmare_catcher",
                name = "Ловец кошмаров",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "Пеньковая или джутовая верёвка, на которой на равных расстояниях друг от друга размещены перья и бусины из дерева, кости или металла. Нифилим, тень или адепт, связанный такой верёвкой, не могут использовать магию страха.",
                recipe = Recipe(
                    dosage = "Верёвка",
                    ingredients = listOf(
                        "Пеньковая или джутовая верёвка",
                        "Перья",
                        "Бусины из дерева, кости или металла"
                    ),
                    preparation = "Допускается создание контура вокруг объекта вместо связывания. При этом перья в таком контуре должны быть направлены внутрь.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_guiding_feather",
                name = "Путеводное пёрышко",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "Костемаг-следопыт окрашивает перо узорами. Такое перо всегда указывает на ближайшую дорогу или населённый пункт.",
                recipe = Recipe(
                    dosage = "Перо",
                    ingredients = listOf(
                        "Перо",
                        "Узоры (окрашивание)"
                    ),
                    preparation = "Костемаг-следопыт окрашивает перо узорами.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_fluff",
                name = "Пух",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "Костемаг окрашивает перо узорами и закрепляет на одежде. При падении с высоты не более 20 метров, маг не получит переломов костей. При падении с высоты не более 10 метров, маг не получит урона от падения.",
                recipe = Recipe(
                    dosage = "Перо на одежде",
                    ingredients = listOf(
                        "Перо",
                        "Узоры (окрашивание)"
                    ),
                    preparation = "Костемаг окрашивает перо узорами и закрепляет на одежде.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_nihchi_arrows",
                name = "Стрелы-нихчи",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень I",
                level = 1,
                description = "Костемаг-анимист делает из костей наконечники для стрел. Он покрывает их резьбой или раскрашивает и делает сквозное отверстие в наконечнике. Разговаривая с духами, объясняет, для чего создаётся стрела. Через отверстие пролетают духи, наполняющие стрелу силой.",
                recipe = Recipe(
                    dosage = "Наконечники для стрел",
                    ingredients = listOf(
                        "Кость",
                        "Резьба или раскрашивание",
                        "Сквозное отверстие"
                    ),
                    preparation = "При создании костемаг-анимист разговаривает с духами, объясняя им, для чего создаётся такая стрела, или поёт песню/мелодию.",
                    duration = "—",
                    comments = "+1 урон от стрелы с костяным наконечником. Считается магической атакой (разбивает 1 блок, требуется ставить блок заново), может ранить бестелесных существ, в том числе нифилим.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== УРОВЕНЬ II ==========
            SpellEntry(
                id = "bonemagic_reminiscence",
                name = "Реминисценция (Отзвук)",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Уникальный способ резьбы по кости и Вспоминательных чар. На костях вырезают схематические изображения событий. Остемаг способен считывать такие схематические изображения и видеть неискажённую картину произошедшего.",
                recipe = Recipe(
                    dosage = "Кость",
                    ingredients = listOf(
                        "Кость",
                        "Резьба схематических изображений событий",
                        "Имена действующих лиц (для Отзвука)"
                    ),
                    preparation = "При реминисценции на «полотне» нередко подписывают имена действующих лиц. Тогда костемаг-словесник может воззвать к голосу говорившего. Маги пламени и равновесия создавали Отзвук в виде сквозного кружева, чтобы через изображения мог проникать свет. Пропуская своё магическое свечение через такое кружево, они способны показать запечатлённые события любой личности, даже не владеющей костемагией.",
                    duration = "—",
                    comments = "Отзвук нельзя изменить или исказить — техника использует исключительную способность костей помнить. Реминисценция — наука для тех, кто освоил 2 уровень костемагии.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_bone_warrior",
                name = "Костевои",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Костемаг использует когти, рога и зубы животных в качестве оружия, которое наносит урон бестелесным существам, в том числе и нифилим. Оружие костевоя покрывается узором (руны, орнамент, краска).",
                recipe = Recipe(
                    dosage = "Оружие",
                    ingredients = listOf(
                        "Когти, рога или зубы животных",
                        "Узор (руны, орнамент, краска)",
                        "Рукоять (опционально)"
                    ),
                    preparation = "Для оружия может создаваться рукоять, но структура когтя/рога/зуба остаётся неизменной.",
                    duration = "—",
                    comments = "Наносит урон бестелесным существам, в том числе нифилим.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_osteomancy",
                name = "Прочник",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Базовое умение остеманта — сращивание повреждённых костей в своём теле или теле другого человека. Восстановление переломов и дробящего урона (на 2 уровне) и 1 единицы здоровья. С помощью остемантии можно восстановить только 1 единицу здоровья за бой или за час (реального времени).",
                recipe = Recipe(
                    dosage = "Касание",
                    ingredients = listOf(
                        "Перелом или повреждённая кость"
                    ),
                    preparation = "Каст заклинания: остемант держит руки над переломом, совершает над этим местом движение руками «восьмёркой», затем движет ладони вдоль сломанной кости в разные стороны, затем вновь сводит их вместе и повторяет «восьмёрку». Движение повторяется 4-6 раз. Направление «восьмёрки» не имеет значения.",
                    duration = "—",
                    comments = "На третьем уровне костемагии остемант может вырастить отсутствующую кость. Движения повторяются 30 раз.",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),
            SpellEntry(
                id = "bonemagic_ku",
                name = "Ку",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Головной убор из перьев. Защищает носителя от ментальных воздействий всеобщей магией и страхом. Не защищает от ментальных приказов Ветви Слова.",
                recipe = Recipe(
                    dosage = "Головной убор",
                    ingredients = listOf(
                        "Перья"
                    ),
                    preparation = "Костемаг создаёт головной убор из перьев.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_latsini",
                name = "Латсини",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Браслеты, созданные костемагом, защищают от проклятий. Важный нюанс — латсини из перьев боевого петуха, напротив, притягивает проклятия. Все творимые проклятия в радиусе нескольких километров автоматически падут на латсини и его обладателя.",
                recipe = Recipe(
                    dosage = "Браслеты",
                    ingredients = listOf(
                        "Перья (обычные или боевого петуха)"
                    ),
                    preparation = "Костемаг создаёт браслеты из перьев.",
                    duration = "—",
                    comments = "Важно: латсини не работает, если не находится на руке или ноге.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_vzmoguch",
                name = "Взмогуч",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Артефакт-амулет, который личность носит на себе и который усиливает конкретные способности или заклинания. Взмогучи делаются из костей различных магических существ и животных. Обычно взмогуч делают в виде подвески или серьги. У мага может быть лишь один взмогуч.",
                recipe = Recipe(
                    dosage = "Амулет",
                    ingredients = listOf(
                        "Кость магического существа или животного",
                        "Подвеска или серьга"
                    ),
                    preparation = "Эффекты костей различных животных и магических существ: Виверны и дракониды — +1 единица урона каждому заклинанию, наносящему 3 и более урона. Химериты — заклинания могут проникать на все планы существования. Насекомые — +1 урон по нифилим и адептам. Демонические твари — +1 урон магам Пламени. Черви — +1 урон геомантам. Песиглавцы — +1 урон перевёртышам. Земноводные — +1 жизнь. Рептилии — +5 метров радиус заклинаний Ветви Слова. Летуны — +1 урон аэротургам. Котоглавцы — +1 урон анимистам. Водные — +1 урон заклинаниям гидрософистов и магов крови и заклинаниям молнии.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_thumb",
                name = "Большой палец",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Некоторые костемаги завещают свой большой палец руки потомкам для того, чтобы сделать из него тотем. Большой палец руки — идеальное вместилище для духа предка. Используя такой тотем, шаман наделяет дух максимальной силой. Тень, вселённая в большой палец, может вспомнить, кто она и кем являлась в прошлом.",
                recipe = Recipe(
                    dosage = "Тотем",
                    ingredients = listOf(
                        "Кость большого пальца руки"
                    ),
                    preparation = "Для тотема духа и вселения тени в идеале использовать кости большого пальца руки владельца, однако при правильном использовании подойдёт любой большой палец.",
                    duration = "—",
                    comments = "Известны случаи, когда через большой палец удавалось не только вернуть тени память, но и позволить ей слиться с Душой мира.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_aked_a_ta",
                name = "Акед а-та",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень II",
                level = 2,
                description = "Костемаг укрепляет здоровье другой личности или магического существа. Используется 7 или 8 зуб любого ряда.",
                recipe = Recipe(
                    dosage = "Ритуал",
                    ingredients = listOf(
                        "7 или 8 зуб любого ряда",
                        "Перья",
                        "Погребальный костёр",
                        "Зелье Костерост"
                    ),
                    preparation = "Костемаг проводит ритуал похорон, где зуб — олицетворение личности или магического существа. Для этого костемаг создаёт погребальный костёр в виде небольшого помоста, который выстилает перьями, на которые кладёт зуб. После сжигания пепел добавляется в зелье Костерост, и личность или магическое существо выпивает его. На месте потерянного зуба вырастает новый, как символ возрождения.",
                    duration = "—",
                    comments = "Примечание: в качестве зуба можно использовать таблетку кальция, которую подрезали по форме зуба. Ритуал удаления зуба должен быть отыгран. В качестве альтернативы сжиганию можно закапывать зуб на подстилке из перьев в землю, а через три полнолуния использовать землю из могилы вместо пепла.",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),

            // ========== УРОВЕНЬ III ==========
            SpellEntry(
                id = "bonemagic_skullmancy",
                name = "Черепомантия",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Череп личности или существа покрывается узором (руны, орнамент, символы, окрашивание) при постоянном направлении Дара в череп. После завершения ритуала костемаг получает доступ к знаниям того, кому принадлежит череп. Череп можно заставить говорить и отвечать на вопросы. Череп обладает способностью левитировать и нередко становится фамильяром для черепоманта.",
                recipe = Recipe(
                    dosage = "Череп",
                    ingredients = listOf(
                        "Череп личности или существа",
                        "Узор (руны, орнамент, символы, окрашивание)",
                        "Постоянное направление Дара"
                    ),
                    preparation = "Для заставить череп говорить: анимист использует череп как тотем для духа, словесник вырезает приказ говорить на челюсти или зубах, равновесник вселяет в череп тень, пламенники-йоганы направляют элементаля огня из физической формы в духовную. Память костей черепа создаёт ему новую личность на основе использованной магии.",
                    duration = "—",
                    comments = "Официально черепомантия не является некромантией, поскольку не взывает к праху павших насильственным образом, а создаёт новую личность. Если игрок хочет создать череполёт на выездной игре, допускаются варианты: рисунок на картоне или холсте, череп из папье-маше, череп из ЭВА. Допускается использование настоящих черепов.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_exomancy",
                name = "Экзомагия",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Изучая остемагию, начиная со второго уровня, костемаг сможет увеличивать количество костей в своём теле, выращивая внешние костные наросты. Размер и количество таких наростов ограничено, поскольку требует больших усилий от организма. Эти новые образования используются для усиления магических практик.",
                recipe = Recipe(
                    dosage = "Костные наросты",
                    ingredients = listOf(
                        "Костные наросты",
                        "Узор"
                    ),
                    preparation = "Венец — вокруг головы мага вырастают небольшие широкие рога 8-10 штук. Увеличивает проводимость Дара через тело мага, что даёт существенный прирост к жизнеспособности организма. +1 единица максимального здоровья игрока. Хелицеры — на плечах мага вырастают костные дуги. Их можно использовать в качестве посохов и жезлов. Работает по принципу длины посоха. Может иметь форму серпа, косы, клешни или шипа. Пата (Пата Уэйна) — три костяных шипа на предплечье мага. Чрезвычайно прочные. Используется как оружие, скалолазный крюк, атакующий жезл. Пропуская Дар через пату, маг может метнуть на расстоянии до 15 метров магическую стрелу. 1 единица урона в дальнем и ближнем бою.",
                    duration = "—",
                    comments = "Экзомагия для перевёртышей может носить уникальный характер, в зависимости от типа перевёртыша. Мастера костемаги могут использовать в экзомагии чужие кости, приращивая их к своему телу.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_sympathetic_feathers",
                name = "Симпатические перья",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Костемаг связывает два пера между собой с помощью костемагии. Прикреплённые к предметам, эти перья распространяют связь и на предметы. Таким образом можно связать магическим образом два предмета, которые не были зачарованы на симпатическую связь изначально.",
                recipe = Recipe(
                    dosage = "Два пера",
                    ingredients = listOf(
                        "Два пера",
                        "Связь через костемагию"
                    ),
                    preparation = "Костемаг связывает два пера между собой с помощью костемагии.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_black_swan",
                name = "Чёрный лебедь",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Костемаг создаёт ожерелье из чёрных перьев. Тот, кто носит подобное ожерелье, не может использовать Дар. Зачастую Чёрный лебедь сопровождается непреложным обетом или руническим знаком-липучкой, чтобы ожерелье нельзя было снять.",
                recipe = Recipe(
                    dosage = "Ожерелье",
                    ingredients = listOf(
                        "Чёрные перья",
                        "Непреложный обет или рунический знак-липучка"
                    ),
                    preparation = "Костемаг создаёт ожерелье из чёрных перьев.",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_skull_merge",
                name = "Слияние с черепом",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Костемаг-словесник вместо создания череполёта соединяет знания обладателя черепа со своими, либо производит слияние для другой личности.",
                recipe = Recipe(
                    dosage = "Ритуал",
                    ingredients = listOf(
                        "Подготовленный череп",
                        "Ночь",
                        "8 часов сна"
                    ),
                    preparation = "В ходе ритуала необходимо провести ночь с подготовленным черепом, приложенным его родничковой зоной к родничковой зоне мага-приёмника. Руки костемага должны находиться на висках черепа. Если процесс передаётся от черепа к третьему лицу, костемаг-словесник выступает проводником, держа руки на родничковых зонах личности и черепа. Приёмник должен уснуть. После 8 часов сна он проснётся, имея знания черепа.",
                    duration = "8 часов",
                    comments = "Процедура опасна для мага-приёмника, поскольку в процессе может случиться расслоение или даже замещение личности.",
                    canBeAdded = false,
                    recipeType = RecipeType.RITUAL
                )
            ),
            SpellEntry(
                id = "bonemagic_incarnation",
                name = "Инкарнация",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Восстановление души или духа в костях личности.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Кости личности"
                    ),
                    preparation = "",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_bone_curse",
                name = "Проклятье Кость от кости",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Запрещённая магическая практика костемагии.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Кости"
                    ),
                    preparation = "",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "bonemagic_bone_theft",
                name = "Костекрада",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Уровень III",
                level = 3,
                description = "Обмен костями с другой личностью для объединения магических способностей.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Кости"
                    ),
                    preparation = "",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== ОБЩИЕ ПОНЯТИЯ ==========
            SpellEntry(
                id = "bonemagic_general_concepts",
                name = "Основные понятия костемагии",
                category = MagicCategory.UNIVERSAL,
                school = "Костемагия",
                subgroup = "Общее",
                level = 1,
                description = "Кости помнят. Древнее магическое искусство, появившееся до возникновения рун и чар. На данный момент костемагия трансформировалась, став не отдельным магическим направлением, а основой для современной науки.",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "Оссуарий (костница) — кабинет костемагии",
                        "Кости помнят",
                        "Целых рук, целых ног — ассоциация с магией, дорогами, делами",
                        "Безкостный — плохой человек",
                        "Пенгта-кушта няврем — беззубый ребёнок",
                        "",
                        "Основные понятия:",
                        "• Все кости одного организма связаны друг с другом Даром. Даже если они разделены. Даже если кость потеряла свою целостность.",
                        "• Кости хранят в себе магию, если их обладатель имел такие способности.",
                        "• Костяные иглы, шипы, зубы, при определённых обстоятельствах способны проникать из одного плана существования в другой.",
                        "",
                        "Предмет костемагии:",
                        "• Позвоночник — может заменить любую кость в ритуале, кроме зубов, черепов и больших пальцев рук.",
                        "• Кисти и предплечья — артефакты, связанные с конкретными заклинаниями.",
                        "• Ноги — следопытство.",
                        "• Зубы — здоровье, связь с родственниками и предками.",
                        "• Когти, шипы и иглы — оружие.",
                        "• Черепа — знания владельцев данной кости.",
                        "• Перья — защита.",
                        "• Кораллы и раковины моллюсков — различные магические обряды. Раковины способны сохранять звуки внутри себя."
                    ),
                    preparation = "",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            )
        )
    )

    val militarySchool = MagicSchool(
        id = "military",
        name = "Военное дело",
        category = MagicCategory.UNIVERSAL,
        description = "Военное дело — направление магии, созданное мастерами школы боевых искусств Батараскуру для усиления магов в ближнем бою. После было адаптировано для всех магов и не-магов. Если вы не обучены военному делу, то любое оружие ближнего боя наносит 1 урон без модификаторов.",
        spells = listOf(
            // ========== УРОВЕНЬ I ==========
            SpellEntry(
                id = "military_level_1",
                name = "I уровень военного дела",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Уровни",
                level = 1,
                description = "Начальный уровень владения оружием. Открывает способности кинжалов и мечей. Даёт умение «Калечащий удар» и пассивку «Плечом к плечу».",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "«Калечащий удар» — если следующая атака мага попадёт в цель (не будет заблокирована щитом), цель становится обездвиженной на 1 минуту (сохраняя способность ставить блоки и колдовать). В случае, если атака будет заблокирована, действие «калечащего удара» заканчивается. Также действие заканчивается, если маг произносит любое другое заклинание раньше, чем атакует оружием цель.",
                        "",
                        "Пассивное умение «Плечом к плечу» — если рядом с магом (в радиусе 2.5 метров) находятся те, кого маг может назвать союзниками в бою, то маг получает 1 дополнительное здоровье за каждого до конца боя, но не более 3 дополнительных единиц здоровья. Эффект работает только в бою.",
                        "",
                        "Открываются способности оружия: кинжалы, мечи."
                    ),
                    preparation = "Дистанция «Калечащего удара»: удара. Блок: 1. Тип урона: зависит от оружия.",
                    duration = "—",
                    comments = "Дистанция пассивки «Плечом к плечу»: в радиусе 2.5 метров.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== УРОВЕНЬ II ==========
            SpellEntry(
                id = "military_level_2",
                name = "II уровень военного дела",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Уровни",
                level = 2,
                description = "Открывает способности топоров и дробящего оружия. Даёт умение «Вихрь».",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "«Вихрь» — круговая атака оружием. Наносит 1 единицу урона. На «вихрь» распространяются все усиления атак ближнего боя.",
                        "",
                        "Открываются способности оружия: топоры, дробящее."
                    ),
                    preparation = "Дистанция «Вихря»: в радиусе 2.5 метров. Блок: 3. Тип урона: колюще-режущий / ушиб (в зависимости от типа оружия).",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== УРОВЕНЬ III ==========
            SpellEntry(
                id = "military_level_3",
                name = "III уровень военного дела",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Уровни",
                level = 3,
                description = "Открывает способности двуручного оружия. Даёт умения «Блиц-атака» и «Преодоление». Пассивно: +1 макс здоровье (если ещё нет здоровья за физическую подготовку).",
                recipe = Recipe(
                    dosage = "—",
                    ingredients = listOf(
                        "«Блиц-атака» — при совершении удара маг может произнести «блиц-атака», тогда эту атаку цель сможет заблокировать только блоком 2-го уровня.",
                        "",
                        "«Преодоление» — в течение 1 минуты маг не может попасть в какой-либо контроль и получает 3 дополнительных единицы здоровья. По окончании эффекта дополнительное здоровье исчезает. «Преодоление» можно использовать не более 2-х раз за бой, при этом нельзя использовать это же заклинание, пока не закончился эффект предыдущего «преодоления».",
                        "",
                        "Открываются способности оружия: двуручное.",
                        "",
                        "Пассивно: +1 макс здоровье (если ещё нет здоровья за физическую подготовку)."
                    ),
                    preparation = "Дистанция «Блиц-атаки»: удара. Блок: 2. Тип урона: колюще-режущий / ушиб (в зависимости от типа оружия).",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),

            // ========== ОРУЖИЕ ==========
            SpellEntry(
                id = "military_daggers",
                name = "Кинжалы",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Оружие",
                level = 1,
                description = "Кинжалом считается оружие, клинок которого до 30 см. При владении I уровнем военного дела кинжал наносит +1 урон. Удар в спину +1 урон.",
                recipe = Recipe(
                    dosage = "Кинжал",
                    ingredients = listOf("Владение кинжалами (I уровень военного дела)"),
                    preparation = "Кинжалом считается оружие, клинок которого до 30 см.",
                    duration = "—",
                    comments = "Тип урона: колюще-режущий.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "military_swords",
                name = "Мечи",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Оружие",
                level = 1,
                description = "Мечом считается оружие, клинок которого более 50 см. При владении I уровнем военного дела меч наносит +1 урон. Если воитель сражается 1 на 1, то удары мечом наносят +1 урон.",
                recipe = Recipe(
                    dosage = "Меч",
                    ingredients = listOf("Владение мечами (I уровень военного дела)"),
                    preparation = "Мечом считается оружие, клинок которого более 50 см.",
                    duration = "—",
                    comments = "Тип урона: колюще-режущий.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "military_axes",
                name = "Топоры",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Оружие",
                level = 2,
                description = "Если цель находится в обездвиженном или оглушённом состоянии, воитель топором может отрубить конечность со словесной маркировкой «отрубание», при этом нанеся урон как от обычного удара.",
                recipe = Recipe(
                    dosage = "Топор",
                    ingredients = listOf("Владение топорами (II уровень военного дела)"),
                    preparation = "",
                    duration = "—",
                    comments = "Тип урона: режущий.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "military_blunt",
                name = "Молоты и булавы",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Оружие",
                level = 2,
                description = "Удары в механизмы (в том числе автоматоны), стены, магические барьеры (не блоки!) наносят +1 урон.",
                recipe = Recipe(
                    dosage = "Молот / булава",
                    ingredients = listOf("Владение дробящим оружием (II уровень военного дела)"),
                    preparation = "",
                    duration = "—",
                    comments = "Тип урона: дробящий.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "military_twohanded",
                name = "Двуручное оружие",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Оружие",
                level = 3,
                description = "+1 урон (да, двуручное оружие при владении им наносит 3 урона за атаку). Важно: двуручным оружием нельзя бить, держа одной рукой, иначе удар не засчитывается. Огромная сила игнорирует данное правило.",
                recipe = Recipe(
                    dosage = "Двуручное оружие",
                    ingredients = listOf("Владение двуручным оружием (III уровень военного дела)"),
                    preparation = "Двуручное оружие должно иметь удобный для двух рук хват.",
                    duration = "—",
                    comments = "Тип урона: зависит от типа оружия.",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            ),
            SpellEntry(
                id = "military_shields",
                name = "Щиты",
                category = MagicCategory.UNIVERSAL,
                school = "Военное дело",
                subgroup = "Оружие",
                level = 1,
                description = "+1 максимальное здоровье при ношении щита.",
                recipe = Recipe(
                    dosage = "Щит",
                    ingredients = listOf("Ношение щита"),
                    preparation = "",
                    duration = "—",
                    comments = "",
                    canBeAdded = false,
                    recipeType = RecipeType.GENERAL
                )
            )
        )
    )

    val fearlessnessSchool = MagicSchool(
        id = "fearlessness",
        name = "Бесстрашие",
        category = MagicCategory.UNIVERSAL,
        description = "Бесстрашие — искусство противостояния страху.",
        spells = listOf(
            SpellEntry(
                id = "fearlessness_1",
                name = "Бесстрашие",
                category = MagicCategory.UNIVERSAL,
                school = "Бесстрашие",
                level = 1,
                description = "Маг создаёт кратковременный луч, который наносит порождениям нифилим и адептам 1 единицу урона. Луч имеет белый цвет с оттенком, зависящим от направления магии создателя заклинания"),

            SpellEntry(
                id = "fearlessness_2",
                name = "Щит бесстрашия",
                category = MagicCategory.UNIVERSAL,
                school = "Бесстрашие",
                level = 2,
                description = "Создаёт барьер перед  магом, сквозь который сдерживает физическое давление страхов. Страхи и адепты не могут преодолеть этот барьер физически. Однако, единичный щит не останавливает атаки магией страха. С Щитом бесстрашия можно перемещаться. Щит бесстрашия можно объединять с другими магами. При этом, эффект будет усиливаться. Каждый новый маг в щите будет добавлять эффект. Двое магов - защита от 1 уровня заклинаний Страха. Трое магов - защита от 2 уровня заклинаний Страха. Четверо магов - защита от 3 уровня заклинаний Страха. Пятеро и более - защита от всех заклинаний Страха. Движения каста Щита бесстрашия должны быть синхронными."
            ),

            SpellEntry(
                id = "fearlessness_3",
                name = "Взгляд бесстрашия",
                category = MagicCategory.UNIVERSAL,
                school = "Бесстрашие",
                level = 3,
                description = "Маг, обладающий данным заклинанием видит страхи и нифилим, которые используют свою магию из других планов существования - мира теней или пространства нифилим.Страх или нифилим, на которого применено данное заклинание становится осязаемым и видимым в мире настоящем. На него можно воздействовать обычной Ветвийной магией. Каст: После Оси и концентрации Дара, маг выбрасывает одну руку вперёд, делает хватаельное движение, затем повторяет это второй рукой и тянет на  себя, вытаскивая страх в мир настоящий."
            ),
            SpellEntry(
                id = "fearlessness_4",
                name = "Бесстрашие Эйгара",
                category = MagicCategory.UNIVERSAL,
                school = "Бесстрашие",
                level = 4,
                description = "Маг впитывает в себя страх, развоплощая его. Это смертельное заклинание для страхов, но не для адептов и нифилим. При атаке на адепта или нифилим, Бесстрашие Эйгара наносит им 3 единицы урона. Бесстрашие Эйгара наносит магу 4 единицы урона. Это заклинание не наносит урон сотворившим его адептам. Дистанция: 5 метров Блок: 2. Каст: После Оси и концентрации Дара, маг выбрасывает вперёд обе руки, сжимает кисти в кулаки, а затем резко дёргает руки к себе, ударяя ими в грудь."
            ),
            SpellEntry(
                id = "fearlessness_5",
                name = "Страхогон",
                category = MagicCategory.UNIVERSAL,
                school = "Бесстрашие",
                level = 5,
                description = "Массовое заклинание. Маг обращает страх против него самого. Все страхи в радиусе 2,5 метров перестают атаковать и убегают в течении 10 секунд. Дистанция: в радиусе 2.5 метров Блок: 3. Каст: После Оси и концентрации Дара, маг совершает вращение вокруг своей оси на 360 градусов с раскинутыми руками и ладонями выставленными от себя."
            ),
            SpellEntry(
                id = "fearlessness_6",
                name = "Бесстрашие Финдли",
                category = MagicCategory.UNIVERSAL,
                school = "Бесстрашие",
                level = 6,
                description = "Вызывает на себя внимание страха, адепта или нифилим. Маг провоцирует атаку врага на себя. Провокация действует до момента, пока маг не получит урон от противника, либо пока противник не погибнет. Дистанция: 5 метров Блок: 2. Каст: После Оси и концентрации Дара, маг скрещивает вытянутые руки перед собой и раскидывает их в стороны к низу. В процессе игрок дополнительно маркирует противника."
            ),
            SpellEntry(
                id = "fearlessness_7",
                name = "Длань бесстрашия",
                category = MagicCategory.UNIVERSAL,
                school = "Бесстрашие",
                level = 7,
                description = "Маг направляет заклинание на союзника, разрушая любое ментальное воздействие или воздействие контроля, наложенное с использованием магии страха. Длань бесстрашия наносит магу, сотворившему заклинание 1 единицу урона. Дистанция: касание. Блок: 1. Каст: После Оси и концентрации Дара, маг выбрасывает одну руку с ладонью, раскрытой в сторону цели и касается ею цели."
            )
        )
    )

    val lovePathSchool = MagicSchool(
        id = "love_path",
        name = "Тропа любви",
        category = MagicCategory.UNIVERSAL,
        description = "Тропа любви — уникальное искусство, основанное на эмоциональной связи между людьми. Включает пять языков любви: Вербалы, Эмпаты, Спасатели, Дарители, Кинестеты.",
        spells = listOf(
            // ========== ВЕРБАЛЫ ==========
            SpellEntry(
                id = "love_verbals_1",
                name = "Я люблю тебя",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Вербалы",
                description = "Личность испытывает прилив сил. Два следующих заклинания имеют удвоенный эффект — если эффект урон, то он удваивается, если контроль, то увеличивается время его действия в два раза, если воздействие, то на две цели. Не работает на массовые заклинания. Для того, чтобы творить это заклинание, требуется, чтобы объект искренне признался в любви Влюблённому. Это должно происходить в спокойной обстановке и без понуканий Влюблённого."
            ),
            SpellEntry(
                id = "love_verbals_2",
                name = "Я с тобой",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Вербалы",
                description = "Пока Влюблённый находится в радиусе 5 метров от возлюбленного, у последнего есть три дополнительные единицы жизни. Для поддержания заклинания, вся магия, исходящая от Влюблённого должна быть направлена только на возлюбленного. Эффект пропадает как только Влюблённый использует любой эффект на другую цель или теряет 3 единицы жизней, тогда вновь эффект начнет работать уже вне текущего боя."
            ),
            SpellEntry(
                id = "love_verbals_3",
                name = "Ты потрясающая/потрясающий",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Вербалы",
                description = "Объект заклинания становится привлекательным для собеседника (игрок под заклинанием обязан сообщить это собеседнику, собеседник не может это игнорировать и уходить от беседы намеренно). Эффект действует в течении одного разговора. Разговор считается оконченным, либо когда личности разошлись, либо по истечении пяти минут. Возлюбленный, на которого применена эта магия перестаёт быть объектом агрессии всех целей, пока он не двигается и не использует магию в течение 1 минуты. Для сотворения заклинания Влюблённый должен сделать три комплимента достоинствам возлюбленного до применения магии."
            ),
            SpellEntry(
                id = "love_verbals_4",
                name = "У тебя всё получится",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Вербалы",
                description = "Любая следующая проверка возлюбленного будет успешной. Два раза за бой. Для сотворения, влюблённый должен объяснить, почему у возлюбленного всё получится. Пример: ты умный и стойкий, у тебя всё получится!"
            ),
            SpellEntry(
                id = "love_verbals_5",
                name = "Я слушаю",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Вербалы",
                description = "Возлюбленный может в деталях рассказать о том, как он получил рану, кто её нанёс и что он испытывал в этот момент. Влюблённый молча слушает личность. После того, как рассказ окончен, у возлюбленного восстанавливается 1 единица здоровья. Таким образом можно восстановить только одну единицу жизней в час. Таймер обновляется с началом нового часа. Для использования умения, влюблённый должен обладать 1 уровнем целительства."
            ),

            // ========== ЭМПАТЫ ==========
            SpellEntry(
                id = "love_empaths_1",
                name = "Я тебя вижу",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Эмпаты",
                description = "Влюблённый эмпат может видеть глазами возлюбленного и наоборот. Для того, чтобы заклинание работало, необходимо, чтобы один из партнёров находился в спокойном состоянии (не бежал, не сражался, имел ровный сердечный ритм и не отвлекался на разговоры с кем-либо ещё). Для того, чтобы ритуал работал, требуется согласие возлюбленного."
            ),
            SpellEntry(
                id = "love_empaths_2",
                name = "Совместный опыт",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Эмпаты",
                description = "Влюблённый передаёт свои навыки всеобщей магии возлюбленному. Для этого необходимо, чтобы возлюбленный обладал начальным уровнем этих навыков."
            ),
            SpellEntry(
                id = "love_empaths_3",
                name = "Твои мысли",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Эмпаты",
                description = "Эмпат может проникнуть в разум возлюбленного и защитить его от ментального воздействия, либо спасти от ментального воздействия, если в голове возлюбленного есть чужой разум. Партнёры могут проникнуть в мысли друг друга и знать их. Для применения необходимо согласие партнёра."
            ),
            SpellEntry(
                id = "love_empaths_4",
                name = "Разная любовь",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Эмпаты",
                description = "Если у эмпата уже есть не менее двух других жестов эмпатии, он может распространять свою любовь на двух любых существ, вне зависимости, друг это, любовный интерес, зверь, автоматон. Иными словами, у эмпата может не быть возлюбленного, но может быть два лучших друга. Или лучший друг и любимый питомец."
            ),
            SpellEntry(
                id = "love_empaths_5",
                name = "Большое сердце",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Эмпаты",
                description = "Эмпат может добавлять по одному живому существу в свою зону любви за каждый освоенный полностью язык любви. Иными словами, если изучить все языки, то у влюблённого может быть 2 базовых и 5 дополнительных объектов любви. Этот жест комбинируется с жестом Разная любовь."
            ),

            // ========== СПАСАТЕЛИ ==========
            SpellEntry(
                id = "love_rescuers_1",
                name = "Усиленное исцеление",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Спасатели",
                description = "Влюблённый эффективнее применяет навыки целительства на возлюбленного. Все исцеляющие эффекты восстанавливают +1 дополнительную единицу жизней."
            ),
            SpellEntry(
                id = "love_rescuers_2",
                name = "Вместе",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Спасатели",
                description = "При обоюдном чувстве друг к другу, влюблённый и возлюбленный имеют 2 дополнительные единицы жизней, пока находятся на расстоянии не более 5 метров друг от друга. Преграды и отсутствие видимости не разрушают эту связь. Для сотворения связи, необходимо устное или письменное обоюдное признание в любви (дружеская тоже подходит) и выполнить вместе совместное дело — игра, приключение, прогулка, работа. Связь пропадает в случае, если один из партнёров перестаёт испытывать любовь либо умирает."
            ),
            SpellEntry(
                id = "love_rescuers_3",
                name = "Не бойся",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Спасатели",
                description = "Если кто-то из партнёров получил эффект страха, либо контроля разума, то оба они могут снять этот эффект. Для этого необходимо провести рядом со спящим партнёром ночь (в игровом эквиваленте 30 минут). Всё это время тот, кто подвергся воздействию, должен спать (если события происходят днём, то понадобится снотворное, либо помощь умбраманта). Второй партнёр, должен находится рядом и рассказывать ему на выбор: сказки со счастливым концом/истории, где всё закончилось хорошо, либо случились позитивные изменения/рассказать историю, где возлюбленный побеждает все страхи и невзгоды, освобождается от влияния и возвращается к нормальному состоянию."
            ),
            SpellEntry(
                id = "love_rescuers_4",
                name = "Я тебя чувствую",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Спасатели",
                description = "Спасатель перенимает половину всех эффектов, полученных возлюбленным. Это касается и положительных, и отрицательных моментов. Ритуал действует, пока влюблённый не потеряет все единицы здоровья. Ритуал действует на любом расстоянии. Для того, чтобы ритуал работал, требуется согласие возлюбленного. ВАЖНО: в случае с излечением, чтобы исцелить 1 единицу жизней, необходимо восстановить 2 единицы жизней."
            ),

            // ========== ДАРИТЕЛИ ==========
            SpellEntry(
                id = "love_givers_1",
                name = "Любит-не-любит",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Дарители",
                description = "Зачарованный цветок. Для зачарования требуется цветок, круг и любой предмет возлюбленного. Влюблённый должен находится внутри круга. Необходим 1 уровень чар. Влюблённый даритель произносит в кругу «Любит-не-любит», затем проговаривая эти же слова отрывает лепестки у цветка, пока не останется один. Этот цветок он может передать личности. Оторвав последний лепесток, для Влюблённого он окрасится в цвета: если личность питает к Влюблённому чувства, то в красный, а если нет, то в синий."
            ),
            SpellEntry(
                id = "love_givers_2",
                name = "Омела",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Дарители",
                description = "Амулет из омелы. Амулет из омелы влюбленный может передать только возлюбленному или лучшему другу. Если к обладателю омеллы проявляют агрессию, он может использовать её чтобы предотвратить конфликт или сгладить углы. После использования омелла увядает и амулет необходимо сделать заново. Единовременно на руках можно иметь одну омелу."
            ),
            SpellEntry(
                id = "love_givers_3",
                name = "Парные амулеты",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup= "Дарители",
                description = "Выполняются в любой форме, но обязательно должны составлять единую композицию вместе. Передаёт объекту любви все навыки всеобщей магии, которыми обладает Влюблённый. Это распространяется только на Всеобщую магию. Парный амулет работает только на одно конкретное искусство. Жест работает, пока Влюблённый и объект любви носят эти амулеты на видном месте."
            ),
            SpellEntry(
                id = "love_givers_4",
                name = "Эммусуби",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Дарители",
                description = "Амулет представляет из себя небольшой тканевый кармашек, размером не более 6х6 см, внутри которого вложен пергамент с посланием. Влюблённый даритель пишет это послание от руки чернилами на пергаменте. В послание он может заложить один любой эффект доступного ему заклинания, чары, ритуала, жеста. Это заклинание не может иметь негативный эффект. Обладатель Эммусуби может достать послание из кармашка, порвать его, вложить обратно и выполнить эффект заклинания."
            ),
            SpellEntry(
                id = "love_givers_5",
                name = "Еда",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Дарители",
                description = "Приготовленная для объекта любви пища будет восстанавливать ему жизни. Для этого необходимо иметь 1 уровень целительства. Механика: каждый 1 укус, прожёванный и проглоченный считается 1 единицей жизней. 1 укус ~ 1 печенька орео. В случае с жидкостями считается 1 глоток."
            ),
            SpellEntry(
                id = "love_givers_6",
                name = "Зелье сопричастия",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Дарители",
                description = "Зелье, которое позволяет использовать на выпившего одно любое воздействие магии любви, даже если он не является возлюбленным. Зелье должно быть выпито влюблённым также, если предполагается обоюдный эффект. В составе зелья должна быть частичка влюблённого, а в случае парного эффекта, во флаконе для Влюблённого должна быть частичка объекта."
            ),
            SpellEntry(
                id = "love_givers_7",
                name = "Узы любви",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Дарители",
                description = "Набор украшений — браслеты на руки и ноги, украшение на шею. Можно надеть только на личность, искренне влюблённую в мага любви. Все исчислимые эффекты заклинаний увеличиваются на 1. Пример: Огненный шар наносит 3 единицы урона. Обладатель Уз любви не может каким-либо образом навредить Дарителю, всегда находится на его стороне. Снять Узы любви можно только при смерти одной личности в паре."
            ),

            // ========== КИНЕСТЕТЫ ==========
            SpellEntry(
                id = "love_kinesthetes_1",
                name = "Объятия",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Кинестеты",
                description = "Защищают от воздействия страхом — физического или ментального. Объятия могут быть сонаправленными (друг к другу лицом), либо однонаправленные (лицом в одну сторону). При этом Влюблённый и объект любви не могут двигаться и молчат. Если жест исполняет Спасатель, то кроме защиты от страха, защищает и от обычной магии. Заклинание создает своеобразный щит, прочность которого — текущее количество жизней Влюблённого умноженное на 3."
            ),
            SpellEntry(
                id = "love_kinesthetes_2",
                name = "Поцелуи",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Кинестеты",
                description = "Снимает станы, требующие физического воздействия, снимает сон и летаргический сон. Снимает морок (можно делать не на возлюбленного). Поцелуй при амулете из Омелы считается признанием в любви. Поцелуй при амулете из Омелы примиряет врагов."
            ),
            SpellEntry(
                id = "love_kinesthetes_3",
                name = "Секс",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Кинестеты",
                description = "Полностью исцеляет все единицы здоровья обоим партнёрам. Снимает эффект слабости, залечивает не сквозные раны, менее 3 сантиметров. Во время секса партнёры неуязвимы для ментальных воздействий любой магией. После жеста, у Влюблённого и объекта любви появляется три дополнительные единицы жизни. Они существуют до момента, пока их не снимут. Жест работает только при обоюдном согласии и только когда оба партнёра не находятся в состоянии бездействия, либо в критическом состоянии."
            ),

            // ========== ОБЩИЕ ДЛЯ ТРОПЫ ==========
            SpellEntry(
                id = "love_common_feromones",
                name = "Феромоны",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Влюблённость",
                description = "Общая способность всех влюблённых. Тот, кто стал Влюблённым способен управлять своими феромонами. Активируя их, маг любви становится физически привлекателен для окружающих. Это не пробуждает любовь, только влечение. Игрок, который попал под действие феромонов, обязан отыгрывать влечение к магу любви в течение 1 минуты. Радиус действия 5 метров. Если цель воздействия обладает ментальной защитой, то воздействие не сработает."
            ),
            SpellEntry(
                id = "love_common_polyamory",
                name = "Полиамория",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Тропа Любви",
                description = "Доступна при изучении Языка кинестетики, эмпатии и спасателя. Полиаморные любящие способны распространять все свои способности тропы любви на тех, с кем у них был продолжительный телесный или эмоциональный контакт. Контакт это: секс, танец, разговор по душам, слияние разумов. Чтобы стать полиамором, необходимо совершить не менее трёх признаний в любви, не теряя чувств к другим объектам любви и изучить описанные выше языки любви."
            ),
            SpellEntry(
                id = "love_common_unrequited",
                name = "Безответная любовь",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Тропа Любви",
                description = "Если Влюблённому на признание в любви дадут отказ, он вступает на тропу Безответной любви. При этом он теряет возможность использовать свои способности на друга и сосредотачивается на возлюбленном. Он может изучать языки любви, однако все свойства их работают в одностороннем порядке, но с усилением +1 (где это возможно). За каждый жест в отношении объекта любви, получает 1 единицу урона. Сойти с тропы Безответной любви можно, если Влюблённый полюбит кого-то другого, либо, если Влюблённому кто-то признается в любви."
            ),
            SpellEntry(
                id = "love_common_universal",
                name = "Всеобъемлющая любовь",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Тропа Любви",
                description = "Изучив все ритуалы и нюансы трёх Языков, Влюблённый становится Любящим. Такие личности способны проявлять любовь к любой личности, вне зависимости от знакомства. Для этого необходимо пройти через Принятие — таинство, в котором Любящий проходит испытание своих чувств. В ходе таинства Любящий должен проявить любовь к личностям, которая вызывает у него презрение, ярость и страх."
            ),
            SpellEntry(
                id = "love_common_death",
                name = "Побеждая Смерть",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Жертва любви",
                description = "Чару можно создать для трёх самых дорогих личностей один единственный раз. В случае, если личность должна умереть не естественной смертью, то этого не происходит. Цель исцеляется до полного уровня жизней, с неё спадают все негативные эффекты. Требуется уровень зачарования — Мастер."
            ),
            SpellEntry(
                id = "love_common_exchange",
                name = "Обмен",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Жертва любви",
                description = "В момент гибели объекта любви, маг Любви отдаёт свою жизнь, взамен. Тот, на кого был использован Обмен, восстанавливает полностью свои жизни, с него спадают все негативные эффекты. Отказаться от Обмена нельзя. На того, кто использовал Обмен, нельзя использовать Обмен."
            ),
            SpellEntry(
                id = "love_common_healing",
                name = "Исцеляющая любовь",
                category = MagicCategory.UNIVERSAL,
                school = "Тропа любви",
                subgroup = "Тропа Любви",
                description = "Через воздействие излечивает от Страха. Чтобы обучиться этому умению, необходимо вместе с магом любви, обладающим этим навыком, провести этот ритуал. Это ритуал, в ходе которого, Любящий погружается в разум объекта через Альхеру, словесника или онейроманта. Там он встречается со страхом и должен сразится с ним."
            )
        )
    )

    // ========== ЗАПРЕЩЁННАЯ МАГИЯ ==========

    val voodooSchool = MagicSchool(
        id = "voodoo",
        name = "Вуду",
        category = MagicCategory.FORBIDDEN,
        description = "Вуду — запретное искусство, связанное с духами Лоа. Каждый Лоа даёт свою силу, но требует плату. Маг вуду служит одному Лоа и после инициации получает доступ ко всем его ритуалам.",
        spells = listOf(
            // ========== ОБЩИЕ РИТУАЛЫ ==========
            SpellEntry(
                id = "voodoo_common_invocation",
                name = "Призыв Лоа",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Общие",
                description = "Для призыва Лоа необходимо начертить его веве на месте призыва или иметь при себе предмет с его изображением. Также нужны минимум 3 предмета-символа, связанных с Лоа. Закрыв глаза, обратитесь к Лоа с объяснением намерений трижды."
            ),
            SpellEntry(
                id = "voodoo_common_grisgris",
                name = "Гри-гри",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Общие",
                description = "Амулеты в виде тканевого или кожаного мешочка, в который вудуист кладёт фрагменты, необходимые для ритуала. Обычно носят на шее."
            ),
            SpellEntry(
                id = "voodoo_common_nightmare_totem",
                name = "Кошмарный тотем",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Общие",
                description = "Тотем для накопления магии страха. Может впитать от 5 единиц энергии страха. Основой могут стать: твёрдый страх, останки зверя или личности, кости, останки нифилим."
            ),

            // ========== ЛЕГБА ==========
            SpellEntry(
                id = "voodoo_legba_initiation",
                name = "Инициация Легбы",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Обряд инициации начинается с призыва Легбы. Он погрузит мага в Альхеру, где нужно найти 5 вех пути — знаков веве Легбы. Каждый переход между вехами усложнён условиями (закрытые глаза, на одной ноге, задом наперёд и т.д.). Во время пути нужно собрать фрагменты для своего гри-гри."
            ),
            SpellEntry(
                id = "voodoo_legba_serving",
                name = "Служение в жизни и в послесмертии",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Пассивно: маг вуду Легбы после смерти не сольется с душой мира, он станет духом-воплощением во служении Папе Легбе."
            ),
            SpellEntry(
                id = "voodoo_legba_immaterial",
                name = "Нематериальное материально",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Пассивно: маг вуду Легбы способен касаться духов."
            ),
            SpellEntry(
                id = "voodoo_legba_altar",
                name = "Алтарь Легбе",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Алтарь позволяет пассивно видеть и слышать Альхеру из мира настоящего, а также используется для перехода в мир духов. Это физический проход: арка, дверной проем, окно и т.д. Необходимо начертить веве Легбы."
            ),
            SpellEntry(
                id = "voodoo_legba_spirit_call",
                name = "Призыв духа",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Очертите контур, начертите веве Легбы, подготовьте 3 предмета, связанных с духом. Цена — знак идентичности. Дух сможет общаться не менее 1 минуты."
            ),
            SpellEntry(
                id = "voodoo_legba_spirit_capture",
                name = "Пленение духа",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Очертите контур, начертите веве Легбы, подготовьте 3 предмета-символа пленения. Цена — кровь не менее 100 мл. В области дух не сможет двигаться."
            ),
            SpellEntry(
                id = "voodoo_legba_spirit_control",
                name = "Контроль духа",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Коснитесь духа предметом с веве Легбы, отдайте 3 единицы страха из Кошмарного тотема. Произнесите 'контроль духа' — сможете приказать духу любые действия."
            ),
            SpellEntry(
                id = "voodoo_legba_grisgris",
                name = "Гри-гри Легбы",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Защищает от любого вида одержимости. В мешочек положить: символические вещи Легбы, аратензию, частицу вудуиста. Цена — одна одержимость Легбой."
            ),
            SpellEntry(
                id = "voodoo_legba_alkhera",
                name = "Переход в Альхеру",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Легба",
                description = "Через Алтарь Легбы. Цена: 5 знаков идентичности (на 1 игровой день) или 1 тотем с духом (на 5 дней)."
            ),

            // ========== САМЕДИ ==========
            SpellEntry(
                id = "voodoo_samedi_initiation",
                name = "Инициация Самеди",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Самеди",
                description = "Самеди даёт день и ночь. Нужно сделать всё, что может понравиться Самеди, затем привести себя в критическое ранение. Самеди решит, достоин ли ты."
            ),
            SpellEntry(
                id = "voodoo_samedi_dead_talk",
                name = "Общение с мертвыми",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Самеди",
                description = "Ритуал у трупа. Нужен веве Самеди. Цена: алкоголь (1 стакан = 1 вопрос, 1 бутылка = 5 вопросов), 100 мл крови = 20 вопросов, 5 ед. страха = неограниченно."
            ),
            SpellEntry(
                id = "voodoo_samedi_dead_control",
                name = "Контроль мертвеца",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Самеди",
                description = "Нужно хотя бы раз видеть момент смерти личности. Коснуться трупа предметом с веве Самеди, заплатить 100 мл крови или 3 ед. страха. Произнести 'контроль мертвеца'."
            ),
            SpellEntry(
                id = "voodoo_samedi_grisgris_remains",
                name = "Гри-гри неприкасаемых останков",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Самеди",
                description = "Защищает останки носителя от использования. 3 символа Самеди, частица вудуиста, 3 символа защиты. Цена — одержимость Самеди."
            ),
            SpellEntry(
                id = "voodoo_samedi_grisgris_hel",
                name = "Гри-гри защиты от Хели",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Самеди",
                description = "Защищает тёмного мага от попадания в Хельхейм. 3 символа Самеди, частица вудуиста, руна чернь. Цена — посмертное служение Самеди."
            ),
            SpellEntry(
                id = "voodoo_samedi_phylactery",
                name = "Поисковые чары для нахождения филактерии",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Самеди",
                description = "Предмет ориентирования, веве Самеди, частицы некроманта. Цена — смерть, посвящённая Самеди."
            ),
            SpellEntry(
                id = "voodoo_samedi_altar",
                name = "Алтарь Самеди и Бриджит",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Самеди",
                description = "Позволяет избежать смерти. Могила личности, убитой вудуистом, с символами Самеди и Бриджит. При смерти вудуист попадает в гроб с полным здоровьем."
            ),

            // ========== БРИДЖИТ ==========
            SpellEntry(
                id = "voodoo_brigitte_initiation",
                name = "Инициация Бриджит",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Бриджит",
                description = "Бриджит испытывает тело: нельзя пользоваться одной конечностью, весь урон +1, нельзя исцеляться. Затем нужно рассказать о своей жизни."
            ),
            SpellEntry(
                id = "voodoo_brigitte_healing",
                name = "Целебная природа",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Бриджит",
                description = "1 цветок усилит 1 следующее исцеление на 1 ед. 1 фрукт усилит 3 следующих исцеления на 1 ед."
            ),
            SpellEntry(
                id = "voodoo_brigitte_grisgris",
                name = "Гри-гри Бриджит",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Бриджит",
                description = "Даёт +1 максимальное здоровье. 3 символа Бриджит, частица вудуиста, 3 символа здоровья. Цена: уязвимость к урону 5 дней + подарок кому-либо."
            ),
            SpellEntry(
                id = "voodoo_brigitte_altar",
                name = "Алтарь Самеди и Бриджит",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Бриджит",
                description = "Позволяет избежать смерти. Могила личности, убитой вудуистом, с символами Самеди и Бриджит."
            ),
            SpellEntry(
                id = "voodoo_brigitte_sculpting",
                name = "Лепка",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Бриджит",
                description = "Позволяет заложить в неродившееся существо качества. Каждое качество — отдельный сеанс с интервалом 5 дней. Цена — 100 мл крови за сеанс."
            ),
            SpellEntry(
                id = "voodoo_brigitte_rebirth",
                name = "Перерождение",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Бриджит",
                description = "Позволяет определить, в каком виде существа вудуист переродится. Требует многолетнего воспитания существа."
            ),

            // ========== ОГУН ==========
            SpellEntry(
                id = "voodoo_ogun_initiation",
                name = "Инициация Огуна",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Огун",
                description = "Создать оружие и сразиться с Огуном в дуэли на равных. Если Огун доволен боем и оружием — наречёт магом вуду."
            ),
            SpellEntry(
                id = "voodoo_ogun_trophies",
                name = "Боевые трофеи",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Огун",
                description = "Вудуист должен участвовать в открытом бою и собрать трофей. Трофеи используются в ритуалах Огуна. Все трофеи должны быть добыты после инициации."
            ),
            SpellEntry(
                id = "voodoo_ogun_altar",
                name = "Алтарь Огуна",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Огун",
                description = "Даёт физические силы: правило ведения в одиночку, поднятие тяжестей, оглушение руками, урон ударами рук. Изваяние обезьяны с молотом + веве Огуна."
            ),
            SpellEntry(
                id = "voodoo_ogun_grisgris",
                name = "Гри-гри Огуна",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Огун",
                description = "Позволяет сражаться 1 минуту после потери всех единиц боевого духа. Символы Огуна, частица вудуиста, кровь из боя (100 мл)."
            ),
            SpellEntry(
                id = "voodoo_ogun_important_trophy",
                name = "Важный трофей",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Огун",
                description = "Боевой трофей даёт +1 максимальное здоровье. Противник должен быть побеждён самим вуду в открытом бою. Начертить веве Огуна."
            ),
            SpellEntry(
                id = "voodoo_ogun_weapon",
                name = "Любимое оружие",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Огун",
                description = "Зачаровать оружие. Эффекты: урон бестелесным, урон нежити, +1 урон нифилим, +1 урон, нельзя отнять. Вудуист может создать только 2 таких оружия за всю жизнь."
            ),
            SpellEntry(
                id = "voodoo_ogun_defeat",
                name = "Твое поражение – моя сила",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Огун",
                description = "Когда вудуист доводит противника до критического ранения, он восстанавливает здоровье до максимума. Веве Огуна на тело. Цена: кровь вудуиста и трёх убитых врагов."
            ),

            // ========== ДАМБАЛА ==========
            SpellEntry(
                id = "voodoo_damballa_initiation",
                name = "Инициация Дамбалы",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Рассказать о главном страхе. Составить предсказание (Когда? Где? Кто? Что сделал?) и сделать так, чтобы оно исполнилось."
            ),
            SpellEntry(
                id = "voodoo_damballa_reptiles",
                name = "Общение с рептилиями",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Пассивно: вудуист Дамбалы способен понимать мотивы рептилий и общаться с ними."
            ),
            SpellEntry(
                id = "voodoo_damballa_prediction",
                name = "Предсказание",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Гладь воды. Начальный запрос — 1 серебряная монета. Каждое уточнение — 1 серебряная монета."
            ),
            SpellEntry(
                id = "voodoo_damballa_past",
                name = "Взгляд в прошлое",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Гладь воды. В жертву — воспоминание. Дамбала определяет, достаточно ли ценное воспоминание."
            ),
            SpellEntry(
                id = "voodoo_damballa_dark_speech",
                name = "Понимание темного наречия",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Начертить веве Дамбалы на теле. Пока веве на маге — работает."
            ),
            SpellEntry(
                id = "voodoo_damballa_adaptation",
                name = "Адаптация",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Съесть плоть существа — получить сопротивление урону от этого типа существ (-1 урон, но не менее 1). Цена: 1 ед. страха."
            ),
            SpellEntry(
                id = "voodoo_damballa_grisgris",
                name = "Гри-гри Дамбалы",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Усиливает урон от магии страхов на 1 ед. Символы Дамбалы, частица вудуиста, руна Кси. Цена: 13 ед. страха."
            ),
            SpellEntry(
                id = "voodoo_damballa_wormholes",
                name = "Открытие червоточин",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Пожертвовать 99 ед. страха, разрезать пространство режущим оружием с веве Дамбалы. Оружие разрушится."
            ),
            SpellEntry(
                id = "voodoo_damballa_time",
                name = "Перемещение во времени",
                category = MagicCategory.FORBIDDEN,
                school = "Вуду",
                subgroup = "Дамбала",
                description = "Легенды гласят, что лучшим последователям Дамбала помогает перемещаться во времени на своей спине."
            )
        )
    )

    val bloodMagicSchool = MagicSchool(
        id = "blood_magic",
        name = "Магия крови",
        category = MagicCategory.FORBIDDEN,
        description = "Магия крови — запретное искусство, использующее жизненную силу для усиления заклинаний. Включает несколько ветвей: Кровь Слова, Кровь Пламени, Кровь Жизни, Кровь Равновесия.",
        spells = listOf(
            // ========== ОБЩЕЕ ==========
            SpellEntry(
                id = "blood_common_1",
                name = "Заклинания на уровень выше",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Общее",
                description = "Магия крови позволяет колдовать заклинания на уровень выше. Маг может использовать как свою кровь как катализатор, так и чужую заготовленную (подходит только кровь мага — личности, обладающей геном магии, не менее 100 мл). При этом маг не может таким образом получить начальный первый уровень, он должен знать и уметь основы искусства."
            ),
            SpellEntry(
                id = "blood_common_2",
                name = "Всеобщая магия на уровень выше",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Общее",
                description = "Магия крови позволяет пользоваться навыками всеобщей магии на уровень выше по тем же правилам."
            ),
            SpellEntry(
                id = "blood_common_3",
                name = "Смена ветви",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Общее",
                description = "Смена ветви возможна при использовании магии крови. Ветвь мага определяется геном магии и с помощью ритуала сангремантии возможно повлиять на него, чтобы изменить ветвь мага. Последствия процесса смены ветви усугубляются количеством лет мага и степенью его углубленности в навыки ветви."
            ),
            SpellEntry(
                id = "blood_common_4",
                name = "Призыв демонов",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Общее",
                description = "Благодаря магии крови возможен призыв демонов. Кровь в данном случае выступает элементом жертвы для призыва и содержит энергию для ритуала призыва. Помимо крови для призыва демона необходимо знать его имя, иногда необходимы определенные элементы для ритуала — символы или предметы. Призыв демона сравним с темной версией ритуалов зачарования."
            ),

            // ========== КРОВЬ СЛОВА ==========
            SpellEntry(
                id = "blood_words_1",
                name = "Договор на крови",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Слова",
                description = "Непреложный обет заключенный с помощью магии крови. Такого рода кровавый обет заключается с помощью открытой раны на предплечье цели договора. Маг крови берет внутреннюю часть предплечья (касаясь раны) и заключает непреложный обет на условиях, которые он пожелает, без возможности цели на несогласие."
            ),
            SpellEntry(
                id = "blood_words_2",
                name = "Зов крови",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Слова",
                description = "Зачарование на крови магией слова. Позволяет заставить цель, с помощью зачарования на ее крови, прийти в назначенное магом крови время и место. При этом цель зачарования испытывает желание прибыть в назначенное место и не может противиться этому желанию."
            ),
            SpellEntry(
                id = "blood_words_3",
                name = "Власть крови",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Слова",
                description = "Пассивное умение магов слова Разума. Заклинания «Внушение» и «Прямой контроль» можно накладывать на расстоянии в пределах 5 метров. Их блок при этом не меняется."
            ),
            SpellEntry(
                id = "blood_words_4",
                name = "Слабая кровь",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Слова",
                description = "Заклинание магов крови слов Силы. Словесник накладывает ограничение на колдовство заклинаний определенного уровня (базовой ветвийной магии и специалитета соответствующих уровней), заявляя, например «Слабая кровь – Первый уровень!»."
            ),
            SpellEntry(
                id = "blood_words_5",
                name = "Приказы самоповреждения",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Слова",
                description = "Пассивный навык магов крови слова. Маг крови способен нанести себе увечье на 1 единицу урона (или использовать заготовленную кровь как энергию не менее 100 мл) и следующий приказ, достигнувший цели может содержать смысл самоповреждения цели."
            ),

            // ========== КРОВЬ ПЛАМЕНИ ==========
            SpellEntry(
                id = "blood_flame_1",
                name = "Кипячение крови",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Пламени",
                description = "Сангремант огня может нагреть тело противника. Если цель пропустила заклинание, то получает 3 единицы урона и эффект «поджога» (три следующих заклинания магии огня будут наносить по этой цели на 1 единицу урона больше)."
            ),
            SpellEntry(
                id = "blood_flame_2",
                name = "Охлаждение крови",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Пламени",
                description = "При открытой ране (потеряна хотя бы одна единица жизней), сангремант огня может замедлить ход крови и вызывать онемение. Цель не может атаковать и перемещается шагом в течение минуты."
            ),
            SpellEntry(
                id = "blood_flame_3",
                name = "Красная пелена",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Пламени",
                description = "Если у цели есть ранение и была выпущена кровь, то сангремант огня может наложить на цель состояние берсерка. На протяжении 1 минуты цель не будет ощущать боли и испытывать непреодолимое желание убивать ближайшую к себе цель. После окончания воздействия цель ощутит весь урон, который испытала за время красной пелены."
            ),

            // ========== КРОВЬ ЖИЗНИ ==========
            SpellEntry(
                id = "blood_life_1",
                name = "Вкус крови",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Жизни",
                description = "Маг-перевертыш-сангремант может получить возможность восстанавливать здоровье за каждую единицу урона, нанесенную в ближнем бою. Если здоровье достигло максимума, то перевертыш получает временное здоровье. Он не может накопить больше дополнительного здоровья, чем число его максимального здоровья."
            ),
            SpellEntry(
                id = "blood_life_2",
                name = "Власть Сильного",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Жизни",
                description = "Пассивный навык идущих этой тропой. Особая школа перевертышей-гемомантов. Суть тропы заключается в возможности обретать силы множества духов, если сможет показать свое безукоризненное превосходство перед ними."
            ),
            SpellEntry(
                id = "blood_life_3",
                name = "Кровотечение",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Жизни",
                description = "Сангремант жизни может наложить эффект кровотечения на цель до конца боя: если цель находится под воздействием заклинания кровотечения, то каждые три пройденных шага нанесут цели 1 урон."
            ),
            SpellEntry(
                id = "blood_life_4",
                name = "Прямо в сердце",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Жизни",
                description = "Смертельное заклинание, выполняемое в два этапа: Сначала маг крови должен совершить целевое дистанционное заклинание левой рукой. Если заклинание достигло цели, то цель не способна двигаться и стоит пронзенная болью на месте. Затем магу крови необходимо приблизится и правой рукой коснуться тела в области сердца цели, она попадет в критическое состояние."
            ),

            // ========== КРОВЬ РАВНОВЕСИЯ ==========
            SpellEntry(
                id = "blood_balance_1",
                name = "Баланс сил",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Равновесия",
                description = "Умбрамант может уравнять свое здоровье со здоровьем цели заклинания, при этом заявляя кого с кем уравнивает число жизней. Здоровье уравнивается до конца боя, все повреждения сохраняются даже если бой закончился."
            ),
            SpellEntry(
                id = "blood_balance_2",
                name = "Эскалация",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Равновесия",
                description = "После активации эскалации следующие три попавшие магические атаки, наносящие урон, восстановят магу тени 1 здоровье за каждую пораженную цель."
            ),
            SpellEntry(
                id = "blood_balance_3",
                name = "Жертвенность",
                category = MagicCategory.FORBIDDEN,
                school = "Магия крови",
                subgroup = "Кровь Равновесия",
                description = "Заклинание отнимает заявленное число здоровья у умбраманта, колдующего «жертвенность». Следующая атака умбраманта нанесет на Х урона больше, где Х — нанесенный урон мага тени самому себе."
            )
        )
    )

    val adeptismSchool = MagicSchool(
        id = "adeptism",
        name = "Адептизм",
        category = MagicCategory.FORBIDDEN,
        description = "Адептизм — тайное искусство, о котором почти ничего не известно. Механики появятся позже.",
        spells = emptyList()
    )


    // ========== СПЕЦИАЛИТЕТЫ РАВНОВЕСИЯ ==========

    val specLightWarriorsSchool = MagicSchool(
        id = "spec_light_warriors",
        name = "Воины Света",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.BALANCE,
        direction = "Свет",
        description = "Воины Света — элитные бойцы, сочетающие мастерство клинка с магией света. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_light_warriors_1",
                name = "Световой рывок",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Свет",
                specialization = "Воины Света",
                level = 1,
                description = "Мгновенное перемещение к цели с помощью света."
            ),
            SpellEntry(
                id = "spec_light_warriors_2",
                name = "Световые клинки",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Свет",
                specialization = "Воины Света",
                level = 2,
                description = "Создает парные клинки из чистой энергии."
            ),
            SpellEntry(
                id = "spec_light_warriors_3",
                name = "Форма света",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Свет",
                specialization = "Воины Света",
                level = 3,
                description = "Маг превращается в существо из чистого света."
            )
        )
    )

    val specWillSchool = MagicSchool(
        id = "spec_will",
        name = "Воля",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.BALANCE,
        description = "Специалитет Воли — искусство управления чужой волей. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_will_1",
                name = "Провокация",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                specialization = "Воля",
                level = 1,
                description = "Вызывает у цели непреодолимое желание атаковать мага."
            ),
            SpellEntry(
                id = "spec_will_2",
                name = "Оппортунизм",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                specialization = "Воля",
                level = 2,
                description = "Маг использует слабости врага для усиления атаки."
            ),
            SpellEntry(
                id = "spec_will_3",
                name = "Купол воли",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                specialization = "Воля",
                level = 3,
                description = "Создает мощный защитный купол из силы воли."
            )
        )
    )

    val specWillControlSchool = MagicSchool(
        id = "spec_will_control",
        name = "Контроль Воли",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.BALANCE,
        description = "Контроль Воли — искусство подавления чужой воли. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_will_control_1",
                name = "Подавление воли",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                specialization = "Контроль Воли",
                level = 1,
                description = "Подавляет волю цели, ослабляя её сопротивление."
            ),
            SpellEntry(
                id = "spec_will_control_2",
                name = "Волей-неволей",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                specialization = "Контроль Воли",
                level = 2,
                description = "Заставляет цель действовать против её желания."
            ),
            SpellEntry(
                id = "spec_will_control_3",
                name = "Забрать волю",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                specialization = "Контроль Воли",
                level = 3,
                description = "Полностью лишает цель воли."
            )
        )
    )

    val specShadowWarriorsSchool = MagicSchool(
        id = "spec_shadow_warriors",
        name = "Воины Тени",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.BALANCE,
        direction = "Тень",
        description = "Воины Тени — мастера скрытности и контроля, использующие тьму как оружие. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_shadow_warriors_1",
                name = "Морфей",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Тень",
                specialization = "Воины Тени",
                level = 1,
                description = "Погружает цель в глубокий сон."
            ),
            SpellEntry(
                id = "spec_shadow_warriors_2",
                name = "Инферметатум",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Тень",
                specialization = "Воины Тени",
                level = 2,
                description = "Вызывает адское пламя из тени."
            ),
            SpellEntry(
                id = "spec_shadow_warriors_3",
                name = "Слабость",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.BALANCE,
                direction = "Тень",
                specialization = "Воины Тени",
                level = 3,
                description = "Лишает цель сил."
            )
        )
    )

// ========== СПЕЦИАЛИТЕТЫ СЛОВ ==========

    val specWordsMindSchool = MagicSchool(
        id = "spec_words_mind",
        name = "Слова разума",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.WORDS,
        description = "Слова разума — искусство внушения и контроля сознания. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_words_mind_1",
                name = "Массовый приказ",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова разума",
                level = 1,
                description = "Отдает приказ сразу нескольким целям."
            ),
            SpellEntry(
                id = "spec_words_mind_2",
                name = "Внушение",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова разума",
                level = 2,
                description = "Внедряет мысль в разум цели."
            ),
            SpellEntry(
                id = "spec_words_mind_3",
                name = "Прямой контроль",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова разума",
                level = 3,
                description = "Полный контроль над разумом цели."
            )
        )
    )

    val specWordsResolveSchool = MagicSchool(
        id = "spec_words_resolve",
        name = "Слова решимости",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.WORDS,
        description = "Слова решимости — искусство поддержки и защиты. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_words_resolve_1",
                name = "Вдохновение",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова решимости",
                level = 1,
                description = "Вдохновляет союзника на подвиг."
            ),
            SpellEntry(
                id = "spec_words_resolve_2",
                name = "Свет разума",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова решимости",
                level = 2,
                description = "Очищает разум от ментального воздействия."
            ),
            SpellEntry(
                id = "spec_words_resolve_3",
                name = "Сковать тьму",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова решимости",
                level = 3,
                description = "Сковывает силы тьмы словом."
            )
        )
    )

    val specWordsPowerSchool = MagicSchool(
        id = "spec_words_power",
        name = "Слова силы",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.WORDS,
        description = "Слова силы — искусство разрушения и боли. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_words_power_1",
                name = "Боль",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова силы",
                level = 1,
                description = "Причиняет боль словом."
            ),
            SpellEntry(
                id = "spec_words_power_2",
                name = "Анепия",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова силы",
                level = 2,
                description = "Лишает цели способности говорить."
            ),
            SpellEntry(
                id = "spec_words_power_3",
                name = "Шум",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова силы",
                level = 3,
                description = "Оглушающий шум, выводящий из строя."
            )
        )
    )

    val specWordsJusticeSchool = MagicSchool(
        id = "spec_words_justice",
        name = "Слова справедливости",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.WORDS,
        description = "Слова справедливости — искусство возмездия. [Описание появится позже]",
        spells = listOf(
            SpellEntry(
                id = "spec_words_justice_1",
                name = "Обвинение",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова справедливости",
                level = 1,
                description = "Выдвигает обвинение, ослабляя цель."
            ),
            SpellEntry(
                id = "spec_words_justice_2",
                name = "Протест",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова справедливости",
                level = 2,
                description = "Мощный протест против несправедливости."
            ),
            SpellEntry(
                id = "spec_words_justice_3",
                name = "Приговор",
                category = MagicCategory.BRANCH,
                branch = MagicBranch.WORDS,
                specialization = "Слова справедливости",
                level = 3,
                description = "Выносит приговор, нанося огромный урон."
            )
        )
    )

// ========== СПЕЦИАЛИТЕТЫ ПЛАМЕНИ ==========

    val specFlamePrimalSchool = MagicSchool(
        id = "spec_flame_primal",
        name = "Первородный огонь",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Первородный огонь — древнейшая форма пламени. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_primal_1", name = "Ожог", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Первородный огонь", level = 1, description = "Оставляет болезненный ожог."),
            SpellEntry(id = "spec_flame_primal_2", name = "Конус пламени", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Первородный огонь", level = 2, description = "Конус пламени поражает область."),
            SpellEntry(id = "spec_flame_primal_3", name = "Огненная плеть", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Первородный огонь", level = 3, description = "Плеть из чистейшего огня.")
        )
    )

    val specFlameExplosionSchool = MagicSchool(
        id = "spec_flame_explosion",
        name = "Энергия взрывов",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Энергия взрывов — искусство концентрированной мощи. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_explosion_1", name = "Кража", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Энергия взрывов", level = 1, description = "Крадет энергию у цели."),
            SpellEntry(id = "spec_flame_explosion_2", name = "Залп энергии", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Энергия взрывов", level = 2, description = "Концентрированный залп энергии."),
            SpellEntry(id = "spec_flame_explosion_3", name = "Взрыв дара", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Энергия взрывов", level = 3, description = "Мощный взрыв магической энергии.")
        )
    )

    val specFlameStormSchool = MagicSchool(
        id = "spec_flame_storm",
        name = "Власть над бурей",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Власть над бурей — контроль над молниями. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_storm_1", name = "Шок", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Власть над бурей", level = 1, description = "Электрический шок."),
            SpellEntry(id = "spec_flame_storm_2", name = "Щит молний", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Власть над бурей", level = 2, description = "Защитный щит из молний."),
            SpellEntry(id = "spec_flame_storm_3", name = "Цепная молния", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Власть над бурей", level = 3, description = "Молния, перескакивающая между целями.")
        )
    )

    val specFlameMagnetismSchool = MagicSchool(
        id = "spec_flame_magnetism",
        name = "Магнетизм",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Магнетизм — контроль над магнитными полями. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_magnetism_1", name = "Заряд статики", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Магнетизм", level = 1, description = "Статический заряд."),
            SpellEntry(id = "spec_flame_magnetism_2", name = "Притяжение", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Магнетизм", level = 2, description = "Притягивает цель."),
            SpellEntry(id = "spec_flame_magnetism_3", name = "Магнетизм", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Магнетизм", level = 3, description = "Полный контроль над магнетизмом.")
        )
    )

    val specFlameCryomancySchool = MagicSchool(
        id = "spec_flame_cryomancy",
        name = "Криомания",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Криомания — искусство холода и льда. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_cryomancy_1", name = "Гололед", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Криомания", level = 1, description = "Покрывает поверхность льдом."),
            SpellEntry(id = "spec_flame_cryomancy_2", name = "Ледяная Шрапнель", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Криомания", level = 2, description = "Осколки льда."),
            SpellEntry(id = "spec_flame_cryomancy_3", name = "Криостазис", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Криомания", level = 3, description = "Замораживает цель.")
        )
    )

    val specFlameGreenSchool = MagicSchool(
        id = "spec_flame_green",
        name = "Зеленое пламя",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Зеленое пламя — искусство эмоций. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_green_1", name = "Ощущение эмоций", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Зеленое пламя", level = 1, description = "Чувствует эмоции через касание."),
            SpellEntry(id = "spec_flame_green_2", name = "Видение эмоций", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Зеленое пламя", level = 2, description = "Видит эмоции на расстоянии."),
            SpellEntry(id = "spec_flame_green_3", name = "Забирание эмоций", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Зеленое пламя", level = 3, description = "Забирает эмоции у цели.")
        )
    )

    val specFlameDivinationSchool = MagicSchool(
        id = "spec_flame_divination",
        name = "Огненное прорицание",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Огненное прорицание — искусство предвидения. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_divination_1", name = "Наделение эмоцией", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Огненное прорицание", level = 1, description = "Наделяет эмоцией через касание."),
            SpellEntry(id = "spec_flame_divination_2", name = "Возвращение эмоций", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Огненное прорицание", level = 2, description = "Возвращает утраченные эмоции."),
            SpellEntry(id = "spec_flame_divination_3", name = "Наделение сильным чувством", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Огненное прорицание", level = 3, description = "Наделяет сильным чувством.")
        )
    )

    val specFlamePlasmaSchool = MagicSchool(
        id = "spec_flame_plasma",
        name = "Плазмамантия",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.FLAME,
        description = "Плазмамантия — высшее искусство огня. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_flame_plasma_1", name = "Заря", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Плазмамантия", level = 1, description = "Плазменный заряд."),
            SpellEntry(id = "spec_flame_plasma_2", name = "Драконий доспех", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Плазмамантия", level = 2, description = "Доспех из плазмы."),
            SpellEntry(id = "spec_flame_plasma_3", name = "Живой огонь / Сверхновая", category = MagicCategory.BRANCH, branch = MagicBranch.FLAME, specialization = "Плазмамантия", level = 3, description = "Высшее проявление плазмы.")
        )
    )

// ========== СПЕЦИАЛИТЕТЫ ЖИЗНИ ==========

    val specLifeArboristicsSchool = MagicSchool(
        id = "spec_life_arboristics",
        name = "Арбористика",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        description = "Арбористика — искусство управления растениями. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_life_arboristics_1", name = "Едкая пыльца", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Арбористика", level = 1, description = "Пыльца, раздражающая врагов."),
            SpellEntry(id = "spec_life_arboristics_2", name = "Корневища / Острые листья", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Арбористика", level = 2, description = "Атака корнями и листьями."),
            SpellEntry(id = "spec_life_arboristics_3", name = "Вырастить лес", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Арбористика", level = 3, description = "Выращивает лес.")
        )
    )

    val specLifeAnimismSchool = MagicSchool(
        id = "spec_life_animism",
        name = "Анимистика",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        description = "Анимистика — искусство работы с духами. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_life_animism_1", name = "Тотем", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Анимистика", level = 1, description = "Создает тотем."),
            SpellEntry(id = "spec_life_animism_2", name = "Воплощение духа", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Анимистика", level = 2, description = "Воплощает дух."),
            SpellEntry(id = "spec_life_animism_3", name = "Развоплощение", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Анимистика", level = 3, description = "Развоплощает дух.")
        )
    )

    val specLifeVitamintiaSchool = MagicSchool(
        id = "spec_life_vitamintia",
        name = "Витаминтия",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        description = "Витаминтия — искусство управления плотью. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_life_vitamintia_1", name = "Шипы", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Витаминтия", level = 1, description = "Выращивает шипы."),
            SpellEntry(id = "spec_life_vitamintia_2", name = "Выкручивание плоти", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Витаминтия", level = 2, description = "Выкручивает плоть."),
            SpellEntry(id = "spec_life_vitamintia_3", name = "Управление плотью", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Витаминтия", level = 3, description = "Управляет плотью.")
        )
    )

    val specLifeHydroSchool = MagicSchool(
        id = "spec_life_hydro",
        name = "Гидрософистика",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        description = "Гидрософистика — искусство управления водой. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_life_hydro_1", name = "Очищающие воды", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Гидрософистика", level = 1, description = "Очищает воду."),
            SpellEntry(id = "spec_life_hydro_2", name = "Стоячая вода", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Гидрософистика", level = 2, description = "Создает стоячую воду."),
            SpellEntry(id = "spec_life_hydro_3", name = "Осушение", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Гидрософистика", level = 3, description = "Осушает.")
        )
    )

    val specLifeAeroSchool = MagicSchool(
        id = "spec_life_aero",
        name = "Аэротургия",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        description = "Аэротургия — искусство управления воздухом. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_life_aero_1", name = "Точность", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Аэротургия", level = 1, description = "Повышает точность."),
            SpellEntry(id = "spec_life_aero_2", name = "Объятья ветра", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Аэротургия", level = 2, description = "Ветер обнимает цель."),
            SpellEntry(id = "spec_life_aero_3", name = "Удушение", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Аэротургия", level = 3, description = "Удушает цель.")
        )
    )

    val specLifeGeoSchool = MagicSchool(
        id = "spec_life_geo",
        name = "Геомантия",
        category = MagicCategory.BRANCH,
        branch = MagicBranch.LIFE,
        description = "Геомантия — искусство управления землёй и камнем. [Описание появится позже]",
        spells = listOf(
            SpellEntry(id = "spec_life_geo_1", name = "Каменный кулак", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Геомантия", level = 1, description = "Каменный кулак."),
            SpellEntry(id = "spec_life_geo_2", name = "Расщелина", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Геомантия", level = 2, description = "Создает расщелину."),
            SpellEntry(id = "spec_life_geo_3", name = "Жернова", category = MagicCategory.BRANCH, branch = MagicBranch.LIFE, specialization = "Геомантия", level = 3, description = "Жернова.")
        )
    )
    // ========== СПИСКИ ШКОЛ ПО КАТЕГОРИЯМ ==========

    val basicBranchSchools = listOf(
        balanceLightSchool,
        balanceShadowSchool,
        wordsSchool,
        flameSchool,
        lifeShamanSchool,
        lifeShapeshifterSchool
    )

    val specializationSchools = listOf(
        // Равновесие
        specLightWarriorsSchool,
        specWillSchool,
        specWillControlSchool,
        specShadowWarriorsSchool,

        // Слова
        specWordsMindSchool,
        specWordsResolveSchool,
        specWordsPowerSchool,
        specWordsJusticeSchool,

        // Пламя
        specFlamePrimalSchool,
        specFlameExplosionSchool,
        specFlameStormSchool,
        specFlameMagnetismSchool,
        specFlameCryomancySchool,
        specFlameGreenSchool,
        specFlameDivinationSchool,
        specFlamePlasmaSchool,

        // Жизнь
        specLifeArboristicsSchool,
        specLifeAnimismSchool,
        specLifeVitamintiaSchool,
        specLifeHydroSchool,
        specLifeAeroSchool,
        specLifeGeoSchool
    )

    val branchSchools = basicBranchSchools + specializationSchools


    val universalSchools = listOf(
        runologySchool,
        alchemySchool,
        enchantmentSchool,
        healingSchool,
        trackingSchool,
        cikiroSchool,
        bonemagicSchool,
        militarySchool,
        fearlessnessSchool,
        lovePathSchool,
        machineariumSchool
    )

    val forbiddenSchools = listOf(
        voodooSchool,
        bloodMagicSchool,
        adeptismSchool
    )

    // ========== ВСЕ ЗАКЛИНАНИЯ (для поиска и обратной совместимости) ==========

    val allSpells: List<SpellEntry> = (branchSchools + universalSchools + forbiddenSchools)
        .flatMap { it.spells }

    // ========== МЕТОДЫ ==========

    fun getSchoolsByCategory(category: MagicCategory): List<MagicSchool> {
        return when (category) {
            MagicCategory.BRANCH -> branchSchools
            MagicCategory.UNIVERSAL -> universalSchools
            MagicCategory.FORBIDDEN -> forbiddenSchools
        }
    }

    fun getSchoolById(id: String): MagicSchool? {
        return (branchSchools + universalSchools + forbiddenSchools).find { it.id == id }
    }

    fun getSpellById(id: String): SpellEntry? {
        return allSpells.find { it.id == id }
    }

    fun searchSpells(query: String): List<SpellEntry> {
        return allSpells.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.description.contains(query, ignoreCase = true)
        }
    }
}