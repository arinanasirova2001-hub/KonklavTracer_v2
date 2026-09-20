package com.example.konklavtracer_v2.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.RuneDatabase
import com.example.konklavtracer_v2.models.Runes
import com.example.konklavtracer_v2.models.RunesCategory

class RunesTabFragment : Fragment() {

    companion object {
        fun newInstance(categoryName: String): RunesTabFragment {
            return RunesTabFragment().apply {
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

        val categoryName = arguments?.getString("category") ?: "PRON"
        val category = RunesCategory.valueOf(categoryName)
        val runes = RuneDatabase.getRunesByCategory(category)

        val listView = view.findViewById<ListView>(R.id.lvSchools)
        val adapter = RuneAdapter(runes)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val rune = adapter.getItem(position) as Runes
            showRuneDetail(rune)
        }
    }

    private fun showRuneDetail(rune: Runes) {
        val dialog = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_rune_detail)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<TextView>(R.id.tvRuneName).text = rune.name
        dialog.findViewById<TextView>(R.id.tvRuneSymbol).text = rune.symbol
        dialog.findViewById<TextView>(R.id.tvRuneDescription).text = rune.description

        dialog.findViewById<Button>(R.id.btnCloseRune).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private inner class RuneAdapter(
        private val runes: List<Runes>
    ) : android.widget.BaseAdapter() {
        override fun getCount(): Int = runes.size
        override fun getItem(position: Int): Any = runes[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(requireContext()).inflate(
                R.layout.item_school,
                parent,
                false
            )

            val rune = runes[position]
            view.findViewById<TextView>(R.id.tvSchoolName).text = rune.name
            view.findViewById<TextView>(R.id.tvSpellCount).text = rune.description.take(60) + "..."

            return view
        }
    }
}