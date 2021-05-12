package com.example.tindog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.core.view.View
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    // [START declare_auth]
    private lateinit var auth: FirebaseAuth
    // [END declare_auth]

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
    }

    fun register(view: android.view.View){
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

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                //l'utilisateur est bien Signed In mais le passage a la SlideScreenActivity ne marche pas
                val intent = Intent(this,SlideScreenActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }

    fun goToLogin(view: android.view.View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}