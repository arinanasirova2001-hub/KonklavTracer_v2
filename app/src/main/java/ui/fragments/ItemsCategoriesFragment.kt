package com.example.konklavtracer_v2.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.ui.IngredientsListActivity
import com.example.konklavtracer_v2.ui.RunesListActivity

class ItemsCategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schools_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = listOf(
            ItemCategoryItem("Ингредиенты", "Травы, животные, особые"),
            ItemCategoryItem("Руны", "Выразимые и невыразимые")
        )

        val listView = view.findViewById<ListView>(R.id.lvSchools)
        val adapter = CategoryAdapter(categories)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val category = adapter.getItem(position) as ItemCategoryItem
            when (category.name) {
                "Ингредиенты" -> {
                    val intent = Intent(requireContext(), IngredientsListActivity::class.java)
                    startActivity(intent)
                }
                "Руны" -> {
                    val intent = Intent(requireContext(), RunesListActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private data class ItemCategoryItem(
        val name: String,
        val description: String
    )

    private inner class CategoryAdapter(
        private val items: List<ItemCategoryItem>
    ) : android.widget.BaseAdapter() {
        override fun getCount(): Int = items.size
        override fun getItem(position: Int): Any = items[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(requireContext()).inflate(
                R.layout.item_school,
                parent,
                false
            )

            val item = items[position]
            view.findViewById<TextView>(R.id.tvSchoolName).text = item.name
            view.findViewById<TextView>(R.id.tvSpellCount).text = item.description

            return view
        }
    }
}