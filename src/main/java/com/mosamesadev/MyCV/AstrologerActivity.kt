package com.mosamesadev.myCV

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_astrologer.*



class Astrologer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astrologer)
        //I understand it is odd to see this onCreate to be so empty, but that is because I purposefully do not use the entered data as an input for the result.

        BtnAstrologerSplashScreen.setOnClickListener {
            val intent = Intent(this, AstrologerSplashScreenActivity::class.java)
            startActivity(intent)
        }

    }

}