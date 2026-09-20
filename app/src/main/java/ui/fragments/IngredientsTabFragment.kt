package com.example.konklavtracer_v2.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.IngredientDatabase
import com.example.konklavtracer_v2.models.Ingredient
import com.example.konklavtracer_v2.models.IngredientCategory

class IngredientsTabFragment : Fragment() {

    companion object {
        fun newInstance(categoryName: String): IngredientsTabFragment {
            return IngredientsTabFragment().apply {
                arguments = Bundle().apply {
                    putString("category", categoryName)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schools_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryName = arguments?.getString("category") ?: "HERB"
        val category = IngredientCategory.valueOf(categoryName)
        val ingredients = IngredientDatabase.getIngredientsByCategory(category)

        val listView = view.findViewById<ListView>(R.id.lvSchools)
        val adapter = IngredientAdapter(ingredients)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val ingredient = adapter.getItem(position) as Ingredient
            showIngredientDetail(ingredient)
        }
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

    private inner class IngredientAdapter(
        private val ingredients: List<Ingredient>
    ) : android.widget.BaseAdapter() {
        override fun getCount(): Int = ingredients.size
        override fun getItem(position: Int): Any = ingredients[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(requireContext()).inflate(
                R.layout.item_school,
                parent,
                false
            )

            val ingredient = ingredients[position]
            view.findViewById<TextView>(R.id.tvSchoolName).text = ingredient.name
            view.findViewById<TextView>(R.id.tvSpellCount).text = ingredient.properties.take(60) + "..."

            return view
        }
    }
}