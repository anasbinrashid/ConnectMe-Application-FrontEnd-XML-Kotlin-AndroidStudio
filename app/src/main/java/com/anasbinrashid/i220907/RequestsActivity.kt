package com.anasbinrashid.i220907

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RequestsActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_requests)
        applyRoundedCornersToAllImages(findViewById(R.id.main))

        val flg = findViewById<ImageView>(R.id.back_button)

        flg.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val req = findViewById<TextView>(R.id.dms)

        req.setOnClickListener {
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