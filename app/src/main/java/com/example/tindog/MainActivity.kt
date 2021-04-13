package com.example.tindog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val button = findViewById<Button>(R.id.button_login)
        button.setOnClickListener {
            val intent =  Intent(this, SlideScreenActivity::class.java)

            startActivity(intent)
        }

        val button2 = findViewById<TextView>(R.id.signUp)
        button2.setOnClickListener {
            val intent =  Intent(this, SignUpActivity::class.java)

            startActivity(intent)
        }
    }
}