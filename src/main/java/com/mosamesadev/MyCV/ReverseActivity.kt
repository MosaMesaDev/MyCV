package com.mosamesadev.myCV

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reverse.*

var Inputfield = " "
var ReversedText = " "


class Reverse : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)

        fun GetTextFromField(){
            Inputfield = ReverseInput.text.toString()

            ReversedText = Inputfield.split(" ").reversed().joinToString(" ")

            ReverseTextView3.text = ReversedText
        }
        btnReverse.setOnClickListener{
            GetTextFromField()
        }

    }

}
