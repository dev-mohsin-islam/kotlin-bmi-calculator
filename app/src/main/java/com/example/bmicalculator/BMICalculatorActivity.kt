package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMICalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalcaulator)

        val weightInput = findViewById<EditText>(R.id.weightInput)
        val heightInput = findViewById<EditText>(R.id.heightInput)
        val calculatorBtn = findViewById<Button>(R.id.calculateBtn)
        val resultText = findViewById<TextView>(R.id.resultText)
        val categoryText = findViewById<TextView>(R.id.categoryText)

        calculatorBtn.setOnClickListener{
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()

            if(weight ==null || height ==null || height ==0.0){
                resultText.text = "Please enter valid numbers."
                categoryText.text = ""
                return@setOnClickListener
            }
            val bmi = weight / (height * height)
            val category = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25.0 -> "Normal"
                bmi < 30.0 -> "Overweight"
                else -> "Obese"
            }
            categoryText.text = category

        }
    }
}