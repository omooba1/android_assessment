package com.david.apicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.david.apicall.databinding.ActivityMainBinding
import com.david.apicall.ui.ItemAdapter
import com.david.apicall.ui.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemAdapter = ItemAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.itemRecycler.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.run {
            getItems()
            itemsLiveData.observe(this@MainActivity, {items ->
                itemAdapter.items = items
                itemAdapter.notifyDataSetChanged()
            })
        }

        binding.studentPageButton.setOnClickListener {
            val intent = Intent(this,StudentActivity::class.java)
            startActivity(intent)
        }
    }
}