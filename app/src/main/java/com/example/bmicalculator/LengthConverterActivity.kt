package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LengthConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length_converter)

        val metersInout = findViewById<EditText>(R.id.metersInput)
        val converterBtn = findViewById<Button>(R.id.convertButton)
        val resultLength =  findViewById<TextView>(R.id.resultText)

        converterBtn.setOnClickListener{
            val meters = metersInout.text.toString().toDoubleOrNull()

            if(meters ==null || meters ==0.0){
                resultLength.text = "Please enter valid numbers."
                return@setOnClickListener
            }
            val centimeters = meters * 100
            resultLength.text = "Result:  %.2f cm".format(centimeters)
        }

    }
}