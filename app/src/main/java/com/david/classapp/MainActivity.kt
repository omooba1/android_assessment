package com.david.classapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val validUsername: String = "admin"
    private val validEmail: String = "admin@gmail.com"
    private val validPhoneNumber = "08123730770"
    private val validPassword: String = "admin"

    private lateinit var userNameInput: EditText
    private lateinit var userEmailAddress: EditText
    private lateinit var phoneNumberInput: EditText
    private lateinit var userPassWord: EditText
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameInput = findViewById(R.id.userNameInput)
        userEmailAddress = findViewById(R.id.userEmailAddress)
        userPassWord = findViewById(R.id.passWordInput)
        phoneNumberInput = findViewById(R.id.phoneNumberInput)
        signUpButton = findViewById(R.id.signUpButton)

        signUpButton.setOnClickListener {
            val username = userNameInput.text.toString()
            val email = userEmailAddress.text.toString()
            val phone = phoneNumberInput.text.toString()
            val password = userPassWord.text.toString()

            signUp(username, email, phone, password)
        }

    }

    private fun signUp(userName: String, eMail: String, phoneNumber: String, passWord: String) {
        if (correctdetils(userName, eMail, phoneNumber, passWord)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "Sign Up Completed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Enter correct details", Toast.LENGTH_SHORT).show()

        }
    }

    private fun correctdetils(username: String, email: String, phone: String, password: String): Boolean {
        if (username == validUsername && email == validEmail && phone == validPhoneNumber && password == validPassword) return true
        return false

    }
}