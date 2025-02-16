package com.anasbinrashid.i220907

import GridAdapter
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
import java.util.Arrays


class AddActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        applyRoundedCornersToAllImages(findViewById(R.id.main))

        gridView = findViewById<View>(R.id.gridView) as GridView?
        adapter = GridAdapter(this, imageList)
        gridView?.setAdapter(adapter)


        val cross = findViewById<ImageView>(R.id.cross)

        cross.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val next = findViewById<TextView>(R.id.next)

        next.setOnClickListener{
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }
        val cam = findViewById<ImageView>(R.id.cam)

        cam.setOnClickListener{
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}