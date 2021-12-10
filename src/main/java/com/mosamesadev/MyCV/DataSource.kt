package com.mosamesadev.MyCV


import android.content.Context
import com.example.recyclersample.R

class Datasource(val context: Context) {
    fun getFlowerList(): Array<String> {

        // Return flower list from string resources
        return context.resources.getStringArray(R.array.flower_array)
    }
}