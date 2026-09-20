package com.example.konklavtracer_v2.data


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.konklavtracer_v2.models.*
import org.json.JSONArray
import org.json.JSONObject

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "konklav.db"
        private const val DATABASE_VERSION = 4

        // Таблицы
        const val TABLE_CHARACTERS = "characters"
        const val TABLE_INVENTORY = "inventory"
        const val TABLE_SPELLS = "spells"
        const val TABLE_NOTES = "notes"

        // Колонки персонажей
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_RACE = "race"
        const val COL_SUBRACE = "subrace"
        const val COL_BASE_ASPECTS = "base_aspects"
        const val COL_FINAL_ASPECTS = "final_aspects"
        const val COL_MAGIC_DATA = "magic_data"  // НОВАЯ КОЛОНКА
        const val COL_MAX_HEALTH = "max_health"
        const val COL_CURRENT_HEALTH = "current_health"
        const val COL_ARROWS = "arrows"
        const val COL_COPPER = "copper"
        const val COL_SILVER = "silver"
        const val COL_GOLD = "gold"
        const val COL_CREATED_AT = "created_at"
        const val COL_UPDATED_AT = "updated_at"

        // Колонки инвентаря
        const val COL_INV_ID = "id"
        const val COL_INV_CHAR_ID = "character_id"
        const val COL_INV_NAME = "item_name"
        const val COL_INV_DESC = "description"
        const val COL_INV_QTY = "quantity"
        const val COL_INV_EQUIPPED = "is_equipped"


        const val TABLE_CATEGORIES = "categories"
        const val COL_CAT_ID = "id"
        const val COL_CAT_NAME = "name"
        const val COL_CAT_CHAR_ID = "character_id"
        const val COL_CAT_ORDER = "sort_order"
        const val COL_INV_CATEGORY_ID = "category_id"

        // Колонки заклинаний
        const val COL_SPELL_ID = "id"
        const val COL_SPELL_NAME = "name"
        const val COL_SPELL_LEVEL = "level"
        const val COL_SPELL_SCHOOL = "school"
        const val COL_SPELL_CASTING_TIME = "casting_time"
        const val COL_SPELL_RANGE = "spell_range"
        const val COL_SPELL_DURATION = "duration"
        const val COL_SPELL_DESCRIPTION = "description"
        const val COL_SPELL_DAMAGE = "damage"
        const val COL_SPELL_IS_CUSTOM = "is_custom"

        // Колонки заметок
        const val COL_NOTE_ID = "id"
        const val COL_NOTE_CHAR_ID = "character_id"
        const val COL_NOTE_TITLE = "title"
        const val COL_NOTE_CONTENT = "content"
        const val COL_NOTE_CREATED_AT = "created_at"
        const val COL_NOTE_UPDATED_AT = "updated_at"

        const val COL_ARTIFACT_HEALTH = "artifact_health_bonus"
    }

    override fun onCreate(db: SQLiteDatabase) {
        createCharactersTable(db)
        createInventoryTable(db)
        createCategoriesTable(db)
        createSpellsTable(db)
        createNotesTable(db)
    }

    private fun createCategoriesTable(db: SQLiteDatabase) {
        db.execSQL("""
        CREATE TABLE $TABLE_CATEGORIES (
            $COL_CAT_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COL_CAT_NAME TEXT NOT NULL,
            $COL_CAT_CHAR_ID INTEGER NOT NULL,
            $COL_CAT_ORDER INTEGER NOT NULL DEFAULT 0,
            FOREIGN KEY ($COL_CAT_CHAR_ID) REFERENCES $TABLE_CHARACTERS($COL_ID) 
                ON DELETE CASCADE
        )
    """)
    }

    private fun createCharactersTable(db: SQLiteDatabase) {
        db.execSQL("""
        CREATE TABLE $TABLE_CHARACTERS (
            $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COL_NAME TEXT NOT NULL,
            $COL_RACE TEXT NOT NULL,
            $COL_SUBRACE TEXT DEFAULT '',
            $COL_BASE_ASPECTS TEXT NOT NULL,
            $COL_FINAL_ASPECTS TEXT NOT NULL,
            $COL_MAGIC_DATA TEXT DEFAULT '{}',
            $COL_MAX_HEALTH INTEGER NOT NULL DEFAULT 10,
            $COL_CURRENT_HEALTH INTEGER NOT NULL DEFAULT 10,
            $COL_ARROWS INTEGER NOT NULL DEFAULT 0,
            $COL_COPPER INTEGER NOT NULL DEFAULT 0,
            $COL_SILVER INTEGER NOT NULL DEFAULT 0,
            $COL_GOLD INTEGER NOT NULL DEFAULT 0,
            $COL_ARTIFACT_HEALTH INTEGER NOT NULL DEFAULT 0,
            $COL_CREATED_AT INTEGER NOT NULL,
            $COL_UPDATED_AT INTEGER NOT NULL
        )
    """)
    }

    private fun createInventoryTable(db: SQLiteDatabase) {
        db.execSQL("""
        CREATE TABLE $TABLE_INVENTORY (
            $COL_INV_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COL_INV_CHAR_ID INTEGER NOT NULL,
            $COL_INV_NAME TEXT NOT NULL,
            $COL_INV_DESC TEXT DEFAULT '',
            $COL_INV_QTY INTEGER NOT NULL DEFAULT 1,
            $COL_INV_EQUIPPED INTEGER NOT NULL DEFAULT 0,
            $COL_INV_CATEGORY_ID INTEGER DEFAULT NULL,
            FOREIGN KEY ($COL_INV_CHAR_ID) REFERENCES $TABLE_CHARACTERS($COL_ID) 
                ON DELETE CASCADE,
            FOREIGN KEY ($COL_INV_CATEGORY_ID) REFERENCES $TABLE_CATEGORIES($COL_CAT_ID) 
                ON DELETE SET NULL
        )
    """)
    }

    private fun createSpellsTable(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE $TABLE_SPELLS (
                $COL_SPELL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_SPELL_NAME TEXT NOT NULL,
                $COL_SPELL_LEVEL INTEGER NOT NULL,
                $COL_SPELL_SCHOOL TEXT NOT NULL,
                $COL_SPELL_CASTING_TIME TEXT NOT NULL,
                $COL_SPELL_RANGE TEXT NOT NULL,
                $COL_SPELL_DURATION TEXT NOT NULL,
                $COL_SPELL_DESCRIPTION TEXT NOT NULL,
                $COL_SPELL_DAMAGE TEXT,
                $COL_SPELL_IS_CUSTOM INTEGER NOT NULL DEFAULT 0
            )
        """)
    }

    private fun createNotesTable(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE $TABLE_NOTES (
                $COL_NOTE_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NOTE_CHAR_ID INTEGER,
                $COL_NOTE_TITLE TEXT NOT NULL,
                $COL_NOTE_CONTENT TEXT NOT NULL,
                $COL_NOTE_CREATED_AT INTEGER NOT NULL,
                $COL_NOTE_UPDATED_AT INTEGER NOT NULL,
                FOREIGN KEY ($COL_NOTE_CHAR_ID) REFERENCES $TABLE_CHARACTERS($COL_ID) 
                    ON DELETE CASCADE
            )
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE $TABLE_CHARACTERS ADD COLUMN $COL_MAGIC_DATA TEXT DEFAULT '{}'")
        }
        if (oldVersion < 3) {
            db.execSQL("ALTER TABLE $TABLE_CHARACTERS ADD COLUMN $COL_ARTIFACT_HEALTH INTEGER NOT NULL DEFAULT 0")
        }
        if (oldVersion < 4) {
            db.execSQL("ALTER TABLE $TABLE_INVENTORY ADD COLUMN $COL_INV_CATEGORY_ID INTEGER DEFAULT NULL")
            // Создаем таблицу категорий если её нет
            createCategoriesTable(db)
        }
    }

    // ========== КОНВЕРТАЦИЯ ASPECTS <-> JSON ==========

    private fun aspectsToJson(aspects: Aspects): String {
        return JSONObject().apply {
            put("vigilance", aspects.vigilance)
            put("perception", aspects.perception)
            put("will", aspects.will)
            put("agility", aspects.agility)
            put("constitution", aspects.constitution)
            put("driving", aspects.driving)
            put("craft", aspects.craft)
            put("magic", aspects.magic)
            put("melee", aspects.melee)
            put("shooting", aspects.shooting)
            put("stealth", aspects.stealth)
            put("healing", aspects.healing)
        }.toString()
    }

    private fun jsonToAspects(json: String): Aspects {
        return try {
            val obj = JSONObject(json)
            Aspects(
                vigilance = obj.optInt("vigilance", 0),
                perception = obj.optInt("perception", 0),
                will = obj.optInt("will", 0),
                agility = obj.optInt("agility", 0),
                constitution = obj.optInt("constitution", 0),
                driving = obj.optInt("driving", 0),
                craft = obj.optInt("craft", 0),
                magic = obj.optInt("magic", 0),
                melee = obj.optInt("melee", 0),
                shooting = obj.optInt("shooting", 0),
                stealth = obj.optInt("stealth", 0),
                healing = obj.optInt("healing", 0)
            )
        } catch (e: Exception) {
            Aspects()
        }
    }

    // ========== КОНВЕРТАЦИЯ MAGICDATA <-> JSON ==========

    private fun magicDataToJson(magicData: MagicData): String {
        return JSONObject().apply {
            put("branch", magicData.branch.name)
            put("balance_direction", magicData.balanceDirection?.name ?: "")
            put("life_direction", magicData.lifeDirection?.name ?: "")
            put("animal_type", magicData.animalType?.name ?: "")

            // Базовые заклинания
            val baseSpellsArray = JSONArray()
            magicData.baseSpells.forEach { spell ->
                baseSpellsArray.put(JSONObject().apply {
                    put("name", spell.name)
                    put("level", spell.level)
                    put("description", spell.description)
                })
            }
            put("base_spells", baseSpellsArray)

            // Специалитеты
            val specSpellsObj = JSONObject()
            magicData.specializationSpells.forEach { (specName, spells) ->
                val spellsArray = JSONArray()
                spells.forEach { spell ->
                    spellsArray.put(JSONObject().apply {
                        put("name", spell.name)
                        put("level", spell.level)
                        put("description", spell.description)
                    })
                }
                specSpellsObj.put(specName, spellsArray)
            }
            put("specialization_spells", specSpellsObj)

            // Вудуизм
            val voodooLoasObj = JSONObject()
            magicData.voodooLoas.forEach { (loa, aspect) ->
                voodooLoasObj.put(loa, aspect)
            }
            put("voodoo_loas", voodooLoasObj)

            val fearlessnessArray = JSONArray()
            magicData.fearlessnessSpells.forEach { spell ->
                fearlessnessArray.put(spell)
            }
            put("fearlessness_spells", fearlessnessArray)

// Магия крови
            put("has_blood_magic", magicData.hasBloodMagic)

            put("love_path_type", magicData.lovePathType)
            val loveLanguagesObj = JSONObject()
            magicData.loveLanguages.forEach { (language, gestures) ->
                val gesturesArray = JSONArray()
                gestures.forEach { gesture ->
                    gesturesArray.put(gesture)
                }
                loveLanguagesObj.put(language, gesturesArray)
            }
            put("love_languages", loveLanguagesObj)

            // Неветвийная магия
            val universalMagicObj = JSONObject()
            magicData.universalMagic.forEach { (school, level) ->
                universalMagicObj.put(school, level)
            }
            put("universal_magic", universalMagicObj)
        }.toString()
    }

    private fun jsonToMagicData(json: String): MagicData {
        return try {
            val obj = JSONObject(json)

            val branch = try {
                MagicBranch.valueOf(obj.optString("branch", "NONE"))
            } catch (e: Exception) {
                MagicBranch.NONE
            }

            val balanceDirection = try {
                val value = obj.optString("balance_direction", "")
                if (value.isNotEmpty()) BalanceDirection.valueOf(value) else null
            } catch (e: Exception) {
                null
            }

            val lifeDirection = try {
                val value = obj.optString("life_direction", "")
                if (value.isNotEmpty()) LifeDirection.valueOf(value) else null
            } catch (e: Exception) {
                null
            }

            val animalType = try {
                val value = obj.optString("animal_type", "")
                if (value.isNotEmpty()) AnimalType.valueOf(value) else null
            } catch (e: Exception) {
                null
            }

            // Базовые заклинания
            val baseSpells = mutableListOf<BaseSpell>()
            val baseSpellsArray = obj.optJSONArray("base_spells")
            if (baseSpellsArray != null) {
                for (i in 0 until baseSpellsArray.length()) {
                    val spellObj = baseSpellsArray.getJSONObject(i)
                    baseSpells.add(
                        BaseSpell(
                            name = spellObj.optString("name", ""),
                            level = spellObj.optInt("level", 0),
                            description = spellObj.optString("description", "")
                        )
                    )
                }
            }

            // Специалитеты
            val specializationSpells = mutableMapOf<String, List<BaseSpell>>()
            val specSpellsObj = obj.optJSONObject("specialization_spells")
            if (specSpellsObj != null) {
                val keys = specSpellsObj.keys()
                while (keys.hasNext()) {
                    val specName = keys.next()
                    val spellsArray = specSpellsObj.optJSONArray(specName)
                    val spells = mutableListOf<BaseSpell>()
                    if (spellsArray != null) {
                        for (i in 0 until spellsArray.length()) {
                            val spellObj = spellsArray.getJSONObject(i)
                            spells.add(
                                BaseSpell(
                                    name = spellObj.optString("name", ""),
                                    level = spellObj.optInt("level", 0),
                                    description = spellObj.optString("description", "")
                                )
                            )
                        }
                    }
                    specializationSpells[specName] = spells
                }
            }

            // Неветвийная магия
            val universalMagic = mutableMapOf<String, Int>()
            val universalMagicObj = obj.optJSONObject("universal_magic")
            if (universalMagicObj != null) {
                val keys = universalMagicObj.keys()
                while (keys.hasNext()) {
                    val key = keys.next()
                    universalMagic[key] = universalMagicObj.optInt(key, 0)
                }
            }

            // Вудуизм
            val voodooLoas = mutableMapOf<String, String>()
            val voodooLoasObj = obj.optJSONObject("voodoo_loas")
            if (voodooLoasObj != null) {
                val keys = voodooLoasObj.keys()
                while (keys.hasNext()) {
                    val key = keys.next()
                    voodooLoas[key] = voodooLoasObj.optString(key, "")
                }
            }

            val fearlessnessSpells = mutableListOf<String>()
            val fearlessnessArray = obj.optJSONArray("fearlessness_spells")
            if (fearlessnessArray != null) {
                for (i in 0 until fearlessnessArray.length()) {
                    fearlessnessSpells.add(fearlessnessArray.getString(i))
                }
            }

// Магия крови
            val hasBloodMagic = obj.optBoolean("has_blood_magic", false)



            val lovePathType = obj.optString("love_path_type", "")
            val loveLanguages = mutableMapOf<String, List<String>>()
            val loveLanguagesObj = obj.optJSONObject("love_languages")
            if (loveLanguagesObj != null) {
                val keys = loveLanguagesObj.keys()
                while (keys.hasNext()) {
                    val key = keys.next()
                    val gesturesArray = loveLanguagesObj.optJSONArray(key)
                    val gestures = mutableListOf<String>()
                    if (gesturesArray != null) {
                        for (i in 0 until gesturesArray.length()) {
                            gestures.add(gesturesArray.getString(i))
                        }
                    }
                    loveLanguages[key] = gestures
                }
            }

            MagicData(
                branch = branch,
                balanceDirection = balanceDirection,
                lifeDirection = lifeDirection,
                animalType = animalType,
                baseSpells = baseSpells,
                specializationSpells = specializationSpells,
                universalMagic = universalMagic,
                voodooLoas = voodooLoas,
                lovePathType = lovePathType,
                loveLanguages = loveLanguages,
                fearlessnessSpells = fearlessnessSpells,
                hasBloodMagic = hasBloodMagic
            )
        } catch (e: Exception) {
            MagicData()
        }
    }



    // ========== МЕТОДЫ ДЛЯ ПЕРСОНАЖЕЙ ==========

    fun addCharacter(character: Character): Long {
        val db = writableDatabase
        val now = System.currentTimeMillis()
        val values = ContentValues().apply {
            put(COL_NAME, character.name)
            put(COL_RACE, character.race)
            put(COL_SUBRACE, character.subrace)
            put(COL_BASE_ASPECTS, aspectsToJson(character.baseAspects))
            put(COL_FINAL_ASPECTS, aspectsToJson(character.finalAspects))
            put(COL_MAGIC_DATA, magicDataToJson(character.magicData))
            put(COL_MAX_HEALTH, character.maxHealth)
            put(COL_ARTIFACT_HEALTH, character.artifactHealthBonus)
            put(COL_CURRENT_HEALTH, character.currentHealth)
            put(COL_ARROWS, character.arrows)
            put(COL_COPPER, character.copper)
            put(COL_SILVER, character.silver)
            put(COL_GOLD, character.gold)
            put(COL_CREATED_AT, now)
            put(COL_UPDATED_AT, now)
        }
        return db.insert(TABLE_CHARACTERS, null, values)
    }

    fun getCharacterById(id: Int): Character? {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_CHARACTERS,
            null,
            "$COL_ID = ?",
            arrayOf(id.toString()),
            null, null, null
        )

        cursor.use {
            if (it.moveToFirst()) {
                return cursorToCharacter(it)
            }
        }
        return null
    }
    fun getCategories(characterId: Int): List<ItemCategory> {
        val categories = mutableListOf<ItemCategory>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_CATEGORIES,
            null,
            "$COL_CAT_CHAR_ID = ?",
            arrayOf(characterId.toString()),
            null, null, "$COL_CAT_ORDER ASC"
        )

        cursor.use {
            while (it.moveToNext()) {
                categories.add(
                    ItemCategory(
                        id = it.getInt(it.getColumnIndexOrThrow(COL_CAT_ID)),
                        name = it.getString(it.getColumnIndexOrThrow(COL_CAT_NAME)),
                        characterId = it.getInt(it.getColumnIndexOrThrow(COL_CAT_CHAR_ID)),
                        sortOrder = it.getInt(it.getColumnIndexOrThrow(COL_CAT_ORDER))
                    )
                )
            }
        }
        return categories
    }

    // Добавление категории
    fun addCategory(characterId: Int, name: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_CAT_NAME, name)
            put(COL_CAT_CHAR_ID, characterId)
            put(COL_CAT_ORDER, getCategoryCount(characterId))
        }
        return db.insert(TABLE_CATEGORIES, null, values)
    }

    // Количество категорий
    fun getCategoryCount(characterId: Int): Int {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT COUNT(*) FROM $TABLE_CATEGORIES WHERE $COL_CAT_CHAR_ID = ?",
            arrayOf(characterId.toString())
        )
        cursor.use {
            if (it.moveToFirst()) {
                return it.getInt(0)
            }
        }
        return 0
    }

    // Удаление категории
    fun deleteCategory(categoryId: Int): Int {
        val db = writableDatabase
        // Сначала убираем категорию у предметов
        val values = ContentValues().apply {
            putNull(COL_INV_CATEGORY_ID)
        }
        db.update(
            TABLE_INVENTORY,
            values,
            "$COL_INV_CATEGORY_ID = ?",
            arrayOf(categoryId.toString())
        )
        // Потом удаляем категорию
        return db.delete(
            TABLE_CATEGORIES,
            "$COL_CAT_ID = ?",
            arrayOf(categoryId.toString())
        )
    }

    // Переименование категории
    fun renameCategory(categoryId: Int, newName: String): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_CAT_NAME, newName)
        }
        return db.update(
            TABLE_CATEGORIES,
            values,
            "$COL_CAT_ID = ?",
            arrayOf(categoryId.toString())
        )
    }



    fun getAllCharacters(): List<Character> {
        val characters = mutableListOf<Character>()
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM $TABLE_CHARACTERS ORDER BY $COL_NAME",
            null
        )

        cursor.use {
            while (it.moveToNext()) {
                characters.add(cursorToCharacter(it))
            }
        }
        return characters
    }

    private fun cursorToCharacter(cursor: Cursor): Character {
        return Character(
            id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)),
            name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)),
            race = cursor.getString(cursor.getColumnIndexOrThrow(COL_RACE)),
            subrace = cursor.getString(cursor.getColumnIndexOrThrow(COL_SUBRACE)),
            baseAspects = jsonToAspects(cursor.getString(cursor.getColumnIndexOrThrow(COL_BASE_ASPECTS))),
            finalAspects = jsonToAspects(cursor.getString(cursor.getColumnIndexOrThrow(COL_FINAL_ASPECTS))),
            magicData = jsonToMagicData(cursor.getString(cursor.getColumnIndexOrThrow(COL_MAGIC_DATA))),
            maxHealth = cursor.getInt(cursor.getColumnIndexOrThrow(COL_MAX_HEALTH)),
            artifactHealthBonus = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ARTIFACT_HEALTH)),
            currentHealth = cursor.getInt(cursor.getColumnIndexOrThrow(COL_CURRENT_HEALTH)),
            arrows = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ARROWS)),
            copper = cursor.getInt(cursor.getColumnIndexOrThrow(COL_COPPER)),
            silver = cursor.getInt(cursor.getColumnIndexOrThrow(COL_SILVER)),
            gold = cursor.getInt(cursor.getColumnIndexOrThrow(COL_GOLD)),
            createdAt = cursor.getLong(cursor.getColumnIndexOrThrow(COL_CREATED_AT)),
            updatedAt = cursor.getLong(cursor.getColumnIndexOrThrow(COL_UPDATED_AT))
        )
    }

    fun updateCharacter(character: Character): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_NAME, character.name)
            put(COL_RACE, character.race)
            put(COL_SUBRACE, character.subrace)
            put(COL_BASE_ASPECTS, aspectsToJson(character.baseAspects))
            put(COL_FINAL_ASPECTS, aspectsToJson(character.finalAspects))
            put(COL_MAGIC_DATA, magicDataToJson(character.magicData))
            put(COL_MAX_HEALTH, character.maxHealth)
            put(COL_ARTIFACT_HEALTH, character.artifactHealthBonus)
            put(COL_CURRENT_HEALTH, character.currentHealth)
            put(COL_ARROWS, character.arrows)
            put(COL_COPPER, character.copper)
            put(COL_SILVER, character.silver)
            put(COL_GOLD, character.gold)
            put(COL_UPDATED_AT, System.currentTimeMillis())
        }
        return db.update(
            TABLE_CHARACTERS,
            values,
            "$COL_ID = ?",
            arrayOf(character.id.toString())
        )
    }

    fun deleteCharacter(id: Int): Int {
        val db = writableDatabase
        // Сначала удаляем инвентарь
        db.delete(
            TABLE_INVENTORY,
            "$COL_INV_CHAR_ID = ?",
            arrayOf(id.toString())
        )
        // Потом удаляем персонажа
        return db.delete(
            TABLE_CHARACTERS,
            "$COL_ID = ?",
            arrayOf(id.toString())
        )
    }

    // ========== МЕТОДЫ ДЛЯ ИНВЕНТАРЯ ==========

    fun addItemToInventory(
        characterId: Int,
        itemName: String,
        description: String = "",
        quantity: Int = 1,
        isEquipped: Boolean = false,
        categoryId: Int? = null  // ДОБАВЛЕНО
    ): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_INV_CHAR_ID, characterId)
            put(COL_INV_NAME, itemName)
            put(COL_INV_DESC, description)
            put(COL_INV_QTY, quantity)
            put(COL_INV_EQUIPPED, if (isEquipped) 1 else 0)
            if (categoryId != null) {
                put(COL_INV_CATEGORY_ID, categoryId)
            }
        }
        return db.insert(TABLE_INVENTORY, null, values)
    }

    fun getInventory(characterId: Int): List<InventoryItem> {
        val items = mutableListOf<InventoryItem>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_INVENTORY,
            null,
            "$COL_INV_CHAR_ID = ?",
            arrayOf(characterId.toString()),
            null, null, "$COL_INV_NAME ASC"
        )

        cursor.use {
            while (it.moveToNext()) {
                items.add(
                    InventoryItem(
                        id = it.getInt(it.getColumnIndexOrThrow(COL_INV_ID)),
                        name = it.getString(it.getColumnIndexOrThrow(COL_INV_NAME)),
                        description = it.getString(it.getColumnIndexOrThrow(COL_INV_DESC)),
                        quantity = it.getInt(it.getColumnIndexOrThrow(COL_INV_QTY)),
                        isEquipped = it.getInt(it.getColumnIndexOrThrow(COL_INV_EQUIPPED)) == 1,
                        categoryId = if (it.isNull(it.getColumnIndexOrThrow(COL_INV_CATEGORY_ID))) null
                        else it.getInt(it.getColumnIndexOrThrow(COL_INV_CATEGORY_ID))
                    )
                )
            }
        }
        return items
    }

    fun updateInventoryItem(item: InventoryItem): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_INV_NAME, item.name)
            put(COL_INV_DESC, item.description)
            put(COL_INV_QTY, item.quantity)
            put(COL_INV_EQUIPPED, if (item.isEquipped) 1 else 0)
            put(COL_INV_CATEGORY_ID, item.categoryId)   // ← ЭТА СТРОКА ДОЛЖНА БЫТЬ!
        }
        return db.update(
            TABLE_INVENTORY,
            values,
            "$COL_INV_ID = ?",
            arrayOf(item.id.toString())
        )
    }

    fun deleteInventoryItem(itemId: Int): Int {
        val db = writableDatabase
        return db.delete(
            TABLE_INVENTORY,
            "$COL_INV_ID = ?",
            arrayOf(itemId.toString())
        )
    }

    // ========== МЕТОДЫ ДЛЯ ЗАКЛИНАНИЙ ==========

    fun addSpell(
        name: String,
        level: Int,
        school: String,
        castingTime: String,
        range: String,
        duration: String,
        description: String,
        damage: String? = null,
        isCustom: Boolean = false
    ): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_SPELL_NAME, name)
            put(COL_SPELL_LEVEL, level)
            put(COL_SPELL_SCHOOL, school)
            put(COL_SPELL_CASTING_TIME, castingTime)
            put(COL_SPELL_RANGE, range)
            put(COL_SPELL_DURATION, duration)
            put(COL_SPELL_DESCRIPTION, description)
            put(COL_SPELL_DAMAGE, damage)
            put(COL_SPELL_IS_CUSTOM, if (isCustom) 1 else 0)
        }
        return db.insert(TABLE_SPELLS, null, values)
    }

    fun getAllSpells(): List<Spell> {
        val spells = mutableListOf<Spell>()
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM $TABLE_SPELLS ORDER BY $COL_SPELL_LEVEL, $COL_SPELL_NAME",
            null
        )

        cursor.use {
            while (it.moveToNext()) {
                spells.add(
                    Spell(
                        id = it.getInt(it.getColumnIndexOrThrow(COL_SPELL_ID)),
                        name = it.getString(it.getColumnIndexOrThrow(COL_SPELL_NAME)),
                        level = it.getInt(it.getColumnIndexOrThrow(COL_SPELL_LEVEL)),
                        school = it.getString(it.getColumnIndexOrThrow(COL_SPELL_SCHOOL)),
                        castingTime = it.getString(it.getColumnIndexOrThrow(COL_SPELL_CASTING_TIME)),
                        range = it.getString(it.getColumnIndexOrThrow(COL_SPELL_RANGE)),
                        duration = it.getString(it.getColumnIndexOrThrow(COL_SPELL_DURATION)),
                        description = it.getString(it.getColumnIndexOrThrow(COL_SPELL_DESCRIPTION)),
                        damage = it.getString(it.getColumnIndexOrThrow(COL_SPELL_DAMAGE)),
                        isCustom = it.getInt(it.getColumnIndexOrThrow(COL_SPELL_IS_CUSTOM)) == 1
                    )
                )
            }
        }
        return spells
    }

    // ========== МЕТОДЫ ДЛЯ ЗАМЕТОК ==========

    fun addNote(characterId: Int?, title: String, content: String): Long {
        val db = writableDatabase
        val now = System.currentTimeMillis()
        val values = ContentValues().apply {
            put(COL_NOTE_CHAR_ID, characterId)
            put(COL_NOTE_TITLE, title)
            put(COL_NOTE_CONTENT, content)
            put(COL_NOTE_CREATED_AT, now)
            put(COL_NOTE_UPDATED_AT, now)
        }
        return db.insert(TABLE_NOTES, null, values)
    }

    fun updateNote(note: Note): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_NOTE_TITLE, note.title)
            put(COL_NOTE_CONTENT, note.content)
            put(COL_NOTE_UPDATED_AT, System.currentTimeMillis())
        }
        return db.update(
            TABLE_NOTES,
            values,
            "$COL_NOTE_ID = ?",
            arrayOf(note.id.toString())
        )
    }



    fun getAllNotes(): List<Note> {
        val notes = mutableListOf<Note>()
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM $TABLE_NOTES ORDER BY $COL_NOTE_UPDATED_AT DESC",
            null
        )

        cursor.use {
            while (it.moveToNext()) {
                notes.add(
                    Note(
                        id = it.getInt(it.getColumnIndexOrThrow(COL_NOTE_ID)),
                        characterId = if (it.isNull(it.getColumnIndexOrThrow(COL_NOTE_CHAR_ID))) null
                        else it.getInt(it.getColumnIndexOrThrow(COL_NOTE_CHAR_ID)),
                        title = it.getString(it.getColumnIndexOrThrow(COL_NOTE_TITLE)),
                        content = it.getString(it.getColumnIndexOrThrow(COL_NOTE_CONTENT)),
                        createdAt = it.getLong(it.getColumnIndexOrThrow(COL_NOTE_CREATED_AT)),
                        updatedAt = it.getLong(it.getColumnIndexOrThrow(COL_NOTE_UPDATED_AT))
                    )
                )
            }
        }
        return notes
    }

    fun deleteNote(noteId: Int): Int {
        val db = writableDatabase
        return db.delete(
            TABLE_NOTES,
            "$COL_NOTE_ID = ?",
            arrayOf(noteId.toString())
        )
    }

    fun getNotesForCharacter(characterId: Int): List<Note> {
        val notes = mutableListOf<Note>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NOTES,
            null,
            "$COL_NOTE_CHAR_ID = ?",
            arrayOf(characterId.toString()),
            null, null, "$COL_NOTE_UPDATED_AT DESC"
        )

        cursor.use {
            while (it.moveToNext()) {
                notes.add(
                    Note(
                        id = it.getInt(it.getColumnIndexOrThrow(COL_NOTE_ID)),
                        characterId = it.getInt(it.getColumnIndexOrThrow(COL_NOTE_CHAR_ID)),
                        title = it.getString(it.getColumnIndexOrThrow(COL_NOTE_TITLE)),
                        content = it.getString(it.getColumnIndexOrThrow(COL_NOTE_CONTENT)),
                        createdAt = it.getLong(it.getColumnIndexOrThrow(COL_NOTE_CREATED_AT)),
                        updatedAt = it.getLong(it.getColumnIndexOrThrow(COL_NOTE_UPDATED_AT))
                    )
                )
            }
        }
        return notes
    }
}