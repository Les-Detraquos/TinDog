package com.example.tindog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_screen)

        val button = findViewById<Button>(R.id.button_returnMatching)
        button.setOnClickListener {
            val intent =  Intent(this, SlideScreenActivity::class.java)

            startActivity(intent) }
    }
}