package com.example.tindog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SlideScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_screen)

        val button = findViewById<ImageView>(R.id.settings)
        button.setOnClickListener {
            val intent =  Intent(this, UserScreenActivity::class.java)

            startActivity(intent)
        }
    }
}