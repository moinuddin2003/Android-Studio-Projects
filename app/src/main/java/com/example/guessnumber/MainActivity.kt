package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset: ImageButton
    lateinit var imageButtonCheck: ImageButton

    var random: Int = nextInt(1,100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView2)
        editText = findViewById(R.id.editText)
        imageButtonReset = findViewById(R.id.imageButtonReset)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)

        textView.text = "Please enter your guess:"

        imageButtonCheck.setOnClickListener {

            val number: Int = editText.text.toString().toInt()

            if (number<random)
            {
                textView.text = "Your number is too low"
                editText.text.clear()
            }
            else if (number>random)
            {
                textView.text = "Your number is too high"
                editText.text.clear()
            }
            else
            {
                textView.text = "You Get it"
                editText.text.clear()
            }
        }

        imageButtonReset.setOnClickListener {

            reset()
        }
    }

    fun reset()
    {
        random = nextInt(1,100)
        textView.text = "Please enter your guess:"
        editText.text.clear()

    }
}