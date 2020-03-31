package com.bb.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}

        val countButton: Button = findViewById(R.id.countup_button)
        countButton.setOnClickListener{countUp()}

        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice(){
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()

        //resultText.text = "Dice Rolled!"

        val resultText: TextView = findViewById(R.id.result_text)

        resultText.text = randomInt.toString()

        // val diceImage: ImageView = findViewById(R.id.dice_image)

        val drawableRsource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableRsource)
    }

    private fun countUp(){
        val resultText: TextView = findViewById(R.id.result_text)

        if(resultText.text == "Hello World!"){
            resultText.text = "1"
        } else {
            var resultInt = resultText.text.toString().toInt()

            if(resultInt < 6){
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }
}
