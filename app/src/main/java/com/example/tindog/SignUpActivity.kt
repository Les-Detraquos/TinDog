package com.example.tindog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

//ask for help about resolving these two reference
import com.google.firebase.database.ktx.database
import com.google.firebase.storage.ktx.storage


class SignUpActivity : AppCompatActivity() {

    // [START declare_auth]
    private lateinit var auth: FirebaseAuth
    // [END declare_auth]

    // [START storage_field_declaration]
    lateinit var storage: FirebaseStorage
    // [END storage_field_declaration]

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        // [START storage_field_initialization]
        storage = Firebase.storage
        // [END storage_field_initialization]
    }

    fun register(view: View){
        val getEmail = findViewById<EditText>(R.id.email_textField)
        val getPassword = findViewById<EditText>(R.id.password_textField)
        val email = getEmail.text.toString()
        val password = getPassword.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                setContentView(R.layout.activity_slide_screen)
                val intent = Intent(this,SlideScreenActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }

    fun goToLogin(view: View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    //declare database ref
    private lateinit var database: DatabaseReference

    //initialize database ref
    fun initializeDbRef() {
        database = Firebase.database.reference
    }

    // writing new user in database
    fun writeNewUser(userId: String, name: String, surname: String, phoneNumber: String, email: String, password: String) {
        val user = User(name, surname, phoneNumber, email, password)
        database.child("users").child(userId).setValue(user)
    }

    fun downloadAnimalPictures() {

        // Create a reference to a file from a Google Cloud Storage URI
        val cat1Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/cat1.jfif")
        val cat2Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/cat2.jfif")
        val cat3Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/cat3.jfif")
        val cat4Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/cat4.jfif")
        val dog1Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/dog1.jfif")
        val dog2Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/dog2.jfif")
        val dog3Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/dog3.jfif")
        val dog4Ref = storage.getReferenceFromUrl("gs://tindog-d82b1.appspot.com/dog4.jfif")

        //je crois que ca n'a aucun sens de les dl depuis le cloud alors que je les ai deja sur l'ordi
        //Il faut voir si il y a un moyen d'acceder directement au cloud et les display dans le recycler
        //view sans les telecharger en local
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

