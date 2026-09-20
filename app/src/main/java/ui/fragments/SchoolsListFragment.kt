package com.example.konklavtracer_v2.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.SpellDatabase
import com.example.konklavtracer_v2.models.MagicCategory
import com.example.konklavtracer_v2.models.MagicSchool
import com.example.konklavtracer_v2.ui.SchoolDetailActivity

class SchoolsListFragment : Fragment() {

    companion object {
        fun newInstance(categoryName: String): SchoolsListFragment {
            return SchoolsListFragment().apply {
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

        val categoryName = arguments?.getString("category") ?: "BRANCH"
        val category = MagicCategory.valueOf(categoryName)

        val items = mutableListOf<Any>()

        if (category == MagicCategory.BRANCH) {
            items.add("Базовые ветви")
            items.addAll(SpellDatabase.basicBranchSchools)
            items.add("Специалитеты")
            items.addAll(SpellDatabase.specializationSchools)
        } else if (category == MagicCategory.FORBIDDEN) {
            // Для запрещённой магии показываем Вуду как одну школу
            items.addAll(SpellDatabase.forbiddenSchools)
        } else {
            items.addAll(SpellDatabase.getSchoolsByCategory(category))
        }

        val listView = view.findViewById<ListView>(R.id.lvSchools)
        val adapter = SchoolListAdapter(items)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = adapter.getItem(position)
            if (item is MagicSchool) {
                val intent = Intent(requireContext(), SchoolDetailActivity::class.java).apply {
                    putExtra("school_id", item.id)
                }
                startActivity(intent)
            }
        }
    }

    private inner class SchoolListAdapter(private val items: List<Any>) : BaseAdapter() {
        override fun getCount(): Int = items.size
        override fun getItem(position: Int): Any = items[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val item = items[position]

            return if (item is String) {
                // Заголовок
                val view = LayoutInflater.from(requireContext()).inflate(
                    android.R.layout.simple_list_item_1,
                    parent,
                    false
                )
                (view as TextView).apply {
                    text = item
                    textSize = 20f
                    setTextColor(requireContext().getColor(R.color.bir))
                    setTypeface(null, android.graphics.Typeface.BOLD)
                    setPadding(16, 24, 16, 12)
                }
                view
            } else {
                // Школа
                val school = item as MagicSchool
                val view = LayoutInflater.from(requireContext()).inflate(
                    R.layout.item_school,
                    parent,
                    false
                )
                view.findViewById<TextView>(R.id.tvSchoolName).text = school.name
                view.findViewById<TextView>(R.id.tvSpellCount).text = "${school.spells.size} заклинаний"
                view
            }
        }
    }
}