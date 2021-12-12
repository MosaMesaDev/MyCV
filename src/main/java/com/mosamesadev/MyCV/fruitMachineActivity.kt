package com.mosamesadev.myCV

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mosamesadev.myCV.R
import kotlinx.android.synthetic.main.activity_fruitmachine.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Initialize all the variables!
var Teller = 10
var x = 100
var cc = 0
var ccc = 0
var ww = 0
var www = 0
var ss = 0
var sss = 0
var mm = 0
var mmm = 0
var ff = 0
var fff = 0

// These three lists are what the slotmachine will pick from, when randomly choosing a name.
// THey are weighted by using different number of recurring names.
val FirstIconList = listOf("frontman", "cookie","cookie", "cookie", "cookie", "cookie","worker","worker","worker","cookie", "soldier", "soldier", "manager", "manager", "younghee","younghee","younghee")
val SecondIconList = listOf("frontman","cookie", "cookie", "cookie", "cookie", "cookie","worker","worker","worker","cookie", "soldier", "soldier", "manager", "manager", "younghee","younghee")
val ThirdIconList = listOf("frontman","cookie", "cookie", "cookie", "cookie", "cookie","worker","worker","worker","cookie", "soldier", "soldier", "manager", "manager", "younghee",)

// prefil the three names, this will determine which images will be shown at the start of the game
var randomFirstIcon = "younghee"
var randomSecondIcon = "younghee"
var randomThirdIcon = "younghee"

class fruitMachine : AppCompatActivity() {

    fun Main(){
        scoreTekstVeld.text = "$Teller"
        textView3.text = "When Young-Hee watches, nobody wins"
        textView11.text = "$cc" // These are running totals for every winning combination. cc is the combination cookie + cookie
        textView12.text = "$ccc"
        textView13.text = "$ww"
        textView14.text = "$www"// THis is the combination worker + worker + worker
        textView15.text = "$ss"
        textView16.text = "$sss"
        textView17.text = "$mm"
        textView18.text = "$mmm"
        textView19.text = "$ff"
        textView20.text = "$fff"
    }

    fun shuffleTheDeck(){
        randomFirstIcon = FirstIconList.shuffled().first()
        randomSecondIcon = SecondIconList.shuffled().first()
        randomThirdIcon = ThirdIconList.shuffled().first()}
    suspend fun shuffleTheDeck10000(){
        randomFirstIcon = FirstIconList.shuffled().first()
        randomSecondIcon = SecondIconList.shuffled().first()
        randomThirdIcon = ThirdIconList.shuffled().first()}

    fun checkIcons() {
        checkFirstIcon()
        checkSecondIcon()
        checkThirdIcon() }
    suspend fun checkIcons10000() {
        checkFirstIcon10000()
        checkSecondIcon10000()
        checkThirdIcon10000()
    }

    fun calculatePrize() {

        // First if statement is to stop prize calculation if Young-Hee is watching
        if (randomFirstIcon != "younghee" && randomSecondIcon != "younghee" && randomThirdIcon != "younghee") {

            // Calculate all the prizes from equal images on the first two icons
            if (randomFirstIcon == "cookie" && randomSecondIcon == "cookie") {
                Teller += 2
                cc += 1
            }
            if (randomFirstIcon == "worker" && randomSecondIcon == "worker") {
                Teller += 5
                ww += 4
            }
            if (randomFirstIcon == "soldier" && randomSecondIcon == "soldier") {
                Teller += 8
                ss += 7
            }
            if (randomFirstIcon == "manager" && randomSecondIcon == "manager") {
                Teller += 10
                mm += 9
            }
            if (randomFirstIcon == "frontman" && randomSecondIcon == "frontman") {
                Teller += 25
                ff += 24
            }

            // Calculate all the extra prizes if all three icons are the same
            if (randomFirstIcon == "cookie" && randomSecondIcon == "cookie" && randomThirdIcon == "cookie") {
                Teller += 3
                ccc += 2
            }
            if (randomFirstIcon == "worker" && randomSecondIcon == "worker" && randomThirdIcon == "worker") {
                Teller += 9
                www += 8
            }
            if (randomFirstIcon == "soldier" && randomSecondIcon == "soldier" && randomThirdIcon == "soldier") {
                Teller += 25
                sss += 24
            }
            if (randomFirstIcon == "manager" && randomSecondIcon == "manager" && randomThirdIcon == "manager") {
                Teller += 40
                mmm += 39
            }
            if (randomFirstIcon == "frontman" && randomSecondIcon == "frontman" && randomThirdIcon == "frontman") {
                Teller += 125
                fff += 124
            }
        }
    }
    suspend fun calculatePrize10000() {

        // First if statement is to stop prize calculation if Young-Hee is watching
        if (randomFirstIcon != "younghee" && randomSecondIcon != "younghee" && randomThirdIcon != "younghee") {

            // Calculate all the prizes from equal images on the first two icons
            if (randomFirstIcon == "cookie" && randomSecondIcon == "cookie") {
                Teller += 2
                cc += 1
            }
            if (randomFirstIcon == "worker" && randomSecondIcon == "worker") {
                Teller += 5
                ww += 4
            }
            if (randomFirstIcon == "soldier" && randomSecondIcon == "soldier") {
                Teller += 8
                ss += 7
            }
            if (randomFirstIcon == "manager" && randomSecondIcon == "manager") {
                Teller += 10
                mm += 9
            }
            if (randomFirstIcon == "frontman" && randomSecondIcon == "frontman") {
                Teller += 25
                ff += 24
            }

            // Calculate all the extra prizes if all three icons are the same
            if (randomFirstIcon == "cookie" && randomSecondIcon == "cookie" && randomThirdIcon == "cookie") {
                Teller += 3
                ccc += 2
            }
            if (randomFirstIcon == "worker" && randomSecondIcon == "worker" && randomThirdIcon == "worker") {
                Teller += 9
                www += 8
            }
            if (randomFirstIcon == "soldier" && randomSecondIcon == "soldier" && randomThirdIcon == "soldier") {
                Teller += 25
                sss += 24
            }
            if (randomFirstIcon == "manager" && randomSecondIcon == "manager" && randomThirdIcon == "manager") {
                Teller += 40
                mmm += 39
            }
            if (randomFirstIcon == "frontman" && randomSecondIcon == "frontman" && randomThirdIcon == "frontman") {
                Teller += 125
                fff += 74
            }
        }
    }

