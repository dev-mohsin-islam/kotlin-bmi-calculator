package com.example.bmicalculator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bmiButton = findViewById<Button>(R.id.bmiButton)
        val lengthButton = findViewById<Button>(R.id.lengthButton)

        bmiButton.setOnClickListener {
            startActivity(Intent(this, BMICalculatorActivity::class.java))
        }

        lengthButton.setOnClickListener {
            startActivity(Intent(this, LengthConverterActivity::class.java))
        }
    }
}
