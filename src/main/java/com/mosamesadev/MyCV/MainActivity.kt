package com.mosamesadev.MyCV


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        //Layout manager
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val item = ArrayList<User>()
        //adding user
        item.add(User("Developers", Lastname = "Foo"))
        item.add(User("Dome", Lastname = "Foo"))
        item.add(User("Developers1", Lastname = "Foo"))
        item.add(User("Dome1", Lastname = "Foo"))
        item.add(User("Developers2", Lastname = "Foo"))
        item.add(User("Dome2", Lastname = "Foo"))
        item.add(User("Developers3", Lastname = "Foo"))
        item.add(User("Dome3", Lastname = "Foo"))
        //Adapter setting
        mAdapter = RecyclerViewAdapter(item)
        recyclerView.adapter = mAdapter
    }
}