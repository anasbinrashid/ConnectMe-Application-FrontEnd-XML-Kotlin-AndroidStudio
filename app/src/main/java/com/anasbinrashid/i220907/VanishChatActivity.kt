package com.anasbinrashid.i220907

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VanishChatActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_vanish_chat)
        applyRoundedCornersToAllImages(findViewById(R.id.main))

        val scrollView = findViewById<ScrollView>(R.id.chats)
        scrollView.post {
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
        }

        val back = findViewById<ImageView>(R.id.back_button)
        back.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        val vp = findViewById<Button>(R.id.vp)
        vp.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}