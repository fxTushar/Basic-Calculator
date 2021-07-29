package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var clearButton: Button
    private lateinit var divideButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var subtractButton: Button
    private lateinit var addButton: Button
    private lateinit var equalButton: Button
    private lateinit var dotButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()

        var num1: String = ""
        var num2: String = ""
        var operation: String = ""

        button0.setOnClickListener {
            if(editText.text.isNotEmpty()){
                editText.setText(editText.text.toString() + "0")
            }
        }
        button1.setOnClickListener {
            editText.setText(editText.text.toString() + "1")
        }
        button2.setOnClickListener {
            editText.setText(editText.text.toString() + "2")
        }
        button3.setOnClickListener {
            editText.setText(editText.text.toString() + "3")
        }
        button4.setOnClickListener {
            editText.setText(editText.text.toString() + "4")
        }
        button5.setOnClickListener {
            editText.setText(editText.text.toString() + "5")
        }
        button6.setOnClickListener {
            editText.setText(editText.text.toString() + "6")
        }
        button7.setOnClickListener {
            editText.setText(editText.text.toString() + "7")
        }
        button8.setOnClickListener {
            editText.setText(editText.text.toString() + "8")
        }
        button9.setOnClickListener {
            editText.setText(editText.text.toString() + "9")
        }

        addButton.setOnClickListener {
            if(operation.isEmpty()) {
                num1 = editText.text.toString()
            }
            operation = "+"
            editText.setText("")
            editText.hint = num1
        }
        subtractButton.setOnClickListener {
            if(operation.isEmpty()) {
                num1 = editText.text.toString()
            }
            if(editText.text.isEmpty()){
                editText.setText("-")
            } else {
                editText.setText("")
                operation = "-"
            }
            editText.hint = num1
        }
        multiplyButton.setOnClickListener {
            if(operation.isEmpty()) {
                num1 = editText.text.toString()
            }
            operation = "*"
            editText.setText("")
            editText.hint = num1
        }
        divideButton.setOnClickListener {
            if(operation.isEmpty()) {
                num1 = editText.text.toString()
            }
            operation = "/"
            editText.setText("")
            editText.hint = num1
        }
        dotButton.setOnClickListener {
            if(!editText.text.contains(".")){
                editText.setText(editText.text.toString() + ".")
            }
        }
        equalButton.setOnClickListener {
            num2 = editText.text.toString()

            val finalValue: Double = when(operation){
                "+" -> num1.toDouble() + num2.toDouble()
                "*" -> num1.toDouble() * num2.toDouble()
                "/" -> num1.toDouble() / num2.toDouble()
                "-" -> num1.toDouble() - num2.toDouble()
                else -> editText.text.toString().toDouble()
            }
            if(finalValue.toString().contains(".0")){
                editText.setText(finalValue.toInt().toString())
            } else {
                editText.setText(finalValue.toString())
            }
            operation = ""
        }
        clearButton.setOnClickListener {
            editText.setText("")
            editText.hint = "0"
        }
    }

    fun bindViews(){
        editText = findViewById(R.id.editText)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        dotButton = findViewById(R.id.dotButton)
        clearButton = findViewById(R.id.clearButton)
        equalButton = findViewById(R.id.equalButton)
    }
}