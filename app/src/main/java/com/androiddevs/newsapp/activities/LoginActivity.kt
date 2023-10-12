package com.example.newsbreeze.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.newsbreeze.databinding.ActivityLoginBinding
import android.widget.Toast
import com.example.newsbreeze.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding: ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

        setContentView(binding.root)

        binding.signUpButton.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)  // Start the second activity
        }

        binding.guestButton.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)  // Start the second activity
        }


        binding.loginButton.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, NewsActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }  // Start the second activity
        }
    }

}