package com.david.classapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    private lateinit var services: TextView
    private lateinit var anyServices: TextView
    private lateinit var carRental: ImageView
    private lateinit var carRent: TextView
    private lateinit var buySell: ImageView
    private lateinit var buySellText: TextView
    private lateinit var rePairImage: ImageView
    private lateinit var rePair: TextView
    private lateinit var accessoriesImage: ImageView
    private lateinit var accessoriesText: TextView
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        services = findViewById(R.id.services)
        anyServices = findViewById(R.id.anyServices)
        carRental = findViewById(R.id.carRental)
        carRent = findViewById(R.id.carRent)
        buySell = findViewById(R.id.buySell)
        buySellText = findViewById(R.id.buySellText)
        rePairImage = findViewById(R.id.rePairImage)
        rePair = findViewById(R.id.rePair)
        accessoriesImage = findViewById(R.id.accessoriesImage)
        accessoriesText = findViewById(R.id.accessoriesText)
        continueButton = findViewById(R.id.continueButton)

        continueButton.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        }

    }
}