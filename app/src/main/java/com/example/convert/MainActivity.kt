package com.example.convert

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //creating a drop down button "spinner"
        //creating an array that will be displayed
        val mSpinner = findViewById<Spinner>(R.id.spinner_1)
        val unitList = arrayOf<String?>("Kilometer", "Meter", "Centimeter", "Milimeter", "Feet", "Yard",
            "Mile",)

        val unitAdapter = ArrayAdapter<Any?>(this, R.layout.snipper_list, unitList)
        unitAdapter.setDropDownViewResource(R.layout.snipper_list)

        mSpinner.adapter = unitAdapter

        //giving valuable by find the id
        val value = findViewById<EditText>(R.id.editTextNumber2)
        val kilometer = findViewById<TextView>(R.id.KiloAns)
        val meter = findViewById<TextView>(R.id.MeterAns)
        val centimeter = findViewById<TextView>(R.id.CentiAns)
        val milimeter = findViewById<TextView>(R.id.MiliAns)
        val feet = findViewById<TextView>(R.id.FeetAns)
        val yard = findViewById<TextView>(R.id.YardAns)
        val miles = findViewById<TextView>(R.id.MilesAns)


        //creating onitemselected listener that when the item on an array is select it should act as follows
        mSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            //when the item is selected
            //position: int represent the position in the array when is select
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val inputValue = value.text.toString().toDoubleOrNull()

                //when the input part has been given value
                if (inputValue != null){
                    when (position) {
                        //kilometer
                        0 -> {
                            kilometer.text = inputValue.toString()
                            meter.text = (inputValue * 1000).toString()
                            centimeter.text = (inputValue * 100000).toString()
                            milimeter.text = (inputValue * 1000000).toString()
                            feet.text = (inputValue * 3280.84).toString()
                            yard.text = (inputValue * 1093.61).toString()
                            miles.text = (inputValue * 0.000621371).toString()
                        }
                        //meter
                        1 -> {
                            kilometer.text = (inputValue / 1000).toString()
                            meter.text = inputValue.toString()
                            centimeter.text = (inputValue * 100).toString()
                            milimeter.text = (inputValue * 1000).toString()
                            feet.text = (inputValue * 3.28084).toString()
                            yard.text = (inputValue * 1.09361).toString()
                            miles.text = (inputValue * 0.000621371).toString()
                        }
                        //centimeter
                        2 -> {
                            kilometer.text = (inputValue / 100000).toString()
                            meter.text = (inputValue / 100).toString()
                            centimeter.text = inputValue.toString()
                            milimeter.text = (inputValue * 10).toString()
                            feet.text = (inputValue * 0.0328084).toString()
                            yard.text = (inputValue * 0.0109361).toString()
                            miles.text = (inputValue * 0.00000328084).toString()
                        }
                        //Milimeter
                        3 -> {
                            kilometer.text = (inputValue / 1000000).toString()
                            meter.text = (inputValue / 1000).toString()
                            centimeter.text = (inputValue / 10).toString()
                            milimeter.text = inputValue.toString()
                            feet.text = (inputValue * 0.000328084).toString()
                            yard.text = (inputValue * 0.000109361).toString()
                            miles.text = (inputValue * 0.0000000328084).toString()
                        }
                        //Feet
                        4 -> {
                            kilometer.text = (inputValue / 3280.84).toString()
                            meter.text = (inputValue / 3.28084).toString()
                            centimeter.text = (inputValue * 30.48).toString()
                            milimeter.text = (inputValue * 304.8).toString()
                            feet.text = inputValue.toString()
                            yard.text = (inputValue * 1.09361).toString()
                            miles.text = (inputValue * 0.000189394).toString()
                        }
                        //yard
                        5 -> {
                            kilometer.text = (inputValue / 1093.61).toString()
                            meter.text = (inputValue / 1.09361).toString()
                            centimeter.text = (inputValue * 91.44).toString()
                            milimeter.text = (inputValue * 914.4).toString()
                            feet.text = (inputValue / 1.09361).toString()
                            yard.text = inputValue.toString()
                            miles.text = (inputValue * 0.000568182).toString()
                        }
                        //miles
                        6 -> {
                            kilometer.text = (inputValue / 0.000621371).toString()
                            meter.text = (inputValue / 0.000621371).toString()
                            centimeter.text = (inputValue * 1609.34).toString()
                            milimeter.text = (inputValue * 1609340).toString()
                            feet.text = (inputValue / 0.000621371).toString()
                            yard.text = (inputValue / 0.000568182).toString()
                            miles.text = inputValue.toString()
                        }
                    }
                }else {
                    Toast.makeText(this@MainActivity, "Please enter a valid number", Toast.LENGTH_SHORT).show()
                }
            }

            //when nothing is select
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //it does nothing that's why the part is empty
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}

