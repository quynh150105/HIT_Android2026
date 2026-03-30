package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var resp: TextView
    var isNewNumber = true
    var oldNumber = ""
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resp = findViewById(R.id.tvRes)

        setUpNumberButton(R.id.btn1)
        setUpNumberButton(R.id.btn2)
        setUpNumberButton(R.id.btn3)
        setUpNumberButton(R.id.btn4)
        setUpNumberButton(R.id.btn5)
        setUpNumberButton(R.id.btn6)
        setUpNumberButton(R.id.btn7)
        setUpNumberButton(R.id.btn8)
        setUpNumberButton(R.id.btn9)
        setUpNumberButton(R.id.btn0)

        setUpOperatorButton(R.id.btnCong)
        setUpOperatorButton(R.id.btnTru)
        setUpOperatorButton(R.id.btnNhan)
        setUpOperatorButton(R.id.btnChia)

        setUpEqualButton()
        setUpAcButton()


    }

    fun setUpNumberButton(id: Int) {
        findViewById<TextView>(id).setOnClickListener {
            val textNumber = findViewById<TextView>(id).text.toString();

            if (isNewNumber) {
                resp.text = textNumber
                isNewNumber = false
            } else {
                if (resp.text.toString() == "0") {
                    resp.text = textNumber
                } else {
                    resp.text = resp.text.toString() + textNumber
                }
            }
        }
    }

    fun setUpOperatorButton(id: Int) {
        findViewById<TextView>(id).setOnClickListener {
            operator = findViewById<TextView>(id).text.toString();
            oldNumber = resp.text.toString();
            isNewNumber = true;
        }
    }

    fun setUpEqualButton() {
        findViewById<TextView>(R.id.btnEqual).setOnClickListener {
            val newNumber = resp.text.toString().toDouble();
            val old = if (oldNumber == "") 0.0  else (oldNumber.toDouble())
            var result = 0.0;

            if (operator == "/" && newNumber == 0.0) {
                Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            when (operator) {
                "+" -> result = newNumber + old;
                "-" -> result = newNumber - old;
                "*" -> result = newNumber * old;
                "/" -> result = newNumber / old;
                else -> result = newNumber
            }
            resp.text = result.toString();
            isNewNumber = true;

        }
    }

    fun setUpAcButton() {
        findViewById<TextView>(R.id.btnAc).setOnClickListener {
            resp.text = "0";
            oldNumber = "";
            isNewNumber = true;
            operator = "";
        }
    }
}