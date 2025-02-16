@file:Suppress("DEPRECATION")

package com.anasbinrashid.i220907

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SearchActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var rvRecentSearches: RecyclerView
    private lateinit var searchAdapter: SearchAdapter
    private val recentSearches = mutableListOf("Anas Bin Rashid", "Lionel Messi", "Babar Azam")

    private fun applyRoundedCornersToAllImages(rootView: View) {
        if (rootView is ImageView) {
            rootView.outlineProvider = ViewOutlineProvider.BACKGROUND
            rootView.clipToOutline = true
        } else if (rootView is ViewGroup) {
            for (i in 0 until rootView.childCount) {
                applyRoundedCornersToAllImages(rootView.getChildAt(i))
            }
        }
    }

    private fun setupRecyclerView() {
        rvRecentSearches.layoutManager = LinearLayoutManager(this)
        searchAdapter = SearchAdapter(recentSearches)
        rvRecentSearches.adapter = searchAdapter
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        applyRoundedCornersToAllImages(findViewById(R.id.main))

        rvRecentSearches = findViewById(R.id.searches)
        etSearch = findViewById(R.id.search_bar)
        setupRecyclerView()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val selectedItemId = intent.getIntExtra("selectedItemId", R.id.navigation_search)
        bottomNavigationView.selectedItemId = selectedItemId

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("selectedItemId", R.id.navigation_home)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_search -> true
                R.id.navigation_add -> true
                R.id.navigation_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("selectedItemId", R.id.navigation_profile)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_contacts -> {
                    val intent = Intent(this, ContactsActivity::class.java)
                    intent.putExtra("selectedItemId", R.id.navigation_contacts)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }

        val add = findViewById<FloatingActionButton>(R.id.add)
        add.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                searchAdapter.filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}