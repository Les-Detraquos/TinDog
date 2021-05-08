package com.example.tindog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SlideScreenActivity : AppCompatActivity() {
    val name_animal = findViewById<TextView>(R.id.name_animal)
    val yes_button = findViewById<ImageView>(R.id.no_button)
    val no_button = findViewById<ImageView>(R.id.yes_button)


    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference()
    var nameAnimal = myRef.child("name_animal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_screen)

        val button = findViewById<ImageView>(R.id.settings)
        button.setOnClickListener {
            val intent =  Intent(this, UserScreenActivity::class.java)

            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        nameAnimal.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val text =
                    dataSnapshot.getValue(String::class.java)!!
                name_animal.text = text
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        //code en java a convertir en kt : tentative de passer au prochain
        //nom d'animal en cliquant sur le no_button ou le yes_button

        //no_button.setOnClickListener(new View.OnClickListener(){
            //@Override
            //public void onClick(View view){
                //nameAnimal.setValue()
            //}
        //})
    }
}