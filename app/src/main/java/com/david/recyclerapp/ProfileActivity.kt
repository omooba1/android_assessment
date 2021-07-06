package com.david.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.david.recyclerapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            profilePicture1.setImageResource(intent.getStringExtra("ProfilePicture")!!.toInt())
            firstName1.text = intent.getStringExtra("firstName")
            lastName1.text = intent.getStringExtra("lastName")
        }
    }
}
