package com.example.tindog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

//ask for help about resolving these two reference
import com.google.firebase.database.ktx.database
import com.google.firebase.referencecode.database.models.User


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
    //code needed to write one time in the database the animal's information needed for the recycler view

    //declare database ref
    private lateinit var database: DatabaseReference

    //initialize database ref
    fun initializeDbRef() {
        database = Firebase.database.reference
    }

    // writing new user in database
    fun writeNewUser(animalID: String, name: String, race: String, breed: String, age: String, city: String) {
        val user = User(name, race, breed, age, city)
        database.child("animals").child(animalID).setValue(user)
    }
}
