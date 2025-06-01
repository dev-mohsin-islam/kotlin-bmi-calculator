package com.example.bmicalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightInput = findViewById<EditText>(R.id.weightInput)
        val heightInput = findViewById<EditText>(R.id.heightInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)

        calculateBtn.setOnClickListener {
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()

            if (weight == null || height == null || height <= 0) {
                resultText.text = "Please enter valid values."
            } else {
                val bmi = weight / (height * height)
                val category = when {
                    bmi < 18.5 -> "Underweight"
                    bmi < 25 -> "Normal"
                    bmi < 30 -> "Overweight"
                    else -> "Obese"
                }
                resultText.text = "BMI: %.2f\nCategory: %s".format(bmi, category)
            }
        }
    }
}
