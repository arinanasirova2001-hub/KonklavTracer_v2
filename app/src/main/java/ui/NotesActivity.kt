package com.example.konklavtracer_v2.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.DatabaseHelper
import com.example.konklavtracer_v2.models.Note
import com.example.konklavtracer_v2.utils.DialogUtils

class NotesActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private var characterId: Int = -1
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        characterId = intent.getIntExtra("character_id", -1)
        dbHelper = DatabaseHelper(this)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Заметки"

        setupListView()
        setupAddButton()
    }

    override fun onResume() {
        super.onResume()
        refreshNotes()
    }

    private fun setupListView() {
        val notes = getNotesList()
        adapter = NoteAdapter(this, notes)

        findViewById<ListView>(R.id.lvNotes).apply {
            adapter = this@NotesActivity.adapter

            setOnItemClickListener { _, _, position, _ ->
                val note = adapter.getItem(position) as Note
                showEditNoteDialog(note)
            }

            setOnItemLongClickListener { _, _, position, _ ->
                val note = adapter.getItem(position) as Note
                showDeleteConfirmation(note)
                true
            }
        }
    }

    private fun setupAddButton() {
        findViewById<Button>(R.id.btnAddNote).setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun getNotesList(): List<Note> {
        return if (characterId != -1) {
            dbHelper.getNotesForCharacter(characterId)
        } else {
            dbHelper.getAllNotes()
        }
    }

    private fun showAddNoteDialog() {
        val dialog = Dialog(this).apply {
            setContentView(R.layout.dialog_add_note)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<Button>(R.id.btnCancelNote).setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.btnSaveNote).setOnClickListener {
            val title = dialog.findViewById<EditText>(R.id.etNoteTitle).text.toString().trim()
            val content = dialog.findViewById<EditText>(R.id.etNoteContent).text.toString().trim()

            if (title.isEmpty()) {
                Toast.makeText(this, "Введите заголовок", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val noteCharacterId = if (characterId != -1) characterId else null
            dbHelper.addNote(noteCharacterId, title, content)
            refreshNotes()
            dialog.dismiss()
            Toast.makeText(this, "Заметка создана", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }

    private fun showEditNoteDialog(note: Note) {
        val dialog = Dialog(this).apply {
            setContentView(R.layout.dialog_add_note)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        dialog.findViewById<EditText>(R.id.etNoteTitle).setText(note.title)
        dialog.findViewById<EditText>(R.id.etNoteContent).setText(note.content)

        dialog.findViewById<Button>(R.id.btnCancelNote).setOnClickListener {
            dialog.dismiss()
        }

        dialog.findViewById<Button>(R.id.btnSaveNote).setOnClickListener {
            val title = dialog.findViewById<EditText>(R.id.etNoteTitle).text.toString().trim()
            val content = dialog.findViewById<EditText>(R.id.etNoteContent).text.toString().trim()

            if (title.isEmpty()) {
                Toast.makeText(this, "Введите заголовок", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val updatedNote = note.copy(
                title = title,
                content = content
            )

            dbHelper.updateNote(updatedNote)
            refreshNotes()
            dialog.dismiss()
            Toast.makeText(this, "Заметка обновлена", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }



    private fun showDeleteConfirmation(note: Note) {
        DialogUtils.showDeleteDialog(
            context = this,
            title = "Удалить заметку?",
            message = "Заметка \"${note.title}\" будет удалена.",
            onConfirm = {
                dbHelper.deleteNote(note.id)
                refreshNotes()
            }
        )
    }

    private fun refreshNotes() {
        adapter.clear()
        adapter.addAll(getNotesList())
        adapter.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Адаптер для заметок
    private class NoteAdapter(
        context: android.content.Context,
        notes: List<Note>
    ) : android.widget.ArrayAdapter<Note>(
        context,
        R.layout.item_note,
        notes
    ) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(
                R.layout.item_note,
                parent,
                false
            )

            val note = getItem(position) ?: return view

            view.findViewById<TextView>(R.id.tvNoteTitle).text = note.title

            val tvPreview = view.findViewById<TextView>(R.id.tvNotePreview)
            if (note.content.isNotEmpty()) {
                tvPreview.text = note.content
                tvPreview.visibility = View.VISIBLE
            } else {
                tvPreview.visibility = View.GONE
            }

            return view
        }
    }
}