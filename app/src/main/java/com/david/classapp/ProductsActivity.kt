package com.david.classapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProductsActivity : AppCompatActivity() {

    private lateinit var callButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        callButton = findViewById(R.id.callButton)

        callButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }
    }
}