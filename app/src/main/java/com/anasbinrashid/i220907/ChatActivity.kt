@file:Suppress("DEPRECATION")

package com.anasbinrashid.i220907

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class ChatActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetector

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)

        gestureDetector = GestureDetector(this, this)

        val scrollView = findViewById<ScrollView>(R.id.chats)
        scrollView.post {
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
        }

        val back = findViewById<ImageView>(R.id.back_button)
        back.setOnClickListener {
            val intent = Intent(this, DMListActivity::class.java)
            startActivity(intent)
        }

        val call = findViewById<ImageView>(R.id.call)
        call.setOnClickListener {
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
        }

        val vcall = findViewById<ImageView>(R.id.vcall)
        vcall.setOnClickListener {
            val intent = Intent(this, VideoCallActivity::class.java)
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

        val rootView = findViewById<View>(R.id.main)
        rootView.setOnTouchListener { _, event -> gestureDetector.onTouchEvent(event) }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return event?.let { gestureDetector.onTouchEvent(it) } == true || super.onTouchEvent(event)
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (e1 != null) {
            val deltaY = e2.y - e1.y
            if (deltaY > 150) {
                val intent = Intent(this, VanishChatActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return false
    }

    override fun onDown(e: MotionEvent): Boolean = false
    override fun onShowPress(e: MotionEvent) {}
    override fun onSingleTapUp(e: MotionEvent): Boolean = false
    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean = false
    override fun onLongPress(e: MotionEvent) {}
}
