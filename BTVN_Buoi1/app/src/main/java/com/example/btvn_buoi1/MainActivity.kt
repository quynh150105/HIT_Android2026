package com.example.btvn_buoi1

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.btvn_buoi1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var isVisible = false

        binding.tvLogin.setOnClickListener {
            isVisible = !isVisible
//            if(isVisible) {
//                binding.cb.isChecked= true
//                binding.edtPass.transformationMethod = null
//            } else {
//                binding.cb.isChecked= false
//                binding.edtPass.transformationMethod = PasswordTransformationMethod()
//            }

            binding.edtPass.transformationMethod =
                if (isVisible) null else PasswordTransformationMethod()
            binding.cb.isChecked = if (isVisible) true else false
        }

        val text = binding.text.text.toString()
        val spannable = SpannableString(text)


        // màu
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            7, 10,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

//
// p
// click
        spannable.setSpan(
            object : ClickableSpan() {
                override fun onClick(widget: View) {
                    Toast.makeText(this@MainActivity, "Clicked!", Toast.LENGTH_SHORT).show()
                }
            },
            7, 10,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.text.text = spannable

        binding.text.movementMethod = LinkMovementMethod.getInstance()


    }
}