@file:Suppress("DEPRECATION")

package com.anasbinrashid.i220907

import GridAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Arrays

class ProfileActivity : AppCompatActivity() {

    private var gridView: GridView? = null
    private var adapter: GridAdapter? = null
    private val imageList: List<Int> = Arrays.asList(
        R.drawable.anas, R.drawable.anas, R.drawable.anas, R.drawable.anas,
        R.drawable.anas, R.drawable.anas, R.drawable.anas, R.drawable.anas,
        R.drawable.anas, R.drawable.anas, R.drawable.anas, R.drawable.anas,
        R.drawable.anas, R.drawable.anas, R.drawable.anas, R.drawable.anas,
        R.drawable.anas, R.drawable.anas, R.drawable.anas
    )

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
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        applyRoundedCornersToAllImages(findViewById(R.id.main))

        gridView = findViewById<View>(R.id.gridView) as GridView?
        adapter = GridAdapter(this, imageList)
        gridView?.setAdapter(adapter)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val selectedItemId = intent.getIntExtra("selectedItemId", R.id.navigation_profile)
        bottomNavigationView.selectedItemId = selectedItemId

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("selectedItemId", R.id.navigation_home)
                    startActivity(intent)
                    true
                }

                R.id.navigation_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra("selectedItemId", R.id.navigation_search)
                    startActivity(intent)
                    true
                }

                R.id.navigation_add -> {
                    true
                }

                R.id.navigation_profile -> {
                    true
                }

                R.id.navigation_contacts -> {
                    val intent = Intent(this, ContactsActivity::class.java)
                    intent.putExtra("selectedItemId", R.id.navigation_contacts)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

        val flr = findViewById<TextView>(R.id.followersCount)

        flr.setOnClickListener {
            val intent = Intent(this, FollowersActivity::class.java)
            startActivity(intent)
        }

        val flr2 = findViewById<TextView>(R.id.followersCount2)

        flr2.setOnClickListener {
            val intent = Intent(this, FollowersActivity::class.java)
            startActivity(intent)
        }

        val flg = findViewById<TextView>(R.id.followingCount)

        flg.setOnClickListener {
            val intent = Intent(this, FollowingActivity::class.java)
            startActivity(intent)
        }

        val flg2 = findViewById<TextView>(R.id.followingCount2)

        flg2.setOnClickListener {
            val intent = Intent(this, FollowingActivity::class.java)
            startActivity(intent)
        }

        val edit = findViewById<ImageView>(R.id.editbutton)

        edit.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        val add = findViewById<FloatingActionButton>(R.id.add)

        add.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}