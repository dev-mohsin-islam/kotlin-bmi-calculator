package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmicalculator.R
import com.example.model.BMIResult

class BMIAdapter(private val items: List<BMIResult>) : RecyclerView.Adapter<BMIAdapter.BMIViewHolder>() {

    class BMIViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val infoText: TextView = itemView.findViewById(R.id.bmiInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BMIViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bmi_item, parent, false)
        return BMIViewHolder(view)
    }

    override fun onBindViewHolder(itemHolder: BMIViewHolder, position: Int) {
        val item = items[position]
        itemHolder.infoText.text = "Name: ${item.name} Weight: ${item.weight}kg, Height: ${item.height}m → BMI: ${"%.2f".format(item.bmi)}"
    }

    override fun getItemCount(): Int = items.size
}
