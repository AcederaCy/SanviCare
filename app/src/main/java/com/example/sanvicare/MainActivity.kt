package com.example.sanvicare

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var logoImageView: ImageView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logoImageView = findViewById(R.id.logoImageView)
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        logoImageView.startAnimation(animation)
        Handler(mainLooper).postDelayed({
            logoImageView.visibility = ImageView.GONE
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.loginFormConstraintLayout).visibility = androidx.constraintlayout.widget.ConstraintLayout.VISIBLE
        }, 1000)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidCredentials(username, password)) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        return username == "user" && password == "password"
    }
}