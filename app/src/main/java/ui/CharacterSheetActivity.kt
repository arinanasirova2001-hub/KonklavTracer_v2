package com.example.konklavtracer_v2.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.konklavtracer_v2.R
import com.example.konklavtracer_v2.data.DatabaseHelper
import com.example.konklavtracer_v2.ui.fragments.AbilitiesFragment
import com.example.konklavtracer_v2.ui.fragments.CharacterSheetFragment
import com.example.konklavtracer_v2.ui.fragments.InventoryFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

class CharacterSheetActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private var characterId: Int = -1
    private lateinit var viewPager: ViewPager2
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_sheet)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        dbHelper = DatabaseHelper(this)
        characterId = intent.getIntExtra("character_id", -1)

        if (characterId == -1) {
            finish()
            return
        }

        setupDrawer(toolbar)
        setupViewPager()
    }

    private fun setupDrawer(toolbar: Toolbar) {
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_character_sheet -> {
                    // Переключаемся на первую вкладку
                    viewPager.currentItem = 0
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.menu_knowledge_base -> {
                    // Открываем справочник
                    val intent = Intent(this, KnowledgeBaseActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.menu_notes -> {
                    // Открываем заметки
                    val intent = Intent(this, NotesActivity::class.java).apply {
                        putExtra("character_id", characterId)
                    }
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupViewPager() {
        viewPager = findViewById(R.id.viewPager)
        val adapter = ViewPagerAdapter(this)

        adapter.addFragment(CharacterSheetFragment.newInstance(characterId), "Лист")
        adapter.addFragment(AbilitiesFragment.newInstance(characterId), "Способности")
        adapter.addFragment(InventoryFragment.newInstance(characterId), "Инвентарь")

        viewPager.adapter = adapter

        TabLayoutMediator(findViewById(R.id.tabLayout), viewPager) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
    }



    private fun showDeleteConfirmation() {
        val dialog = android.app.Dialog(this).apply {
            setContentView(R.layout.dialog_delet_confirmation)
            window?.setBackgroundDrawable(
                android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT)
            )
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )

            findViewById<Button>(R.id.btnCancelDelete).setOnClickListener {
                dismiss()
            }

            findViewById<Button>(R.id.btnConfirmDelete).setOnClickListener {
                dbHelper.deleteCharacter(characterId)
                Toast.makeText(this@CharacterSheetActivity, "Персонаж удален", Toast.LENGTH_SHORT).show()
                finish()
                dismiss()
            }
        }
        dialog.show()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }
}

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = mutableListOf<Fragment>()
    private val titles = mutableListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    fun getTitle(position: Int): String = titles[position]

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}