package com.example.neha_mapd711_test

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        val getDistance = intent.getStringExtra("GetDistance")
        val getVehicle = intent.getStringExtra("GetVehicle")
        val getTimeOfDay = intent.getStringExtra("GetTimeOfDay")
        val getDirection = intent.getStringExtra("GetDirection")
        val getSwitch = intent.getStringExtra("GetSwitch")
        val getChecked = intent.getStringExtra("GetCheckbox")

        //defining a reference object from activity_result.xml
        val VehicleSize = findViewById<TextView>(R.id.vehicle_tv)
        val Distance = findViewById<TextView>(R.id.distance_tv)
        val TimeOfDay = findViewById<TextView>(R.id.time_tv)
        val Direction = findViewById<TextView>(R.id.direction_tv)
        val Switch = findViewById<TextView>(R.id.transponder_tv)
        val Toll = findViewById<TextView>(R.id.tolltotal)
        webView = findViewById(R.id.webview)
        webView.apply { loadUrl("https://www.407etr.com/en/tolls/tolls/toll-calculator.html")
            webViewClient = WebViewClient()
            webView.settings.javaScriptEnabled = true
            webView.getSettings().setAllowFileAccess(true)
            webView.getSettings().setAppCacheEnabled(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        }


        val suffixedDistance = getDistance.toString()+ " Km"


        //assigning message value to textview control of activity_result.xml
        VehicleSize.text = getVehicle.toString()
        Distance.text = suffixedDistance
        TimeOfDay.text = getTimeOfDay.toString()
        Direction.text = getDirection.toString()
        Switch.text = getSwitch.toString()
        var tollPerKMValue = tollPerKM(getTimeOfDay.toString(),getVehicle.toString(),getDirection.toString())

        // calculation for toll calculator
        var t = tollPerKMValue
        var d = getDistance!!.toDouble()
        var tc = 1
        var c = 4.2
        var TollResult = (d * t /100)+tc+c

        Toll.text = TollResult.toString()
    }

    private fun tollPerKM(timeOfDay: String,vehicle:String, direction: String ): Double {
        var t=2.00
        if (timeOfDay == "Wkdy 12:00 AM - 6:00 AM"){

            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 25.29
                }else{
                    t = 5.29
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 50.58
                }else{
                    t = 50.58
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 75.87
                }else{
                    t = 75.87
                }
            }
        }else if(timeOfDay == "Wkdy 6:00 AM - 7:00 AM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 42.04
                }else{
                    t = 44.86
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 84.08
                }else{
                    t = 89.72
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 126.12
                }else{
                    t = 134.58
                }
            }
        }else if(timeOfDay == "Wkdy 7:00 AM - 9:30 AM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 47.83
                }else{
                    t = 54.93
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 95.66
                }else{
                    t = 109.86
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 143.49
                }else{
                    t = 164.79
                }
            }
        }else if(timeOfDay == "Wkdy 9:30 AM - 10:30 AM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 42.04
                }else{
                    t = 46.58
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 84.08
                }else{
                    t = 93.16
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 126.12
                }else{
                    t = 139.74
                }
            }
        } else if(timeOfDay == "Wkdy 10:30 AM - 2:30 PM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 38.47
                }else{
                    t = 39.07
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 76.94
                }else{
                    t = 78.14
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 115.41
                }else{
                    t = 117.21
                }
            }
        }else if(timeOfDay == "Wkdy 2:30 PM - 3:30 PM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 43.62
                }else{
                    t = 48.61
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 97.22
                }else{
                    t = 87.24
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 145.83
                }else{
                    t = 130.86
                }
            }
        }else if(timeOfDay == "Wkdy 3:30 PM - 6:00 PM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 49.56
                }else{
                    t = 58.48
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 116.96
                }else{
                    t = 99.12
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 175.44
                }else{
                    t = 148.68
                }
            }
        }else if(timeOfDay == "Wkdy 6:00 PM - 7:00 PM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 46.81
                }else{
                    t = 43.62
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 93.62
                }else{
                    t = 87.24
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 130.86
                }else{
                    t = 140.43
                }
            }
        }else if(timeOfDay == "Wkdy 7:00 PM - 12:00 AM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 25.29
                }else{
                    t = 25.29
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 50.58
                }else{
                    t = 50.58
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 75.87
                }else{
                    t = 75.87
                }
            }
        }else if(timeOfDay == "Wkends + Hldys 12:00 AM - 11:00 AM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 25.29
                }else{
                    t = 25.29
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 50.58
                }else{
                    t = 50.58
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 75.87
                }else{
                    t = 75.87
                }
            }
        }else if(timeOfDay == "Wkends + Hldys 11:00 AM - 7:00 PM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 34.63
                }else{
                    t = 34.63
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 69.26
                }else{
                    t = 69.26
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 103.89
                }else{
                    t = 103.89
                }
            }
        }else if(timeOfDay == "Wkends + Hldys 7:00 PM - 12:00 AM"){
            if(vehicle == "Light Vehicle"){
                if(direction == "East Bound"){
                    t = 25.29
                }else{
                    t = 25.29
                }
            }else if(vehicle == "Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 50.58
                }else{
                    t = 50.58
                }
            }else if(vehicle == "Multi Heavy Vehicle"){
                if(direction == "East Bound"){
                    t = 75.87
                }else{
                    t = 75.87
                }
            }
        }
        return t
    }
}





