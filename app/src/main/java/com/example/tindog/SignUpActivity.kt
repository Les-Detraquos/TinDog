package com.example.tindog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val button = findViewById<Button>(R.id.button_saveAccount)
        button.setOnClickListener {
            val intent =  Intent(this, SlideScreenActivity::class.java)

            startActivity(intent)
        }
    }
}