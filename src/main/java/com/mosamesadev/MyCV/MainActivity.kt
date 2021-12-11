package com.mosamesadev.myCV


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R
import com.mosamesadev.myCV.RecyclerViewAdapter
import com.mosamesadev.myCV.User


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
        item.add(User("R.drawable.iconcookie","Developers", Lastname = "Foo"))
        item.add(User("R.drawable.iconfrontman","Developers", Lastname = "Foo"))
        item.add(User("R.drawable.iconmanager","Developers", Lastname = "Foo"))
        item.add(User("R.drawable.iconsoldier","Developers", Lastname = "Foo"))
        item.add(User("R.drawable.iconworker","Developers", Lastname = "Foo"))
        item.add(User("R.drawable.iconyounghee","Developers", Lastname = "Foo"))
        item.add(User("R.drawable.iconplattegrond","Developers", Lastname = "Foo"))

        //Adapter setting
        mAdapter = RecyclerViewAdapter(item)
        recyclerView.adapter = mAdapter
    }
}