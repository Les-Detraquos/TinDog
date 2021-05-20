package com.example.tindog

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

//ask for help about resolving these two reference
import com.google.firebase.database.ktx.database



class SlideScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_screen)



        //Page swipe
        val recyclerView2 = findViewById<RecyclerView>(R.id.recycler_viewSwipe)
        val listExampleSwipe = GénérationListDébile2(size=10)
        recyclerView2.layoutManager = LinearLayoutManager (this)
        recyclerView2.adapter = AdapterRclVwSwipe(listExampleSwipe)

    }
    //code needed to write one time in the database the animal's information needed for the recycler view


    fun GénérationListDébile2(size: Int): List<RclVwSwipe>{

        val list2 = ArrayList<RclVwSwipe>()

        for (i in 0 until size) {
            val drawable = when (i / 1) {
                0 -> R.drawable.chat14
                1 -> R.drawable.chat15
                2 -> R.drawable.chat16
                3 -> R.drawable.chat17
                4 -> R.drawable.chien17
                5 -> R.drawable.teterouge
                6 -> R.drawable.couza
                7 -> R.drawable.nezmoche
                8 -> R.drawable.marsupial
                9 -> R.drawable.chouettecheum
                else -> null
            }

            val item2 = drawable?.let { RclVwSwipe(it, textnom = "Nom $i") }

            if (item2 != null) {
                list2.add(item2)
            }
        }
        return list2
    }

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
