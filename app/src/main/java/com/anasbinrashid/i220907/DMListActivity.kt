package com.anasbinrashid.i220907

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DMListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dmlist)

        val flg = findViewById<ImageView>(R.id.back_button)

        flg.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val req = findViewById<TextView>(R.id.requests)

        req.setOnClickListener {
            val intent = Intent(this, RequestsActivity::class.java)
            startActivity(intent)
        }

        val c1 = findViewById<RelativeLayout>(R.id.chat1)

        c1.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        val c2 = findViewById<RelativeLayout>(R.id.chat2)

        c2.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        val c3 = findViewById<RelativeLayout>(R.id.chat3)

        c3.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        val c4 = findViewById<RelativeLayout>(R.id.chat4)

        c4.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        val c5 = findViewById<RelativeLayout>(R.id.chat5)

        c5.setOnClickListener {
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