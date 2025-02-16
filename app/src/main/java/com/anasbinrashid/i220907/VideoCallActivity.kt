package com.anasbinrashid.i220907

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VideoCallActivity : AppCompatActivity() {
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_video_call)
        applyRoundedCornersToAllImages(findViewById(R.id.main))

        val done = findViewById<ImageView>(R.id.end)

        done.setOnClickListener {
            Toast.makeText(this, "Call Ended!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}