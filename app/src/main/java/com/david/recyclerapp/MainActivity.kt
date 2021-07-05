package com.david.recyclerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.david.recyclerapp.adapters.NameAdapter
import com.david.recyclerapp.adapters.OnNameItemClickListener
import com.david.recyclerapp.databinding.ActivityMainBinding
import com.david.recyclerapp.databinding.ActivityProfileBinding
import com.david.recyclerapp.models.Name

class MainActivity : AppCompatActivity(), OnNameItemClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var myNameAdapter: NameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val names: List<Name> = listOf(
            Name(
                R.drawable.ic_image,
                "Moses",
                "David"
            ),

            Name(
                R.drawable.ic_image1,
                "Jennifer",
                "Jones"
            ),

            Name(
                R.drawable.ic_image2,
                "Daniel",
                "David"
            ),

            Name(
                R.drawable.ic_image3,
                "Sonia",
                "Stone"
            ),

            Name(
                R.drawable.ic_image4,
                "Joy",
                "Mathew"
            ),

            Name(
                R.drawable.ic_image5,
                "Faith",
                "Moses"
            ),

            Name(
                R.drawable.ic_image6,
                "Sophia",
                "Ezekiel"
            ),

            Name(
                R.drawable.ic_image7,
                "Solomon",
                "Isaac"
            ),

            Name(
                R.drawable.ic_image8,
                "Stanley",
                "Humble"
            ),

            Name(
                R.drawable.ic_image9,
                "Jakie",
                "Chan"
            ),

            Name(
                R.drawable.ic_image10,
                "Hosea",
                "Francis"
            ),

            Name(
                R.drawable.ic_image11,
                "Tony",
                "Stark"
            ),

            Name(
                R.drawable.ic_image12,
                "Oscar",
                "Raymond"
            ),

            Name(
                R.drawable.ic_image13,
                "Kelly",
                "Kenneth"
            ),

            Name(
                R.drawable.ic_image14,
                "Sandra",
                "Frank"
            ),

            Name(
                R.drawable.ic_image15,
                "James",
                "Jude"
            ),

            Name(
                R.drawable.ic_image16,
                "Antonia",
                "David"
            ),

            Name(
                R.drawable.ic_image17,
                "Mark",
                "Solomon"
            ),

            Name(
                R.drawable.ic_image18,
                "Luke",
                "John"
            ),

            Name(
                R.drawable.ic_image19,
                "Dr. Hudson",
                "Kenneth"
            )
        )

        myNameAdapter = NameAdapter(names, this)

        binding.nameRecyclerView.adapter = myNameAdapter
    }

    override fun onItemClick(name: Name, position: Int) {
       val intent = Intent(this,ProfileActivity::class.java)
        intent.putExtra("ProfilePicture", name.profile.toString())
        intent.putExtra("firstName", name.first)
        intent.putExtra("lastName", name.last)
        startActivity(intent)
    }
}