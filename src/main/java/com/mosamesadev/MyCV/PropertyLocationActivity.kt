package com.mosamesadev.myCV

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_propertylocation.*


//First we set all the variables. It can be done is fewer lines, but I believe it is preferable fo have it orderly like it is here.
var resultaat = " "

var MaxDistancesLocation1 = listOf(0,0,0,0,0) //These are the distances from a certain location to the furthest service.
var MaxDistancesLocation2 = listOf(0,0,0,0,0)
var MaxDistancesLocation3 = listOf(0,0,0,0,0)
var MaxDistancesLocation4 = listOf(0,0,0,0,0)
var MaxDistancesLocation5 = listOf(0,0,0,0,0)

var SortedMaxDistancesLocation1 = listOf(0,0,0,0,0)//Here the distances are sorted, so it is easy to.
var SortedMaxDistancesLocation2 = listOf(0,0,0,0,0)//tell what the maximum distance from a location to a service is
var SortedMaxDistancesLocation3 = listOf(0,0,0,0,0)
var SortedMaxDistancesLocation4 = listOf(0,0,0,0,0)
var SortedMaxDistancesLocation5 = listOf(0,0,0,0,0)


var MaxDistLocation1 = 0 //The maximum found in the Sorted max distances list.
var MaxDistLocation2 = 0
var MaxDistLocation3 = 0
var MaxDistLocation4 = 0
var MaxDistLocation5 = 0

var Location1SchoolDistance = 0 //Before checking anything, set all the distances to 0 (and INT)
var Location2SchoolDistance = 0
var Location3SchoolDistance = 0
var Location4SchoolDistance = 0
var Location5SchoolDistance = 0

var Location1SupermarketDistance = 0
var Location2SupermarketDistance = 0
var Location3SupermarketDistance = 0
var Location4SupermarketDistance = 0
var Location5SupermarketDistance = 0

var Location1FarmacyDistance = 0
var Location2FarmacyDistance = 0
var Location3FarmacyDistance = 0
var Location4FarmacyDistance = 0
var Location5FarmacyDistance = 0

var Location1BusStopDistance = 0
var Location2BusStopDistance = 0
var Location3BusStopDistance = 0
var Location4BusStopDistance = 0
var Location5BusStopDistance = 0

var Location1DogParkDistance = 0
var Location2DogParkDistance = 0
var Location3DogParkDistance = 0
var Location4DogParkDistance = 0
var Location5DogParkDistance = 0

var MapMaxMinDistance = hashMapOf<String, Int>()
var result = listOf(String, Int)

