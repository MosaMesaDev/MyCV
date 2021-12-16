package com.mosamesadev.myCV

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reverse.*


//Just 2 variables to initialize
var Inputfield = " "
var ReversedText = " "


class Reverse : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)

        fun GetTextFromField(){
            //Get the user input
            Inputfield = ReverseInput.text.toString()

            //Split the user input by using a space as a delimiter.
            //Reverse the order of the words
            //And join the words back together again using a space as a separator
            ReversedText = Inputfield.split(" ").reversed().joinToString(" ")

            //Get the new reversed text and display it in a textview
            ReverseTextView3.text = ReversedText
        }
        btnReverse.setOnClickListener{
            GetTextFromField()
        }

    }

}
