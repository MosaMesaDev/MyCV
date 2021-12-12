package com.mosamesadev.myCV


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    //private lateinit var mAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)
        //Layout manager
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val item = ArrayList<User>()
        //adding user
        item.add(User("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvastrologer.png","Astrologer", "The Astrologer activity was a basic lesson for me about working with input fields in an activity. Even tho in this particular case, the outcome will always be the same ;) ."))
        item.add(User("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvbestproperty.png","Property locator", "In this activity you want to compare 5 neighbourhoods, you want to know which has the lowest max distance to the 5 services you need. \n\nFor interactivity, you place 5 important services, and then the algorithm will show which area has the lowest maximum distance to all 5 services."))
        item.add(User("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvfindinarray.png","Find in array", "This activity deals with finding specific data in an array and then showing where the data was found. You can fill the array with checkboxes, for interactivity."))
        item.add(User("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvreverser.png","String Reverser", "Learning to manipulate strings, I made this activity where you can type any string of words, and have them shown in reverse order."))
        item.add(User("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvrotatearray.png","Rotate Array", "Dealing with arrays, I came across a video that showed how to rotate them. I implemented this idea into an interactive activity."))
        item.add(User("https://raw.githubusercontent.com/MosaMesaDev/myCV/master/src/main/res/drawable/mycvslotmachine.png","Slotmachine", "This is the basic functionality of a slotmachine. I have made it to practice comparing variables and showing images on screen. \n\nFor the button which plays 10000 games, I have had to learn about Coroutines, otherwise the app would freeze for a little while."))


        //Adapter setting

        val newAdapter = RecyclerViewAdapter(item)
        recyclerView.adapter = newAdapter
            newAdapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                if( position == 0 )                    {
                    val intent = android.content.Intent(this@MainActivity, Astrologer::class.java)
                    startActivity(intent)
                }
                if( position == 1 )                    {
                    val intent = android.content.Intent(this@MainActivity, PropertyLocation::class.java)
                    startActivity(intent)
                }
                if( position == 2 )                    {
                    val intent = android.content.Intent(this@MainActivity, Find0::class.java)
                    startActivity(intent)
                }
                if( position == 3 )                    {
                    val intent = android.content.Intent(this@MainActivity, Reverse::class.java)
                    startActivity(intent)
                }
                if( position == 4 )                    {
                    val intent = android.content.Intent(this@MainActivity, Rotate::class.java)
                    startActivity(intent)
                }

                if( position == 5 )                    {
                    val intent = android.content.Intent(this@MainActivity, fruitMachine::class.java)
                    startActivity(intent)
                }

            }

        })




    }
}