package com.example.tindog

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

//ask for help about resolving these two reference
import com.google.firebase.database.ktx.database



class SlideScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_screen)

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

    fun User(name: String, surname: String, phoneNumber: String, email: String, password: String) {
        val getEmail = findViewById<EditText>(R.id.email_textField)
        val getPassword = findViewById<EditText>(R.id.password_textField)
        val getPhoneNumber = findViewById<EditText>(R.id.phoneNumber_textField)
        val getName = findViewById<EditText>(R.id.name_textField)
        val getSurname = findViewById<EditText>(R.id.surname_textField)
        val email = getEmail.text.toString()
        val password = getPassword.text.toString()
        val phoneNumber = getPhoneNumber.text.toString()
        val name = getName.text.toString()
        val surname = getSurname.text.toString()
    }
}