class PropertyLocation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propertylocation)
        supportActionBar?.hide()

        fun checkMinimumMaxDistanceLocation1() {
            // first check minimum distance to School, starting from the furthest away location,
            // to closer by, ending with a check on the location itself.
            //Worst result can be 4 locations away, best result is on the location itself (=distance of 0)
            if (checkBoxPLSchool5.isChecked) {
                Location1SchoolDistance = 4
            }
            if (checkBoxPLSchool4.isChecked) {
                Location1SchoolDistance = 3
            }
            if (checkBoxPLSchool3.isChecked) {
                Location1SchoolDistance = 2
            }
            if (checkBoxPLSchool2.isChecked) {
                Location1SchoolDistance = 1
            }
            if (checkBoxPLSchool1.isChecked) {
                Location1SchoolDistance = 0
            }
            // then check the distance to the Supermarket
            if (checkBoxPLSupermarket5.isChecked) Location1SupermarketDistance = 4
            if (checkBoxPLSupermarket4.isChecked) Location1SupermarketDistance = 3
            if (checkBoxPLSupermarket3.isChecked) Location1SupermarketDistance = 2
            if (checkBoxPLSupermarket2.isChecked) Location1SupermarketDistance = 1
            if (checkBoxPLSupermarket1.isChecked) Location1SupermarketDistance = 0
            // and also the other 3 distances
            if (checkBoxPLFarmacy5.isChecked) Location1FarmacyDistance = 4
            if (checkBoxPLFarmacy4.isChecked) Location1FarmacyDistance = 3
            if (checkBoxPLFarmacy3.isChecked) Location1FarmacyDistance = 2
            if (checkBoxPLFarmacy2.isChecked) Location1FarmacyDistance = 1
            if (checkBoxPLFarmacy1.isChecked) Location1FarmacyDistance = 0

            if (checkBoxPLBusStop5.isChecked) Location1BusStopDistance = 4
            if (checkBoxPLBusStop4.isChecked) Location1BusStopDistance = 3
            if (checkBoxPLBusStop3.isChecked) Location1BusStopDistance = 2
            if (checkBoxPLBusStop2.isChecked) Location1BusStopDistance = 1
            if (checkBoxPLBusStop1.isChecked) Location1BusStopDistance = 0

            if (checkBoxPLDogPark5.isChecked) Location1DogParkDistance = 4
            if (checkBoxPLDogPark4.isChecked) Location1DogParkDistance = 3
            if (checkBoxPLDogPark3.isChecked) Location1DogParkDistance = 2
            if (checkBoxPLDogPark2.isChecked) Location1DogParkDistance = 1
            if (checkBoxPLDogPark1.isChecked) Location1DogParkDistance = 0
        }

        fun checkMinimumMaxDistanceLocation2() {//Same as above, but now for location 2.
            //Notice that the order at which the locations are checked is different from above.
            //This is of course because location 1 has 1 other location at distance 1, but
            //location 2 has 2 other locations at distance 1 away (location 1 and 3)
            if (checkBoxPLSchool5.isChecked) Location2SchoolDistance = 3
            if (checkBoxPLSchool4.isChecked) Location2SchoolDistance = 2
            if (checkBoxPLSchool3.isChecked) Location2SchoolDistance = 1
            if (checkBoxPLSchool1.isChecked) Location2SchoolDistance = 1
            if (checkBoxPLSchool2.isChecked) Location2SchoolDistance = 0

            if (checkBoxPLSupermarket5.isChecked) Location2SupermarketDistance = 3
            if (checkBoxPLSupermarket4.isChecked) Location2SupermarketDistance = 2
            if (checkBoxPLSupermarket3.isChecked) Location2SupermarketDistance = 1
            if (checkBoxPLSupermarket1.isChecked) Location2SupermarketDistance = 1
            if (checkBoxPLSupermarket2.isChecked) Location2SupermarketDistance = 0

            if (checkBoxPLFarmacy5.isChecked) Location2FarmacyDistance = 3
            if (checkBoxPLFarmacy4.isChecked) Location2FarmacyDistance = 2
            if (checkBoxPLFarmacy3.isChecked) Location2FarmacyDistance = 1
            if (checkBoxPLFarmacy1.isChecked) Location2FarmacyDistance = 1
            if (checkBoxPLFarmacy2.isChecked) Location2FarmacyDistance = 0

            if (checkBoxPLBusStop5.isChecked) Location2BusStopDistance = 3
            if (checkBoxPLBusStop4.isChecked) Location2BusStopDistance = 2
            if (checkBoxPLBusStop3.isChecked) Location2BusStopDistance = 1
            if (checkBoxPLBusStop1.isChecked) Location2BusStopDistance = 1
            if (checkBoxPLBusStop2.isChecked) Location2BusStopDistance = 0

            if (checkBoxPLDogPark5.isChecked) Location2DogParkDistance = 3
            if (checkBoxPLDogPark4.isChecked) Location2DogParkDistance = 2
            if (checkBoxPLDogPark3.isChecked) Location2DogParkDistance = 1
            if (checkBoxPLDogPark1.isChecked) Location2DogParkDistance = 1
            if (checkBoxPLDogPark2.isChecked) Location2DogParkDistance = 0
        }

        fun checkMinimumMaxDistanceLocation3() {
            if (checkBoxPLSchool5.isChecked) Location3SchoolDistance = 2
            if (checkBoxPLSchool1.isChecked) Location3SchoolDistance = 2
            if (checkBoxPLSchool2.isChecked) Location3SchoolDistance = 1
            if (checkBoxPLSchool4.isChecked) Location3SchoolDistance = 1
            if (checkBoxPLSchool3.isChecked) Location3SchoolDistance = 0

            if (checkBoxPLSupermarket5.isChecked) Location3SupermarketDistance = 2
            if (checkBoxPLSupermarket1.isChecked) Location3SupermarketDistance = 2
            if (checkBoxPLSupermarket4.isChecked) Location3SupermarketDistance = 1
            if (checkBoxPLSupermarket2.isChecked) Location3SupermarketDistance = 1
            if (checkBoxPLSupermarket3.isChecked) Location3SupermarketDistance = 0

            if (checkBoxPLFarmacy5.isChecked) Location3FarmacyDistance = 2
            if (checkBoxPLFarmacy1.isChecked) Location3FarmacyDistance = 2
            if (checkBoxPLFarmacy4.isChecked) Location3FarmacyDistance = 1
            if (checkBoxPLFarmacy2.isChecked) Location3FarmacyDistance = 1
            if (checkBoxPLFarmacy3.isChecked) Location3FarmacyDistance = 0

            if (checkBoxPLBusStop5.isChecked) Location3BusStopDistance = 2
            if (checkBoxPLBusStop1.isChecked) Location3BusStopDistance = 2
            if (checkBoxPLBusStop4.isChecked) Location3BusStopDistance = 1
            if (checkBoxPLBusStop2.isChecked) Location3BusStopDistance = 1
            if (checkBoxPLBusStop3.isChecked) Location3BusStopDistance = 0

            if (checkBoxPLDogPark5.isChecked) Location3DogParkDistance = 2
            if (checkBoxPLDogPark1.isChecked) Location3DogParkDistance = 2
            if (checkBoxPLDogPark4.isChecked) Location3DogParkDistance = 1
            if (checkBoxPLDogPark2.isChecked) Location3DogParkDistance = 1
            if (checkBoxPLDogPark3.isChecked) Location3DogParkDistance = 0
        }

        fun checkMinimumMaxDistanceLocation4() {
            if (checkBoxPLSchool1.isChecked) Location4SchoolDistance = 3
            if (checkBoxPLSchool2.isChecked) Location4SchoolDistance = 2
            if (checkBoxPLSchool5.isChecked) Location4SchoolDistance = 1
            if (checkBoxPLSchool3.isChecked) Location4SchoolDistance = 1
            if (checkBoxPLSchool4.isChecked) Location4SchoolDistance = 0

            if (checkBoxPLSupermarket1.isChecked) Location4SupermarketDistance = 3
            if (checkBoxPLSupermarket2.isChecked) Location4SupermarketDistance = 2
            if (checkBoxPLSupermarket5.isChecked) Location4SupermarketDistance = 1
            if (checkBoxPLSupermarket3.isChecked) Location4SupermarketDistance = 1
            if (checkBoxPLSupermarket4.isChecked) Location4SupermarketDistance = 0

            if (checkBoxPLFarmacy1.isChecked) Location4FarmacyDistance = 3
            if (checkBoxPLFarmacy2.isChecked) Location4FarmacyDistance = 2
            if (checkBoxPLFarmacy5.isChecked) Location4FarmacyDistance = 1
            if (checkBoxPLFarmacy3.isChecked) Location4FarmacyDistance = 1
            if (checkBoxPLFarmacy4.isChecked) Location4FarmacyDistance = 0

            if (checkBoxPLBusStop1.isChecked) Location4BusStopDistance = 3
            if (checkBoxPLBusStop2.isChecked) Location4BusStopDistance = 2
            if (checkBoxPLBusStop5.isChecked) Location4BusStopDistance = 1
            if (checkBoxPLBusStop3.isChecked) Location4BusStopDistance = 1
            if (checkBoxPLBusStop4.isChecked) Location4BusStopDistance = 0

            if (checkBoxPLDogPark1.isChecked) Location4DogParkDistance = 3
            if (checkBoxPLDogPark2.isChecked) Location4DogParkDistance = 2
            if (checkBoxPLDogPark5.isChecked) Location4DogParkDistance = 1
            if (checkBoxPLDogPark3.isChecked) Location4DogParkDistance = 1
            if (checkBoxPLDogPark4.isChecked) Location4DogParkDistance = 0

        }

        fun checkMinimumMaxDistanceLocation5() {
            //The order here is basically reversed from location 1
            if (checkBoxPLSchool1.isChecked) Location5SchoolDistance = 4
            if (checkBoxPLSchool2.isChecked) Location5SchoolDistance = 3
            if (checkBoxPLSchool3.isChecked) Location5SchoolDistance = 2
            if (checkBoxPLSchool4.isChecked) Location5SchoolDistance = 1
            if (checkBoxPLSchool5.isChecked) Location5SchoolDistance = 0

            if (checkBoxPLSupermarket1.isChecked) Location5SupermarketDistance = 4
            if (checkBoxPLSupermarket2.isChecked) Location5SupermarketDistance = 3
            if (checkBoxPLSupermarket3.isChecked) Location5SupermarketDistance = 2
            if (checkBoxPLSupermarket4.isChecked) Location5SupermarketDistance = 1
            if (checkBoxPLSupermarket5.isChecked) Location5SupermarketDistance = 0

            if (checkBoxPLFarmacy1.isChecked) Location5FarmacyDistance = 4
            if (checkBoxPLFarmacy2.isChecked) Location5FarmacyDistance = 3
            if (checkBoxPLFarmacy3.isChecked) Location5FarmacyDistance = 2
            if (checkBoxPLFarmacy4.isChecked) Location5FarmacyDistance = 1
            if (checkBoxPLFarmacy5.isChecked) Location5FarmacyDistance = 0

            if (checkBoxPLBusStop1.isChecked) Location5BusStopDistance = 4
            if (checkBoxPLBusStop2.isChecked) Location5BusStopDistance = 3
            if (checkBoxPLBusStop3.isChecked) Location5BusStopDistance = 2
            if (checkBoxPLBusStop4.isChecked) Location5BusStopDistance = 1
            if (checkBoxPLBusStop5.isChecked) Location5BusStopDistance = 0

            if (checkBoxPLDogPark1.isChecked) Location5DogParkDistance = 4
            if (checkBoxPLDogPark2.isChecked) Location5DogParkDistance = 3
            if (checkBoxPLDogPark3.isChecked) Location5DogParkDistance = 2
            if (checkBoxPLDogPark4.isChecked) Location5DogParkDistance = 1
            if (checkBoxPLDogPark5.isChecked) Location5DogParkDistance = 0
        }

        fun findBiggestMinimumMaxDistancePerLocation() {
            //Get the max distances to the 5 different services for location 1
            MaxDistancesLocation1 = listOf(
                Location1SchoolDistance,
                Location1SupermarketDistance,
                Location1FarmacyDistance,
                Location1BusStopDistance,
                Location1DogParkDistance
            )
            //Sort the found max distances, so we can find the biggest max distance to this loction.
            SortedMaxDistancesLocation1 = MaxDistancesLocation1.sortedDescending()

            //Get the biggest max distance for this location, out of the sorted list
            MaxDistLocation1 = SortedMaxDistancesLocation1[0]

            //Same but for location 2
            MaxDistancesLocation2 = listOf(
                Location2SchoolDistance,
                Location2SupermarketDistance,
                Location2FarmacyDistance,
                Location2BusStopDistance,
                Location2DogParkDistance
            )
            SortedMaxDistancesLocation2 = MaxDistancesLocation2.sortedDescending()
            MaxDistLocation2 = SortedMaxDistancesLocation2[0]

            MaxDistancesLocation3 = listOf(
                Location3SchoolDistance,
                Location3SupermarketDistance,
                Location3FarmacyDistance,
                Location3BusStopDistance,
                Location3DogParkDistance
            )
            SortedMaxDistancesLocation3 = MaxDistancesLocation3.sortedDescending()
            MaxDistLocation3 = SortedMaxDistancesLocation3[0]

            MaxDistancesLocation4 = listOf(
                Location4SchoolDistance,
                Location4SupermarketDistance,
                Location4FarmacyDistance,
                Location4BusStopDistance,
                Location4DogParkDistance
            )
            SortedMaxDistancesLocation4 = MaxDistancesLocation4.sortedDescending()
            MaxDistLocation4 = SortedMaxDistancesLocation4[0]

            MaxDistancesLocation5 = listOf(
                Location5SchoolDistance,
                Location5SupermarketDistance,
                Location5FarmacyDistance,
                Location5BusStopDistance,
                Location5DogParkDistance
            )
            SortedMaxDistancesLocation5 = MaxDistancesLocation5.sortedDescending()
            MaxDistLocation5 = SortedMaxDistancesLocation5[0]


        }
        BtnCalculatePropertyLocation.setOnClickListener {

            checkMinimumMaxDistanceLocation1()
            checkMinimumMaxDistanceLocation2()
            checkMinimumMaxDistanceLocation3()
            checkMinimumMaxDistanceLocation4()
            checkMinimumMaxDistanceLocation5()
            findBiggestMinimumMaxDistancePerLocation()

            MapMaxMinDistance["L1"] = MaxDistLocation1
            MapMaxMinDistance["L2"] = MaxDistLocation2
            MapMaxMinDistance["L3"] = MaxDistLocation3
            MapMaxMinDistance["L4"] = MaxDistLocation4
            MapMaxMinDistance["L5"] = MaxDistLocation5

            result = MapMaxMinDistance.toList().sortedBy { (_, value) -> value}
            resultaat = result[0].toString()

            //For the sub-optimal locations, use a smaller font for the result.
            textViewMaxDistL1.textSize = 24F
            textViewMaxDistL2.textSize = 24F
            textViewMaxDistL3.textSize = 24F
            textViewMaxDistL4.textSize = 24F
            textViewMaxDistL5.textSize = 24F


            if(resultaat.contains("L1")) {
                //For the optimal location, use a bigger font for the result.
                textViewMaxDistL1.textSize = 36F
            }
            //Show the result on the screen.
            // If it is the best result, this number will be in a bigger font.
            textViewMaxDistL1.text = MaxDistLocation1.toString()

            if(resultaat.contains("L2")) {
                textViewMaxDistL2.textSize = 36F
            }
            textViewMaxDistL2.text = MaxDistLocation2.toString()

            if(resultaat.contains("L3")) {
                textViewMaxDistL3.textSize = 36F
            }
            textViewMaxDistL3.text = MaxDistLocation3.toString()

            if(resultaat.contains("L4")) {
                textViewMaxDistL4.textSize = 36F
            }
            textViewMaxDistL4.text = MaxDistLocation4.toString()

            if(resultaat.contains("L5")) {
                textViewMaxDistL5.textSize = 36F
            }
            textViewMaxDistL5.text = MaxDistLocation5.toString()
        }
    }

}