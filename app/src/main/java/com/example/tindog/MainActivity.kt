package com.example.tindog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.core.view.View
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    // [START declare_auth]
    private lateinit var auth: FirebaseAuth
    // [END declare_auth]

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        // page option
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val ListExample = GénérationListDébile(size = 50)
        recyclerView.adapter = AdapterRclVwOptions(ListExample)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //Page swipe
        val recyclerView2 = findViewById<RecyclerView>(R.id.recycler_viewSwipe)
        val ListExampleSwipe = GénérationListDébile2(size=10)
        recyclerView2.adapter = AdapterRclVwSwipe(ListExampleSwipe)
        recyclerView2.layoutManager = LinearLayoutManager (this)
        recyclerView2.setHasFixedSize(true)
    }

    private fun GénérationListDébile(size: Int): List<RclVwOptions>{

        val list = ArrayList<RclVwOptions>()

        for (i in 0 until size){
            val logo = R.drawable.ic_clef_marteau
            val item = RclVwOptions(logo, text1 = "Item $i")
            list += item


        }
        return list
    }

    private fun GénérationListDébile2(size: Int): List<RclVwSwipe>{

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
            val item2 = RclVwSwipe(drawable, textnom = "Nom $i")

            list2 += item2
        }





        return list2
    }


    fun login(view: android.view.View){
        val getEmailLogin = findViewById<EditText>(R.id.email)
        val getPasswordLogin = findViewById<EditText>(R.id.password)
        val emailLogin = getEmailLogin.text.toString()
        val passwordLogin = getPasswordLogin.text.toString()

        auth.signInWithEmailAndPassword(emailLogin,passwordLogin).addOnCompleteListener { task ->
            if(task.isSuccessful){
                setContentView(R.layout.activity_slide_screen)
                val intent = Intent(this,SlideScreenActivity::class.java)
                setContentView(R.layout.activity_slide_screen)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG)
        }
    }

    fun goToRegister(view: android.view.View){
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }
}