package com.example.assignment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.collection.emptyLongSet

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the buttons, text View and Edit Text using the id we set on the interface

        val submitButton = findViewById<Button>(R.id.submitButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val textDisplay = findViewById<TextView>(R.id.textDisplay)
        val editName = findViewById<EditText>(R.id.editName)

        // MAP OF MEAL SUGGESTIONS BASED ON THE TIME OF DAY
        val mealSuggestions = mapOf(
            "Breakfast" to "bacon and eggs with toasted bread" ,
            "Lunch" to "lasagna" ,
            "Dinner" to "macaroni and cheese"
        )

        // add code to button that happens when its clicked
        submitButton?.setOnClickListener {
            val inputText = editName.text.toString().trim().lowercase()
            if (inputText in mealSuggestions) {
                textDisplay.text = " ${mealSuggestions[inputText]}"

            } else
                textDisplay.text =
                    "error: Entewr a valid time of day (MORNING, AFTERNOON, SUPPER)."
            Toast.makeText(this , "invalid, please try again" , Toast.LENGTH_SHORT).show()
        }


        // add a reset button to reset everything
        resetButton.setOnClickListener {
            editName.text.clear()
            textDisplay.text = ""
        }

    }
}