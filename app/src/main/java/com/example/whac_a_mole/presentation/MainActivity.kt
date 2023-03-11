package com.example.whac_a_mole.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whac_a_mole.repository.Game
import com.example.whac_a_mole.databinding.StartScreenBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : StartScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startGameButton.setOnClickListener {
            nextScreen()
        }
    }

    private fun nextScreen(){
        val intent = Intent(this@MainActivity, Game::class.java)
        startActivity(intent)

    }
}