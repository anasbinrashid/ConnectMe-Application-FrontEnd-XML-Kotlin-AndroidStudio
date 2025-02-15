@file:Suppress("DEPRECATION")

package com.anasbinrashid.i220907

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        var rv = findViewById<RecyclerView>(R.id.post)
        var list = mutableListOf<Model>()
        list.add(Model("Anas Bin Rashid", "Anas Bin Rashid", "Hello Everyone!!"))
        list.add(Model("Babar Azam", "Babar Azam", "AssalamoAlaikum!!"))
        list.add(Model("Lionel Messi", "Lionel Messi", "Hola Amigos!!"))

        var adapter = MyAdapter(list)
        rv.adapter = adapter

        var ln = LinearLayoutManager(this)
        rv.layoutManager=ln
        rv.adapter=adapter

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val selectedItemId = intent.getIntExtra("selectedItemId", R.id.navigation_home)
        bottomNavigationView.selectedItemId = selectedItemId

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra("selectedItemId", R.id.navigation_search)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_add -> {
                    true
                }
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

        add.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        val dm = findViewById<ImageView>(R.id.dmlist)

        dm.setOnClickListener {
            val intent = Intent(this, DMListActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}