package com.example.neha_mapd711_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //clicking on calculate button will send action to result activity
        val calculatebtn = findViewById<View>(R.id.calculateButton) as Button
        //setting on click listener to pass all the values to result activity
        calculatebtn.setOnClickListener{

            val intentResultActivity = Intent(this@MainActivity, ResultActivity::class.java)


            //initializing  the references objects for the inputs from the UI
            val etDistance = findViewById<View>(R.id.enterkm) as EditText
            val radioGroupvehicle = findViewById<View>(R.id.radio_vehicle) as RadioGroup
            val spinnerTimeOfDay = findViewById<View>(R.id.time_spinner) as Spinner
            val radioGroupVehicleID = radioGroupvehicle.checkedRadioButtonId
            val selectedGroupVehicleRadio = radioGroupvehicle.findViewById<View>(radioGroupVehicleID) as RadioButton
            val radiogroupDirection = findViewById<View>(R.id.radio_dir) as RadioGroup
            val radiogroupDirectionID = radiogroupDirection.checkedRadioButtonId
            val selectedradiogroupDirection = radiogroupDirection.findViewById<View>(radiogroupDirectionID) as RadioButton
            val checkbox = findViewById<View>(R.id.checkbox) as CheckBox
            val switchTransponder = findViewById<Switch>(R.id.TransponderSwitch)



            //getting values from the above step and setting it to text
            val getDistance = etDistance.text.toString()
            val getVehicle = selectedGroupVehicleRadio.text as String
            val getTimeOfDay = spinnerTimeOfDay.selectedView as TextView
            val getDirection = selectedradiogroupDirection.text as String


            //storing value with key values pair of intent object using putExtra() method
            intentResultActivity.putExtra("GetDistance",getDistance)
            intentResultActivity.putExtra("GetVehicle",getVehicle)
            intentResultActivity.putExtra("GetTimeOfDay",getTimeOfDay.text)
            intentResultActivity.putExtra("GetDirection", getDirection)
            if(switchTransponder.isChecked){
                intentResultActivity.putExtra("GetSwitch","Yes")
            }else{
                intentResultActivity.putExtra("GetSwitch","No")
            }
            if(checkbox.isChecked){
                intentResultActivity.putExtra("GetCheckbox", "Yes")
            }else{
                intentResultActivity.putExtra("GetCheckbox", "No")
            }

            //navigating to the second activity

            startActivity(intentResultActivity)


        }

    }

}
