package com.example.newsbreeze.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.newsbreeze.R
import com.example.newsbreeze.activities.LoginActivity
import com.example.newsbreeze.activities.SignUpActivity
import com.example.newsbreeze.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val binding: ActivityWelcomeBinding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.GettingStartedButton.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)  // Start the second activity
        }

        binding.loginButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.guestButton.setOnClickListener {
            // Create an Intent to navigate to the second activity
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)  // Start the second activity
        }
    }
}