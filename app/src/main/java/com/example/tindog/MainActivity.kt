package com.example.tindog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
    }

    fun login(view: android.view.View){
        val getEmailLogin = findViewById<EditText>(R.id.email)
        val getPasswordLogin = findViewById<EditText>(R.id.password)
        val emailLogin = getEmailLogin.text.toString()
        val passwordLogin = getPasswordLogin.text.toString()

        auth.signInWithEmailAndPassword(emailLogin,passwordLogin).addOnCompleteListener { task ->
            if(task.isSuccessful){
                //l'utilisateur est bien Signed In mais le passage a la SlideScreenActivity ne marche pas
                val intent = Intent(this,SlideScreenActivity::class.java)
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