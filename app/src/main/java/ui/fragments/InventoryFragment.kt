package com.example.konklavtracer_v2.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.DatabaseHelper
import com.example.konklavtracer_v2.models.InventoryItem
import com.example.konklavtracer_v2.models.ItemCategory
import com.example.konklavtracer_v2.utils.DialogUtils
import kotlin.math.max

class InventoryFragment : Fragment() {
    private lateinit var dbHelper: DatabaseHelper
    private var characterId: Int = -1
    private lateinit var adapter: InventoryAdapter

    private lateinit var spinnerCategory: Spinner
    private val categories = mutableListOf<ItemCategory>()
    private var selectedCategoryId: Int? = null

    private var filterEquippedOnly = false

    companion object {
        fun newInstance(characterId: Int): InventoryFragment {
            return InventoryFragment().apply {
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
        return inflater.inflate(R.layout.fragment_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterId = arguments?.getInt("character_id") ?: -1
        dbHelper = DatabaseHelper(requireContext())

        spinnerCategory = view.findViewById(R.id.spinnerCategory)

        // Обработка фильтра "Только экипированное"
        val cbFilterEquipped = view.findViewById<CheckBox>(R.id.cbFilterEquipped)
        cbFilterEquipped.setOnCheckedChangeListener { _, isChecked ->
            filterEquippedOnly = isChecked
            refreshInventory()
        }

        setupCategorySpinner()
        setupAddCategoryButton()
        setupDeleteCategoryButton()
        setupListView()
        setupAddButton()
    }

    override fun onResume() {
        super.onResume()
        loadCategories()
        refreshInventory()
    }

    // ========== КАТЕГОРИИ ==========

    private fun setupCategorySpinner() {
        loadCategories()
    }

    private fun loadCategories() {
        categories.clear()
        categories.addAll(dbHelper.getCategories(characterId))

        val categoryNames = mutableListOf("Все предметы")
        categoryNames.addAll(categories.map { it.name })

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            categoryNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedCategoryId = if (position == 0) {
                    null
                } else {
                    categories[position - 1].id
                }
                refreshInventory()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }




    private fun setupAddCategoryButton() {
        view?.findViewById<Button>(R.id.btnAddCategory)?.setOnClickListener {
            showAddCategoryDialog()
        }
    }

    private fun showAddCategoryDialog() {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_add_category)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<Button>(R.id.btnCancelCategory).setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.btnSaveCategory).setOnClickListener {
            val categoryName = dialog.findViewById<EditText>(R.id.etCategoryName)
                .text.toString().trim()

            if (categoryName.isEmpty()) {
                Toast.makeText(requireContext(), "Введите название папки", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            dbHelper.addCategory(characterId, categoryName)
            loadCategories()
            dialog.dismiss()
            Toast.makeText(requireContext(), "Папка создана", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }


    private fun setupDeleteCategoryButton() {
        view?.findViewById<Button>(R.id.btnDeleteCategory)?.setOnClickListener {
            if (selectedCategoryId == null) {
                Toast.makeText(
                    requireContext(),
                    "Сначала выберите папку для удаления",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val category = categories.find { it.id == selectedCategoryId }
            if (category != null) {
                showDeleteCategoryConfirmation(category)
            }
        }
    }

    private fun showDeleteCategoryConfirmation(category: ItemCategory) {
        DialogUtils.showDeleteDialog(
            context = requireContext(),
            title = "Удалить папку?",
            message = "Папка \"${category.name}\" будет удалена. Предметы внутри останутся без категории.",
            onConfirm = {
                dbHelper.deleteCategory(category.id)
                selectedCategoryId = null
                loadCategories()
                refreshInventory()
                Toast.makeText(requireContext(), "Папка удалена", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun showDeleteCategoryDialog(category: ItemCategory) {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_delet_confirmation)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            findViewById<Button>(R.id.btnCancelDelete).setOnClickListener {
                dismiss()
            }

            findViewById<Button>(R.id.btnConfirmDelete).setOnClickListener {
                dbHelper.deleteCategory(category.id)
                loadCategories()
                dismiss()
                Toast.makeText(requireContext(), "Папка удалена", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }

    // ========== ИНВЕНТАРЬ ==========

    private fun setupListView() {
        val inventory = dbHelper.getInventory(characterId)
        adapter = InventoryAdapter(requireContext(), inventory)

        view?.findViewById<ListView>(R.id.lvInventory)?.apply {
            adapter = this@InventoryFragment.adapter

            setOnItemClickListener { _, _, position, _ ->
                val item = adapter.getItem(position) as InventoryItem
                showEditItemDialog(item)
            }

            setOnItemLongClickListener { _, _, position, _ ->
                val item = adapter.getItem(position) as InventoryItem
                showDeleteConfirmation(item)
                true
            }
        }
    }

    private fun setupAddButton() {
        view?.findViewById<Button>(R.id.btnAddItem)?.setOnClickListener {
            showAddItemDialog()
        }
    }

    private fun showAddItemDialog() {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_add_item)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        var quantity = 1
        val tvQuantity = dialog.findViewById<TextView>(R.id.tvQuantity)

        // Настраиваем Spinner для категорий
        val spinnerItemCategory = dialog.findViewById<Spinner>(R.id.spinnerItemCategory)
        val categoryNames = mutableListOf("Без категории")
        categoryNames.addAll(categories.map { it.name })

        val categoryAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            categoryNames
        )
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerItemCategory.adapter = categoryAdapter

        // Если выбрана категория в основном окне, выбираем её
        if (selectedCategoryId != null) {
            val position = categories.indexOfFirst { it.id == selectedCategoryId }
            if (position >= 0) {
                spinnerItemCategory.setSelection(position + 1)
            }
        }

        dialog.findViewById<Button>(R.id.btnMinusQuantity).setOnClickListener {
            quantity = max(1, quantity - 1)
            tvQuantity.text = quantity.toString()
        }

        dialog.findViewById<Button>(R.id.btnPlusQuantity).setOnClickListener {
            quantity++
            tvQuantity.text = quantity.toString()
        }

        dialog.findViewById<Button>(R.id.btnCancelAdd).setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.btnConfirmAdd).setOnClickListener {
            val name = dialog.findViewById<EditText>(R.id.etItemName).text.toString().trim()
            val description = dialog.findViewById<EditText>(R.id.etItemDescription).text.toString().trim()
            val isEquipped = dialog.findViewById<CheckBox>(R.id.cbEquipped).isChecked

            // Определяем выбранную категорию
            val selectedPosition = spinnerItemCategory.selectedItemPosition
            val categoryId = if (selectedPosition > 0) {
                categories[selectedPosition - 1].id
            } else {
                null
            }

            if (name.isEmpty()) {
                Toast.makeText(requireContext(), "Введите название предмета", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            dbHelper.addItemToInventory(
                characterId = characterId,
                itemName = name,
                description = description,
                quantity = quantity,
                isEquipped = isEquipped,
                categoryId = categoryId
            )

            refreshInventory()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showEditItemDialog(item: InventoryItem) {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_add_item)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        // Заполняем текущие значения
        dialog.findViewById<EditText>(R.id.etItemName).setText(item.name)
        dialog.findViewById<EditText>(R.id.etItemDescription).setText(item.description)
        dialog.findViewById<CheckBox>(R.id.cbEquipped).isChecked = item.isEquipped

        // Настраиваем Spinner для категорий
        val spinnerItemCategory = dialog.findViewById<Spinner>(R.id.spinnerItemCategory)
        val categoryNames = mutableListOf("Без категории")
        categoryNames.addAll(categories.map { it.name })

        val categoryAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            categoryNames
        )
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerItemCategory.adapter = categoryAdapter

        // Устанавливаем текущую категорию
        if (item.categoryId != null) {
            val position = categories.indexOfFirst { it.id == item.categoryId }
            if (position >= 0) {
                spinnerItemCategory.setSelection(position + 1)
            }
        }

        var quantity = item.quantity
        val tvQuantity = dialog.findViewById<TextView>(R.id.tvQuantity)
        tvQuantity.text = quantity.toString()

        dialog.findViewById<Button>(R.id.btnMinusQuantity).setOnClickListener {
            quantity = max(1, quantity - 1)
            tvQuantity.text = quantity.toString()
        }

        dialog.findViewById<Button>(R.id.btnPlusQuantity).setOnClickListener {
            quantity++
            tvQuantity.text = quantity.toString()
        }

        dialog.findViewById<Button>(R.id.btnCancelAdd).setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.btnConfirmAdd).setOnClickListener {
            val name = dialog.findViewById<EditText>(R.id.etItemName).text.toString().trim()
            val description = dialog.findViewById<EditText>(R.id.etItemDescription).text.toString().trim()
            val isEquipped = dialog.findViewById<CheckBox>(R.id.cbEquipped).isChecked

            // Определяем выбранную категорию
            val selectedPosition = spinnerItemCategory.selectedItemPosition
            val categoryId = if (selectedPosition > 0) {
                categories[selectedPosition - 1].id
            } else {
                null
            }

            if (name.isEmpty()) {
                Toast.makeText(requireContext(), "Введите название предмета", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val updatedItem = item.copy(
                name = name,
                description = description,
                quantity = quantity,
                isEquipped = isEquipped,
                categoryId = categoryId
            )

            dbHelper.updateInventoryItem(updatedItem)
            refreshInventory()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showDeleteConfirmation(item: InventoryItem) {
        DialogUtils.showDeleteDialog(
            context = requireContext(),
            title = "Удалить предмет?",
            message = "Предмет \"${item.name}\" будет удалён.",
            onConfirm = {
                dbHelper.deleteInventoryItem(item.id)
                refreshInventory()
            }
        )
    }

    private fun refreshInventory() {
        val allItems = dbHelper.getInventory(characterId)

        val filteredItems = allItems.filter { item ->
            val categoryMatch = selectedCategoryId == null || item.categoryId == selectedCategoryId
            val equippedMatch = !filterEquippedOnly || item.isEquipped
            categoryMatch && equippedMatch
        }

        adapter.clear()
        adapter.addAll(filteredItems)
        adapter.notifyDataSetChanged()
    }

    // Адаптер для инвентаря
    private class InventoryAdapter(
        context: android.content.Context,
        items: List<InventoryItem>
    ) : android.widget.ArrayAdapter<InventoryItem>(
        context,
        R.layout.item_inventory,
        items
    ) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(
                R.layout.item_inventory,
                parent,
                false
            )

            val item = getItem(position) ?: return view

            view.findViewById<TextView>(R.id.tvItemName).text = item.name

            val tvQuantity = view.findViewById<TextView>(R.id.tvItemQuantity)
            tvQuantity.text = "x${item.quantity}"

            val tvDescription = view.findViewById<TextView>(R.id.tvItemDescription)
            if (item.description.isNotEmpty()) {
                tvDescription.text = item.description
                tvDescription.visibility = View.VISIBLE
            } else {
                tvDescription.visibility = View.GONE
            }

            val tvEquipped = view.findViewById<TextView>(R.id.tvItemEquipped)
            if (item.isEquipped) {
                tvEquipped.visibility = View.VISIBLE
            } else {
                tvEquipped.visibility = View.GONE
            }

            return view
        }
    }
}