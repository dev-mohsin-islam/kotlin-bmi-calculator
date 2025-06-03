package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.BMIAdapter
import com.example.model.BMIResult

private lateinit var recyclerView: RecyclerView
private val bmiList = mutableListOf<BMIResult>()
private lateinit var adapter: BMIAdapter

class BMICalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalcaulator)

        val nameInput = findViewById<EditText>(R.id.nameInput)

        val weightInput = findViewById<EditText>(R.id.weightInput)
        val heightInput = findViewById<EditText>(R.id.heightInput)
        val resultText = findViewById<TextView>(R.id.resultText)

        recyclerView = findViewById(R.id.bmiRecyclerView)
        adapter = BMIAdapter(bmiList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        findViewById<Button>(R.id.calculateBtn).setOnClickListener {
            val name =  nameInput.text.toString().trim()
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()
            if (weight != null && height != null && height > 0) {
                val bmi = weight / (height * height)
                resultText.text = "Your BMI is %.2f".format(bmi)

                val item = BMIResult(name, weight, height, bmi)
                bmiList.add(0, item) // Add at top
                adapter.notifyItemInserted(0)
            } else {
                resultText.text = "Enter valid values"
            }
        }

        val clearBtn = findViewById<Button>(R.id.clearHistoryBtn)
        clearBtn.setOnClickListener {
            bmiList.clear()
            adapter.notifyDataSetChanged()
        }

//        calculatorBtn.setOnClickListener{
//            val weight = weightInput.text.toString().toDoubleOrNull()
//            val height = heightInput.text.toString().toDoubleOrNull()
//
//            if(weight ==null || height ==null || height ==0.0){
//                resultText.text = "Please enter valid numbers."
//                categoryText.text = ""
//                return@setOnClickListener
//            }
//            val bmi = weight / (height * height)
//            val category = when {
//                bmi < 18.5 -> "Underweight"
//                bmi < 25.0 -> "Normal"
//                bmi < 30.0 -> "Overweight"
//                else -> "Obese"
//            }
//            categoryText.text = category
//
//        }
    }
}