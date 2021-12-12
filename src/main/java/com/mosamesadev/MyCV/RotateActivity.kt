package com.mosamesadev.myCV

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rotate.*
import java.util.*


var temp = " "
var RotateArray  = listOf(" ")
var RotateArrayTempString  = " "
var numberOfLoops = 1
var numberOfLoopsTemp = " "
var StringLength = 1

class Rotate : AppCompatActivity() {

    fun RotateTheArray() {

        RotateArrayTempString = editTextInputArray.text.toString() // Get the input string
        RotateArray = RotateArrayTempString.split("-") // Split up the string into a list
        StringLength = RotateArray.size // check the number of items that has been put in

        val arr = RotateArray // To use the Java trick, we first need an arr and a list
        val list = arr.toList()
        temp = RotateArray[0] // keep this one item in the list safe

        numberOfLoopsTemp = editTextNumberRotate.text.toString() // input of the number of steps to rotate the array
        numberOfLoops = numberOfLoopsTemp.toInt()

        Collections.rotate(list, numberOfLoops) // Java trick
        RotateResultTextView.text = list.joinToString() // output to the Activity

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate)

        BtnRotateIt.setOnClickListener {RotateTheArray()}

    }

}

