package com.mosamesadev.myCV

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.annotation.RequiresApi


class FlashlightActivity : AppCompatActivity() {
    private lateinit var cameraM :CameraManager
    private lateinit var powerBtn:ImageButton
    private var isFlash = false  //Initialize the flashlight to the Off position

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashlight)
        // Set the view ID
        powerBtn = findViewById(R.id.power)
        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        powerBtn.setOnClickListener { flashLightOnRoOff(it) }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOnRoOff(v: View?) {


        if (!isFlash){
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isFlash = true        //Set the flash to on after the button press.
            powerBtn.setImageResource(R.drawable.ic_power_on)         //Set the on/off switch to the on or off version of the picture
        }
        else{
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,false)
            isFlash = false  //Set the flash to off after the button press.
            powerBtn.setImageResource(R.drawable.ic_power_off)
        }

    }

}