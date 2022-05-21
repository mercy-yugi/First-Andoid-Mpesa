package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BMICalculatorActivity : AppCompatActivity() {
    lateinit var btnCalculate: Button
    lateinit var etWeight:EditText
    lateinit var etHeight:EditText
    lateinit var tvBmi:TextView
    lateinit var tvstatus:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator2)
     btnCalculate=findViewById(R.id.btnCalculate)
        etWeight=findViewById(R.id.etWeight)
        etHeight=findViewById(R.id.etHeight)
        tvBmi=findViewById(R.id.tvBmi)
        tvstatus=findViewById(R.id.tvstatus)


        btnCalculate.setOnClickListener {
            tvBmi.text=""
            val weight=etWeight.text.toString()
            val height=etHeight.text.toString()
            if(weight.isBlank()) {
                etWeight.setError("WEIGHT IS REQUIRED")
                return@setOnClickListener
            }
            if (height.isBlank()){
                etHeight.setError("HEIGHT IS REQUIRED")
                return@setOnClickListener
            }
            calculateBmi(weight.toDouble(), height.toInt())
        }
    }

    fun calculateBmi(weight:Double,height:Int){
        var heightMetres=height/100.0
        var bmi=weight/(heightMetres*heightMetres)
        tvBmi.text= bmi.toString()

        if(bmi<18.5){
           tvstatus.text="Underweight"
        }
        else if (bmi in 18.6..25.8){
            tvstatus.text="Normal"
        }
        else if (bmi in 25.1..30.0){
            tvstatus.text="Overweight"
        }
        else{
            tvstatus.text="Obesse"
        }
    }
}