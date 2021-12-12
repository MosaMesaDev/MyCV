package com.mosamesadev.myCV

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_find0.*


var FirstColumn = false
var FirstRow = false
var SecondColumn = false
var SecondRow = false
var ThirdColumn = false
var ThirdRow = false


class Find0 : AppCompatActivity() {

    fun FindThe0InTheArray(){

        imageViewRow1.isVisible = false  // hide all the arrows!
        imageViewRow2.isVisible = false
        imageViewRow3.isVisible = false
        imageViewColumn1.isVisible = false
        imageViewColumn2.isVisible = false
        imageViewColumn3.isVisible = false

        FirstColumn = false // reset the previous results
        FirstRow = false
        SecondColumn = false
        SecondRow = false
        ThirdColumn = false
        ThirdRow = false

        // first the checks of the isChecked
        if (checkBox1.isChecked) {
            FirstColumn = true
            FirstRow = true
        }
        if (checkBox2.isChecked) {
            SecondColumn = true
            FirstRow = true
        }
        if (checkBox3.isChecked) {
            ThirdColumn = true
            FirstRow = true
        }
        if (checkBox4.isChecked) {
            FirstColumn = true
            SecondRow = true
        }
        if (checkBox5.isChecked) {
            SecondColumn = true
            SecondRow = true
        }
        if (checkBox6.isChecked) {
            ThirdColumn = true
            SecondRow = true
        }
        if (checkBox7.isChecked) {
            FirstColumn = true
            ThirdRow = true
        }
        if (checkBox8.isChecked) {
            SecondColumn = true
            ThirdRow = true
        }
        if (checkBox9.isChecked) {
            ThirdColumn = true
            ThirdRow = true
        }


        // Then the checks of the rows and columns to set the visibility of the arrows

        if (FirstRow == true){
            imageViewRow1.isVisible = true
        }
        if (SecondRow == true){
            imageViewRow2.isVisible = true
        }
        if (ThirdRow == true){
            imageViewRow3.isVisible = true
        }
        if (FirstColumn == true){
            imageViewColumn1.isVisible = true
        }
        if (SecondColumn == true){
            imageViewColumn2.isVisible = true
        }
        if (ThirdColumn == true){
            imageViewColumn3.isVisible = true
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find0)

        imageViewRow1.isVisible = false  // hide all the arrows!
        imageViewRow2.isVisible = false
        imageViewRow3.isVisible = false
        imageViewColumn1.isVisible = false
        imageViewColumn2.isVisible = false
        imageViewColumn3.isVisible = false

        supportActionBar?.hide() // I really do not like to see that action bar

        BtnFill0Execute.setOnClickListener { FindThe0InTheArray() }

    }
}