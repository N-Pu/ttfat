package com.example.whac_a_mole.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whac_a_mole.databinding.TransitionScreenBinding

class TransitionScreen : AppCompatActivity() {
    private lateinit var binding: TransitionScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransitionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scoreFromGame = intent.getStringExtra("key")
        binding.tvResult.text = "Score: $scoreFromGame"


        binding.buttonStartOver.setOnClickListener {
            finish()
            startScreen()
        }

        binding.buttonExit.setOnClickListener {
            finishAffinity()

        }
    }
    private fun startScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}