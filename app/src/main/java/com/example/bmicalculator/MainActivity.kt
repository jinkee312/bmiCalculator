package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btncalculate.setOnClickListener(){
            val weight:Double = weight.text.toString().toDouble()
            val height:Double = height.text.toString().toDouble()
            val bmi = CalculateBMI(weight,height)
//            if(bmi < 18.5){
//                imgResult.setImageResource(R.drawable.under)
//            }
//            else if(bmi < 24.9){
//                imgResult.setImageResource(R.drawable.normal)
//            }
//            else{
//                imgResult.setImageResource(R.drawable.over)
//            }
            val status:String
        when {
            bmi < 18.5 -> {
                imgResult.setImageResource(R.drawable.under)
                status = "under"
            }
            bmi < 24.9 -> {
                imgResult.setImageResource(R.drawable.normal)
                status = "normal"
            }
            else -> {
                imgResult.setImageResource(R.drawable.over)
                status = "over"
            }
        }
            txtInfo.text = "BMI %.2f (%s)".format(bmi, status)
        }

        btnReset.setOnClickListener(){
            imgResult.setImageResource(R.drawable.empty)
            txtInfo.text= ""
            height.text.clear()
            weight.text.clear()

        }


    }



    fun CalculateBMI(weight:Double , height:Double):Double{

        return weight/ pow(height,2.0)

    }
}