    fun checkFirstIcon() {

        // Drawing the image on the first icon
        if (randomFirstIcon == "younghee") {
            Glide.with(this)
                .load(R.drawable.iconyounghee)
                .into(imageView1)
        }
        if (randomFirstIcon == "frontman") {
            Glide.with(this)
                .load(R.drawable.iconfrontman)
                .into(imageView1)
        }

        if (randomFirstIcon == "cookie") {
            Glide.with(this)
                .load(R.drawable.iconcookie)
                .into(imageView1)
        }


        if (randomFirstIcon == "worker") {
            Glide.with(this)
                .load(R.drawable.iconworker)
                .into(imageView1)
        }

        if (randomFirstIcon == "soldier") {
            Glide.with(this)
                .load(R.drawable.iconsoldier)
                .into(imageView1)
        }

        if (randomFirstIcon == "manager") {
            Glide.with(this)
                .load(R.drawable.iconmanager)
                .into(imageView1)
        }
    }
    suspend fun checkFirstIcon10000() {

        // Drawing the image on the first icon
        if (randomFirstIcon == "younghee") {
            Glide.with(this)
                .load(R.drawable.iconyounghee)
                .into(imageView1)
        }
        if (randomFirstIcon == "frontman") {
            Glide.with(this)
                .load(R.drawable.iconfrontman)
                .into(imageView1)
        }

        if (randomFirstIcon == "cookie") {
            Glide.with(this)
                .load(R.drawable.iconcookie)
                .into(imageView1)
        }


        if (randomFirstIcon == "worker") {
            Glide.with(this)
                .load(R.drawable.iconworker)
                .into(imageView1)
        }

        if (randomFirstIcon == "soldier") {
            Glide.with(this)
                .load(R.drawable.iconsoldier)
                .into(imageView1)
        }

        if (randomFirstIcon == "manager") {
            Glide.with(this)
                .load(R.drawable.iconmanager)
                .into(imageView1)
        }
    }

    fun checkSecondIcon() {

        // Drawing the image on the second icon
        if (randomSecondIcon == "younghee") {
            Glide.with(this)
                .load(R.drawable.iconyounghee)
                .into(imageView2)
        }
        if (randomSecondIcon == "frontman") {
            Glide.with(this)
                .load(R.drawable.iconfrontman)
                .into(imageView2)
        }

        if (randomSecondIcon == "cookie") {
            Glide.with(this)
                .load(R.drawable.iconcookie)
                .into(imageView2)
        }


        if (randomSecondIcon == "worker") {
            Glide.with(this)
                .load(R.drawable.iconworker)
                .into(imageView2)
        }

        if (randomSecondIcon == "soldier") {
            Glide.with(this)
                .load(R.drawable.iconsoldier)
                .into(imageView2)
        }

        if (randomSecondIcon == "manager") {
            Glide.with(this)
                .load(R.drawable.iconmanager)
                .into(imageView2)
        }
    }
    suspend fun checkSecondIcon10000() {

        // Drawing the image on the second icon
        if (randomSecondIcon == "younghee") {
            Glide.with(this)
                .load(R.drawable.iconyounghee)
                .into(imageView2)
        }
        if (randomSecondIcon == "frontman") {
            Glide.with(this)
                .load(R.drawable.iconfrontman)
                .into(imageView2)
        }

        if (randomSecondIcon == "cookie") {
            Glide.with(this)
                .load(R.drawable.iconcookie)
                .into(imageView2)
        }


        if (randomSecondIcon == "worker") {
            Glide.with(this)
                .load(R.drawable.iconworker)
                .into(imageView2)
        }

        if (randomSecondIcon == "soldier") {
            Glide.with(this)
                .load(R.drawable.iconsoldier)
                .into(imageView2)
        }

        if (randomSecondIcon == "manager") {
            Glide.with(this)
                .load(R.drawable.iconmanager)
                .into(imageView2)
        }
    }


