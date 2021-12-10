package com.mosamesadev.MyCV


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieves data from datasource
        val flowerList = Datasource(this).getFlowerList()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = FlowerAdapter(flowerList)
    }
}