    fun checkThirdIcon(){

        // Drawing the image on the third icon
        if (randomThirdIcon == "younghee") {
            Glide.with(this)
                .load(R.drawable.iconyounghee)
                .into(imageView3)
        }
        if(randomThirdIcon == "frontman") {
            Glide.with(this)
                .load(R.drawable.iconfrontman)
                .into(imageView3)
        }

        if (randomThirdIcon == "cookie"){
            Glide.with(this)
                .load(R.drawable.iconcookie)
                .into(imageView3)
        }

        if (randomThirdIcon == "worker"){
            Glide.with(this)
                .load(R.drawable.iconworker)
                .into(imageView3)
        }

        if (randomThirdIcon == "soldier"){
            Glide.with(this)
                .load(R.drawable.iconsoldier)
                .into(imageView3)
        }

        if (randomThirdIcon == "manager"){
            Glide.with(this)
                .load(R.drawable.iconmanager)
                .into(imageView3)
        }
    }
    suspend fun checkThirdIcon10000(){

        // Drawing the image on the third icon
        if (randomThirdIcon == "younghee") {
            Glide.with(this)
                .load(R.drawable.iconyounghee)
                .into(imageView3)
        }
        if(randomThirdIcon == "frontman") {
            Glide.with(this)
                .load(R.drawable.iconfrontman)
                .into(imageView3)
        }

        if (randomThirdIcon == "cookie"){
            Glide.with(this)
                .load(R.drawable.iconcookie)
                .into(imageView3)
        }

        if (randomThirdIcon == "worker"){
            Glide.with(this)
                .load(R.drawable.iconworker)
                .into(imageView3)
        }

        if (randomThirdIcon == "soldier"){
            Glide.with(this)
                .load(R.drawable.iconsoldier)
                .into(imageView3)
        }

        if (randomThirdIcon == "manager"){
            Glide.with(this)
                .load(R.drawable.iconmanager)
                .into(imageView3)
        }
    }

    fun fruitMachineLogica() {
        // Slotmachine logic, after clicking on the Play button
        Teller-- // Scorecounter decreases one time
        shuffleTheDeck() // Pick randomly an name from the list
        checkIcons() // Use Glide to show the images, based on the picked names
        calculatePrize() // Add winnings to the counter
        scoreTekstVeld.text = "$Teller" // Show the new counter to the score field
        textView11.text = "$cc" // These are running totals for every winning combination. cc is the combination cookie + cookie
        textView12.text = "$ccc"
        textView13.text = "$ww"
        textView14.text = "$www"// THis is the combination worker + worker + worker
        textView15.text = "$ss"
        textView16.text = "$sss"
        textView17.text = "$mm"
        textView18.text = "$mmm"
        textView19.text = "$ff"
        textView20.text = "$fff"

    }
    suspend fun fruitMachineLogica10000() {
        // Slotmachine logic, after clicking on the Play 10000x button
        x = 10000 // initiate a counter of 10000 plays
        while (x > 0) {
            Teller--// same as with fruitMachineLogica()
            x--
            CoroutineScope(Default).launch { shuffleTheDeck10000() }
            CoroutineScope(Default).launch { calculatePrize10000() }
        }
        // After playing 10000 games, show the results on the screen
        withContext(Dispatchers.Main) {
            checkIcons10000() // First set the new icons
            scoreTekstVeld.text = "$Teller" // and then all the scores
            textView11.text = "$cc"
            textView12.text = "$ccc"
            textView13.text = "$ww"
            textView14.text = "$www"
            textView15.text = "$ss"
            textView16.text = "$sss"
            textView17.text = "$mm"
            textView18.text = "$mmm"
            textView19.text = "$ff"
            textView20.text = "$fff"}

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_fruitmachine)// show the activity_fruitmachine activity

        // prefill the three imageviews with the iconic Young-Hee character
        val imageOne = findViewById<ImageView>(R.id.imageView1)
        val imageTwo = findViewById<ImageView>(R.id.imageView2)
        val imageThree = findViewById<ImageView>(R.id.imageView3)

        Glide.with(this)
            .load(R.drawable.iconyounghee)
            .into(imageTwo)

        Glide.with(this)
            .load(R.drawable.iconyounghee)
            .into(imageOne)

        Glide.with(this)
            .load(R.drawable.iconyounghee)
            .into(imageThree)

        Main()

        // Listener for the button that starts the play once
        startKnop.setOnClickListener {
            fruitMachineLogica()
        }

        // Listener for the button that starts the play 10000 times WITHIN a coroutine
        startKnop10000.setOnClickListener {
            CoroutineScope(Default).launch{
                fruitMachineLogica10000()
            }



        }
    }}